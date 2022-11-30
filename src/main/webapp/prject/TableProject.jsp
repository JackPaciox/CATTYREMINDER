    <div class="card shadow">
        <div class="card-header py-3">
            <p class="text-primary m-0 fw-bold">Employee Info</p></div>
        <div class="card-body"><div class="row"><div class="col-md-6 text-nowrap">
            <div id="dataTable_length" class="dataTables_length" aria-controls="dataTable">
                <label class="form-label">Show&nbsp;<select class="d-inline-block form-select form-select-sm">
                    <option value="10" selected="">10</option>
                    <option value="25">25</option>
                    <option value="50">50</option>
                    <option value="100">100</option>
                </select>&nbsp;
                </label>
            </div>
        </div>
            <div class="col-md-6">
                <div class="text-md-end dataTables_filter" id="dataTable_filter">
                    <label class="form-label">
                        <input type="search" class="form-control form-control-sm" aria-controls="dataTable" placeholder="Search"></label>
                </div>
            </div>
        </div>

            <div class="table-responsive table mt-2" id="dataTable" role="grid" aria-describedby="dataTable_info">
            <table class="table my-0" id="dataTable">
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Creator</th>
                </tr>
                </thead>
                </table>
                <%
                    List<ProjectDTO> list = (List)request.getSession().getAttribute("projects");
                    for (ProjectDTO p : list) {
                %>
                <table class="table my-0" id="dataTable">
                    <tbody>
                        <tr>
                        <td><a href=${pageContext.request.contextPath}/project/read/<%=p.getId()%>>
                            <%=p.getName()%>
                        </a></td>
                        <td><%=p.getDescription()%></td>
                        <td><%=u.getCreator()%></td>
                        <td><a href="${pageContext.request.contextPath}/project/preupdate/<%=p.getId()%>" class="item-btn update-btn">Modifica</a></td>
                        <td><a href="${pageContext.request.contextPath}/project/delete/<%=p.getId()%>" class="item-btn remove-btn">Elimina</a></td>
                    </tbody>
                </table>
                        <%-- <div class="shadow card"> --%>
                            <a class="btn btn-link text-start card-header fw-bold" data-bs-toggle="collapse" aria-expanded="true" aria-controls="collapse-4" href="#collapse-4" role="button">Segments</a>
                            <div class="collapse show" id="collapse-4">
                                <div class="card-body">
                                <%
                                    List<SegmentDTO> list = (List)request.getSession().getAttribute("segment"+p.getId().toString());
                                    for (SegmentDTO s : list) {
                                %>
                                <table class="table my-0" id="dataTable">
                                    <tbody>
                                        <tr>
                                        <td><a href=${pageContext.request.contextPath}/segment/read/<%=s.getId()%>>
                                            <%=s.getName()%>
                                        </a></td>
                                        <td>
                                            <div class="progress-bar bg-warning" aria-valuenow=<%=s.status()%> aria-valuemin="0" aria-valuemax="100" style="width: 40%;"><span class="visually-hidden"><%=s.status()%>%</span></div>
                                        </td>
                                    </tbody>
                                  </table>
                                <%
                                    }
                                %>
                                </div>
                            </div>
                        </div>
                <%
                    }
                %>
            </div>
            <div class="row">
                <div class="col-md-6 align-self-center">
                    <p id="dataTable_info" class="dataTables_info" role="status" aria-live="polite">Showing 1 to 10 of 27</p></div>
                <div class="col-md-6"><nav class="d-lg-flex justify-content-lg-end dataTables_paginate paging_simple_numbers">
                    <ul class="pagination"><li class="page-item disabled"><a class="page-link" aria-label="Previous" href="#">
                        <span aria-hidden="true">«</span></a></li><li class="page-item active"><a class="page-link" href="#">1</a></li>
                        <li class="page-item"><a class="page-link" href="#">2</a></li><li class="page-item"><a class="page-link" href="#">3</a></li>
                        <li class="page-item"><a class="page-link" aria-label="Next" href="#"><span aria-hidden="true">»</span></a></li></ul></nav>
                </div>
            </div>
        </div>
    </div>
</div>
</div>