<%-- 
    Document   : index
    Created on : Mar 20, 2020, 11:20:05 AM
    Author     : thinh
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.sql.Date"%>
<%@page import="java.sql.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index Page</title>
        <link href="${pageContext.request.contextPath}/stylesheets/style.css" rel="stylesheet" type="text/css"/>

    </head>
    <body>
        <%@include file="header.jsp" %>
        <div class="main">
            <div class="content">
                <h2 class="title-color"><a href="newsinfo?id=${latestNews.id}">${latestNews.title}</a></h2>
                <img src="images/i1.jpg" alt="news avatar" class="news-img"/><br><br>
                <div class="full-description">
                    ${latestNews.shortDescription}
                </div>

                <div class="location-right">
                    <img src="images/comment.gif" alt="comment" class="icon"/>
                    <img src="images/timeicon.gif" alt="timeicon" class="icon"/>
                    By ${latestNews.writer} | ${latestNews.showDate}
                </div>
            </div>
            <!--Side bar-->
            <div class="sidebar-right">
                <%@include file="right-side.jsp" %>
            </div>
        </div>
        <img src="images/footer.jpg" alt="footer" class="web-width"/>
    </body>
</html>
