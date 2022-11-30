<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.UserDTO"%>
<%@include file="../tpl/bootstrap.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<% session.setAttribute("currentSection", "users"); %>
	<%@include file="../tpl/head.jsp" %>
<title>User Manager</title>
</head>
<body>

<%@include file="../tpl/navbar.jsp" %>

<div class="main">

	<c:set var="list" value="${list}" scope="request"/>
	<jsp:include page="/user/list.jsp"/>

	<%@include file="/user/insert.jsp" %>

</div>
<br>
<%@include file="../tpl/footer.jsp" %>
</body>
</html>