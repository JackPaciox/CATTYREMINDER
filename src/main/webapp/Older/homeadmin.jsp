<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.util.List"  import="it.contrader.dto.UserDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Admin</title>

</head>
<body>

<% request.getSession().setAttribute("currentSection", "home"); %>
<%@include file="/css/header.jsp"%>
<%--
  <div class="navbar">
  <% UserDTO u = (UserDTO) session.getAttribute("dto");
  String usertype = u.getUsertype().toString();
  %>
<%if (usertype.equals("USER")) {%>
  <a href="homeadmin.jsp">Home</a>
  <a class="pippo" href=UserServlet?mode=read&update=true&id=<%=u.getId()%>>User</a>
  <a class="active"  href="CenterServlet?mode=list">Center</a>
  <a href="ProductServlet?mode=list">Products</a>
  <a href="OrderServlet?mode=list">Order</a>
  <a href="LogoutServlet" id="logout">Logout</a>
<%}%>
<%if (usertype.equals("ADMIN")) {%>
  <a href="homeadmin.jsp">Home</a>
  <a href=UserServlet?mode=read&update=true&id=u.getId>User</a>
  <a href="#">Imposta come utente</a>
  <a class="active"  href="CenterServlet?mode=list">Center</a>
  <a href="LogoutServlet" id="logout">Logout</a>
<%}%>
<%if (usertype.equals("SUPERADMIN")) {%>
  <a href="homeadmin.jsp">Home</a>
  <a href="UserServlet?mode=list">Users</a>
  <a class="active"  href="CenterServlet?mode=list">Center</a>
  <a href="LogoutServlet" id="logout">Logout</a>
<%}%>
</div>

--%>

<div class="main">
<h1>Welcome ${user.getUsername()}</h1>


"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."

</div>


<%@ include file="/css/footer.jsp" %>

</body>
</html>