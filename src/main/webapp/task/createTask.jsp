<div class="p-5">
    <div class="text-center">
        <h4 class="text-dark mb-4">Add A task</h4>
    </div>
    <form class="user" action="task/insert">
        <div class="row mb-3">
            <input class="form-control form-control-user" type="text" id="exampleFirstName-1" placeholder="Task Name" name="TaskName">
        </div>
        <div class="mb-3">
            <input class="form-control form-control-user" type="text" id="exampleInputEmail" aria-describedby="description" placeholder="Task description" name="Description">
        </div>
        <div class="row mb-3">
            <div class="col-sm-6 mb-3 mb-sm-0">
                <input class="form-control form-control-user" type="date" id="exampleInputEmail-1" aria-describedby="description" placeholder="Start Date" name="startdate">
            </div>
            <div class="col-sm-6">
                <input class="form-control form-control-user" type="date" id="exampleInputEmail-2" aria-describedby="description" placeholder="End date" name="date">
            </div>
        </div>
        <div class="row mb-3">
            <div class="col-sm-6 mb-3 mb-sm-0">
                <div class="btn-user w-100">
                    <a class="btn btn-primary btn btn-primary d-block btn-user w-100" data-bs-toggle="collapse" aria-expanded="false" aria-controls="collapse-3" href="#collapse-3" role="button">Assign resources</a>
                    <div class="collapse" id="collapse-3">
                        <%if(){
                        <%@ include file="user/list.jsp" %>

                                 <div class="col-sm-6">
                                        <div class="btn-user w-100">
                                            <a class="btn btn-primary btn btn-primary d-block btn-user w-100" data-bs-toggle="collapse" aria-expanded="false" aria-controls="collapse-4" href="#collapse-4" role="button">Assign Project</a>
                                            <div class="collapse" id="collapse-4">
                                                <%@ include  file="project/list.jsp"%>
                                            </div>
                                        </div>
                                    </div>

                        <% } else() {%>
                        <p>no users can be found</p>
                        <% } %>
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>
<div class="container">
    <div class="row">
        <div class="col-md-4">

        </div>
        <div class="col-md-4 col-xl-4">
            <button class="btn btn-primary btn btn-primary d-block btn-user w-100" type="button" style="box-shadow: 0px 0px;transform: perspective(0px) scale(1.58);--bs-success: #1cc88a;--bs-success-rgb: 28,200,138;background: rgb(28,200,138);">Create!</button>
        </div>
        <div class="col-md-4">

        </div>
    </div>
</div>
</div>
<footer class="bg-white sticky-footer">
    <div class="container my-auto">
        <div class="text-center my-auto copyright">
            <span>Copyright © CattyReminder 2022</span>
        </div>
    </div>
</footer>
</div>
<a class="border rounded d-inline scroll-to-top" href="#page-top">
    <i class="fas fa-angle-up"></i>
</a>
</div>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<script src="assets/js/script.min.js"></script>
</body>
</html>