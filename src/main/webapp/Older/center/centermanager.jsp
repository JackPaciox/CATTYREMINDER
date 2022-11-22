<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.CenterDTO"
	import="it.contrader.dto.UserDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Center Manager</title>
</head>
    <body>
    <%@ include file="../css/header.jsp" %>

        <div class="main main-manager flex-row">
            <%
                List<CenterDTO> list = (List<CenterDTO>) request.getAttribute("list");
            %>

            <br>

            <table>
                <tr>
                    <th>Center Name</th>
                    <th>Center address</th>
                    <th>Center city</th>
                    <th>Center province</th>
                    <th></th>
                    <th></th>
                </tr>
                <%
                    for (CenterDTO c : list) {
                %>
                <tr>
                    <td><a href=CenterServlet?mode=read&id=<%=c.getId()%>>
                            <%=c.getCentername()%>
                    </a></td>
                    <td><%=c.getCenteraddress()%></td>
                    <td><%=c.getCentercity()%></td>
                    <td><%=c.getCenterprovince()%></td>
                    <%if (usertype.equals("USER")) {%>
                        <td><a href=ProductServlet?mode=list&id=<%=c.getId()%>>ShowProducts</a></td>
                    <%}%>
                    <%if (usertype.equals("ADMIN") || usertype.equals("SUPERADMIN")) {%>
                        <td><a href=OrderServlet?mode=list&id=<%=c.getId()%>>Orders</a></td>
                        <td><a href=CenterServlet?mode=read&id=<%=c.getId()%>>Edit</a></td>
                        <td><a href=ProductServlet?mode=list&id=<%=c.getId()%>>products</td>
                        <td><a href=CenterServlet?mode=delete&id=<%=c.getId()%>>Delete</a></td>
                    <%}%>
                </tr>
                <%
                    }
                %>
            </table>
            <%if (usertype.equals("ADMIN")) {%>
            <form id="floatright" action=CenterServlet?mode=insert method="post">
                <div class="row">
                    <div class="col-25">
                        <label for="cent">Centername</label>
                    </div>
                    <div class="col-75">
                        <input type="text" id="cent" name="centername" value="centername">
                    </div>
                </div>
                <div class="row">
                    <div class="col-25">
                        <label for="centeraddress">centeraddress</label>
                    </div>
                    <div class="col-75">
                        <input type="text" id="centeraddress" name="centeraddress" value="centeraddress">
                    </div>
                <div class="row">
                    <div class="col-25">
                        <label for="center">centercity</label>
                    </div>
                    <div class="col-75">
                        <input type="text" id="center" name="centercity" value="centercity">
                    </div>
                </div>
                <div class="row">
                    <div class="col-25">
                        <label for="centerprovince">centerprovince</label>
                    </div>
                    <div>
                        <input type="text" id="centerprovince" name="centerprovince" value="centerprovince">
                    </div>
                </div>
                <div>
                    <button type="submit">Inserisci</button>
                </div>
            </form>


        <%
        }
        %>
        </div>
        <div>
            <a class="button-back" href="#" onclick="history.back()">Indietro</a>
        </div>
    <br>

    <%@ include file="../css/footer.jsp" %>
    </body>
</html>