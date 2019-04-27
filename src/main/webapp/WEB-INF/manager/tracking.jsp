<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: dasha
  Date: 2019-04-27
  Time: 21:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tracking</title>
    <style>

        .margin {
            margin-top: 5%;
        }

        .bullet {
            margin-left: 0;
            list-style: none;
            counter-reset: li;

        }

        .bullet li {
            position: relative;
            margin-bottom: 1.5em;
            border: 3px solid #a5cddf;
            padding: 0.6em;
            border-radius: 4px;
            background: #FEFEFE;
            color: #231F20;
            font-size: 14pt;
            display: inline-block;
        }

        .bullet li:before {
            position: absolute;
            top: -0.7em;
            padding-left: 0.4em;
            padding-right: 0.4em;
            font-size: 14pt;
            font-weight: bold;
            color: #DCC24B;
            background: #FEFEFE;
            border-radius: 50%;
            counter-increment: li;
            content: counter(li);

        }

        label {
            font-size: 14pt;
        }

        .mydiv {
            float: left;
            padding: 10px;
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

    </style>
</head>

<body>
<jsp:include page="../views/header_nlogoutmanager.jsp"/>
<div class="container">
    <div class="row margin">
        <c:choose>
            <c:when test="${not empty requestScope.list}">
                <h1>Request list</h1>
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Content</th>
                        <th>Date</th>
                        <th>State</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="request" items="${requestScope.list}">
                        <tr>
                            <td></td>
                            <td><c:out value="${request.content}"/></td>
                            <td><c:out value="${request.date}"/></td>
                            <td><c:out value="${request.accepted}"/></td>
                            <td ><c:out value="${request.id}"/>
                            <td>
                                <c:forEach var="account" items="${requestScope.req}">
                                    <c:out value="${account}"/>
                                </c:forEach>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:when>


            <c:otherwise>
                <h1>Request list is empty</h1>
            </c:otherwise>
        </c:choose>
        <tags:pagination pagination="${requestScope.pagination}"/>
    </div>
</div>
</body>
</html>
