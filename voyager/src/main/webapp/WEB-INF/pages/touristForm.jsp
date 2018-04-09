<%--
  Created by IntelliJ IDEA.
  User: purushotham
  Date: 4/4/2018
  Time: 1:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="header.jsp" %>
<html>
<head>
    <title>Voyager</title>
</head>
<body>
        <div class="row">
    <div class="col-md-3"></div>
    <div class="col-md-6">

            <h1>Register Tourist</h1>
            <form:form action="saveTourist" method="post" commandName="tourist">
    <%--<tr>
        <c:choose>
        <c:when test="${sessionScope.isEditable == true}">
        <td>
            <form:select items="${touristList}"  itemLabel="firstName" itemValue="id" path="tours.id"></form:select>
        </td>
        </c:when>
    </c:choose>
    </tr>--%>
                <form:hidden path="id"/>
    <div class="md-form">
                    <p>First Name</p>
                <form:input path="firstName" class="form-control" />
    </div>
    <div class="md-form">
                    <p>Last Name</p>
                    <form:input path="lastName" class="form-control"/>
    </div>
    <div class="md-form">
                    <p>Date of Birth:</p>

        <input type="date" class="date form-control" name="dob" data-date="" data-date-format="YYYY-MM-DD" value="2015-08-09">
    </div>
    <div class="md-form">
    <form:hidden path="passport.p_id" />
                    <p>Passport:</p>
    <form:input path="passport.type" class="form-control" /><br>
    <input class="date form-control" type="date" name="passport.expiredDate" data-date="" data-date-format="YYYY-MM-DD" value="2015-08-09" /><br>                   <%--<form:input path="passport.expiredDate" type="date" /><br>--%>
    <form:input path="passport.issuedBy" class="form-control" /><br>
    </div>
        <div class="md-form">
      <c:forEach items="${tourist.addressList}" varStatus="vs">
        <c:choose>
            <c:when test="${vs.index=='0'}">
                <p>Primary Address:</p>
            </c:when>
            <c:otherwise>
                <p>Alternate Address:</p>
            </c:otherwise>
        </c:choose>
        <form:hidden path="addressList[${vs.index}].id"/>
        <td>City: </td>
        <td><form:input path="addressList[${vs.index}].city" class="form-control"/></td>
        <td>Street: </td>
        <td><form:input path="addressList[${vs.index}].street" class="form-control"/></td>
        <td>State: </td>
        <td><form:input path="addressList[${vs.index}].state" class="form-control" /></td>
        <td>Zipcode: </td>
        <td><form:input path="addressList[${vs.index}].zipcode" class="form-control" /></td>
                </c:forEach>
        </div>
    <div class="text-center mt-4">
                        <button class="btn btn-primary" type="submit">Save</button>
    </div>
    <p>
         <c:forEach items="${tourist.tours}"  var ="tourPackage" varStatus="vs">
        <form:hidden path="tours[${vs.index}].id"/>
        <form:hidden path="tours[${vs.index}].placeName"/>
        <form:hidden path="tours[${vs.index}].packageType"/>
        <form:hidden path="tours[${vs.index}].packageName"/>
        <form:hidden path="tours[${vs.index}].price"/>
         </c:forEach>
    </p>
    </form:form>
        </div>
</div>
<script>
    $(document).ready(function(){
        $("input").on("change", function() {
            console.log("on change attribute")
            this.setAttribute(
                "data-date",
                moment(this.value, "YYYY-MM-DD")
                    .format( this.getAttribute("data-date-format") )
            )
        }).trigger("change")
    })
</script>

<style>
    input.date {
        position: relative;
        width: 150px; height: 20px;
        color: white;
    }

    input.date:before {
        position: absolute;
        top: 3px; left: 3px;
        content: attr(data-date);
        display: inline-block;
        color: black;
    }

    input.date::-webkit-datetime-edit, input.date::-webkit-inner-spin-button, input.date::-webkit-clear-button {
        display: none;
    }

    input.date::-webkit-calendar-picker-indicator {
        position: absolute;
        top: 3px;
        right: 0;
        color: black;
        opacity: 1;
    }
</style>
</body>
</html>