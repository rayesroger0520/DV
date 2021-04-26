/*
 * DataConnection.java
 * 
 * All Rights Reserved.
 * Copyright (c) 2019 FPT University
 */
package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Data connection<br>
 *
 * <pre>
 * Class thực hiện thao tác kết nối với cơ sở dữ liệu với thông tin lấy trong file config.xml
 * Trong class này sẽ tiến hành các xử lí dưới đây
 *
 * ・initConfig
 * ・getImagefolder
 * ・closeConn
 * ・closeResultSet
 * ・closePreparedStatement
 * ・connToMssql
 * </pre>
 *
 * @author thinh
 */
public class DataConnection {

    /**
     * Store connection
     */
    private static Connection conn = null;
    /**
     * Store URL connection
     */
    private static String connURL = "";
    /**
     * Store user sql server account
     */
    private static String user = "";
    /**
     * Store password sql server account
     */
    private static String pass = "";

    /**
     * Init config with info save in config.xml<br>
     *
     * <pre>
     * Method sẽ lấy các thông tin được lưu trong file config.xml để gán cho các biến thực hiện kết nối.
     * Trong trường hợp không lấy được thì thực hiện xử lí exception.
     * </pre>
     */
    private static void initConfig() {
        try {
            InitialContext initialContext = new InitialContext();
            Context environmentContext = (Context) initialContext.lookup("java:comp/env");
            connURL = (String) environmentContext.lookup("myConnection");
            user = (String) environmentContext.lookup("dbUser");
            pass = (String) environmentContext.lookup("dbPass");
            System.out.println("Config read");
        } catch (NamingException e) {
            System.out.println("Cannot read config");
            System.out.println(e.getMessage());
        }
    }

    /**
     * Lấy image folder từ file config.xml<br>
     *
     * <pre>
     * Method sẽ thực hiện lấy đường dẫn đến file Image trong file config.xml.
     * Trường hợp không lấy được sẽ thực hiện xử lý exception.
     * </pre>
     *
     * @return the imageFolder
     * @throws Exception trường hợp có excetion xảy ra nhưng không phải
     * NamingExcetion
     */
    public String getImageFolder() throws Exception {
        String imageFolder = null;
        try {
            InitialContext initialContext = new InitialContext();
            Context environmentContext = (Context) initialContext.lookup("java:comp/env");
            imageFolder = (String) environmentContext.lookup("imagePath");
        } catch (NamingException e) {
            System.out.println("Cannot read config");
            System.out.println(e.getMessage());
            throw e;
        }
        return imageFolder;
    }

    /**
     * Đóng kết nối của connection hiện tại<br>
     *
     * <pre>
     * Method sẽ thực hiện đóng kết nối connection
     * Trường hợp không thực hiện được sẽ thực hiện xử lý exception
     * </pre>
     *
     * ◆Trình tự xử lí<br>
     *      1. Kiểm tra xem connection có tồn tại hay không và nếu tồn tại thì đã bị đóng chưa<br> 
     *          1.1 Trường hợp tồn tại và chưa bị đóng<br> 
     *              1.1.1 Đóng kết nối connection.<br> 
     * ◆Xử lí exception<br> 
     *      ・Nếu xử lí in-output thất bại thì sinh SQLException và throw ra gốc gọi ra.<br>
     *
     * @param conn the connection
     */
    public static void closeConn(Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Đóng ResultSet<br>
     *
     * <pre>
     * Method sẽ thực hiện đóng ResultSet
     * Trường hợp không thực hiện được sẽ thực hiện xử lý exception
     * </pre>
     *
     * ◆Trình tự xử lí<br>
     *      1. Kiểm tra xem ResultSet có tồn tại hay không và nếu tồn tại thì đã bị đóng chưa<br>
     *          1.1 Trường hợp tồn tại và chưa bị đóng<br>
     *              1.1.1 Đóng kết nối ResultSet.<br>
     * ◆Xử lí exception<br> 
     *      ・Nếu xử lí in-output thất bại thì sinh SQLException<br>
     *
     * @param rs the result set
     */
    public static void closeResultSet(ResultSet rs) {
        try {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Đóng PreparedStatement<br>
     *
     * <pre>
     * Method sẽ thực hiện đóng PreparedStatement
     * Trường hợp không thực hiện được sẽ thực hiện xử lý exception
     * </pre>
     *
     * ◆Trình tự xử lí<br>
     *      1. Kiểm tra xem PreparedStatement có tồn tại hay không và nếu tồn tại thì đã bị đóng chưa<br>
     *          1.1 Trường hợp tồn tại và chưa bị đóng<br>
     *              1.1.1 Đóng kết nối PreparedStatement.<br>
     * ◆Xử lí exception<br> 
     *      ・Nếu xử lí in-output thất bại thì sinh SQLException và throw ra gốc gọi ra.<br>
     *
     * @param ps the result set
     */
    public static void closePrepareStatement(PreparedStatement ps) {
        try {
            if (ps != null && !ps.isClosed()) {
                ps.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Thực hiện kết nối CSDL<br>
     *
     * <pre>
     * Method sẽ thực hiện đóng PreparedStatement
     * Trường hợp không thực hiện được sẽ thực hiện xử lý exception
     * </pre>
     *
     * ◆Trình tự xử lí<br>
     *      1. Kiểm tra xem PreparedStatement có tồn tại hay không và nếu tồn tại thì đã bị đóng chưa<br>
     *          1.1 Trường hợp tồn tại và chưa bị đóng<br>
     *              1.1.1 Đóng kết nối PreparedStatement.<br>
     * ◆Xử lí exception<br> 
     *      ・Nếu xử lí in-output thất bại thì sinh SQLException và throw ra gốc gọi ra.<br>
     *
     */
    public static Connection connToMssql() throws SQLException, ClassNotFoundException {
//        String url = "jdbc:sqlserver://"+serverName+":"+portNumber +";databaseName="+dbName;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        initConfig();
        return DriverManager.getConnection(connURL, user, pass);
    }
}
