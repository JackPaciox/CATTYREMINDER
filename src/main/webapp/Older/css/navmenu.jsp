<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<div class="header">Health Wellness</div>

<div class="navbar <%=request.getSession().getAttribute("currentSection")%>" id="mainNavBar">
    <a class="home-btn" href="homeadmin.jsp">Home</a>
    <a class="users-btn" href="UserServlet?mode=list">Users</a>
    <a class="logout-btn" href="LogoutServlet" id="logout">Logout</a>
</div>