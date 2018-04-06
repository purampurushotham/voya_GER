<%--
  Created by IntelliJ IDEA.
  User: purushotham
  Date: 4/4/2018
  Time: 3:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="header.jsp" %>
<html>
<head>
    <head>
    </head>
</head>
<body>
<div align="center">
        <h1>Tourists</h1>
    <%--    <h3>
    <a href="newTourist">New Tourist</a>
            </h3>--%>
<table border="1" class="table table-hover table-responsive-md btn-table">
     
                <th>First Name</th>
                <th>Last Name</th>
                <th>DOB</th>
                <th>Passport Details</th>
                <th>Primary Address</th>
                <th>Alternate Address</th>
     
                <c:forEach var="tourist" items="${touristList}">
                    <tr>
     
                        <td>${tourist.firstName}</td>
                        <td>${tourist.lastName}</td>
                        <td>${tourist.dob}</td>
                        <td>Type:${tourist.passport.type},
                            Expired:${tourist.passport.expiredDate},
                            Issued By :${tourist.passport.issuedBy}
                            </td>
                <c:forEach var="address" items="${tourist.addressList}">
                        <td>
                            Street: ${address.street}, City: ${address.city},State: ${address.state}, Zipcode: ${address.zipcode}
                        </td>
</c:forEach>
                        <td><button type="button" class="btn btn-default btn-rounded"
                                onclick="window.location.href='/editTourist?id=${tourist.id}'">Edit</button>
                                 <button type="button" class="btn btn-danger btn-rounded"
                                         onclick="window.location.href='/deleteTourist?id=${tourist.id}'">Delete</button></td>
                    </tr>
                </c:forEach>
            </table>
    </div>

</body>

</html>
