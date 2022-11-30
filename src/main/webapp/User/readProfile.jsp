<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" import="java.util.List"%>

<%@include file="/WebContentFolder/head.jsp" %>
<%@include file="/WebContentFolder/principalNavBar.jsp" %>
<%@include file="/WebContentFolder/secondaryNavBar.jsp" %>
<div class="container-fluid">
	<div class="d-sm-flex justify-content-between align-items-center mb-4">
		<h3 class="text-dark mb-0">Project x</h3>
		<a class="btn btn-primary btn-sm d-none d-sm-inline-block" role="button" href="#"><i class="fas fa-download fa-sm text-white-50"></i>&nbsp;Generate Report</a></div>
	<div class="row">
		<div class="col">
			<div class="row mb-3">
				<div class="col-lg-4">
					<div class="card mb-3">
						<div class="card-body text-center shadow">
							<img class="rounded-circle mb-3 mt-4" src="assets/img/dogs/image2.jpeg" width="160" height="160">
							<div class="mb-3"></div>
							<label class="form-label" for="first_name" style="margin-right: 10px;"><strong>First Name</strong></label>
							<label class="form-label" for="first_name"><strong>Last Name</strong></label>
						</div>
					</div>
				</div>
				<div class="col-lg-8">
					<div class="row mb-3 d-none">
						<div class="col">
							<div class="card text-white bg-primary shadow">
								<div class="card-body">
									<div class="row mb-2">
										<div class="col"><p class="m-0">Peformance</p>
											<p class="m-0"><strong>65.2%</strong></p>
										</div>
										<div class="col-auto">
											<i class="fas fa-rocket fa-2x"></i>
										</div>
									</div>
									<p class="text-white-50 small m-0"><i class="fas fa-arrow-up"></i>&nbsp;5% since last month</p>
								</div>
							</div>
						</div>
						<div class="col">
							<div class="card text-white bg-success shadow">
								<div class="card-body">
									<div class="row mb-2">
										<div class="col">
											<p class="m-0">Peformance</p>
											<p class="m-0"><strong>65.2%</strong></p>
										</div>
										<div class="col-auto"><i class="fas fa-rocket fa-2x"></i></div>
									</div>
									<p class="text-white-50 small m-0"><i class="fas fa-arrow-up"></i>&nbsp;5% since last month</p></div>
							</div>
						</div>
					</div>
					<div class="row"><div class="col">
						<div class="card shadow mb-3">
							<div class="card-header py-3">
								<p class="text-primary m-0 fw-bold">Contacts</p>
							</div>
							<div class="card-body">
								<form>
									<div class="row">
										<div class="col">
											<div class="mb-3">
												<label class="form-label" for="username"><strong>Username</strong></label>
												<p>City info</p>
											</div>
										</div>
										<div class="col"><div class="mb-3"><label class="form-label" for="email"><strong>Email Address</strong></label>
										</div>
											<p>City info</p>
										</div>
									</div>
									<div class="row">
										<div class="col">
											<div class="mb-3">
												<label class="form-label" for="username"><strong>Prefix</strong></label>
												<p>Prefix</p>
											</div>
										</div>
										<div class="col">
											<div class="mb-3">
												<label class="form-label" for="username"><strong>Phone number</strong></label>
												<p>Phone number</p>
											</div>
										</div>
									</div>
									<div class="mb-3"></div>
								</form>
							</div>
						</div>
						<div class="card shadow mb-3">
							<div class="card-header py-3">
								<p class="text-primary m-0 fw-bold">Locations</p>
							</div>
							<div class="card-body">
								<form>
									<div class="row"><div class="col">
										<div class="mb-3">
											<label class="form-label" for="username"><strong>City</strong></label>
										</div>
										<p>City info</p>
									</div>
										<div class="col">
											<div class="mb-3">
												<label class="form-label" for="email"><strong>State</strong></label>
											</div>
											<p>State info</p>
										</div>
									</div>
									<div class="row">
										<div class="col">
											<div class="mb-3">
												<label class="form-label" for="last_name"><strong>Address</strong><br></label>
											</div>
											<p>Address info</p>
										</div>
									</div>
									<div class="mb-3"></div>
								</form>
							</div>
						</div>
						<div class="card shadow"></div>
					</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-lg-6 mb-4">
			<div class="card shadow mb-4">
				<div class="card-header py-3">
					<h6 class="text-primary fw-bold m-0">Projects</h6>
				</div>
				<div class="card-body">
					<h4 class="small fw-bold">Server migration<span class="float-end">20%</span></h4>
					<div class="progress mb-4">
			<div class="progress-bar bg-danger" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" style="width: 20%;"><span class="visually-hidden">20%</span></div>
		</div><h4 class="small fw-bold">Sales tracking<span class="float-end">40%</span></h4><div class="progress mb-4">
			<div class="progress-bar bg-warning" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%;"><span class="visually-hidden">40%</span></div>
		</div><h4 class="small fw-bold">Customer Database<span class="float-end">60%</span></h4>
					<div class="progress mb-4">
			<div class="progress-bar bg-primary" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%;"><span class="visually-hidden">60%</span></div>
		</div><h4 class="small fw-bold">Payout Details<span class="float-end">80%</span></h4><div class="progress mb-4">
			<div class="progress-bar bg-info" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%;"><span class="visually-hidden">80%</span></div>
		</div><h4 class="small fw-bold">Account setup<span class="float-end">Complete!</span></h4><div class="progress mb-4">
			<div class="progress-bar bg-success" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%;"><span class="visually-hidden">100%</span></div>
		</div>
				</div>
			</div>
		</div>
		<div class="col">
			<div class="card shadow mb-4">
				<div class="card-header py-3">
					<h6 class="text-primary fw-bold m-0">Task assigned</h6>
				</div>
				<ul class="list-group list-group-flush">
					<li class="list-group-item">
						<div class="row align-items-center no-gutters">
							<div class="col me-2">
								<h6 class="mb-0"><strong>Lunch meeting</strong></h6>
								<span class="text-xs">10:30 AM</span>
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
							<div class="col me-2">
								<h6 class="mb-0"><strong>Lunch meeting</strong></h6>
								<span class="text-xs">11:30 AM</span>
							</div>
							<div class="col-auto">
								<div class="form-check">
									<input class="form-check-input" type="checkbox" id="formCheck-5">
									<label class="form-check-label" for="formCheck-5"></label>
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
								<div class="form-check">
									<input class="form-check-input" type="checkbox" id="formCheck-6">
									<label class="form-check-label" for="formCheck-6"></label>
								</div>
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