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

</head>
<body>
<h1>Request for master</h1>
<jsp:include page="../views/header_nlogout.jsp"/>

<div>

    <c:forEach var="request" items="${requestScope.list}">
       <%-- <c:if test="${request.accepted=='ACCEPTED'}">--%>
            <ul>
                <li>Content: <c:out value="${request.content}"/></li>
                <li>Date: <c:out value="${request.date}"/></li>
                <li>
                    <form method="post" action="${pageContext.request.contextPath}/app/actionMaster">
                        <label>Status
                            <input type="radio" name="radio${request.id}" value="IN_PROCESS">In process
                            <input type="radio" name="radio${request.id}" value="REJECTED">Ready
                            <input type="submit" name="action" value="OK" >
                            <input type="hidden" name="dN" value="${request.id}">
                        </label>
                    </form>
                </li>


            </ul>
       <%-- </c:if>--%>
    </c:forEach>

    <tags:pagination pagination="${requestScope.pagination}"/>
</div>
</body>
</html>
