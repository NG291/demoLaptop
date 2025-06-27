<!DOCTYPE html>
<html lang="en">
<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <head>
            <meta charset="utf-8" />
            <meta http-equiv="X-UA-Compatible" content="IE=edge" />
            <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
            <meta name="description" content=" LaptopShop" />
            <meta name="author" content="Public" />
            <title>ProductDetail - LaptopShop</title>
            <link href="/css/styles.css" rel="stylesheet" />
            <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
        </head>

        <body class="sb-nav-fixed d-flex flex-column min-vh-100">
            <jsp:include page="../layout/header.jsp" />
            <div id="layoutSidenav">
                <jsp:include page="../layout/sidenav.jsp" />
                <div id="layoutSidenav_content">
                    <main>
                        <div class="container-fluid px-4">
                            <h1 class="mt-4">Product Detail</h1>
                            <ol class="breadcrumb mb-4">
                                <li class="breadcrumb-item"> <a href="/admin">Dashboard</a></li>
                                <li class="breadcrumb-item"> <a href="/admin/product">Product</a></li>
                                <li class="breadcrumb-item active"> Product Detail </li>
                            </ol>
                            <div class="mt-5">
                                <div class="row">
                                    <div class="col-12 mx-auto">
                                        <div class="d-flex justify-content-between">
                                            <h3> Product Detail: id=${id}</h3>
                                        </div>
                                        <hr />
                                        <div class="card" style="width: 40%">
                                            <div class="col-12 mb-3">
                                                <!-- <img style="max-height: 250px; display:none" alt="avatarPreview"
                                                    id="avatarPreview"> -->
                                                <img class="card-img-top" style="max-width: auto; max-height: 300px;"
                                                    src="/images/product/${product.image}" alt="ImageLapTop">

                                            </div>
                                            <div class="card-header">
                                                Product Information
                                            </div>
                                            <ul class="list-group list-group-flush">
                                                <li class="list-group-item" disabled="true"> ID: ${id}</li>
                                                <li class="list-group-item"> Name: ${product.name}</li>
                                                <li class="list-group-item"> Price ${product.price}</li>

                                            </ul>
                                            <a class="btn btn-success" href="/admin/product">Back</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </main>
                </div>
            </div>
            <jsp:include page="../layout/footer.jsp" />
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
                crossorigin="anonymous"></script>
            <script src="/js/scripts.js"></script>
        </body>

</html>