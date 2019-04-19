<%--
  Created by IntelliJ IDEA.
  User: GlaDOS
  Date: 29 Mar 2019
  Time: 12:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Moderator</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css">


</head>
<body>
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="brand" href="${pageContext.request.contextPath}/app/home">${requestScope.langBundle.getString("YOUR_REPAIRS")}</a>
            <div class="nav-collapse collapse">
                <ul class="nav">
                    <li><a href="${pageContext.request.contextPath}/app/reviewAll">${requestScope.langBundle.getString("REVIEWS")}</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">${requestScope.langBundle.getString("LANGUAGE")} <b class="caret"></b></a>
                        <ul class="dropdown-menu">

                            <li><a type="submit" href="${pageContext.request.contextPath}/app/home?lang=uk_ua">${requestScope.langBundle.getString("UA")}</a></li>
                            <li class="divider"></li>
                            <li><a type="submit" href="${pageContext.request.contextPath}/app/home?lang=en_uk">${requestScope.langBundle.getString("EN")}</a></li>

                        </ul>

                    </li>
                </ul>
                <form class="navbar-form pull-right" method="post" action="${pageContext.request.contextPath}/app/home">
                    <input class="span2" name="email" id="email" type="text" placeholder="${requestScope.langBundle.getString("EMAIL")}">
                    <input class="span2" name="password" id="password" type="password" placeholder="${requestScope.langBundle.getString("PASSWORD")}">
                    <button type="submit" class="btn btn-primary" value="Login">${requestScope.langBundle.getString("LOG_IN")}</button>
                    <a  class="btn btn-primary" href="${pageContext.request.contextPath}/app/registration">${requestScope.langBundle.getString("SIGN_UP")}</a><br>

                </form>
            </div><!--/.nav-collapse -->
        </div>
    </div>
</div>

</body>
</html>
