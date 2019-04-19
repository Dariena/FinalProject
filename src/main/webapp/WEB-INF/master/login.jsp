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

    /* Carousel base class */
    .carousel {
    margin-bottom: 60px;
    }

    .carousel .container {
    position: absolute;
    right: 0;
    bottom: 0;
    left: 0;
    }

    .carousel-control {
    background-color: transparent;
    border: 0;
    font-size: 120px;
    margin-top: 0;
    text-shadow: 0 1px 1px rgba(0,0,0,.4);
    }

    .carousel .item {
    height: 500px;
    }
    .carousel img {
    min-width: 100%;
    height: 130%;
    }

    .carousel-caption {
    background-color: transparent;
    position: static;
    max-width: 550px;
    padding: 0 20px;
    margin-bottom: 30px;
    }
    .carousel-caption h1,
    .carousel-caption .lead {
    margin: 0;
    line-height: 1.25;
    color: #000;
    text-shadow: 0 1px 1px rgba(0,0,0,.4);
    }
    .carousel-caption .btn {
    margin-top: 10px;
    }
    .margin {
        margin-top: 5%;
    }

    </style>
    <link type="text/css" href="${pageContext.request.contextPath}/static/css/bootstrap-responsive.css" rel="stylesheet">




    <!-- Fav and touch icons -->
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="${pageContext.request.contextPath}/static/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="${pageContext.request.contextPath}/static/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="${pageContext.request.contextPath}/static/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="${pageContext.request.contextPath}/static/ico/apple-touch-icon-57-precomposed.png">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/static/ico/favicon.png">
    <link rel="" href="${pageContext.request.contextPath}static/img/tool-1957451_1280.jpg">
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
            <a class="brand" href="${pageContext.request.contextPath}/app/home">Your Repairs</a>
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

                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">${requestScope.langBundle.getString("MY_OFFICE")}<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href=${pageContext.request.contextPath}/app/actionMaster>${requestScope.langBundle.getString("REQUESTS")}</a></li>
                            <li class="divider"></li>
                        <li> <a class="nav-link" href="${pageContext.request.contextPath}/app/logout">${requestScope.langBundle.getString("LOG_OUT")}</a></li>
                </ul>
            </div>
            <!--/.nav-collapse -->
        </div>
    </div>
</div>

<div class="container">

    <div class="container">

        <div id="myCarousel" class="carousel slide">
            <div class="carousel-inner">
                <div class="item active">
                    <img src="${pageContext.request.contextPath}/static/img/tool-1957451_1280.jpg" alt="">
                    <div class="container">
                        <div class="carousel-caption">
                            <h1>Example headline.</h1>
                            <p class="lead">Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                            <a class="btn btn-large btn-primary" href="${pageContext.request.contextPath}/app/registration">Sign up today</a>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <img src="${pageContext.request.contextPath}/static/img/tool-1957451_1280.jpg" alt="">
                    <div class="container">
                        <div class="carousel-caption">
                            <h1>Another example headline.</h1>
                            <p class="lead">Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                            <a class="btn btn-large btn-primary" href="#">Learn more</a>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <img src="${pageContext.request.contextPath}/static/img/tool-1957451_1280.jpg" alt="">
                    <div class="container">
                        <div class="carousel-caption">
                            <h1>One more for good measure.</h1>
                            <p class="lead">Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                            <a class="btn btn-large btn-primary" href="#">Browse gallery</a>
                        </div>
                    </div>
                </div>
            </div>
            <a class="left carousel-control" href="#myCarousel" data-slide="prev">&lsaquo;</a>
            <a class="right carousel-control" href="#myCarousel" data-slide="next">&rsaquo;</a>
        </div><!-- /.carousel -->
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

</div>
<!-- /container -->

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

