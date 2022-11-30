<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<div class="row" id="insertForm">
    <div class="row">
        <h3>Inserisci nuovo utente</h3>
        <div class="closeInsert toggleShowHideTarget" data-target-show="#listItems" data-target-hide="#insertForm">&times;</div>
    </div>
    <form class="insert" action="${pageContext.request.contextPath}/users/insert" method="post">
        <div class="row legendForm">
            (*) Campi obbligatori
        </div>
        <div class="row">
            <div class="col-25">
                <label for="user">Username <span class="requiredFields">(*)</span></label>
            </div>
            <div class="col-75">
                <input type="text" id="user" name="username" placeholder="inserisci username" required>
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="pass">Password <span class="requiredFields">(*)</span></label>
            </div>
            <div class="col-75">
                <input type="text" id="pass" name="password" placeholder="Inserisci password" required>
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="type">Usertype</label>
            </div>
            <div class="col-75">
                <select id="type" name="usertype">
                    <option value="ADMIN">ADMIN</option>
                    <option value="USER">USER</option>
                </select>
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="firstname">Nome <span class="requiredFields">(*)</span></label>
            </div>
            <div class="col-75">
                <input type="text" id="firstname" name="firstname" placeholder="Inserisci Nome" required>
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="lastname">Cognome <span class="requiredFields">(*)</span></label>
            </div>
            <div class="col-75">
                <input type="text" id="lastname" name="lastname" placeholder="Inserisci Cognome" required>
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="address">Indirizzo</label>
            </div>
            <div class="col-75">
                <input type="text" id="address" name="address" placeholder="Inserisci Indirizzo">
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="zipcode">CAP</label>
            </div>
            <div class="col-75">
                <input type="text" id="zipcode" name="zipcode" placeholder="Inserisci CAP">
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="city">Città</label>
            </div>
            <div class="col-75">
                <input type="text" id="city" name="city" placeholder="Inserisci Città">
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="province">Provincia</label>
            </div>
            <div class="col-75">
                <input type="text" id="province" name="province" placeholder="Inserisci Provincia">
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="email">Email <span class="requiredFields">(*)</span></label>
            </div>
            <div class="col-75">
                <input type="email" id="email" name="email" placeholder="Inserisci Email" required>
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="phone">Telefono</label>
            </div>
            <div class="col-75">
                <input type="text" id="phone" name="phone" placeholder="Inserisci Telefono">
            </div>
        </div>
        <button type="submit">Salva</button>
    </form>
</div>