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
<p>Request for manager</p>
<jsp:include page="../views/header_nlogout.jsp"/>

<div>

    <c:forEach var="request" items="${requestScope.request}">
        <%--<c:if test="${request.accepted=='UNREAD'}">--%>
        <ul>
            <li>Content: <c:out value="${request.content}"/></li>
            <li>Date: <c:out value="${request.date}"/></li>
            <li>
            <form method="post" action="${pageContext.request.contextPath}/app/actionManager">
            <label>Status
                <input type="radio" name="radio${request.id}" value="ACCEPTED">Accepted
                <input type="radio" name="radio${request.id}" value="REJECTED">Rejected
                <input class="span2" name="comment" id="comment" type="text" placeholder="">
                <input type="submit" name="action" value="OK" >
                <input type="hidden" name="dN" value="${request.id}">
            </label>
            </form>
            </li>


        </ul>
       <%-- </c:if>--%>
    </c:forEach>
</div>
</body>
</html>
