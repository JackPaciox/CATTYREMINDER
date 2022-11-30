<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" import="it.contrader.dto.CenterDTO" import="it.contrader.dto.UserDTO" import="it.contrader.dto.UserDTO" import="java.util.List"%>
<%@ page import="it.contrader.model.User" %>

<%
    CenterDTO center = (CenterDTO) request.getAttribute("center");
    UserDTO userCurrent = (UserDTO)request.getSession().getAttribute("currentUser");

    List<UserDTO> adminUserslist = (List<UserDTO>)request.getAttribute("adminUserslist");
%>

<div class="row" id="insertForm">
    <div class="row">
        <h3>Inserisci nuovo centro benessere</h3>
        <div class="closeInsert toggleShowHideTarget" data-target-show="#listItems,#readMain" data-target-hide="#insertForm">&times;</div>
    </div>
    <form class="insert" action="<%=request.getContextPath()%>/centers/insert" method="post">
        <% if(request.getParameter("user_id") != null) { %>
            <input type="hidden" name="user_id" value="<%=request.getParameter("user_id")%>"/>
        <% } else { %>
            <% if(userCurrent.getUsertype().equals(User.Usertype.SUPERADMIN) && request.getAttribute("adminUserslist")!= null) { %>
                <div class="row">
                    <div class="col-25">
                        <label for="user_id">Seleziona utente</label>
                    </div>
                    <div class="col-75">
                        <select id="user_id" name="user_id">
                            <%
                                for (UserDTO u : adminUserslist) {
                            %>
                            <option value="<%=u.getId()%>"> <%=u.getUsername()%> - <%=u.getFirstname()%> <%=u.getLastname()%> </option>
                            <%
                                }
                            %>
                        </select>
                    </div>
                </div>
            <% } else if(userCurrent.getUsertype().equals(User.Usertype.ADMIN)){%>
                <input type="hidden" name="user_id" value="<%=userCurrent.getId()%>" />
            <% } %>
        <% } %>

        <div class="row">
            <div class="col-25">
                <label for="name">Nome centro</label>
            </div>
            <div class="col-75">
                <input type="text" id="name" name="name" placeholder="Inserisci nome centro">
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="description">Descrizione</label>
            </div>
            <div class="col-75">
                <textarea id="description" name="description" placeholder="Inserisci una descrizione"></textarea>
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="address">Indirizzo</label>
            </div>
            <div class="col-75">
                <input type="text" id="address" name="address" placeholder="Inserisci indirizzo">
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
                <input type="text" id="city" name="city" placeholder="Inserisci città">
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="province">Provincia</label>
            </div>
            <div class="col-75">
                <input type="text" id="province" name="province" placeholder="Inserisci provincia">
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="phone">Telefono</label>
            </div>
            <div class="col-75">
                <input type="text" id="phone" name="phone" placeholder="Inserisci un numero telefonico">
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="email">Email</label>
            </div>
            <div class="col-75">
                <input type="email" id="email" name="email" placeholder="Inserisci email">
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="website">Sito web</label>
            </div>
            <div class="col-75">
                <input type="text" id="website" name="website" placeholder="Inserisci sito web">
            </div>
        </div>
        <button type="submit">Salva</button>
    </form>
</div>