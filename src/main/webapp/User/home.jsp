<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" import="java.util.List"
import="com.Cattyreminder.cattyreminder.dto.UserDTO"
import="com.Cattyreminder.cattyreminder.dto.ProjectDTO"
import="com.Cattyreminder.cattyreminder.dto.TaskDTO"
import="com.Cattyreminder.cattyreminder.dto.EventDTO"
 import="com.Cattyreminder.cattyreminder.dto.SegmentDTO"%>
<%UserDTO u = (UserDTO) request.getSession().getAttribute("currentUser");%>
<%@include file="/WebContentFolder/head.jsp" %>
<%@include file="/WebContentFolder/principalNavBar.jsp" %>
<%@include file="/WebContentFolder/secondaryNavBar.jsp" %>

<div class="container-fluid"><div class="d-sm-flex justify-content-between align-items-center mb-4">
	<h3 class="text-dark mb-0">Dashboard</h3>
	<a class="btn btn-primary btn-sm d-none d-sm-inline-block" role="button" href="#"><i class="fas fa-download fa-sm text-white-50"></i>&nbsp;Generate Report</a>
</div>
	<div class="row">

	    <div class="col">
	    <% Boolean isnull = (Boolean) request.getSession().getAttribute("projectnull");
	    if(isnull){%>
	    <%System.out.println("nessun progetto trovato");%>
        <%}else{%>
        <%System.out.println("progetti trovati");%>
        	            	    <%@include file="/project/TableProject.jsp" %>
        <%}%>
            <a href="/projects/add">
        			<button class="btn btn-primary" type="button" >Add Project</button>
            </a>
        </div>
		<div class="col">
			    <% Boolean taskisnull = (Boolean) request.getSession().getAttribute("tasknull");
        	    if(taskisnull){%>
        	        <%System.out.println("nessuna task trovata");%>
                <%}else{%>
                    <%System.out.println("task trovate");%>
                	<%@include file="/task/List.jsp" %>
                <%}%>
		</div>
	</div>
	<div class="row">
		<div class="col">
			    <% Boolean eventisnull = (Boolean) request.getSession().getAttribute("eventnull");
        	    if(eventisnull){%>
        	        <%System.out.println("nessuna evento trovato");%>
                <%}else{%>
                    <%System.out.println("eventi trovati");%>
                	<%@include file="/event/List.jsp" %>
                <%}%>
            <div class="col-auto">

		        <button class="btn btn-primary" type="button">Enter call</button>
		    </div>
		</div>
	</div>
</div>
</div>
<footer class="bg-white sticky-footer">
	<div class="container my-auto">
		<div class="text-center my-auto copyright"><span>Copyright © CattyReminder 2022</span></div>
	</div>
</footer>
</div>
<a class="border rounded d-inline scroll-to-top" href="#page-top"><i class="fas fa-angle-up"></i></a>
</div>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<script src="assets/js/script.min.js"></script>
</body>
</html>