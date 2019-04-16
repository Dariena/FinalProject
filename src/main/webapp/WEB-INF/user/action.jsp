<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<jsp:include page="../views/header.jsp"/>
<form class="navbar-form pull-right" method="post" action="${pageContext.request.contextPath}/app/action">
    <input class="span2" name="content" id="content" type="text" placeholder="">
    <button type="submit" class="btn" value="Request">Create</button>

</form>
<div>
    <c:forEach var="request" items="${sessionScope.request}">
    <ul>
        <li>Content: <c:out value="${request.content}"/></li>
        <li>Date: <c:out value="${request.date}"/></li>
        <li>Status: <c:out value="${request.accepted}"/></li>
        <c:if test="${request.comment!=''}"><li>Comment: <c:out value="${request.comment}"/></li>
        </c:if>
    </ul>
    </c:forEach>
</div>
</body>
</html>
