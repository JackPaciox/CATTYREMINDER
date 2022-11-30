<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" import="java.util.List"%>

<%@include file="./WebContentFolder/head.jsp" %>
<%@include file="./WebContentFolder/principalNavBar.jsp" %>
<%@include file="./WebContentFolder/secondaryNavBar.jsp" %>
<div class="container-fluid">
    <h3 class="text-dark mb-4">Profile</h3>
    <div class="row mb-3">
        <div class="col-lg-4">
            <div class="card mb-3">
                <div class="card-body text-center shadow">
                    <img class="rounded-circle mb-3 mt-4" src="assets/img/dogs/image2.jpeg" width="160" height="160">
                    <div class="mb-3">
                    <button class="btn btn-primary btn-sm" type="button">Change Photo</button>
                    </div>
                </div>
            </div>
            <div class="card shadow mb-4">
                <div class="card-header py-3">
                    <h6 class="text-primary fw-bold m-0">Status</h6>
                </div>
                <div class="card-body" style="padding: 7px;margin: 31px;height: 215px;width: 349.664px;">
                    <textarea id="message-2" name="status" rows="6" placeholder="Your status" style="width: 282px;"></textarea>
                    <div class="col-md-8 col-lg-6 col-xl-5 col-xxl-4" style="width: 288.188px;text-align: center;">
                        <button class="btn btn-primary d-block w-100" type="submit">Set Status</button>
                        <div class="card mb-5"></div>
                    </div>
                    <h4 class="small fw-bold"></h4>
                    <section></section>
                </div>
            </div>
        </div>
        <div class="col-lg-8">
            <div class="row mb-3 d-none">
                <div class="col">
                    <div class="card text-white bg-primary shadow">
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
                            <p class="text-white-50 small m-0"><i class="fas fa-arrow-up"></i>&nbsp;5% since last month</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <div class="card shadow mb-3">
                        <div class="card-header py-3">
                            <p class="text-primary m-0 fw-bold">User Settings</p>
                        </div>
                        <div class="card-body">
                            <form>
                                <div class="row">
                                    <div class="col">
                                        <div class="mb-3">
                                            <label class="form-label" for="username"><strong>Username</strong></label>
                                            <input class="form-control" type="text" id="username" placeholder="user.name" name="username">
                                        </div>
                                    </div>
                                    <div class="col">
                                        <div class="mb-3">
                                            <label class="form-label" for="email"><strong>Email Address</strong></label>
                                            <input class="form-control" type="email" id="email" placeholder="user@example.com" name="email">
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col">
                                        <div class="mb-3">
                                            <label class="form-label" for="first_name"><strong>First Name</strong></label>
                                            <input class="form-control" type="text" id="first_name" placeholder="John" name="firstName">
                                        </div>
                                    </div>
                                    <div class="col">
                                        <div class="mb-3">
                                            <label class="form-label" for="last_name"><strong>Last Name</strong></label>
                                            <input class="form-control" type="text" id="last_name" placeholder="Doe" name="lastName">
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col">
                                        <div class="mb-3">
                                            <label class="form-label" for="last_name"><strong>Phone Prefix</strong><br></label>
                                            <input class="form-control" type="text" id="last_name-1" placeholder="+39" name="phonePrefix">
                                        </div>
                                    </div>
                                    <div class="col">
                                        <div class="mb-3">
                                            <label class="form-label" for="last_name"><strong>Phone Number</strong><br></label>
                                            <input class="form-control" type="text" id="last_name-2" placeholder="333 444 ..." name="phoneNumber">
                                        </div>
                                    </div>
                                </div>
                                <div class="mb-3">
                                    <button class="btn btn-primary btn-sm" type="submit">Save Settings</button>
                                </div>
                            </form>
                        </div>
                    </div>
                    <div class="card shadow">
                        <div class="card-header py-3">
                            <p class="text-primary m-0 fw-bold">Contact Settings</p>
                        </div>
                        <div class="card-body">
                            <form>
                                <div class="mb-3">
                                    <label class="form-label" for="address"><strong>Address</strong></label>
                                    <input class="form-control" type="text" id="address" placeholder="Sunset Blvd, 38" name="address">
                                </div>
                                <div class="row">
                                    <div class="col">
                                        <div class="mb-3">
                                            <label class="form-label" for="city"><strong>City</strong></label>
                                            <input class="form-control" type="text" id="city" placeholder="Los Angeles" name="city">
                                        </div>
                                    </div>
                                    <div class="col">
                                        <div class="mb-3">
                                            <label class="form-label" for="country"><strong>Country</strong></label>
                                            <input class="form-control" type="text" id="country" placeholder="USA" name="country">
                                        </div>
                                    </div>
                                </div>
                                <div class="mb-3">
                                    <button class="btn btn-primary btn-sm" type="submit">Save&nbsp;Settings</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="card shadow mb-5">
        <div class="card-header py-3">
            <p class="text-primary m-0 fw-bold">Forum Settings</p>
        </div>
        <div class="card-body"><form><div class="mb-3"></div>
            <div class="mb-3">
                <div class="row">
                    <div class="col-md-6">
                        <form>
                            <div class="mb-3"></div>
                            <div class="mb-3">
                                <div class="form-check form-switch">
                                    <input class="form-check-input" type="checkbox" id="formCheck-1">
                                    <label class="form-check-label" for="formCheck-1"><strong>Notify me via message</strong></label>
                                </div>
                                <div class="form-check form-switch">
                                    <input class="form-check-input" type="checkbox" id="formCheck-4">
                                    <label class="form-check-label" for="formCheck-4"><strong>Notify me via e-mail</strong></label>
                                </div>
                                <div class="form-check form-switch">
                                    <input class="form-check-input" type="checkbox" id="formCheck-6">
                                    <label class="form-check-label" for="formCheck-6"><strong>Notify me via what's app</strong></label>
                                </div>
                            </div>
                            <div class="mb-3"></div>
                        </form>
                    </div>
                    <div class="col-md-6">
                        <form>
                            <div class="mb-3"></div>
                            <div class="mb-3">
                                <div class="form-check form-switch">
                                    <input class="form-check-input" type="checkbox" id="formCheck-2">
                                    <label class="form-check-label" for="formCheck-2"><strong>Notify me about events</strong></label>
                                </div>
                                <div class="form-check form-switch">
                                    <input class="form-check-input" type="checkbox" id="formCheck-3">
                                    <label class="form-check-label" for="formCheck-3"><strong>Notify me about task</strong></label>
                                </div>
                                <div class="form-check form-switch"><input class="form-check-input" type="checkbox" id="formCheck-5">
                                    <label class="form-check-label" for="formCheck-5"><strong>Notify me when a project is concluded</strong></label>
                                </div>
                            </div>
                            <div class="mb-3"></div>
                        </form>
                    </div>
                </div>
            </div>
            <div class="mb-3">
                <button class="btn btn-primary btn-sm" type="submit">Save Settings</button>
            </div>
        </form>
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