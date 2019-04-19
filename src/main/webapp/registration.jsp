<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Registration</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/2.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/2.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css">
    <style>
        .margin {
            margin-top: 5%;
        }
    </style>
</head>

<body>

<jsp:include page="WEB-INF/views/header_nlogout.jsp"/>
<div class="container">



        <div class="col-md-12 mb-2 mt-4 margin">
            <h4>Registration</h4>
        </div>


    <div class="container">
        <div class="col-12 md-6">
        <form action="${pageContext.request.contextPath}/app/registration" method="post" class="needs-validation">

                <div class="col-md-6 mb-6">
                    <label for="firstNameUk">First name</label>
                    <input type="text" name="firstNameUk" id="firstNameUk" placeholder=""
                           value="" required>
                </div>

                <div class="col-md-6 mb-6">
                    <label for="surNameUk">Surname</label>
                    <input type="text" name="surNameUk" id="surNameUk" placeholder="" value=""
                           required>
                </div>
                <div class="col-md-6 mb-6">
                    <label for="firstNameUa">First nameUa</label>
                    <input type="text" name="firstNameUa" id="firstNameUa" placeholder=""
                           value="" required>
                </div>
                <div class="col-md-6 mb-6">
                    <label for="surNameUa">SurnameUa</label>
                    <input type="text" name="surNameUa" id="surNameUa" placeholder="" value=""
                           required>
                </div>
                <div class="col-md-6 mb-6">
                    <label for="email">Email</label>
                    <input type="email" name="email" id="email" placeholder="you@example.com"
                           required>
                </div>

                <div class="mb-4">
                    <label for="password">Password</label>
                    <input type="password" name="password" id="password" required>
                </div>
            <hr class="mb-4">
            <input type="submit" class="btn btn-primary btn-submit" name="submitRegistration" value="Registration">
        </form>
        </div>
    </div>
</div>
</body>
</html>
