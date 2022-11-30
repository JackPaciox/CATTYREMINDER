<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" import="java.util.List"
         import="it.contrader.dto.UserDTO" import="it.contrader.dto.ProductDTO" %>
<%@include file="/tpl/bootstrap.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <%
        session.setAttribute("currentSection","home");
        String selectAttribute = "";
        if (request.getAttribute("selectedFilters") != null) {
            selectAttribute = (String)request.getAttribute("selectedFilters");
        }
    %>
    <%@include file="tpl/head.jsp" %>
    <title>Home Admin</title>
</head>
<body>

<%@include file="tpl/navbar.jsp"%>

<div class="main">
    <h1>Ciao ${currentUser.getFirstname()}</h1>

    <h2>Benvenuto in Health Welnness! Scegli la sezione che più ti aggrada.</h2>

    <div class="row" id="listItems">
        <form method="GET" action="<%=request.getContextPath()%>/products/dashboard" id="productOffersFilter">
            <div id="selectContainer">
                <select id="selectFilter" name="filter">
                    <option value="nameAsc" <% if(selectAttribute.equals("nameAsc") || selectAttribute == null){%>selected<%}%>>Nome A-Z</option>
                    <option value="nameDesc" <% if(selectAttribute.equals("nameDesc")){%>selected<%}%>>Nome Z-A</option>
                    <option value="priceAsc" <% if(selectAttribute.equals("priceAsc")){%>selected<%}%>>Prezzo crescente</option>
                    <option value="priceDesc" <% if(selectAttribute.equals("priceDesc")){%>selected<%}%>>Prezzo descrescente</option>
                    <option value="discountAsc" <% if(selectAttribute.equals("discountAsc")){%>selected<%}%>>Sconto crescente</option>
                    <option value="discountDesc" <% if(selectAttribute.equals("discountDesc")){%>selected<%}%>>Sconto decrescente</option>
                    <option value="startDateAsc" <% if(selectAttribute.equals("startDateAsc")){%>selected<%}%>>Data inizio offerta crescente</option>
                    <option value="startDateDesc" <% if(selectAttribute.equals("startDateDesc")){%>selected<%}%>>Data inizio offerta decrescente</option>
                    <option value="endDateAsc" <% if(selectAttribute.equals("endDateAsc")){%>selected<%}%>>Data fine offerta crescente</option>
                    <option value="endDateDesc" <% if(selectAttribute.equals("endDateDesc")){%>selected<%}%>>Data fine offerta decrescente</option>
                </select>
            </div>
        </form>
        <table>
            <thead>
            <tr>
                <th>
                    Nome
                </th>
                <th>Descrizione</th>
                <th>
                    Prezzo
                </th>
                <th>
                    Scontato
                </th>
                <th>Q.tà disponibile</th>
                <th>
                    Inizio offerta
                </th>
                <th>
                    Fine offerta
                </th>
            </tr>
            </thead>

                            <tbody>
                            <%
                                List<ProductDTO> list = (List)request.getAttribute("productsList");
                                for (ProductDTO p : list) {
                            %>
                            <tr>
                                <td><a href="<%=request.getContextPath()%>/products/read/<%=p.getId()%>">
                                    <%=p.getTitle()%>
                                </a></td>
                                <td><span class="ellipsize"><%=p.getDescription()%></span></td>
                                <td><%=p.getPrice()%> &euro;</td>
                                <td><%=p.getDiscount()%> &euro;</td>
                                <td><%=p.getQty()%> pz.</td>
                                <td><%=p.getStartDiscountDate()%></td>
                                <td><%=p.getEndDiscountDate()%></td>
                            </tr>
                            <%
                                }
                            %>
                            </tbody>

        </table>
    </div>
</div>


<%@include file="tpl/footer.jsp" %>

</body>
</html>