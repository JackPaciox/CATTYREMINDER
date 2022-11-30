<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" import="java.util.List"%>

<%@include file="/WebContentFolder/head.jsp" %>
<%@include file="/WebContentFolder/principalNavBar.jsp" %>
<%@include file="/WebContentFolder/secondaryNavBar.jsp" %>

<div class="container-fluid"><div class="d-sm-flex justify-content-between align-items-center mb-4">
	<h3 class="text-dark mb-0">Dashboard</h3>
	<a class="btn btn-primary btn-sm d-none d-sm-inline-block" role="button" href="#"><i class="fas fa-download fa-sm text-white-50"></i>&nbsp;Generate Report</a>
</div>
	<div class="row">

	    <div class="col">
	    <%include file="./prject/TableProject.jsp" %>

		<div class="col">
			<div class="card shadow mb-4">
				<div class="card-header py-3">
					<h6 class="text-primary fw-bold m-0">Today task</h6>
				</div>
				<ul class="list-group list-group-flush">
					<li class="list-group-item">
						<div class="row align-items-center no-gutters">
							<div class="col me-2">
								<h6 class="mb-0"><strong>Lunch meeting</strong></h6>
								<span class="text-xs">10:30 AM</span>
							</div>
							<div class="col-auto">
								<i class="fas fa-trash-alt"></i>
							</div>
							<div class="col-auto">
								<div class="form-check">
									<input class="form-check-input" type="checkbox" id="formCheck-4">
									<label class="form-check-label" for="formCheck-4"></label>
								</div>
							</div>
						</div>
					</li>
					<li class="list-group-item">
						<div class="row align-items-center no-gutters">
							<div class="col me-2"><h6 class="mb-0">
								<strong>Lunch meeting</strong>
							</h6>
								<span class="text-xs">11:30 AM</span>
							</div>
							<div class="col-auto">
								<i class="fas fa-trash-alt"></i>
							</div>
							<div class="col-auto">
								<div class="form-check">
									<input class="form-check-input" type="checkbox" id="formCheck-2">
									<label class="form-check-label" for="formCheck-2"></label>
								</div>
							</div>
						</div>
					</li>
					<li class="list-group-item">
						<div class="row align-items-center no-gutters">
							<div class="col me-2">
								<h6 class="mb-0"><strong>Lunch meeting</strong></h6>
								<span class="text-xs">12:30 AM</span>
							</div>
							<div class="col-auto">
								<i class="fas fa-trash-alt"></i>
							</div>
							<div class="col-auto">
								<div class="form-check">
									<input class="form-check-input" type="checkbox" id="formCheck-3">
									<label class="form-check-label" for="formCheck-3"></label>
								</div>
							</div>
						</div>
					</li>
				</ul>
			</div>
			<button class="btn btn-primary" type="button">Add task</button>
		</div>
	</div>
	<div class="row">
		<div class="col">
			<div class="card shadow mb-4">
				<div class="card-header py-3">
					<h6 class="text-primary fw-bold m-0">Today Event</h6>
				</div>
				<ul class="list-group list-group-flush">
					<li class="list-group-item">
						<div class="row align-items-center no-gutters">
							<div class="col me-2">
								<h6 class="mb-0"><strong>Call meeting</strong></h6>
								<span class="text-xs">10:30 AM</span>
							</div>
							<div class="col-auto">
								<button class="btn btn-primary" type="button">Enter call</button>
							</div>
						</div>
					</li>
					<li class="list-group-item">
						<div class="row align-items-center no-gutters">
							<div class="col me-2">
								<h6 class="mb-0"><strong>Lunch meeting</strong></h6>
								<span class="text-xs">11:30 AM</span>
							</div>
							<div class="col-auto">
								<button class="btn btn-primary" type="button">Enter call</button>
							</div>
						</div>
					</li>
					<li class="list-group-item">
						<div class="row align-items-center no-gutters">
							<div class="col me-2">
								<h6 class="mb-0"><strong>Lunch meeting</strong></h6>
								<span class="text-xs">12:30 AM</span>
							</div>
							<div class="col-auto">
								<button class="btn btn-primary" type="button">Enter call</button>
							</div>
						</div>
					</li>
				</ul>
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