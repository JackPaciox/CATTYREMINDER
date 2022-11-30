<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="it.contrader.dto.UserDTO" import="it.contrader.service.UserService"
    pageEncoding="ISO-8859-1"%>
<%! public UserService userService = new UserService(); %>


<div id="myAccount">
    <a class="item-btn" href="${pageContext.request.contextPath}/users/read/${currentUser.getId()}">I miei dati</a>
    <%
        if (userService.isAdmin((UserDTO)request.getSession().getAttribute("currentUser"))) {
    %>
        <a class="item-btn" href="${pageContext.request.contextPath}/centers/admin/${currentUser.getId()}">I miei Centri</a>
    <%
        }
    %>
</div>

<div class="header">Health Wellness</div>

<div class="navbar <%=request.getSession().getAttribute("currentSection")%>">
    <a class="home-btn" href="${pageContext.request.contextPath}/products/dashboard">Home</a>

    <%
        if (userService.isSuperadmin((UserDTO)request.getSession().getAttribute("currentUser"))) {
    %>
        <a class="users-btn" href="${pageContext.request.contextPath}/users/list/">Utenti</a>
    <%
        }
    %>
    <a class="centers-btn" href="${pageContext.request.contextPath}/centers/list">Centri benessere</a>
    <a class="products-btn" href="${pageContext.request.contextPath}/products/list">Prodotti</a>
    <%
        if (!userService.isSuperadmin((UserDTO)request.getSession().getAttribute("currentUser"))) {
    %>
        <a class="orders-btn" href="${pageContext.request.contextPath}/orders/list">I miei ordini</a>
    <%
        }
    %>
    <a class="logout-btn" href="${pageContext.request.contextPath}/users/logout/" id="logout">Logout</a>
</div>