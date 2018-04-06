<%--
  Created by IntelliJ IDEA.
  User: purushotham
  Date: 4/3/2018
  Time: 4:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="header.jsp" %>
<html>
<head>
    <title>Voyager</title>
</head>


<!-- Main navigation -->

<body class="cyan-skin">
<header>
    <%--    <!--Navbar-->
        <nav class="navbar navbar-expand-lg navbar-dark fixed-top scrolling-navbar">
            <div class="container">
                <a class="navbar-brand" href="#">
                    <strong>MDB</strong>
                </a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent-7" aria-controls="navbarSupportedContent-7" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent-7">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="#">Home
                                <span class="sr-only">(current)</span>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Link</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Profile</a>
                        </li>
                    </ul>
                    <form class="form-inline">
                        <div class="md-form mt-0">
                            <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
                        </div>
                    </form>
                </div>
            </div>
        </nav>--%>
    <!-- Navbar -->
    <!-- Full Page Intro -->
    <div class="view jarallax" data-jarallax='{"speed": 0.2}' style="background-image: url('https://mdbootstrap.com/img/Photos/Others/images/76.jpg'); background-repeat: no-repeat; background-size: cover; background-position: center center;">
        <!-- Mask & flexbox options-->
        <div class="mask rgba-white-light d-flex justify-content-center align-items-center">
            <!-- Content -->
            <div class="container">
                <!--Grid row-->
                <div class="row">
                    <!--Grid column-->
                    <div class="col-md-12 white-text text-center">
                        <h1 class="display-3 mb-0 pt-md-5 pt-5 white-text font-weight-bold wow fadeInDown" data-wow-delay="0.3s">Voyager</h1>
                        <h5 class="text-uppercase pt-md-5 pt-sm-2 pt-5 pb-md-5 pb-sm-3 pb-5 white-text font-weight-bold wow fadeInDown" data-wow-delay="0.3s">Explore the Life</h5>
                        <div class="wow fadeInDown" data-wow-delay="0.3s">
                            <a class="btn btn-light-blue btn-lg" href="/tours">Tour Packages</a>
                            <a class="btn btn-indigo btn-lg" href="/tourists">Tourists</a>
                        </div>
                    </div>
                    <!--Grid column-->
                </div>
                <!--Grid row-->
            </div>
            <!-- Content -->
        </div>
        <!-- Mask & flexbox options-->
    </div>
    <!-- Full Page Intro -->
</header>

<style>
    html,
    body,
    header,
    .view {
        height: 100%;
    }

    @media (max-width: 740px) {
        .full-page-intro {
            height: 100vh;
        }
    }

    .top-nav-collapse {
        background-color: #82b1ff !important;
    }

    .navbar:not(.top-nav-collapse) {
        background: transparent !important;
    }

    @media (max-width: 768px) {
        .navbar:not(.top-nav-collapse) {
            background: #82b1ff !important;
        }
    }

    h5 {
        letter-spacing: 3px;
    }

    .jarallax {
        min-height: auto;
    }

</style>
</body>
</html>
