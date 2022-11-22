<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.CenterDTO"
    import="it.contrader.dto.UserDTO"
	import="it.contrader.dto.ProductDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="./css/custom.css" rel="stylesheet">
<link href="./css/vittoriostyle.css" rel="stylesheet">
<title>Product Manager</title>
</head>

<body>
<%@ include file="../css/header.jsp" %>


<div class="main">
	<%
	//String usertype = (String) request.getAttribute("usertype");
    List<ProductDTO> list = (List<ProductDTO>) request.getAttribute("list");
	%>
<br>
<div>
    <%if(usertype.equals("USER")){%>
    <div class="filter-form">
        <form class="flex-row w-100" action="ProductServlet?mode=filterBy" method="post">
            <div class="row">
                <div class="col-25">
                    <label name="options">Filtra per:</label>
                </div>
                <div class="col-75">
                    <select name="options">
                        <option value=""></option>
                        <option value="DATA">DATA</option>
                        <option value="PREZZO">PREZZO</option>
                        <option value="ORDINE">ORDINE</option>
                    </select>
                </div>
            </div>
            <div class="col-25">
                <button type="submit">Filtra</button>
            </div>
        </form>
    </div>
    <%}%>
    <table>
    		<tr>
    			<th>Titolo</th>
    			<th>Descrizione</th>
    			<th>Prezzo</th>
    			<%if(usertype.equals("ADMIN")){%>
    			<th></th>
    			<th></th>
                <%}%>
    		</tr>
    		<%
    			for (ProductDTO p : list) {
    		%>
    		<tr>
    			<td>
    			    <a href=ProductServlet?mode=read&id=<%=p.getId()%>> <%=p.getTitle()%> </a>
    			</td>
    			<td><%=p.getDescription()%></td>
    			<td><%=p.getPrice()%></td>
    			<%if(usertype.equals("ADMIN")){%>
    			<td><a href=ProductServlet?mode=read&update=true&id=<%=p.getId()%>>Edit</a>
    			</td>
    			<td><a href=ProductServlet?mode=delete&id=<%=p.getId()%>&centerid=<%=request.getAttribute("centerid")%>>Delete</a>
    			</td>
                <%}%>
    		</tr>
    		<%
    			}
    		%>
    	</table>

        <%if(usertype.equals("ADMIN")){%>
            <form id="floatright" action=ProductServlet?mode=insert&id=<%=request.getAttribute("centerid")%> method="post">
                <div class="row">
                    <div class="col-25">
                        <label for="user">Title</label>
                    </div>
                    <div class="col-75">
                      <input type="text" id="product" name="title" placeholder="inserisci titolo">
                    </div>
                </div>
                <div class="row">
                    <div class="col-25">
                        <label for="pass">Descrizione</label>
                    </div>
                    <div class="col-75">
                        <input type="text" id="description" name="description" placeholder="inserisci descrizione">
                    </div>
                </div>
                <div class="row">
                    <div class="col-25">
                        <label for="pass">Prezzo</label>
                    </div>
                    <div class="col-75">
                        <input type="text" id="price" name="price" placeholder="inserisci prezzo">
                    </div>
                </div>
                <div class="row">
                    <div class="col-25">
                        <label for="pass">Sconto</label>
                    </div>
                    <div class="col-75">
                        <input type="text" id="discount" name="discount" placeholder="inserisci sconto">
                    </div>
                </div>
                <div class="row">
                    <div class="col-25">
                        <label for="pass">Data inizio sconto</label>
                    </div>
                    <div class="col-75">
                        <input type="datetime-local" id="start-discount-date" name="start-discount-date" placeholder="inserisci data inizio sconto">
                    </div>
                </div>
                <div class="row">
                    <div class="col-25">
                        <label for="pass">Data fine sconto</label>
                    </div>
                    <div class="col-75">
                        <input type="datetime-local" id="end-discount-date" name="end-discount-date" placeholder="inserisci data fine sconto">
                    </div>
                </div>
                <button type="submit" >Insert</button>
            </form>
        <%}%>

    </div>
</div>

<div>
    <a class="button-back" href="#" onclick="history.back()">Indietro</a>
</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>