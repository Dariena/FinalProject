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
    <title>Master</title>
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


    </style>

</head>
<body>
<jsp:include page="../views/header_nlogout.jsp"/>
<h1>Request for master</h1>

<div class="container">
    <div class="row margin">
        <ol class="bullet">
            <c:forEach var="request" items="${requestScope.list}">

                    <li>
                        <div class="col-md-6 mb-6">Content: <c:out value="${request.content}"/></div>

                        <div class="col-md-6 mb-6">Date: <c:out value="${request.date}"/></div>

                        <form method="post" action="${pageContext.request.contextPath}/app/actionMaster">
                            <label><div class="col-md-6 mb-6">Status:</div>
                                <div class="col-md-6 mb-6"><input type="radio" name="radio${request.id}" value="IN_PROCESS" checked>In process</div>
                                <div class="col-md-6 mb-6"><input type="radio" name="radio${request.id}" value="READY">Ready</div>
                                <div class="col-md-6 mb-6"><input type="submit" name="action" value="OK"></div>
                                <input type="hidden" name="dN" value="${request.id}">
                            </label>
                        </form>
                    </li>

            </c:forEach>
        </ol>
    </div>
</div>
<div class="text-center">
    <tags:pagination pagination="${requestScope.pagination}"/>
</div>
</body>
</html>
