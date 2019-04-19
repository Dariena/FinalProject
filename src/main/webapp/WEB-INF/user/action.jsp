<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
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
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/2.3.1/css/bootstrap.min.css">

</head>
<body>
<jsp:include page="../views/header_nlogout.jsp"/>
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
</div>
<form class="navbar-form pull-right" method="post" action="${pageContext.request.contextPath}/app/action">
    <input class="span2" name="content" id="content" type="text" placeholder="" required>
    <button type="submit" class="btn" value="Request">Create</button>

</form>
<div>
    <c:forEach var="request" items="${requestScope.list}">
    <ul>
        <li>Content: <c:out value="${request.content}"/></li>
        <li>Date: <c:out value="${request.date}"/></li>
        <li>Status: <c:out value="${request.accepted}"/></li>
        <c:if test="${request.comment!=''}"><li>Comment: <c:out value="${request.comment}"/></li>
        </c:if>
    </ul>
    </c:forEach>


</div>
<tags:pagination pagination="${pagination}"/>
</body>
</html>
