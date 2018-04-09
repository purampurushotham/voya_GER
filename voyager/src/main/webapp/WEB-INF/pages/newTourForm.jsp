<%--
  Created by IntelliJ IDEA.
  User: purushotham
  Date: 4/3/2018
  Time: 8:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="header.jsp" %>
<html>
<head>
</head>
<body>
    <div class="row">
    <div class="col-md-3"></div>
    <div class="col-md-6">
                <h1>New/Edit Tour</h1>
                <form:form action="saveTour" method="post" modelAttribute="tour">
                    <form:hidden path="id"/>
        <div class="md-form">
                            <p>Place</p>
            <form:input path="placeName" class="form-control"/>
        </div>
        <div class="md-form">
                            <p>Package Type:</p>
                         <form:input path="packageType" class="form-control" />
        </div>
        <div class="md-form">
                            <p>Package Name:</p>
                            <form:input path="packageName" class="form-control"/>
        </div>
        <div class="md-form">
            <p>Price: </p>
            <form:input path="price" class="form-control" />
        </div>
        <div class="text-center mt-4">
                            <button class="btn btn-primary" type="submit">Save</button>
        </div>
                </form:form>
            </div>
</div>
</body>
</html>
<%--
            <form:form action="saveTour" method="post" modelAttribute="tour">
            <table>
                <form:hidden path="id"/>
                <tr>
                    <td>Place</td>
                    <td><form:input path="placeName" /></td>
                </tr>
                <tr>
                    <td>Package Type:</td>
                    <td><form:input path="packageType" /></td>
                </tr>
                <tr>
                    <td>Package Name:</td>
                    <td><form:input path="packageName" /></td>
                </tr>
    <tr>
        <td>Price: </td>
                    <td><form:input path="price" /></td>
    </tr>
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Save"></td>
                </tr>
            </table>
            </form:form>
--%>