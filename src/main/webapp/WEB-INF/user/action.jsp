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
    <title>User</title>
    <style>

        .margin {
            margin-top: 5%;
        }

        label {
            font-size: 14pt;
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
<jsp:include page="../views/header_nlogout.jsp"/>
<div class="nav-collapse collapse">
    <ul class="nav">
        <li>
            <a href="${pageContext.request.contextPath}/app/reviewAll">${requestScope.langBundle.getString("REVIEWS")}</a>
        </li>
        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">${requestScope.langBundle.getString("LANGUAGE")}
                <b class="caret"></b></a>
            <ul class="dropdown-menu">

                <li><a type="submit"
                       href="${pageContext.request.contextPath}/app/action?lang=uk_ua">${requestScope.langBundle.getString("UA")}</a>
                </li>
                <li class="divider"></li>
                <li><a type="submit"
                       href="${pageContext.request.contextPath}/app/action?lang=en_uk">${requestScope.langBundle.getString("EN")}</a>
                </li>
            </ul>
        </li>
    </ul>
</div>

<div class="container">
    <form class="navbar-form" method="post" action="${pageContext.request.contextPath}/app/action">
        <input style="height: 30px; width: 50%; margin-top: -1px" name="content" id="content" type="text" placeholder="" required>
        <button type="submit" class="btn" value="create" name="create">Create</button>
    </form>
    <div class="row margin">
        <table class="table table-hover">
            <thead>
            <tr>
                <th>#</th>
                <th>Content</th>
                <th>Date</th>
                <th>Status</th>
                <th>Comment</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="request" items="${requestScope.list}">
                <tr>
                    <td></td>
                    <td><c:out value="${request.content}"/></td>
                    <td><c:out value="${request.date}"/></td>
                    <td><c:out value="${request.accepted}"/></td>
                    <td><c:if test="${request.comment!=''}">
                        <c:out value="${request.comment}"/>
                    </c:if></td>
                    <td>
                        <form method="post" action="${pageContext.request.contextPath}/app/action">
                            <input type="hidden" name="dN" value="${request.id}">
                            <input type="submit" class="btn btn-danger" name="delete" value="Delete">
                        </form>
                    </td>
                </tr>

            </c:forEach>
            </tbody>
        </table>

    </div>
</div>
<div class="text-center">
    <tags:pagination pagination="${requestScope.pagination}"/>
</div>
</body>
</html>
