<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
    <title>All</title>


    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/2.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css">
    <style>
        .margin{
            margin-top: 5%;
        }
    </style>
</head>
<body>
<jsp:include page="WEB-INF/views/header_nlogout.jsp"/>

<div class="container">

    <div class="row margin">
        <c:forEach var="review" items="${sessionScope.review}">
            <div class="col-md-6 mb-3">Content: <c:out value="${review.content}"/></div>
            <div class="col-md-6 mb-3"> Date: <c:out value="${review.date}"/></div>
            <div class="col-md-6 mb-3">User`s email: <c:out value="${review.email}"/></div>
            <hr>
        </c:forEach>

    </div>

</div>


</body>
</html>
