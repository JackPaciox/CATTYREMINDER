<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List" import="it.contrader.dto.UserDTO"%>

<div class="row" id="listItems">
    <table>
        <thead>
            <tr>
                <th>Nome utente</th>
                <th>Password</th>
                <th>Tipo utente</th>
                <th>Nome</th>
                <th>Cognome</th>
                <th>Indirizzo</th>
                <th>CAP</th>
                <th>Città</th>
                <th>Provincia</th>
                <th>Email</th>
                <th>Telefono</th>
                <th></th>
                <th></th>
            </tr>
        </thead>

        <tbody>
        <%
            List<UserDTO> list = (List)request.getSession().getAttribute("list");
            for (UserDTO u : list) {
        %>
        <tr>
            <td><a href=${pageContext.request.contextPath}/users/read/<%=u.getId()%>>
                <%=u.getUsername()%>
            </a></td>
            <td><%=u.getPassword()%></td>
            <td><%=(u.getUsertype().equals("ADMIN"))?"Centro benessere":"Privato"%></td>
            <td><%=u.getFirstname()%></td>
            <td><%=u.getLastname()%></td>
            <td><%=u.getAddress()%></td>
            <td><%=u.getZipcode()%></td>
            <td><%=u.getCity()%></td>
            <td><%=u.getProvince()%></td>
            <td><%=u.getEmail()%></td>
            <td><%=u.getPhone()%></td>
            <td><a href="${pageContext.request.contextPath}/users/edit/<%=u.getId()%>" class="item-btn update-btn">Modifica</a></td>
            <td><a href="${pageContext.request.contextPath}/users/delete/<%=u.getId()%>" class="item-btn remove-btn">Elimina</a></td>

        </tr>
        <%
            }
        %>
        </tbody>
    </table>
    <a class="add-item-btn toggleShowHideTarget" data-target-show="#insertForm" data-target-hide="#listItems" href="#">Aggiungi utente</a>
</div>

<script type="text/javascript">
    $(function(){
        let errorRequiredFields = getUrlParameter('errorRequiredFields');
        if (typeof errorRequiredFields != "undefined" && errorRequiredFields == "true") {
            alert("Operazione completata con successo. Ora puoi eseguire il login!");
        }
    });
</script>
