<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" import="java.util.List"%>

<%@include file="/WebContent/head.jsp" %>

<body class="bg-gradient-primary">
<div class="container">
    <div class="card shadow-lg o-hidden border-0 my-5">
        <div class="card-body p-0"><div class="row">
            <div class="col-lg-5 d-none d-lg-flex">
                <div class="flex-grow-1 bg-register-image" style="background-image: url(&quot;assets/img/dogs/image2.jpeg&quot;);">

                </div>
            </div>
            <div class="col-lg-7"><div class="p-5"><div class="text-center">
                <h4 class="text-dark mb-4">Create an Account!</h4>
            </div>
                <form class="user" action="/users/insert" method="post"><div class="row mb-3">
                    <div class="col-sm-6 mb-3 mb-sm-0">
                        <input class="form-control form-control-user" type="text" id="exampleFirstName" placeholder="First Name" name="firstname">
                    </div>
                    <div class="col-sm-6">
                        <input class="form-control form-control-user" type="text" id="exampleLastName" placeholder="Last Name" name="lastname">
                    </div>
                </div>
                    <div class="mb-3">
                        <input class="form-control form-control-user" type="email" id="exampleInputEmail" aria-describedby="emailHelp" placeholder="Email Address" name="email">
                    </div>
                    <div class="row mb-3">
                        <div class="col-sm-6 mb-3 mb-sm-0">
                            <input class="form-control form-control-user" type="password" id="examplePasswordInput" placeholder="Password" name="password">
                        </div>
                        <div class="col-sm-6"><input class="form-control form-control-user" type="password" id="exampleRepeatPasswordInput" placeholder="Repeat Password" name="password_repeat">
                        </div>
                        <div class="col-sm-6"><input class="form-control form-control-user" type="text" id="exampleRepeatPasswordInput-1" placeholder="Phone Number" name="phone" style="margin-top: 11px;">
                        </div>
                    </div>
                    <button class="btn btn-primary d-block btn-user w-100" type="submit">Register Account</button>
                    <hr>
                    <hr>
                </form>
                <div class="text-center">
                    <a class="small" href="forgot-password.html">Forgot Password?</a>
                </div>
                <div class="text-center">
                    <a class="small" href="login.html">Already have an account? Login!</a>
                </div>
            </div>
            </div>
        </div>
        </div>
    </div>
</div>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<script src="assets/js/script.min.js"></script>
</body>
</html>