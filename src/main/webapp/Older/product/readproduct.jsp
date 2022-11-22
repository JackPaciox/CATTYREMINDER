<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.ProductDTO"
    import="it.contrader.dto.UserDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/custom.css" rel="stylesheet">
<link href="./css/vittoriostyle.css" rel="stylesheet">
<title>Read Product</title>
</head>
<body>

<br>
<%@ include file="../css/header.jsp" %>

<div class="main read-prd">
<%ProductDTO p = (ProductDTO) request.getAttribute("product");%>

<div >
    <table class="w-50">
    	<tr>
    		<th>Titolo</th>
    		<th>Descrizione</th>
    		<th>Prezzo</th>
    		<th>Sconto</th>
            <th>Inizio sconto</th>
            <th>Fine sconto</th>
    	</tr>
    	<tr>
    		<td><%=p.getTitle()%></td>
    		<td> <%=p.getDescription()%></td>
    		<td> <%=p.getPrice()%></td>
    		<td><%=p.getDiscount()%></td>
            <td> <%=p.getStart_discount_date()%></td>
            <td> <%=p.getEnd_discount_date()%></td>
    	</tr>
    </table>

    <div class="w-50">
        <form action="OrderServlet?mode=insert" method="post">
            <input type="hidden" name="product_id" value="<%=p.getId()%>" />
            <input type="hidden" name="title" value="<%=p.getTitle()%>" />
            <input type="hidden" name="description" value="<%=p.getDescription()%>" />
            <input type="hidden" name="center_id" value="<%=p.getCenter_id()%>" />
            <input type="hidden" name="price" value="<%=p.getPrice()%>" />
            <input type="hidden" name="discount" value="<%=p.getDiscount()%>" />
            <input type="hidden" name="start-discount-date" value="<%=p.getStart_discount_date()%>" />
            <input type="hidden" name="end-discount-date" value="<%=p.getEnd_discount_date()%>" />

            <div>
                <button class="button" type="submit">Acquista</button>
            </div>
        </form>
    </div>
</div>

<div>
    <a class="button-back" href="#" onclick="history.back()">Indietro</a>
</div>

<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>


</div>

<%@ include file="../css/footer.jsp" %>
</body>
</html>