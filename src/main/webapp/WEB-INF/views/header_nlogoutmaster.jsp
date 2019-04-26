<%--
  Created by IntelliJ IDEA.
  User: dasha
  Date: 2019-04-09
  Time: 12:34
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Your Repairs</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le styles -->
    <link type="text/css" href="${pageContext.request.contextPath}/static/css/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/2.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css">
    <link rel="" href="${pageContext.request.contextPath}static/img/tool-1957451_1280.jpg">



    <link type="text/css" href="${pageContext.request.contextPath}/static/css/bootstrap-responsive.css" rel="stylesheet">




    <!-- Fav and touch icons -->

    <link rel="shortcut icon" href="${pageContext.request.contextPath}/static/ico/favicon.png">
</head>

<body>
    <div class="navbar navbar-inverse navbar-fixed-top">
        <div class="navbar-inner">
            <div class="container">
                <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="brand" href="${pageContext.request.contextPath}/app/home">${requestScope.langBundle.getString("YOUR_REPAIRS")}</a>
                <div class="nav-collapse collapse">
                    <ul class="nav">
                        <li><a href="${pageContext.request.contextPath}/app/reviewAll">${requestScope.langBundle.getString("REVIEWS")}</a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">${requestScope.langBundle.getString("LANGUAGE")} <b class="caret"></b></a>
                            <ul class="dropdown-menu">

                                <li><a type="submit" href="${pageContext.request.contextPath}/app/actionMaster?lang=uk_ua">${requestScope.langBundle.getString("UA")}</a></li>
                                <li class="divider"></li>
                                <li><a type="submit" href="${pageContext.request.contextPath}/app/actionMaster?lang=en_uk">${requestScope.langBundle.getString("EN")}</a></li>

                            </ul>

                        </li>
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
        </div>
    </div>

<!-- Le javascript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="${pageContext.request.contextPath}/static/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/static/js/bootstrap-transition.js"></script>
<script src="${pageContext.request.contextPath}/static/js/bootstrap-alert.js"></script>
<script src="${pageContext.request.contextPath}/static/js/bootstrap-modal.js"></script>
<script src="${pageContext.request.contextPath}/static/js/bootstrap-dropdown.js"></script>
<script src="${pageContext.request.contextPath}/static/js/bootstrap-scrollspy.js"></script>
<script src="${pageContext.request.contextPath}/static/js/bootstrap-tab.js"></script>
<script src="${pageContext.request.contextPath}/static/js/bootstrap-tooltip.js"></script>
<script src="${pageContext.request.contextPath}/static/js/bootstrap-popover.js"></script>
<script src="${pageContext.request.contextPath}/static/js/bootstrap-button.js"></script>
<script src="${pageContext.request.contextPath}/static/js/bootstrap-collapse.js"></script>
<script src="${pageContext.request.contextPath}/static/js/bootstrap-carousel.js"></script>
<script src="${pageContext.request.contextPath}/static/js/bootstrap-typeahead.js"></script>

</body>
</html>

