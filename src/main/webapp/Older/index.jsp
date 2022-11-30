<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<html>
<head>
    <link href="css/vittoriostyle.css" rel="stylesheet">
    <link href="css/custom.css" rel="stylesheet">

    <title>Login SAMPLE</title>
</head>
<body>
<div class="login-container">
    <div class="login" id="loginContainer">
        <h3 class="header">Health Wellness</h3>
        <form class="login" action="/users/login" method="post">
            <label for="user">Username: </label>
            <input type="text" id="user" name="username" placeholder="Insert username"/>
            <label for="pass">Password: </label>
            <input type="password" id="pass" name="password" placeholder="Insert password"/>
            <button type="submit" value="Login" name="pulsante">Login</button>
            <div class="row text-align-center">
                oppure<br/><br/>
                <a href="#" class="toggleShowHideTarget item-btn float-none" data-target-hide="#loginContainer" data-target-show="#insertForm">Registrati</a>
            </div>
        </form>
    </div>
    <%@include file="user/insert-not-logged.jsp" %>
    <div id="footerAbsolute">
        <%@include file="tpl/footer.jsp" %>
    </div>
    <script type="text/javascript">
        $(function(){
            let userAdded = getUrlParameter('userAdded');
            if (typeof userAdded != "undefined" && userAdded == "true") {
                alert("Operazione completata con successo. Ora puoi eseguire il login!");
            }
        });
    </script>
</div>
</body>
</html>