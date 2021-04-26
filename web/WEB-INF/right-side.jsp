<%-- 
    Document   : right-side
    Created on : Mar 20, 2020, 11:35:05 AM
    Author     : thinh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <h1 class="title-color option-header">Digital News</h1>
        <div>
            ${latestNews.shortDescription}
        </div>

        <h1 class="title-color option-header">Search</h1>
        <form action="getsearchpage" method="GET">
            <input type="text" name="search" value="" class="input" required="true"/>
            <input type="submit" value="Go" class="button"/>
        </form>

        <h1 class="title-color option-header">Last Articles</h1>

    <c:forEach items="${list}" var="news">
        <a href="newsinfo?id=${news.id}" class="grey" ><h4>${news.title}</h4></a>
    </c:forEach>

</body>
</html>
