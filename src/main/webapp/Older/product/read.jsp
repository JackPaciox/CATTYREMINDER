<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" import="it.contrader.dto.ProductDTO" import="it.contrader.dto.UserDTO" import="it.contrader.service.UserService"%>
<%@ page import="it.contrader.model.User" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@include file="../tpl/bootstrap.jsp"%>
<%
    /**
     * Imposto variabili di base
     */
    session.setAttribute("currentSection", "products");
    UserDTO currentUser = (UserDTO)request.getSession().getAttribute("currentUser");
    UserService userService = new UserService();

    LocalDate dateObj = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    String currentDate = dateObj.format(formatter);
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <%@include file="../tpl/head.jsp" %>
    <title>Read User</title>
</head>
<body>

<%@include file="../tpl/navbar.jsp" %>

<div class="main">
    <%ProductDTO p = (ProductDTO) request.getAttribute("dto");%>

    <h2><%=p.getTitle()%></h2>
    <%
        if (p.getQty() < 1) {
    %>
        <h4>Attenzione! Disponibilità terminata</h4>
    <%
        }
    %>

    <p><%=p.getDescription()%></p>
    <ul>
        <li><b>Prezzo</b>: <%=p.getPrice()%></li>
        <li><b>Scontato</b>: <%=p.getDiscount()%></li>
        <li><b>Data inizio offerta</b>: <%=p.getStartDiscountDate()%></li>
        <li><b>Data fine offerta</b>: <%=p.getEndDiscountDate()%></li>
        <li><b>Quantità disponibile</b>: <%=p.getQty()%> pz.</li>
    </ul>

    <a href="#" class="back-btn" onclick="history.back()">&laquo; Indietro</a>
    <%
        if (userService.isSuperadmin(currentUser) || (userService.isAdmin(currentUser) && request.getAttribute("isAdminProductOwner") != null) && (boolean)request.getAttribute("isAdminProductOwner")) {
    %>
        <a href="<%=request.getContextPath()%>/products/edit/<%=p.getId()%>" class="item-btn update-btn">Modifica</a>
        <a href="<%=request.getContextPath()%>/products/delete/<%=p.getId()%>" class="item-btn remove-btn">Elimina</a>
    <% } %>
    <%
        if (
                !userService.isSuperadmin(currentUser) &&
                request.getAttribute("isAdminProductOwner") != null &&
                !(boolean)request.getAttribute("isAdminProductOwner")
                && p.getQty() > 0
        ) {
    %>
        <a href="#" class="back-btn submit-form-buy" data-form-selector="#doOrder">&plus; Acquista prodotto</a>
        <form action="<%=request.getContextPath()%>/orders/insert" class="hidden-form" method="post" id="doOrder">
            <input type="hidden" name="product_id" value="<%=p.getId()%>"/>
            <input type="hidden" name="user_id" value="<%=currentUser.getId()%>"/>
            <input type="hidden" name="center_id" value="<%=p.getCenter().getId()%>"/>
            <input type="hidden" name="title" value="<%=p.getTitle()%>"/>
            <input type="hidden" name="description" value="<%=p.getDescription()%>"/>
            <input type="hidden" name="price" value="<%=p.getPrice()%>"/>
            <input type="hidden" name="discount" value="<%=p.getDiscount()%>"/>
            <input type="hidden" name="start_discount_date" value="<%=p.getStartDiscountDate()%>"/>
            <input type="hidden" name="end_discount_date" value="<%=p.getEndDiscountDate()%>"/>
            <input type="hidden" name="orderDate" value="<%=currentDate%>"/>
        </form>
    <%
        }
    %>
</div>


<%@include file="../tpl/footer.jsp" %>
</body>
</html>