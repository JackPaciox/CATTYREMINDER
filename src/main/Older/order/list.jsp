<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List" import="it.contrader.dto.CenterDTO" import="it.contrader.dto.UserDTO"%>
<%@ page import="it.contrader.model.User" %>
<%@ page import="it.contrader.dto.OrderDTO" %>

<div class="row" id="listItems">
    <table>
        <thead>
            <tr>
                <th>Nome</th>
                <th>Descrizione</th>
                <th>Prezzo</th>
                <th>Scontato</th>
                <th>Inizio offerta</th>
                <th>Fine offerta</th>
            </tr>
        </thead>

        <tbody>
        <%
            List<OrderDTO> list = (List)request.getAttribute("list");
            for (OrderDTO o : list) {
        %>
        <tr>
            <td><%=o.getTitle()%></td>
            <td><span class="ellipsize"><%=o.getDescription()%></span></td>
            <td><%=o.getPrice()%> &euro;</td>
            <td><%=o.getDiscount()%> &euro;</td>
            <td><%=o.getStartDiscountDate()%></td>
            <td><%=o.getEndDiscountDate()%></td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>