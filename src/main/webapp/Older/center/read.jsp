<%@page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" import="it.contrader.dto.CenterDTO" import="it.contrader.dto.UserDTO" import="it.contrader.model.User" %>
<%@page import="java.util.List" %>
<%@include file="../tpl/bootstrap.jsp"%>
<%
    /**
     * Imposto variabili di base
     */
    session.setAttribute("currentSection", "centers");
    CenterDTO c = (CenterDTO) request.getAttribute("center");
    session.setAttribute("user_id", c.getId());
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
    <div class="row" id="readMain">
        <h2><%=c.getName()%></h2>
        <p><%=c.getDescription()%></p>
        <h4><%=c.getAddress()%> - CAP: <%=c.getZipcode()%> <br/> <%=c.getCity()%> - <%=c.getProvince()%></h4>
        <ul>
            <li><b>Telefono</b>: <a href="tel:<%=c.getPhone()%>" target="_blank"><%=c.getPhone()%></a></li>
            <li><b>Email</b>: <a href="mailto:<%=c.getEmail()%>" target="_blank"><%=c.getEmail()%></a></li>
            <li><b>Sito web</b>: <a href="<%=c.getWebSite()%>" target="_blank"><%=c.getWebSite()%></a></li>
        </ul>
        <div class="row">
            <h4>Lista promozioni</h4>
            <%@include file="../product/list.jsp" %>
        </div>

        <a href="#" class="back-btn" onclick="history.back()">&laquo; Indietro</a>

    </div>

    <% if (!currentUser.getUsertype().equals(User.Usertype.USER)) { %>
        <%@include file="../product/insert.jsp" %>
    <% } %>

</div>

<%@include file="../tpl/footer.jsp" %>
</body>
</html>