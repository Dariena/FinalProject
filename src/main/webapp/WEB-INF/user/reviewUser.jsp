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
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/2.3.1/css/bootstrap.min.css">
    <style>
        .margin {
            margin-top: 5%;
        }

        table {
            counter-reset: rowNumber;
        }

        table tbody tr {
            counter-increment: rowNumber;
        }

        table tbody tr td:first-child::before {
            content: counter(rowNumber);
            min-width: 1em;
            margin-right: 0.5em;
        }

        form{
            margin-top: 5%;
        }
    </style>
</head>
<body>
<jsp:include page="../views/header_nlogout.jsp"/>

<div class="container">
    <form style="margin-top: 5%" class="navbar-form" method="post" action="${pageContext.request.contextPath}/app/reviewUser">
        <input style="height: 31px; width: 50%; margin-top: -1px" name="content" id="content" type="text" placeholder="" required>
        <button type="submit" class="btn" value="create" name="create">Create</button>
    </form>

    <div class="row margin">
        <table class="table table-hover">
            <thead>
            <tr>
                <th>#</th>
                <th>Content</th>
                <th>Date</th>
                <th>Email</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="review" items="${sessionScope.review}">
                <tr>
                    <td></td>
                    <td>
                        <div class="col-md-6 mb-3"><c:out value="${review.content}"/></div>
                    </td>
                    <td>
                        <div class="col-md-6 mb-3"><c:out value="${review.date}"/></div>
                    </td>
                    <td>
                        <div class="col-md-6 mb-3"><c:out value="${review.email}"/></div>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</div>
</body>
</html>
