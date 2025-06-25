<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <!DOCTYPE html>
    <html lang="en">
    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

            <head>
                <meta charset="utf-8" />
                <meta http-equiv="X-UA-Compatible" content="IE=edge" />
                <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
                <meta name="description" content="Hỏi Dân IT - Dự án laptopshop" />
                <meta name="author" content="Hỏi Dân IT" />
                <title>Update User - Hỏi Dân IT</title>
                <link href="/css/styles.css" rel="stylesheet" />
                <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
            </head>

            <body class="sb-nav-fixed">
                <jsp:include page="../layout/header.jsp" />
                <div id="layoutSidenav">
                    <jsp:include page="../layout/sidenav.jsp" />
                    <div id="layoutSidenav_content">
                        <main>
                            <div class="container-fluid px-4">
                                <h1 class="mt-4">Update Users</h1>
                                <ol class="breadcrumb mb-4">
                                    <li class="breadcrumb-item"> <a href="/admin">Dashboard</a></li>
                                    <li class="breadcrumb-item active"> Update User </li>
                                </ol>
                                <div class="mt-5">
                                    <div class="row">
                                        <div class="col-md-6 col-12 mx-auto">
                                            <h3> Update a user </h3>
                                            <hr />
                                            <form:form method="post" action="/admin/user/update"
                                                modelAttribute="userUpdate" class="row" enctype="multipart/form-data">
                                                <form:input type="hidden" path="id" />
                                                <div class="mb-3 col-12 col-md-6">
                                                    <label class="form-label"> Email:</label>
                                                    <form:input type="email" class="form-control" path="email"
                                                        value="${user.email}" readonly="true" />
                                                </div>
                                                <div class="mb-3 col-12 col-md-6">
                                                    <label class="form-label"> Password:</label>
                                                    <form:input type="password" class="form-control" path="password"
                                                        value="${user.password}" readonly="true" />
                                                </div>
                                                <div class="mb-3 col-12 col-md-6">
                                                    <label class="form-label">Phone number:</label>
                                                    <form:input type="text" class="form-control" path="phoneNumber"
                                                        value="${user.phoneNumber}" />
                                                </div>
                                                <div class="mb-3 col-12 col-md-6">
                                                    <label class="form-label">Full name:</label>
                                                    <form:input type="text" class="form-control" path="fullName"
                                                        value="${user.fullName}" />
                                                </div>
                                                <div class="mb-3">
                                                    <label class="form-label">Address:</label>
                                                    <form:input type="text" class="form-control" path="address"
                                                        value="${user.address}" />
                                                </div>
                                                <div class="mb-3 col-12 col-md-6">
                                                    <label class="form-label">Role:</label>
                                                    <form:select class="form-select" path="role.name">
                                                        <form:option value="ADMIN"> ADMIN</form:option>
                                                        <form:option value="USER"> USER</form:option>
                                                    </form:select>
                                                </div>
                                                <div class="mb-3 col-12 col-md-6">
                                                    <label for="avatarFile" class="form-label">Avatar</label>
                                                    <input class="form-control" type="file" id="avatarFile"
                                                        accept=".png, .jpg, .ipeg" name="imageFile" />
                                                </div>
                                                <div class="col-12 mb-3">
                                                    <img style="max-height: 250px; display:none" alt="avatarPreview"
                                                        id="avatarPreview">
                                                </div>
                                                <div class="col-12 mb-5">
                                                    <button type="submit" class="btn btn-success">Update</button>
                                                </div>
                                            </form:form>
                                        </div>

                                    </div>
                                </div>
                            </div>
                        </main>
                        <jsp:include page="../layout/footer.jsp" />
                    </div>
                </div>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
                    crossorigin="anonymous"></script>
                <script src="/js/scripts.js"></script>
            </body>

    </html>