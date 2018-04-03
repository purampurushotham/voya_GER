<%--
  Created by IntelliJ IDEA.
  User: purushotham
  Date: 4/3/2018
  Time: 4:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Voyager</title>
</head>
<div align="center">
            <h1>Tours List</h1>
            <h3>
    <a href="newTour">New Tour</a>
            </h3>
    <table border="1">
     
                <th>Place</th>
                <th>Package Type</th>
                <th>Package Name</th>
                <th>Price</th>
     
                <c:forEach var="tour" items="${toursList}">
                    <tr>
     
                        <td>${tour.placeName}</td>
                        <td>${tour.packageName}</td>
                        <td>${tour.packageType}</td>
                        <td>${tour.price}</td>
                        <td><a href="editEmployee?id=${tour.id}">Edit</a>
                                 <a href="deleteEmployee?id=${tour.id}">Delete</a></td>
     
                    </tr>
                </c:forEach>
            </table>
        </div>
</body>
</html>
