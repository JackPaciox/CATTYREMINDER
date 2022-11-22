<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.UserDTO"
    import="it.contrader.dto.CenterDTO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <link href="../css/custom.css" rel="stylesheet">

        <link href="../css/vittoriostyle.css" rel="stylesheet">
        <title>Read Center</title>
    </head>
    <body>
        <%@ include file="../css/header.jsp" %>
        <div class="main">
        <br>
        <br>
        <br>
        <br>
            <table>
                <% CenterDTO c = (CenterDTO) request.getAttribute("center"); %>
                <tr>
                    <th>Center Name</th>
                </tr>
                <tr>
                    <td><%=c.getCentername()%></td>
                </tr>
                <tr>
                    <th>Center address</th>
                </tr>
                <tr>
                    <td><%=c.getCenteraddress()%></td>
                </tr>
                <tr>
                    <th>Center city</th>
                </tr>
                <tr>
                    <td><%=c.getCentercity()%></td>
                </tr>
                <tr>
                    <th>Center province</th>
                </tr>
                <tr>
                    <td><%=c.getCenterprovince()%></td>
                </tr>
            </table>
            <br>
            <br>
            <br>
            </div>
            <% if( usertype.equals("USER")) {%>

            <%}%>
            <% if( usertype.equals("ADMIN") || usertype.equals("SUPERADMIN")) {%>
            <form id="floatright" action=CenterServlet?mode=update&id=<%=u.getId()%> method="post">
                <div class="row">
                    <div class="col-25">
                        <label for="cent">Centername</label>
                    </div>
                    <div class="col-75">
                        <input type="text" id="cent" name="centername" value=<%=c.getCentername()%>>
                    </div>
                </div>
                <div class="row">
                    <div class="col-25">
                        <label for="centeraddress">centeraddress</label>
                    </div>
                    <div class="col-75">
                        <input type="text" id="centeraddress" name="centeraddress" value=<%=c.getCenteraddress()%>>
                    </div>
                </div>
                <div class="row">
                    <div class="col-25">
                        <label for="cen">centercity</label>
                    </div>
                    <div class="col-75">
                        <input type="text" id="cen" name="centercity" value=<%=c.getCentercity()%>>
                    </div>
                </div>
                <div class="row">
                    <div class="col-25">
                        <label for="center">centerprovince</label>
                    </div>
                    <div class="col-75">
                        <input type="text" id="center" name="centerprovince" value=<%=c.getCenterprovince()%>>
                    </div>
                </div>
                <div>
                    <button type="submit" >Edit</button>
                </div>
            </form>
            <%}%>
            <div class="">
                <a class="button-back" href="#" onclick="history.back()">Indietro</a>
                <a class="button" href=ProductServlet?mode=list&id=<%=c.getId()%>>ShowProducts</a>
            </div>
            <%@ include file="../css/footer.jsp" %>
        </div>
    </body>
</html>