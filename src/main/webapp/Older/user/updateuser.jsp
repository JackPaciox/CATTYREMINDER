<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.UserDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/custom.css" rel="stylesheet">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit User</title>
</head>
    <body>
        <%@ include file="../css/header.jsp" %>

        <br>
        <div class="main">

            <form class="up-user-form" id="floatleft" action=UserServlet?mode=update&id=<%=u.getId()%> method="post">
                <div class="row">
                    <div class="col-25">
                        <label for="user">Username</label>
                    </div>
                    <div class="col-75">
                        <input type="text" id="user" name="username" value=<%=u.getUsername()%>>
                    </div>
                </div>
                <div class="row">
                    <div class="col-25">
                        <label for="pass">Password</label>
                    </div>
                    <div class="col-75">
                        <input type="text" id="pass" name="password" value=<%=u.getPassword()%>>
                    </div>
                <div class="row">
                    <div class="col-25">
                        <label for="usert">Usertype</label>
                    </div>
                    <div class="col-75">
                        <input type="text" id="usert" name="usertype" value=<%=u.getUsertype()%>>
                    </div>
                </div>
                <div class="row">
                    <div class="col-25">
                        <label for="first">firstname</label>
                    </div>
                    <div class="col-75">
                        <input type="text" id="first" name="fristname" value=<%=u.getFirstname()%>>
                    </div>
                </div>
                <div class="row">
                    <div class="col-25">
                        <label for="last">Lastname</label>
                    </div>
                    <div class="col-75">
                        <input type="text" id="last" name="lastname" value=<%=u.getLastname()%>>
                    </div>
                </div>
                <div class="row">
                    <div class="col-25">
                        <label for="add">Address</label>
                    </div>
                    <div class="col-75">
                        <input type="text" id="add" name="address" value=<%=u.getAddress()%>>
                    </div>
                </div>

                <div class="row">
                    <div class="col-25">
                        <label for="zip">Zipcode</label>
                    </div>
                    <div class="col-75">
                        <input type="text" id="zip" name="zipcode" value=<%=u.getZipcode()%>>
                    </div>
                </div>
                <div class="row">
                    <div class="col-25">
                        <label for="cit">City</label>
                    </div>
                    <div class="col-75">
                        <input type="text" id="cit" name="city" value=<%=u.getCity()%>>
                    </div>
                </div>
                <div class="row">
                    <div class="col-25">
                        <label for="pro">Province</label>
                    </div>
                    <div class="col-75">
                        <input type="text" id="pro" name="province" value=<%=u.getProvince()%>>
                    </div>
                </div>
                <div class="row">
                    <div class="col-25">
                        <label for="em">Email</label>
                    </div>
                    <div class="col-75">
                        <input type="text" id="em" name="email" value=<%=u.getEmail()%>>
                    </div>
                </div>
                <div class="row">
                    <div class="col-25">
                        <label for="pho">Phone</label>
                    </div>
                    <div class="col-75">
                        <input type="text" id="pho" name="phone" value=<%=u.getPhone()%>>
                    </div>
                </div>
                <div class="row">
                    <button type="submit" >Edit</button>
                </div>
            </form>
            <div>
                <a class="button-back" href="#" onclick="history.back()">Indietro</a>
            </div>
        </div>
        <br>
        <%@ include file="../css/footer.jsp" %>
    </body>
</html>