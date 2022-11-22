<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List" import="it.contrader.dto.CenterDTO" import="it.contrader.dto.UserDTO"%>
<%@ page import="it.contrader.model.User" %>
<%@ page import="it.contrader.dto.ProductDTO" %>
<%@ page import="it.contrader.service.UserService" %>


<%
    long centerUserId = 0;
    long centerId = 0;
    if (request.getAttribute("center") != null) {
        centerUserId = ((CenterDTO)request.getAttribute("center")).getUser().getId();
        centerId = ((CenterDTO)request.getAttribute("center")).getId();
    }
%>

<div class="row" id="listItems">
    <table>
        <thead>
            <tr>
                <th>Nome</th>
                <th>Descrizione</th>
                <th>Prezzo</th>
                <th>Scontato</th>
                <th>Q.tà disponibile</th>
                <th>Inizio offerta</th>
                <th>Fine offerta</th>
                <% if (userService.isSuperadmin((UserDTO)request.getSession().getAttribute("currentUser")) || (userService.isAdmin((UserDTO)request.getSession().getAttribute("currentUser")) && ((UserDTO)request.getSession().getAttribute("currentUser")).getId() == centerUserId)) { %>
                    <th colspan="2">Azioni</th>
                <% } %>
            </tr>
        </thead>

        <tbody>
        <%
            List<ProductDTO> productsList = (List<ProductDTO>)request.getAttribute("productsList");
            for (ProductDTO p : productsList) {
        %>

        <tr>
            <td><a href=<%=request.getContextPath()%>/products/read/<%=p.getId()%>>
                <%=p.getTitle()%>
            </a></td>
            <td><span class="ellipsize"><%=p.getDescription()%></span></td>
            <td><%=p.getPrice()%> &euro;</td>
            <td><%=p.getDiscount()%> &euro;</td>
            <td><%=p.getQty()%> pz.</td>
            <td><%=p.getStartDiscountDate()%></td>
            <td><%=p.getEndDiscountDate()%></td>
            <% if (userService.isSuperadmin((UserDTO)request.getSession().getAttribute("currentUser")) || (userService.isAdmin((UserDTO)request.getSession().getAttribute("currentUser")) && ((UserDTO)request.getSession().getAttribute("currentUser")).getId() == centerUserId)) { %>
                <td><a href="<%=request.getContextPath()%>/products/edit/<%=p.getId()%>" class="item-btn update-btn">Modifica</a></td>
                <td><a href="<%=request.getContextPath()%>/products/delete/<%=p.getId()%>" class="item-btn remove-btn">Elimina</a></td>
            <% } %>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>

    <% if (userService.isSuperadmin((UserDTO)request.getSession().getAttribute("currentUser")) || (userService.isAdmin((UserDTO)request.getSession().getAttribute("currentUser")) && ((UserDTO)request.getSession().getAttribute("currentUser")).getId() == centerUserId)) { %>
            <a class="add-item-btn toggleShowHideTarget" data-target-show="#insertForm,#insertFormProduct" data-target-hide="#listItems,#readMain" href="#">&plus; Aggiungi prodotto</a>
    <% } %>
</div>