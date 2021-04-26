/*
 * GetIndexPageController.java
 * 
 * All Rights Reserved.
 * Copyright (c) 2019 FPT University
 */
package controller;

import dal.NewsDAO;
import entity.News;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.NewsFormat;

/**
 *GetIndexPageController class.<br>
 * 
 * <pre>
 * Class thực hiện xử lý request lấy thông tin chi tiết index.jsp
 * Trong class này sẽ tiến hành các xử lí dưới đây.
 * 
 * ・processRequest
 * ・doGet.
 * ・doPost.
 * ・getServletInfo.
 * </pre>
 * 
 * @author thinh
 */


public class GetIndexPageController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GetIndexPageController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GetIndexPageController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            NewsDAO newsDao = new NewsDAO();
            News latestNews = newsDao.getFirst();
            Date latestDate = latestNews.getPublishedDate();
            String xLatestDate = NewsFormat.formatDateToString(latestDate);
            List<News> list = newsDao.getFiveRecent();
            
            request.setAttribute("list", list);
            request.setAttribute("latestNews", latestNews);
            request.setAttribute("date", xLatestDate);
            request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
        } catch (Exception ex) {
            request.getRequestDispatcher("WEB-INF/error.jsp").forward(request, response);
            Logger.getLogger(GetIndexPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
