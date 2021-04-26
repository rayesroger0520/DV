<%-- 
    Document   : mainbody
    Created on : Mar 20, 2020, 11:25:05 AM
    Author     : thinh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="public/stylesheets/style.css" rel="stylesheet" type="text/css"/>
        <script src="public/javascripts/myfunction.js"></script>
    </head>
    <body>
        <div class="header white">
            <img src="public/images/preheader.jpg" class="web-width" alt="preheader"/>
        </div>
        <div class="header white">
            <img src="public/images/header.jpg" alt="header" class="web-width"/>
            <div class="top-left font-large">My Digital News</div>
        </div>
        <div class="header white">
            <img src="public/images/menu.jpg" alt="menu" class="web-width"/>
            <div class="center-left font-medium"><a class="title-colorA" href="home">News</a></div>
        </div>
        <div class="main">
            <div class="content">

            </div>
            <!--Side bar-->
            <div class="sidebar-right">
                <h1 class="title-color option-header">Digital News</h1>
                <div>
                    LOL
                </div>

                <h1 class="title-color option-header">Search</h1>
                <form action="newssearch" method="GET">
                    <input type="text" name="name" value="" class="input" required="true"/>
                    <input type="submit" value="Go" class="button"/>
                </form>

                <h1 class="title-color option-header">Last Articles</h1>




                <a href="newsinfo?id=#" class="grey" ><h4>Lol</h4></a>

            </div>
        </div>
        <img src="public/images/footer.jpg" alt="footer" class="web-width"/>
    </body>
</html>
