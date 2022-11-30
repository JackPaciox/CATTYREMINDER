<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" import="it.contrader.dto.UserDTO" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <% session.setAttribute("currentSection", "users"); %>
    <%@include file="../tpl/head.jsp" %>
    <title>Edit User</title>
</head>
<body>
<%@include file="../tpl/head.jsp" %>

<%@include file="../tpl/navbar.jsp" %>

<div class="main update">

    <%UserDTO u = (UserDTO) request.getAttribute("dto");%>

    <div class="row" id="updateForm">
        <div class="row">
            <h3>Aggiorna dati utente</h3>
        </div>
        <form class="insert" action="<%=request.getContextPath()%>/users/update/<%=u.getId()%>" method="post">
            <div class="row legendForm">
                (*) Campi obbligatori
            </div>
            <div class="row">
                <div class="col-25">
                    <label for="user">Username <span class="requiredFields">(*)</span></label>
                </div>
                <div class="col-75">
                    <input type="text" id="user" name="username" value=<%=u.getUsername()%> required>
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label for="pass">Password <span class="requiredFields">(*)</span></label>
                </div>
                <div class="col-75">
                    <input type="text" id="pass" name="password" value=<%=u.getPassword()%> required>
                </div>
            </div>
            <% if (u.getUsertype().equals("SUPERADMIN")) { %>
            <div class="row">
                <div class="col-25">
                    <label for="type">Usertype</label>
                </div>
                <div class="col-75">
                        <select id="type" name="usertype">
                            <option value="ADMIN" <%if(u.getUsertype().equals("ADMIN")) {%>selected<%}%>>ADMIN</option>
                            <option value="USER" <%if(u.getUsertype().equals("USER")) {%>selected<%}%>>USER</option>
                        </select>
                </div>
            </div>
            <% } else { %>
            <input type="hidden" name="usertype" value="<%=u.getUsertype()%>"/>
            <% } %>
            <div class="row">
                <div class="col-25">
                    <label for="firstname">Nome <span class="requiredFields">(*)</span></label>
                </div>
                <div class="col-75">
                    <input type="text" id="firstname" name="firstname" value=<%=u.getFirstname()%> required>
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label for="lastname">Cognome <span class="requiredFields">(*)</span></label>
                </div>
                <div class="col-75">
                    <input type="text" id="lastname" name="lastname" value=<%=u.getLastname()%> required>
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label for="address">Indirizzo</label>
                </div>
                <div class="col-75">
                    <input type="text" id="address" name="address" value=<%=u.getAddress()%>>
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label for="zipcode">CAP</label>
                </div>
                <div class="col-75">
                    <input type="text" id="zipcode" name="zipcode" value=<%=u.getZipcode()%>>
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label for="city">Città</label>
                </div>
                <div class="col-75">
                    <input type="text" id="city" name="city" value=<%=u.getCity()%>>
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label for="province">Provincia</label>
                </div>
                <div class="col-75">
                    <input type="text" id="province" name="province" value=<%=u.getProvince()%>>
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label for="province">Email <span class="requiredFields">(*)</span></label>
                </div>
                <div class="col-75">
                    <input type="email" id="email" name="email" value=<%=u.getEmail()%> required>
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label for="province">Telefono</label>
                </div>
                <div class="col-75">
                    <input type="text" id="phone" name="phone" value=<%=u.getPhone()%>>
                </div>
            </div>
            <input type="hidden" name="back" value="<%=request.getContextPath()+"/users/read/"+u.getId()%>"/>
            <button type="submit">Aggiorna</button>
            <a href="#" class="back-btn" onclick="history.back()">&laquo; Annulla</a>
        </form>
    </div>

</div>
<br>
<%@include file="../tpl/footer.jsp" %>
</body>
</html>