<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<html>
<head>
<link href="./css/custom.css" rel="stylesheet">

<link href="./css/vittoriostyle.css" rel="stylesheet">


<%--<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous"> --%>

<title>Login SAMPLE</title>
</head>
<body class="login">

       <header>
            <h2 class="title text-center">LOGIN</h2>
       </header>

		<main class="main-login">
		    <form class="login-form " action=LoginServlet?mode=signup method="post">

                <div class="">
                    <label class="" for="user">Username: </label>
                    <input class="" type="text" id="user" name="username" placeholder="Insert username">
                </div>

                <div class="">
                    <label class="" for="pass">Password: </label>
                    <input class="" type="password" id="pass" name="password" placeholder="Insert password">
                </div>

                <button class="" type="submit" value="Login" name="pulsante">Login</button>
            </form>
            <div>
                <a class="button-back" href="./index.jsp">Indietro</a>
            </div>
		</main>

	
</body>
</html>