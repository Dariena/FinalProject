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

    <style type="text/css">
        body {
            padding-top: 60px;
            padding-bottom: 40px;
        }
    </style>
    <link type="text/css" href="${pageContext.request.contextPath}/static/css/bootstrap-responsive.css" rel="stylesheet">




    <!-- Fav and touch icons -->
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="${pageContext.request.contextPath}/static/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="${pageContext.request.contextPath}/static/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="${pageContext.request.contextPath}/static/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="${pageContext.request.contextPath}/static/ico/apple-touch-icon-57-precomposed.png">
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
            <a class="brand" href="#">Your Repairs</a>
            <div class="nav-collapse collapse">
                <ul class="nav">
                    <li class="active"><a href="#">Home</a></li>
                    <li><a href="#">Reviews</a></li>
                    <li><a href="#">Contact</a></li>
                </ul>
                <form class="navbar-form pull-right" method="post" action="${pageContext.request.contextPath}/app/login">
                    <input class="span2" name="email" id="email" type="text" placeholder="Email">
                    <input class="span2" name="password" id="password" type="password" placeholder="Password">
                    <button type="submit" class="btn" value="Login">Sign in</button>
                    <a  class="btn" href="${pageContext.request.contextPath}/app/registration">Registration</a><br>

                </form>
            </div><!--/.nav-collapse -->
        </div>
    </div>
</div>

<div class="container">

    <!-- Main hero unit for a primary marketing message or call to action -->
    <div class="hero-unit">
        <h1>Hello, world!</h1>
        <p>This is a template for a simple marketing or informational website. It includes a large callout called the hero unit and three supporting pieces of content. Use it as a starting point to create something more unique.</p>
        <p><a href="#" class="btn btn-primary btn-large">Learn more &raquo;</a></p>
    </div>

    <!-- Example row of columns -->
    <div class="row">
        <div class="span4">
            <h2>Heading</h2>
            <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
            <p><a class="btn" href="#">View details &raquo;</a></p>
        </div>
        <div class="span4">
            <h2>Heading</h2>
            <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
            <p><a class="btn" href="#">View details &raquo;</a></p>
        </div>
        <div class="span4">
            <h2>Heading</h2>
            <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>
            <p><a class="btn" href="#">View details &raquo;</a></p>
        </div>
    </div>

    <hr>

    <footer>
        <p>&copy; Company 2013</p>
    </footer>

</div> <!-- /container -->

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

