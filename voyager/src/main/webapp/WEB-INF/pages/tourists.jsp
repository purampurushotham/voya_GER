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

<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
        <h1>Tourists</h1>
        <h3>
    <a href="newTourist">New Tourist</a>
            </h3>
    <h2>
<table border="1">
     
                <th>First Name</th>
                <th>Last Name</th>
                <th>DOB</th>
                <th>Passport Details</th>
     
                <c:forEach var="tourist" items="${touristList}">
                    <tr>
     
                        <td>${tourist.firstName}</td>
                        <td>${tourist.lastName}</td>
                        <td>${tourist.dob}</td>
                        <td>Type:${tourist.passport.type},
                            Expired:${tourist.passport.expiredDate},
                            Issued By :${tourist.passport.issuedBy}
                            </td>
    <%--                    <td><a href="ed?id=${tour.id}">Edit</a>
                                 <a href="deleteTour?id=${tour.id}">Delete</a></td>
                                 <a href="bookTour?id=${tour.id}">Book</a></td>--%>
     
                    </tr>
                </c:forEach>
            </table>
    </div>

</body>

</html>
