<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<html>
<head>
<link href="./css/custom.css" rel="stylesheet">
<link href="./css/vittoriostyle.css" rel="stylesheet">


<title>Login SAMPLE</title>
</head>
    <body>
        <header>
            <h2 class="title text-center">REGISTRAZIONE</h2>
        </header>

        <main class="main-signup">
            <form class="signup-form" action="LoginServlet?mode=signup" method="post">
                <div class="flex-row">
                    <div class="w-45">
                        <div class="flex-row justify-c-between">
                            <label for="user">Username: </label>
                            <input type="text" id="user" name="username" placeholder="Inserisci username">
                        </div>

                        <div class="flex-row justify-c-between">
                            <label for="user">Password: </label>
                            <input type="text" id="pass" name="password" placeholder="Inserisci password">
                        </div>

                        <div class="flex-row justify-c-between">
                            <label for="user">Email: </label>
                            <input type="text" id="em" name="email" placeholder="Inserisci email">
                        </div>

                        <div class="flex-row justify-c-between">
                            <label for="user">Telefono: </label>
                            <input type="text" id="pho" name="phone" placeholder="Inserisci telefono">
                        </div>

                        <div class="flex-row justify-c-between">
                            <label for="user">Nome: </label>
                            <input type="text" id="first" name="firstname" placeholder="Inserisci nome">
                        </div>

                        <div class="flex-row justify-c-between">
                            <label for="user">Cognome: </label>
                            <input type="text" id="last" name="lastname" placeholder="Inserisci cognome">
                        </div>
                    </div>

                    <div class="w-45">

                        <div class="flex-row justify-c-between">
                            <label for="user">Tipo utente: </label>
                            <select id="type" name="usertype">
                                <option value="ADMIN">ADMIN</option>
                                <option value="USER">USER</option>
                            </select>
                        </div>

                        <div class="flex-row justify-c-between">
                            <label for="user">Indirizzo: </label>
                            <input type="text" id="add" name="address" placeholder="Inserisci indirizzo">
                        </div>

                        <div class="flex-row justify-c-between">
                            <label for="user">Codice postale: </label>
                            <input type="text" id="zip" name="zipcode" placeholder="Inserisci codice postale">
                        </div>

                        <div class="flex-row justify-c-between">
                            <label for="user">Città: </label>
                            <input type="text" id="cit" name="city" placeholder="Inserisci città">
                        </div>

                        <div class="flex-row justify-c-between">
                            <label for="user">Provincia: </label>
                            <input type="text" id="pro" name="province" placeholder="Inserisci provincia">
                        </div>
                    </div>
                </div>
                <div class=" text-center">
                    <button class="button" type="submit" value="Login" name="pulsante">Registrati</button>

                    <a class="button-back" href="./index.jsp">Indietro</a>

                </div>
            </form>
        </main>
    </body>
</html>