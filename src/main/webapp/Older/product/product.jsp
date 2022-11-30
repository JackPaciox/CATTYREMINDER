<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.CenterDTO"%>
<%@include file="../tpl/bootstrap.jsp"%>
<%
	/**
	 * Imposto variabili di base
	 */
	session.setAttribute("currentSection", "products");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<%@include file="../tpl/head.jsp" %>
<title>User Manager</title>
</head>
<body>

<%@include file="../tpl/navbar.jsp" %>


<div class="main">

	<%@include file="/product/list.jsp" %>

	<%@include file="/product/insert.jsp" %>

</div>
<br>
<%@include file="../tpl/footer.jsp" %>
</body>
</html>