<%@ page import="it.contrader.dto.OrderDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="it.contrader.dto.UserDTO" %>
<%@ page contentType="text/html; charset=ISO-8859-1" language="java"
pageEncoding="ISO-8859-1" import="java.util.List"
import="it.contrader.dto.OrderDTO"%>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Order Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>


<div class="main">
    <%
		List<OrderDTO> list = (List<OrderDTO>) request.getAttribute("list");
	%>

  <br>

  <table>
    <tr>
      <th>Title</th>
      <th>Description</th>
      <th>Price</th>
      <th>Discount</th>
      <th>Start_discount_date</th>
      <th>End_discount_date</th>
      <th>Order_date</th>

      <th></th>
      <th></th>
    </tr>
    <%
      for (OrderDTO o : list) {
    %>
    <tr>
      <td><%=o.getTitle()%></td>
      <td><%=o.getDescription()%></td>
      <td><%=o.getPrice()%></td>
      <td> <%=o.getDiscount()%></td>
      <td> <%=String.valueOf(o.getStart_discount_date())%></td>
      <td> <%=String.valueOf(o.getEnd_discount_date())%></td>
      <td> <%=String.valueOf(o.getOrder_date())%></td>
    </tr>
    <%
      }
    %>
  </table>
      <%@ include file="../css/footer.jsp" %>
</body>
</html>
