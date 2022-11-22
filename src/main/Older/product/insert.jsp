<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" import="it.contrader.dto.CenterDTO" import="it.contrader.dto.UserDTO" import="it.contrader.dto.UserDTO" %>

<%
    CenterDTO center = (CenterDTO) request.getAttribute("center");
%>

<div class="row" id="insertFormProduct">
    <div class="row">
        <h3>Inserisci un nuovo prodotto</h3>
        <div class="closeInsert toggleShowHideTarget" data-target-show="#listItem,#readMain,#listItems" data-target-hide="#insertFormProduct">&times;</div>
    </div>
    <form class="insert" action="<%=request.getContextPath()%>/products/insert" method="post">
        <div class="row">
            <%
                List<CenterDTO> centersList = (List)request.getAttribute("centersList");
            %>

            <%
                if (centersList != null) {
            %>

                <div class="row">
                    <%
                         if (centersList.size() > 1) {
                    %>
                            <div class="col-25">
                                <label for="center_id">Seleziona centro benessere</label>
                            </div>
                            <div class="col-75">
                                <select id="center" name="center">
                    <%
                                for (CenterDTO ce : centersList) {
                    %>
                                    <option value="<%=ce.getId()%>"> <%=ce.getName()%> - <%=ce.getCity()%></option>
                    <%
                                }
                    %>
                                </select>
                    <%
                            } else {
                    %>
                                <input type="hidden" name="center" value="<%=centersList.get(0).getId()%>"/>
                    <%
                            }
                     %>
            </div>
            <%
                } else {
                    if ((CenterDTO)request.getAttribute("center") != null) {
            %>
                <input type="hidden" name="center" value="<%=((CenterDTO)request.getAttribute("center")).getId()%>"/>
                <input type="hidden" name="back" value="<%=request.getContextPath()%>/centers/read/<%=((CenterDTO)request.getAttribute("center")).getId()%>"/>
            <%
                    }
                }
            %>
        </div>

        <div class="row">
            <div class="col-25">
                <label for="title">Nome</label>
            </div>
            <div class="col-75">
                <input type="text" id="title" name="title" placeholder="Inserisci nome del prodotto">
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="description">Descrizione</label>
            </div>
            <div class="col-75">
                <textarea id="description" name="description" placeholder="Inserisci una descrizione"></textarea>
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="price">Prezzo</label>
            </div>
            <div class="col-75">
                <input type="number" min="1" id="price" name="price" placeholder="Inserisci prezzo pieno del prodotto">
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="discount">Scontato</label>
            </div>
            <div class="col-75">
                <input type="number" min="1" id="discount" name="discount" placeholder="Inserisci il prezzo scontato">
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="qty">Q.tà disponibile</label>
            </div>
            <div class="col-75">
                <input type="number" min="1" id="qty" name="qty" placeholder="Aggiorna quantità disponibile">
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="start_discount_date">Data inizio offerta</label>
            </div>
            <div class="col-75">
                <input type="date" id="start_discount_date" name="start_discount_date" placeholder="Inserisci la data di inizio offerta">
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="end_discount_date">Data fine offerta</label>
            </div>
            <div class="col-75">
                <input type="date" id="end_discount_date" name="end_discount_date" placeholder="Inserisci la data di fine offerta">
            </div>
        </div>
        <button type="submit">Salva</button>
    </form>
</div>