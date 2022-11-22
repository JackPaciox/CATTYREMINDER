<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.UserDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<% request.getSession().setAttribute("currentSection", "users"); %>
	<%@ include file="../css/header.jsp" %>
	<title>User Manager</title>
</head>
<body>
<%@ include file="../css/navmenu.jsp" %>

<div class="main">
	<%
		List<UserDTO> list = (List<UserDTO>) request.getAttribute("list");
	%>

<br>

	<table>
		<tr>
			<th>Username</th>
			<th>Password</th>
			<th>Usertype</th>
			<th>Firstname</th>
			<th>Lastname</th>
			<th>Address</th>
			<th>Zipcode</th>
			<th>City</th>
			<th>Province</th>
			<th>Email</th>
			<th>Phone</th>

			<th></th>
			<th></th>
		</tr>
		<%
			for (UserDTO i : list) {
		%>
		<tr>
			<td><a href=UserServlet?mode=read&id=<%=i.getId()%>>
					<%=i.getUsername()%>
			</a></td>
			<td><%=i.getPassword()%></td>
			<td><%=i.getUsertype()%></td>
			<td> <%=i.getFirstname()%></td>
			<td> <%=i.getLastname()%></td>
			<td> <%=i.getAddress()%></td>
			<td> <%=i.getZipcode()%></td>
			<td> <%=i.getCity()%></td>
			<td> <%=i.getProvince()%></td>
			<td> <%=i.getEmail()%></td>
			<td> <%=i.getPhone()%></td>
			<td><a href=UserServlet?mode=read&update=true&id=<%=i.getId()%>>Edit</a>
			</td>
			<td><a href=UserServlet?mode=delete&id=<%=i.getId()%>>Delete</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>



<form id="floatright" action="UserServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="user">Username</label>
    </div>
    <div class="col-75">
      <input type="text" id="user" name="username" placeholder="inserisci username">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="pass">Password</label>
    </div>
    <div class="col-75">
      <input type="text" id="pass" name="password" placeholder="inserisci password">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="type">Usertype</label>
    </div>
	  <div class="row">
		  <div class="col-25">
			  <label for="first">Firstname</label>
		  </div>
		  <div class="col-75">
			  <input type="text" id="first" name="firstname" placeholder="inserisci il nome">
		  </div>
	  </div>
	  <div class="row">
		  <div class="col-25">
			  <label for="last">Lastname</label>
		  </div>
		  <div class="col-75">
			  <input type="text" id="last" name="lastname" placeholder="inserisci il cognome">
		  </div>
	  </div>
	  <div class="row">
		  <div class="col-25">
			  <label for="add">Address</label>
		  </div>
		  <div class="col-75">
			  <input type="text" id="add" name="address" placeholder="inserisci l'indirizzo">
		  </div>
	  </div>
	  <div class="row">
		  <div class="col-25">
			  <label for="zip">Zipcode</label>
		  </div>
		  <div class="col-75">
			  <input type="text" id="zip" name="zipcode" placeholder="inserisci il codice postale">
		  </div>
	  </div>
	  <div class="row">
		  <div class="col-25">
			  <label for="cit">City</label>
		  </div>
		  <div class="col-75">
			  <input type="text" id="cit" name="city" placeholder="inserisci la città">
		  </div>
	  </div>
	  <div class="row">
		  <div class="col-25">
			  <label for="pro">Province</label>
		  </div>
		  <div class="col-75">
			  <input type="text" id="pro" name="province" placeholder="inserisci la provincia">
		  </div>
	  </div>
	  <div class="row">
		  <div class="col-25">
			  <label for="em">Email</label>
		  </div>
		  <div class="col-75">
			  <input type="text" id="em" name="email" placeholder="inserisci email">
		  </div>
	  </div>
	  <div class="row">
		  <div class="col-25">
			  <label for="pho">Phone</label>
		  </div>
		  <div class="col-75">
			  <input type="text" id="pho" name="phone" placeholder="inserisci il numero di telefono">
		  </div>
	  </div>
	  <div class="row">
		  <div class="col-25">
   		 <div class="col-75">
 			<select id="type" name="usertype">
  				<option value="ADMIN">ADMIN</option>
  				<option value="USER">USER</option>

			</select>
    	</div>
  </div>
      <button type="submit" >Insert</button>
</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>