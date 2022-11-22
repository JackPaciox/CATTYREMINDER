<%@page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" import="it.contrader.dto.CenterDTO" import="java.util.List" %>
<%@include file="../tpl/bootstrap.jsp"%>
<%
    /**
     * Imposto variabili di base
     */
    session.setAttribute("currentSection", "centers");
    UserDTO currentUser = (UserDTO)request.getSession().getAttribute("currentUser");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <%@include file="../tpl/head.jsp" %>
    <title>Edit User</title>
</head>
<body>
<%@include file="../tpl/head.jsp" %>

<%@include file="../tpl/navbar.jsp" %>

<div class="main update">

    <%
        CenterDTO c = (CenterDTO)request.getAttribute("center");
    %>

    <div class="row" id="updateForm">
        <div class="row">
            <h3>Aggiorna dati centro benessere</h3>
        </div>
        <form class="insert" action="<%=request.getContextPath()%>/centers/update/<%=c.getId()%>" method="post">
        <%
            List<UserDTO> adminUserslist = (List)request.getAttribute("adminUserslist");
            if (adminUserslist != null) {
        %>
        <div class="row">
            <div class="col-25">
                <label for="user_id">Utente amministratore</label>
            </div>
            <div class="col-75">
                <select id="user_id" name="user_id">
                    <%
                        for (UserDTO u : adminUserslist) {
                    %>
                    <option value="<%=u.getId()%>" data-uid="" <%
                        if (c.getUser().getId() == u.getId()) {
                    %>
                            selected="selected"
                            <%
                                }
                            %>
                    >
                        <%=u.getUsername()%> - <%=u.getFirstname()%> <%=u.getLastname()%>
                    </option>
                    <%
                        }
                    %>
                </select>
            </div>
        </div>
            <% } else { %>
                <input type="hidden" name="user_id" value="<%=c.getUser().getId()%>"/>
            <% } %>
            <div class="row">
                <div class="col-25">
                    <label for="name">Nome centro</label>
                </div>
                <div class="col-75">
                    <input type="text" id="name" name="name" value="<%=c.getName()%>">
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label for="description">Descrizione</label>
                </div>
                <div class="col-75">
                    <textarea id="description" name="description"><%=c.getDescription()%></textarea>
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label for="address">Indirizzo</label>
                </div>
                <div class="col-75">
                    <input type="text" id="address" name="address" value="<%=c.getAddress()%>">
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label for="zipcode">CAP</label>
                </div>
                <div class="col-75">
                    <input type="text" id="zipcode" name="zipcode" value="<%=c.getZipcode()%>">
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label for="city">Città</label>
                </div>
                <div class="col-75">
                    <input type="text" id="city" name="city" value="<%=c.getCity()%>">
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label for="province">Provincia</label>
                </div>
                <div class="col-75">
                    <input type="text" id="province" name="province" value="<%=c.getProvince()%>">
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label for="phone">Telefono</label>
                </div>
                <div class="col-75">
                    <input type="text" id="phone" name="phone" value="<%=c.getPhone()%>">
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label for="email">Email</label>
                </div>
                <div class="col-75">
                    <input type="email" id="email" name="email" value="<%=c.getEmail()%>">
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label for="website">Sito web</label>
                </div>
                <div class="col-75">
                    <input type="text" id="website" name="website" value="<%=c.getWebSite()%>">
                </div>
            </div>

            <button type="submit">Aggiorna</button>
            <a href="#" class="back-btn" onclick="history.back()">&laquo; Annulla</a>
        </form>
    </div>

</div>
<br>
<%@include file="../tpl/footer.jsp" %>
</body>
</html>