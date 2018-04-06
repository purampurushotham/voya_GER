<%--
  Created by IntelliJ IDEA.
  User: purushotham
  Date: 4/4/2018
  Time: 2:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="header.jsp" %>
<html>
<head>
</head>
<body>
<div align="center">
            <h1>Tours List</h1>
            <h3>
    <a href="newTour">New Tour</a>
            </h3>
    <table border="1" class="table table-hover table-responsive-md btn-table">
        <tr>
                    <th>Place</th>
                    <th>Package Type</th>
                    <th>Package Name</th>
                    <th>Price</th>
                `   <th>Actions</th>
         </tr>
                    <c:forEach var="tour" items="${toursList}">
                        <tr>
                                <td onclick="window.location.href='/viewTour?id=${tour.id}'">${tour.placeName}</td>
                                <td onclick="window.location.href='/viewTour?id=${tour.id}'">${tour.packageName}</td>
                                <td onclick="window.location.href='/viewTour?id=${tour.id}'">${tour.packageType}</td>
                                <td onclick="window.location.href='/viewTour?id=${tour.id}'">${tour.price}</td>
                        <td><button type="button" class="btn btn-default btn-rounded"
                                    onclick="window.location.href='/editTour?id=${tour.id}'">Edit</button>
                            <button type="button" class="btn btn-danger btn-rounded"
                                    onclick="window.location.href='/deleteTour?id=${tour.id}'">Delete</button>
                        </td>

            <%--                    <td><a href="editTour?id=${tour.id}">Edit</a>
                                         <a href="deleteTour?id=${tour.id}">Delete</a></td>--%>
                        </tr>

                    </c:forEach>
                </table>
        </div>
<style>
    a:-webkit-any-link {
        cursor: pointer;
        text-decoration: none;
    }
</style>
</body>
</html>
