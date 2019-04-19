<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
    <title>All</title>


    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css">

</head>
<body class="d-flex flex-column h-100">


<jsp:include page="WEB-INF/views/header_nlogout.jsp"/>

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
