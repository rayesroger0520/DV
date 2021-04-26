<%-- 
    Document   : searchpage
    Created on : Mar 20, 2020, 11:38:05 AM
    Author     : thinh
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.sql.Date"%>
<%@page import="java.sql.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Page</title>
        <link href="${pageContext.request.contextPath}/stylesheets/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <%
        int totalPage = Integer.parseInt(request.getAttribute("totalpage").toString());
        int pageIndex = Integer.parseInt(request.getAttribute("pageindex").toString());
        String search = (String) request.getAttribute("search");
    %>
    <body>
        <%@include file="header.jsp" %>
        <div class="main">
            <div class="content">
                <c:choose>
                    <c:when test="${size >0}">
                        <c:forEach  items="${searchlist}" var="news">
                            <div class="searchnews">
                                <h2 class="title-color"><a href="newsinfo?id=${news.id}">${news.title}</a></h2>
                                <img src="images/i1.jpg" alt="news avatar" class="news-img"/><br><br>
                                <div class="full-description">
                                    ${news.shortDescription}
                                </div>

                                <div class="location-right">
                                    <img src="images/comment.gif" alt="comment" class="icon"/>
                                    <img src="images/timeicon.gif" alt="timeicon" class="icon"/>
                                    By ${news.writer} | ${news.showDate}
                                </div>
                            </div>
                        </c:forEach>
                        <div class="paging">
                            <%=util.HtmlHelper.pagger(pageIndex, totalPage, "getsearchpage", search)%>
                        </div>
                    </c:when>
                    <c:when test="${size==0}">
                        No Article Found
                    </c:when>
                </c:choose>

            </div>
            <!--Side bar-->
            <div class="sidebar-right">
                <h1 class="title-color option-header">Digital News</h1>
                <div>
                    ${latestNews.shortDescription}
                </div>

                <h1 class="title-color option-header">Search</h1>
                <form action="getsearchpage" method="GET">
                    <c:choose>
                        <c:when test="${size>0}">
                            <input type="text" name="search" value="" class="input" required="true"/>
                        </c:when>
                        <c:when test="${size==0}">
                            <input type="text" name="search" value="${search}" class="input" required="true"/>
                        </c:when>
                    </c:choose>
                    <input type="submit" value="Go" class="button"/>
                </form>

                <h1 class="title-color option-header">Last Articles</h1>

                <c:forEach items="${list}" var="news">
                    <a href="newsinfo?id=${news.id}" class="grey" ><h4>${news.title}</h4></a>
                        </c:forEach>

            </div>
        </div>
        <img src="images/footer.jpg" alt="footer" class="web-width"/>
    </body>
    <script>
        window.history.pushState("", "", 'getsearchpage');
    </script>
</html>
