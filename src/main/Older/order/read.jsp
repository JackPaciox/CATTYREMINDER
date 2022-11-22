<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" import="it.contrader.dto.CenterDTO" import="it.contrader.dto.OrderDTO" import="it.contrader.dto.UserDTO" %>
<%@include file="../tpl/bootstrap.jsp"%>
<%
    /**
     * Imposto variabili di base
     */
    session.setAttribute("currentSection", "orders");
    UserDTO currentUser = (UserDTO)request.getSession().getAttribute("currentUser");
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
    <%OrderDTO o = (OrderDTO) request.getAttribute("order");%>

    <h2><%=o.getTitle()%></h2>
    <p><%=o.getDescription()%></p>
    <ul>
        <li><b>Prezzo</b>: <%=o.getPrice()%></li>
        <li><b>Scontato</b>: <%=o.getDiscount()%></li>
        <li><b>Data inizio offerta</b>: <%=o.getStartDiscountDate()%></li>
        <li><b>Data fine offerta</b>: <%=o.getEndDiscountDate()%></li>
    </ul>

    <a href="#" class="back-btn" onclick="history.back()">&laquo; Indietro</a>

</div>

<%@include file="../tpl/footer.jsp" %>
</body>
</html>