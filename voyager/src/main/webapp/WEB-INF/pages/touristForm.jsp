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
<html>
<head>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.3/moment.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <title>Title</title>
</head>
<body>
<div align="center">
            <h1>Register Tourist</h1>
            <form:form action="saveTourist" method="post" commandName="tourist">
            <table>
                <form:hidden path="id"/>
                <tr>
                    <td>First Name</td>
                    <td><form:input path="firstName" /></td>
                </tr>
                <tr>
                    <td>Last Name</td>
                    <td><form:input path="lastName" /></td>
                </tr>
                <tr>
                    <td>Date of Birth:</td>
    <%--                <td><input type="text" path="dob" class= "date" name = "dob" value = "<fmt:formatDate value="${dob}" pattern="DD/MM/YYYY" />"/></td>--%>

    <td>
        <input type="date" class="date" name="dob" data-date="" data-date-format="YYYY-MM-DD" value="2015-08-09">
    </td>
                </tr>
                <tr>
                    <form:hidden path="passport.p_id" />
                    <td>Passport:</td>
                    <td><form:input path="passport.type" /><br>
    <input class="date" type="date" name="passport.expiredDate" data-date="" data-date-format="YYYY-MM-DD" value="2015-08-09" /><br>                   <%--<form:input path="passport.expiredDate" type="date" /><br>--%>
    <form:input path="passport.issuedBy" /><br>
    </td>
                </tr>
      <c:forEach items="${tourist.addressList}" varStatus="vs">
    <tr>
        <c:choose>
            <c:when test="${vs.index=='0'}">
                Primary Address:
            </c:when>
            <c:otherwise>
                Alternate Address:
            </c:otherwise>
        </c:choose>
                    <form:hidden path="addressList[${vs.index}].id"/>
        <td>City: </td>
        <td><form:input path="addressList[${vs.index}].city"/></td>
        <td>Street: </td>
        <td><form:input path="addressList[${vs.index}].street"/></td>
        <td>State: </td>
        <td><form:input path="addressList[${vs.index}].state"/></td>
        <td>Zipcode: </td>
        <td><form:input path="addressList[${vs.index}].zipcode"/></td>
    </tr>
                </c:forEach>
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Save"></td>
                </tr>
            </table>
            </form:form>
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
