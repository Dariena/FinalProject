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
    <title>Manager</title>
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

        [type="radio"]:checked,
        [type="radio"]:not(:checked) {
            position: absolute;
            left: -9999px;
        }
        [type="radio"]:checked + label,
        [type="radio"]:not(:checked) + label
        {
            position: relative;
            padding-left: 28px;
            cursor: pointer;
            line-height: 20px;
            display: inline-block;
            color: #666;
        }
        [type="radio"]:checked + label:before,
        [type="radio"]:not(:checked) + label:before {
            content: '';
            position: absolute;
            left: 0;
            top: 0;
            width: 18px;
            height: 18px;
            border: 1px solid #ddd;
            border-radius: 100%;
            background: #fff;
        }
        [type="radio"]:checked + label:after,
        [type="radio"]:not(:checked) + label:after {
            content: '';
            width: 12px;
            height: 12px;
            background: #F87DA9;
            position: absolute;
            top: 4px;
            left: 4px;
            border-radius: 100%;
            -webkit-transition: all 0.2s ease;
            transition: all 0.2s ease;
        }
        [type="radio"]:not(:checked) + label:after {
            opacity: 0;
            -webkit-transform: scale(0);
            transform: scale(0);
        }
        [type="radio"]:checked + label:after {
            opacity: 1;
            -webkit-transform: scale(1);
            transform: scale(1);
        }

    </style>

</head>
<body>
<p>Request for manager</p>
<jsp:include page="../views/header_nlogout.jsp"/>

<div class="container">
    <div class="row margin">
        <ol class="bullet">
            <table class="table table-hover">
            <c:forEach var="request" items="${requestScope.list}">
                <tr>
                    <td><c:out value="${request.content}"/></td>
                    <td><c:out value="${request.date}"/></td>
                    <td><form method="post" action="${pageContext.request.contextPath}/app/actionManager">
                            <div class="mydiv">
                               <p> <label for="radio${request.id}">Accepted</label>
                                <input id="radio${request.id}" class="col-md-6 mb-6" type="radio" name="radio${request.id}"
                                       value="ACCEPTED" checked></p><p>
                                <label for="radio${request.id}">Rejected</label>
                                <input id="radio${request.id}" type="radio" class="col-md-6 mb-6" name="radio${request.id}"
                                       value="REJECTED"></p>
                            </div>
                        <div class="mydiv">
                            <input style="height: 30px; margin-top: -1px" name="comment" id="content" type="text" placeholder="" required>
                        </div>
                        <div class="mydiv">
                            <label><input class=" btn btn-primary" type="submit" name="action" value="OK"></label>
                            <input class="col-md-6 mb-6" type="hidden" name="dN" value="${request.id}">
                        </div>
                    </form></td>
                </tr>
                <%--<li>
                    <div class="col-md-6 mb-6">Content: <c:out value="${request.content}"/></div>
                    <div class="col-md-6 mb-6">Date: <c:out value="${request.date}"/></div>
                    <form method="post" action="${pageContext.request.contextPath}/app/actionManager">
                        <label>Status:
                            <label>
                                Accepted<input class="col-md-6 mb-6" type="radio" name="radio${request.id}"
                                                  value="ACCEPTED" checked>
                                Rejected<input type="radio" class="col-md-6 mb-6" name="radio${request.id}"
                                               value="REJECTED">
                            </label>
                            <textarea rows="3" name="comment" required></textarea>
                            <label><input class=" btn btn-primary" type="submit" name="action" value="OK"></label>
                            <input class="col-md-6 mb-6" type="hidden" name="dN" value="${request.id}">
                        </label>
                    </form>
                </li>
--%>
            </c:forEach>
            </table>
        </ol>
        <tags:pagination pagination="${requestScope.pagination}"/>
    </div>
</div>

</body>
</html>
