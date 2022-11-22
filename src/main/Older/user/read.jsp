<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" import="it.contrader.dto.UserDTO" %>
<%@ page import="it.contrader.model.User" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <% session.setAttribute("currentSection", "users"); %>
    <%@include file="../tpl/head.jsp" %>
    <title>Read User</title>
</head>
<body>

<%@include file="../tpl/navbar.jsp" %>

<div class="main">
    <div class="row" id="readMain">
        <%UserDTO u = (UserDTO) request.getAttribute("dto");%>

        <h2>
            Utente: <%=u.getFirstname()%> <%=u.getLastname()%><br/>
        </h2>
        <h4>Indirizzo: <%=u.getAddress()%>, <%=u.getZipcode()%> - <%=u.getCity()%>, <%=u.getProvince()%></h4>
        <ul>
            <li>Email: <a href="mailto:<%=u.getEmail()%>" target="_blank"><%=u.getEmail()%></a></li>
            <li>Phone: <a href="tel:<%=u.getPhone()%>" target="_blank"><%=u.getPhone()%></a></li>
        </ul>

		<% if (u.getUsertype().equals(User.Usertype.ADMIN)) { %>
			<a href="<%=request.getContextPath()%>/centers/admin/<%=u.getId()%>" class="item-btn">
				&raquo; Visualizza centri benessere
			</a>
		<% } %>
        <a href="<%=request.getContextPath()%>/users/edit/<%=u.getId()%>" class="item-btn">
            &#128393; Aggiorna dati
        </a>
        <% if (!u.getUsertype().equals(User.Usertype.SUPERADMIN)) { %>
            <a href="<%=request.getContextPath()%>/users/delete/<%=u.getId()%>" id="remove-user" class="item-btn">
                &times; Elimina il tuo account
            </a>
        <% } %>
    </div>

	<% if (!u.getUsertype().equals(User.Usertype.USER)) { %>
		<jsp:include page="/center/insert.jsp" >
			<jsp:param name="user_admin_id" value="${user_id}"/>
		</jsp:include>
	<% } %>

</div>

<%@include file="../tpl/footer.jsp" %>
</body>
</html>