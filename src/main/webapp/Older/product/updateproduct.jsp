<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.ProductDTO"
    import="it.contrader.dto.CenterDTO"
    import="it.contrader.dto.UserDTO"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="./css/vittoriostyle.css" rel="stylesheet">
<title>Edit User</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<br>
<div class="main">

<%
ProductDTO p = (ProductDTO) request.getAttribute("dto");
%>
<form id="floatleft" action="ProductServlet?mode=update&id=<%=p.getId()%>" method="post">
    <input type="hidden" name="center_id" value="<%=p.getCenter_id()%>" />
    <div class="row">
        <div class="col-25">
            <label for="ti">Title</label>
        </div>
        <div class="col-75">
          <input type="text" id="ti" name="title" placeholder="inserisci titolo">
        </div>
    </div>
    <div class="row">
        <div class="col-25">
            <label for="des">Descrizione</label>
        </div>
        <div class="col-75">
            <input type="text" id="des" name="description" placeholder="inserisci descrizione">
        </div>
    </div>
    <div class="row">
        <div class="col-25">
            <label for="pri">Prezzo</label>
        </div>
        <div class="col-75">
            <input type="text" id="pri" name="price" placeholder="inserisci prezzo">
        </div>
    </div>
    <div class="row">
        <div class="col-25">
            <label for="dis">Sconto</label>
        </div>
        <div class="col-75">
            <input type="text" id="dis" name="discount" placeholder="inserisci sconto">
        </div>
    </div>
    <div class="row">
        <div class="col-25">
            <label for="sta">Data inizio sconto</label>
        </div>
        <div class="col-75">
            <input type="text" id="sta" name="start-discount-date" placeholder="inserisci data inizio sconto">
        </div>
    </div>
    <div class="row">
        <div class="col-25">
            <label for="end">Data fine sconto</label>
        </div>
        <div class="col-75">
            <input type="text" id="end" name="end-discount-date" placeholder="inserisci data fine sconto">
        </div>
    </div>
    <button type="submit" >Insert</button>
</form>

<%-- torna indietro --%>
<div>
    <a href="#" onclick="history.back()">dietro</a>
</div>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>
