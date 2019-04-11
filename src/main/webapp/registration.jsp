<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Registration</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css">

</head>

<jsp:include page="WEB-INF/views/header_nlogout.jsp"/>

<div class="container">


    <div class="row ">

        <div class="col-md-12 mb-2 mt-4">
            <h4 class="mb-3">Registration</h4>

            <form action="${pageContext.request.contextPath}/app/registration" method="post" class="needs-validation">

                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="firstNameUk">First name</label>
                        <input type="text" class="form-control" name="firstNameUk" id="firstNameUk" placeholder="" value="" required>
                        <div class="invalid-feedback">
                            Valid first name is required.
                        </div>
                    </div>

                    <div class="col-md-6 mb-3">
                        <label for="surNameUk">Surname</label>
                        <input type="text" class="form-control" name="surNameUk" id="surNameUk" placeholder="" value="" required>
                        <div class="invalid-feedback">
                            Valid last name is required.
                        </div>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="firstNameUa">First nameUa</label>
                        <input type="text" class="form-control" name="firstNameUa" id="firstNameUa" placeholder="" value="" required>
                        <div class="invalid-feedback">
                            Valid first name is required.
                        </div>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="surNameUa">SurnameUa</label>
                        <input type="text" class="form-control" name="surNameUa" id="surNameUa" placeholder="" value="" required>
                        <div class="invalid-feedback">
                            Valid last name is required.
                        </div>
                    </div>
                </div>

                <div class="mb-3">
                    <label for="email">Email</label>
                    <input type="email" class="form-control" name="email" id="email" placeholder="you@example.com" required>
                    <div class="invalid-feedback">
                        Email is invalid.
                    </div>
                </div>

                <div class="mb-3">
                    <label for="password">Password</label>
                    <input type="password" class="form-control" name="password" id="password" required>
                    <div class="invalid-feedback">
                        Password is invalid.
                    </div>
                </div>

                <div class="mb-3">
                    <label for="phone">Phone</label>
                    <input type="phone" class="form-control" name="phone" id="phone" required>
                    <div class="invalid-feedback">
                        Phone is invalid.
                    </div>
                </div>

                <hr class="mb-4">
                <input type="submit" class="form-control btn-submit" name="submitRegistration" value="Registration">
            </form>
        </div>
    </div>

</div>


</body>
</html>
