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
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css">


</head>
<body>

<nav class="navbar navbar-expand-lg sticky-top navbar-default">

    <%--<div class="collapse navbar-collapse ml-4">
        <ul class="navbar-nav">

            <li class="nav-item active">
                <a class="nav-link" href="${pageContext.request.contextPath}/app/home">Home</a>
            </li>

        </ul>
    </div>--%>

    <div class="collapse navbar-collapse justify-content-end">

        <a class="nav-link" href="${pageContext.request.contextPath}/app/logout">Logout</a>


    </div>
</nav>

</body>
</html>
