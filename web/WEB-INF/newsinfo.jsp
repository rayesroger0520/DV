<%-- 
    Document   : newsinfo
    Created on : Mar 20, 2020, 11:30:05 AM
    Author     : thinh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>News Info Page</title>
        <link href="${pageContext.request.contextPath}/stylesheets/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div class="main">
            <div class="content">
                <h2 class="title-color">${curnews.title}</h2>
                <img src="images/i1.jpg" alt="news avatar" class="news-img"/><br><br>
                <div class="full-description">
                    ${curnews.fullDescription}
                </div>
                
                <div class="location-right">
                    <img src="images/comment.gif" alt="comment" class="icon"/>
                    <img src="images/timeicon.gif" alt="timeicon" class="icon"/>
                    By ${curnews.writer} | ${date}
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
