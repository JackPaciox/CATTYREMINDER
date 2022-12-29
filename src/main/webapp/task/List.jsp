<div class="card shadow mb-4">
				<div class="card-header py-3">
					<h6 class="text-primary fw-bold m-0">Today task</h6>
				</div>
				<ul class="list-group list-group-flush">
                    <%
                        List<TaskDTO> list = (List<TaskDTO>) request.getSession().getAttribute("tasks");
                        for (TaskDTO t : list) {
                    %>
					<li class="list-group-item">
						<div class="row align-items-center no-gutters">
							<div class="col me-2">
								<h6 class="mb-0"><strong><%=t.getName()%></strong></h6>
								<span class="text-xs"><%=t.getEndDate()%></span>
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
                    <%
                        }
                    %>
				</ul>
			</div>