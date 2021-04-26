/*
 * NewsDao.java

 * All Rights Reserved.
 * Copyright (c) 2019 FPT University
 *
 */
package dal;

import context.DataConnection;
import entity.News;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.NewsFormat;

/**
 * NewsDAO <br>
 * 
 * <pre>
 * Store NewsDAO
 * .getFirst()
 * .getFiveRecent()
 * .getNews()
 * .getSearchNews()
 * .count()
 * </pre>
 * 
 * @author thinh
 */


public class NewsDAO {

    //get the most recent new
    public News getFirst() throws Exception {
        String query = "SELECT TOP (1) [id]\n"
                + "      ,[title]\n"
                + "      ,[writer]\n"
                + "      ,[shortDescription]\n"
                + "      ,[fullDescription]\n"
                + "      ,[publishedDate]\n"
                + "      ,[img]\n"
                + "  FROM [DigitalNews].[dbo].[News] order by publishedDate desc";
        News news = new News();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DataConnection.connToMssql();
            stm = con.prepareStatement(query);
            rs = stm.executeQuery();
            while (rs.next()) {
                String imageFolder = new DataConnection().getImageFolder();
                String img = imageFolder + rs.getString("img");
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String writer = rs.getString("writer");
                String shortDescription = rs.getString("shortDescription");
                String fullDescription = rs.getString("fullDescription");
                Date publishedDate = rs.getDate("publishedDate");
                String showDate = NewsFormat.formatDateToString(publishedDate);
                news = new News(id, title, writer, shortDescription, fullDescription, publishedDate, img);
                news.setShowDate(showDate);
                news.setPublishedDate(NewsFormat.parseDatetimeStringToDate(rs.getString("publishedDate")));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            DataConnection.closeResultSet(rs);
            DataConnection.closePrepareStatement(stm);
            DataConnection.closeConn(con);

        }
        return news;
    }

    //get 5 most recent news without the latest new
    public List<News> getFiveRecent() throws Exception {
        String query = "SELECT TOP (6) [id]\n"
                + "      ,[title]\n"
                + "      ,[writer]\n"
                + "      ,[shortDescription]\n"
                + "      ,[fullDescription]\n"
                + "      ,[publishedDate]\n"
                + "      ,[img]\n"
                + "  FROM [DigitalNews].[dbo].[News] order by publishedDate desc";
        News news = new News();
        List<News> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DataConnection.connToMssql();
            stm = con.prepareStatement(query);
            rs = stm.executeQuery();
            while (rs.next()) {
                String imageFolder = new DataConnection().getImageFolder();
                String img = imageFolder + rs.getString("img");
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String writer = rs.getString("writer");
                String shortDescription = rs.getString("shortDescription");
                String fullDescription = rs.getString("fullDescription");
                Date publishedDate = rs.getDate("publishedDate");
                String showDate = NewsFormat.formatDateToString(publishedDate);
                news = new News(id, title, writer, shortDescription, fullDescription, publishedDate, img);
                news.setPublishedDate(NewsFormat.parseDatetimeStringToDate(rs.getString("publishedDate")));
                list.add(news);
            }
            list.remove(0);

        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            DataConnection.closeResultSet(rs);
            DataConnection.closePrepareStatement(stm);
            DataConnection.closeConn(con);

        }
        return list;
    }

    //get news by id
    public News getNews(int id) throws Exception {
        String query = "SELECT  [id]\n"
                + "      ,[title]\n"
                + "      ,[writer]\n"
                + "      ,[shortDescription]\n"
                + "      ,[fullDescription]\n"
                + "      ,[publishedDate]\n"
                + "      ,[img]\n"
                + "  FROM [DigitalNews].[dbo].[News] where id= ?";
        News news = new News();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DataConnection.connToMssql();
            stm = con.prepareStatement(query);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            while (rs.next()) {
                String imageFolder = new DataConnection().getImageFolder();
                String img = imageFolder + rs.getString("img");
                id = rs.getInt("id");
                String title = rs.getString("title");
                String writer = rs.getString("writer");
                String shortDescription = rs.getString("shortDescription");
                String fullDescription = rs.getString("fullDescription");
                Date publishedDate = rs.getDate("publishedDate");
                String showDate = NewsFormat.formatDateToString(publishedDate);
                news = new News(id, title, writer, shortDescription, fullDescription, publishedDate, img);
                news.setShowDate(showDate);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            DataConnection.closeResultSet(rs);
            DataConnection.closePrepareStatement(stm);
            DataConnection.closeConn(con);

        }
        return news;
    }
    

    //search news by title and paging
    public List<News> getSearchNews(int start, int end, String search) throws Exception {

        String query = "select rn,id,title,writer,shortDescription,fullDescription,publishedDate,img from\n"
                + "  (select ROW_NUMBER() over (order by publishedDate desc)as rn,id,title,writer,shortDescription\n"
                + "  ,fullDescription,publishedDate,img from News where title LIKE ? ) as x where rn between ? and ?  ";
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        News news = null;
        List<News> list = new ArrayList<>();
        try {
            String imageFolder = new DataConnection().getImageFolder();
            con = DataConnection.connToMssql();
            stm = con.prepareStatement(query);
            stm.setString(1, "%" + search + "%");
            stm.setInt(2, start);
            stm.setInt(3, end);

            rs = stm.executeQuery();
            while (rs.next()) {
                String img = imageFolder + rs.getString("img");
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String writer = rs.getString("writer");
                String shortDescription = rs.getString("shortDescription");
                String fullDescription = rs.getString("fullDescription");
                Date publishedDate = rs.getDate("publishedDate");
                news = new News(id, title, writer, shortDescription, fullDescription, publishedDate, img);
                String showDate = NewsFormat.formatDateToString(publishedDate);
                news.setShowDate(showDate);
                list.add(news);
            }
        } catch (Exception ex) {
            Logger.getLogger(NewsDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } finally {
            DataConnection.closeResultSet(rs);
            DataConnection.closePrepareStatement(stm);
            DataConnection.closeConn(con);
        }
        return list;
    }

    //count total rows of new's title
    public int count(String search) throws Exception {
        String query = "SELECT COUNT(*) as TotalRows FROM News where title LIKE ? ";
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            con = DataConnection.connToMssql();
            statement = con.prepareStatement(query);
            statement.setString(1, "%" + search + "%");
            rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getInt("TotalRows");
            }
        } catch (Exception ex) {
            Logger.getLogger(NewsDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } finally {
            DataConnection.closeResultSet(rs);
            DataConnection.closePrepareStatement(statement);
            DataConnection.closeConn(con);
        }
        return 0;
    }

}
