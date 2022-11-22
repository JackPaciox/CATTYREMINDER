<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" import="it.contrader.dto.CenterDTO" import="java.util.List" %>
<%@ page import="it.contrader.dto.OrderDTO" %>
<%@include file="../tpl/bootstrap.jsp"%>
<%
    /**
     * Imposto variabili di base
     */
    session.setAttribute("currentSection", "orders");
    UserDTO currentUser = (UserDTO)request.getSession().getAttribute("currentUser");
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
        OrderDTO o = (OrderDTO) request.getAttribute("order");
    %>

    <div class="row" id="updateForm">
        <div class="row">
            <h3>Aggiorna prodotto</h3>
        </div>
        <form class="insert" action="<%=request.getContextPath()%>/order/update?id=<%=o.getId()%>" method="post">
            <div class="col-25">
                <label for="center_id">Centro benessere</label>
            </div>
            <div class="col-75">
                <select id="center_id" name="center_id">
                    <%
                        List<CenterDTO> centersList = (List)request.getAttribute("centersList");
                        for (CenterDTO c: centersList) {
                    %>
                    <option value="<%=c.getId()%>" data-uid="" <%
                        if (p.getCenter_id() == c.getId()) {
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
            <div class="row">
                <div class="col-25">
                    <label for="title">Nome prodotto</label>
                </div>
                <div class="col-75">
                    <input type="text" id="title" name="title" value="<%=o.getTitle()%>">
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label for="description">Descrizione</label>
                </div>
                <div class="col-75">
                    <textarea id="description" name="description"><%=o.getDescription()%></textarea>
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label for="price">Prezzo</label>
                </div>
                <div class="col-75">
                    <input type="text" id="price" name="price" value="<%=o.getPrice()%>">
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label for="discount">Scontato</label>
                </div>
                <div class="col-75">
                    <input type="text" id="discount" name="discount" value="<%=o.getDiscount()%>">
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label for="qty">Quantità</label>
                </div>
                <div class="col-75">
                    <input type="text" id="qty" name="qty" value="<%=o.getQty()%>">
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label for="start_discount_date">Inizio promozione</label>
                </div>
                <div class="col-75">
                    <input type="text" id="start_discount_date" name="start_discount_date" value="<%=o.getStart_discount_date()%>">
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label for="end_discount_date">Fine promozione</label>
                </div>
                <div class="col-75">
                    <input type="text" id="end_discount_date" name="end_discount_date" value="<%=o.getEnd_discount_date()%>">
                </div>
            </div>

            <button type="submit">Aggiorna</button>
            <a href="#" class="back-btn" onclick="history.back()">&laquo; Annulla</a>
        </form>
    </div>

</div>
<br>
<%@include file="../tpl/footer.jsp" %>
</body>
</html>