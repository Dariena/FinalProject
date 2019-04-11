<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
    <title>All</title>


    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css"/>

</head>
<body class="d-flex flex-column h-100">


<jsp:include page="WEB-INF/views/header.jsp"/>


<br><br>

<div class="container-fluid">

    <h2>All Users</h2>

    <table class="table my-3">

        <thead>
        <tr>
            <th scope="col">FirstName</th>
            <th scope="col">LastName</th>
            <th scope="col">Login</th>
            <th scope="col">Email</th>
        </tr>
        </thead>

        <tbody>

        <c:forEach var="event" items="${events}">
            <tr>
                <td>${event.id}</td>
                <td>${event.name}</td>
                <td>${event.dateTime}</td>
                <td>${event.location}</td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>



</body>
</html>
