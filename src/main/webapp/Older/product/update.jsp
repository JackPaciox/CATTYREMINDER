<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" import="it.contrader.dto.CenterDTO" import="java.util.List" %>
<%@ page import="it.contrader.dto.ProductDTO" %>
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
    <title>Edit User</title>
</head>
<body>
<%@include file="../tpl/head.jsp" %>

<%@include file="../tpl/navbar.jsp" %>

<div class="main update">

    <%
        ProductDTO p = (ProductDTO) request.getAttribute("dto");
    %>

    <div class="row" id="updateForm">
        <div class="row">
            <h3>Aggiorna prodotto</h3>
        </div>
        <form class="insert" action="<%=request.getContextPath()%>/products/update/<%=p.getId()%>" method="post">
            <% if (request.getAttribute("back") != null) { %>
                    <input type="hidden" name="back" value="<%=request.getAttribute("back")%>"/>
            <% } %>
            <% List<CenterDTO> centersList = (List)request.getAttribute("centersList");

    if (centersList.size() > 1){
            %>
            <div class="col-25">
                <label for="center">Seleziona centro benessere</label>
            </div>
            <div class="col-75">
                <select id="center" name="center">
                    <%


                        for (CenterDTO c: centersList) {
                    %>
                    <option value="<%=c.getId()%>" data-uid="" <%
                        if (p.getCenter().getId() == c.getId()) {
                    %>
                            selected="selected"
                            <%
                                }
                            %>
                    >
                        <%=c.getName()%> - <%=c.getCity()%>
                    </option>
                    <%
                        }
                    %>
                </select>
            </div>
            <%}
            else { %>
            <input type="hidden" name="center" value="<%=p.getCenter().getId()%>"/>
            <% } %>
            <% if (request.getParameter("back") != null) { %>
                <input type="hidden" name="back" value="<%=request.getParameter("back")%>"/>
            <% } %>
            <div class="row">
                <div class="col-25">
                    <label for="title">Nome prodotto</label>
                </div>
                <div class="col-75">
                    <input type="text" id="title" name="title" value="<%=p.getTitle()%>">
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label for="description">Descrizione</label>
                </div>
                <div class="col-75">
                    <textarea id="description" name="description"><%=p.getDescription()%></textarea>
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label for="price">Prezzo</label>
                </div>
                <div class="col-75">
                    <input type="text" id="price" name="price" value="<%=p.getPrice()%>">
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label for="discount">Scontato</label>
                </div>
                <div class="col-75">
                    <input type="text" id="discount" name="discount" value="<%=p.getDiscount()%>">
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label for="qty">Quantità</label>
                </div>
                <div class="col-75">
                    <input type="text" id="qty" name="qty" value="<%=p.getQty()%>">
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label for="start_discount_date">Inizio promozione</label>
                </div>
                <div class="col-75">
                    <input type="date" id="start_discount_date" name="start_discount_date" value="<%=p.getStartDiscountDate()%>">
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label for="end_discount_date">Fine promozione</label>
                </div>
                <div class="col-75">
                    <input type="date" id="end_discount_date" name="end_discount_date" value="<%=p.getEndDiscountDate()%>">
                </div>
            </div>
            <input type="hidden" name="back" value="<%=request.getContextPath()+"/products/read/"+p.getId()%>"/>
            <button type="submit">Aggiorna</button>
            <a href="#" class="back-btn" onclick="history.back()">&laquo; Annulla</a>
        </form>
    </div>
</div>
<br/>
<%@include file="../tpl/footer.jsp" %>
</body>
</html>