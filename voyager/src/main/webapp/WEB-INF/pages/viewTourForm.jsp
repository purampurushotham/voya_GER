<%--
  Created by IntelliJ IDEA.
  User: purushotham
  Date: 4/5/2018
  Time: 7:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>
<%@include file="newForm.jsp" %>

    <html>
    <head>
    <link href="tours.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
    <div class="row">
        <div class="col-md-3"></div>
    <div class="col-md-6">
    <!--Card Warning-->
    <div class="card">
        <div class="card-header deep-orange lighten-1 white-text">Package Details</div>
    <div class="card-body">
    <p class="white-text mb-0">
    <ul class="list-group">
    <li class="list-group-item d-flex justify-content-between align-items-center">
    Package Name: ${tour.packageName}
    </li>
    <li class="list-group-item d-flex justify-content-between align-items-center">
    Package Type: ${tour.packageType}
    </li>
    <li class="list-group-item d-flex justify-content-between align-items-center">
    Place: ${tour.placeName}
    </li>
    <li class="list-group-item d-flex justify-content-between align-items-center">
    Price: ${tour.price}
    </li>
    <li class="list-group-item d-flex justify-content-between align-items-center">
    <button class="btn btn-primary btn-rounded"
            onclick="window.location.href='/newTourist?id=${tour.id}'">Book to New </button>
    <button class="btn btn-danger btn-rounded"
            onclick="window.location.href='/getAllTourists?id=${tour.id}'">Book to Existing </button>
        <button class="btn peach-gradient btn-rounded"
                data-toggle="modal" data-target="#centralModalInfo" >Modal</button>
    </li>
    </ul>
    </p>
    </div>
    </div>
    </div>
    </div>
    </body>
    </html>
    <%--<div align="center">
                <h1>Tour Package Details</h1>
        <table border="1">
                   <tr>
            <td>Package Name: ${tour.packageName}</td>
        </tr>
            <tr>
                        <td>Package Type: ${tour.packageType}</td>
            </tr>
            <tr>      <td>Place: ${tour.placeName}</td>
            </tr>
            <tr> <td>Price: ${tour.price}</td>
            </tr>
            <tr>
                                    <td><a href="newTourist?id=${tour.id}">Book to New </a>
                                    <a href="getAllTourists?id=${tour.id}">Book to Existing </a>
            </td>
                                </tr>
                    </table>
            </div>--%>