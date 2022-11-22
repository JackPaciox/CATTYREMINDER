<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" import="java.util.List" import="it.contrader.dto.CenterDTO"
         import="it.contrader.dto.UserDTO" %>
<%@ page import="it.contrader.model.User" %>
<div class="row" id="listItems">
    <table>
        <thead>
        <tr>
            <th>Nome centro</th>
            <th>Descrizione</th>
            <th>Indirizzo</th>
            <th>CAP</th>
            <th>Città</th>
            <th>Provincia</th>
            <th>Telefono</th>
            <th>Email</th>
            <th>Sito web</th>
            <% if (currentUser.getUsertype().equals(User.Usertype.SUPERADMIN) || (boolean) request.getAttribute("editCenters")) { %>
            <th colspan="2">Azioni</th>
            <% } %>
        </tr>
        </thead>

        <tbody>
        <%
            List<CenterDTO> list = (List<CenterDTO>) request.getAttribute("centersList");
            for (CenterDTO u : list) {
        %>
        <tr>
            <td><a href="<%=request.getContextPath()%>/centers/read/<%=u.getId()%>">
                <%=u.getName()%>
            </a></td>
            <td><span class="ellipsize"><%=u.getDescription()%></span></td>
            <td><%=u.getAddress()%>
            </td>
            <td><%=u.getZipcode()%>
            </td>
            <td><%=u.getCity()%>
            </td>
            <td><%=u.getProvince()%>
            </td>
            <td><%=u.getPhone()%>
            </td>
            <td><%=u.getEmail()%>
            </td>
            <td><%=u.getWebSite()%>
            </td>
            <% if (currentUser.getUsertype().equals(User.Usertype.SUPERADMIN) || (boolean)request.getAttribute("editCenters")) { %>
            <td><a href="<%=request.getContextPath()%>/centers/edit/<%=u.getId()%>"
                   class="item-btn update-btn">Modifica</a></td>
            <td><a href="<%=request.getContextPath()%>/centers/delete/<%=u.getId()%>" class="item-btn remove-btn">Elimina</a>
            </td>
            <% } %>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
    <%
        if (currentUser.getUsertype().equals(User.Usertype.SUPERADMIN) || (currentUser.getUsertype().equals(User.Usertype.ADMIN) && (boolean)request.getAttribute("isAdminCenterRequired"))) {
    %>
    <a class="add-item-btn toggleShowHideTarget" data-target-show="#insertForm" data-target-hide="#listItems" href="#">Aggiungi
        centro benessere</a>
    <%
        }
    %>
</div>