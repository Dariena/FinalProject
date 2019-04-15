<%--
  Created by IntelliJ IDEA.
  User: dasha
  Date: 2019-04-15
  Time: 13:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
<p>Action user</p>
<form class="navbar-form pull-right" method="post" action="${pageContext.request.contextPath}/app/action">
    <input class="span2" name="content" id="content" type="text" placeholder="">
    <button type="submit" class="btn" value="Request">Create</button>

</form>
</body>
</html>
