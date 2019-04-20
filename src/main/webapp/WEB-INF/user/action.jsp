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
            /*position: relative;*/
            margin-bottom: 1.5em;
            border: 3px solid #a5cddf;
            padding: 0.6em;
            border-radius: 4px;
            background: #FEFEFE;
            color: #231F20;
            font-size: 14pt;
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
    </style>
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
<form class="navbar-form pull-left" method="post" action="${pageContext.request.contextPath}/app/action">
    <input class="span2" name="content" id="content" type="text" placeholder="" required>
    <button type="submit" class="btn" value="create" name="create">Create</button>

</form>
<div>
    <c:forEach var="request" items="${requestScope.list}">
    <ol class="bullet">
        <li>Content: <c:out value="${request.content}"/>
        Date: <c:out value="${request.date}"/>
        Status: <c:out value="${request.accepted}"/>
        <c:if test="${request.comment!=''}">
            Comment: <c:out value="${request.comment}"/>
        </c:if>

        <form method="post" action="${pageContext.request.contextPath}/app/action">
    <label>
        <input type="hidden" name="dN" value="${request.id}">
        <input type="submit" class="btn btn-danger" name="delete" value="Delete">
    </label>
        </form>
        </  li>
    </ol>

    </c:forEach>



</div>
<tags:pagination pagination="${requestScope.pagination}"/>
</body>
</html>
