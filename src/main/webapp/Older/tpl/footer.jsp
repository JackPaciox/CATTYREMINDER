<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<div class="footer">
    HealthWellness &copy;  2021/2022 by Contrader
</div>

<%
    if (request.getParameter("errorlogin") != null) {
%>
    <div class="errorContainer">
        <div class="errorDisplay">
            <p>Attenzione Username e/o Password non sono corrette!</p>
            <div class="closeInsert toggleShowHideTarget" data-target-hide=".errorContainer">&times;</div>
        </div>
    </div>
<%
    }
%>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-toggleShowHideTarget-1.0.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/custom.js"></script>
