<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dasha
  Date: 2019-04-16
  Time: 18:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Review</title>
</head>

<body>
<jsp:include page="../views/header_nlogout.jsp"/>
<form class="navbar-form pull-right" method="post" action="${pageContext.request.contextPath}/app/reviewUser">
    <input class="span2" name="content" id="content" type="text" placeholder="" required>
    <button type="submit" class="btn" value="Request">Create</button>

</form>
<div>
    <c:forEach var="review" items="${sessionScope.review}">
        <ul>
            <li>Content: <c:out value="${review.content}"/></li>
            <li>Date: <c:out value="${review.date}"/></li>
            <li>User`s email: <c:out value="${review.email}"/></li>
        </ul>
    </c:forEach>
</div>
</body>
</html>
