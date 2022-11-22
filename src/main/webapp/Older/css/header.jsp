<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="it.contrader.dto.UserDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/vittoriostyle.css" rel="stylesheet">
<link href="css/custom.css" rel="stylesheet">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>

</head>
<body>
<div class="header">Health Wellness
    <div class="navbar">
        <% //System.out.println(session.getAttribute("dto"));
            UserDTO u = (UserDTO) session.getAttribute("dto");
            String usertype = u.getUsertype();
            System.out.println(u.getId());
        %>
        <%if (usertype.equals("USER")) {%>
        <a href="homeadmin.jsp">Home</a>
        <a href=UserServlet?mode=read&update=true&id=<%=u.getId()%>>User</a>
        <a href="CenterServlet?mode=list">Center</a>
        <a href="ProductServlet?mode=list">Products</a>
        <a href="OrderServlet?mode=list">Order</a>
        <a href="LogoutServlet" id="logout">Logout</a>
        <%}%>
        <%if (usertype.equals("ADMIN")) {%>
        <a href="homeadmin.jsp">Home</a>
        <a href=UserServlet?mode=read&update=true&id=<%=u.getId()%>>User</a>
        <a href=UserServlet?mode=IMPOSTAUTENTE >Imposta come utente</a>
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
</div>
</body>
</html>