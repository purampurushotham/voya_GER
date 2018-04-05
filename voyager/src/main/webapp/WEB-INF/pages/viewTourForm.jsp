<%--
  Created by IntelliJ IDEA.
  User: purushotham
  Date: 4/5/2018
  Time: 7:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
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
                                <td><a href="newTourist?id=${tour.id}">Book</a>
                            </tr>
                </table>
        </div>
</body>
</html>
