<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: purushotham
  Date: 4/9/2018
  Time: 7:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>
<html>
<head>
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
                        Package Name: ${tourist.firstName}
                    </li>
                    <li class="list-group-item d-flex justify-content-between align-items-center">
                        Package Type: ${tourist.lastName}
                    </li>
                    <li class="list-group-item d-flex justify-content-between align-items-center">
                        Place: ${tourist.dob}
                    </li>
                    <li class="list-group-item d-flex justify-content-between align-items-center">
                        Passport: ${tourist.passport.type},${tourist.passport.expiredDate},${tourist.passport.issuedBy}
                    </li>
                <li class="list-group-item d-flex justify-content-between align-items-center">
                    Tour Packages:
                    <c:forEach var="tour" items="${tourist.tours}">
                             ${tour.packageName},${tour.placeName}
                    </c:forEach>
                        </li>
                    <li class="list-group-item d-flex justify-content-between align-items-center">
                        <button class="btn btn-primary btn-rounded"
                                onclick="window.location.href='/tourists'">Go Back</button>
                    </li>
                </ul>
                </p>
            </div>
        </div>
    </div>
</div>
</body>
</html>
