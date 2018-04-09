<%--
  Created by IntelliJ IDEA.
  User: purushotham
  Date: 4/6/2018
  Time: 1:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="header.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="row">
    <div class="col-md-3"></div>
    <div class="col-md-6">
          <h1>Register Tourist</h1>
                <form:form action="saveTourist" method="post" commandName="tourist">
        <div class="md-form">
            <form:select items="${touristList}"  id="selectCategory" itemLabel="firstName" itemValue="id" path="id">
            </form:select>
        <%--</div>
                    <form:hidden path="id"/>
        <div class="md-form">
                    <td>First Name</td>
                    <td><form:input path="firstName" class="form-control" /></td>
                </div>
        <div class="md-form">
                    <td>Last Name</td>
                    <td><form:input path="lastName" class="form-control" /></td>
        </div>
        <div class="md-form">
                    <p>Date of Birth:</p>
    &lt;%&ndash;                <td><input type="text" path="dob" class= "date" name = "dob" value = "<fmt:formatDate value="${dob}" pattern="DD/MM/YYYY" />"/></td>&ndash;%&gt;

        <input type="date" class="date" name="dob" data-date="" data-date-format="YYYY-MM-DD" value="2015-08-09" class="form-control">
        </div>
        <div class="md-form">
    <form:hidden path="passport.p_id" />
                    <p>Passport:</p>
                    <form:input path="passport.type" class="form-control" /><br>
    <input class="date" type="date" name="passport.expiredDate" data-date="" data-date-format="YYYY-MM-DD" value="2015-08-09" class="form-control" /><br>                   &lt;%&ndash;<form:input path="passport.expiredDate" type="date" /><br>&ndash;%&gt;
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
        <td><form:input path="addressList[${vs.index}].city"/></td>
        <td>Street: </td>
        <td><form:input path="addressList[${vs.index}].street"/></td>
        <td>State: </td>
        <td><form:input path="addressList[${vs.index}].state"/></td>
        <td>Zipcode: </td>
        <td><form:input path="addressList[${vs.index}].zipcode"/></td>
                </c:forEach>
        </div>
        <div class="text-center mt-4">
            <button class="btn btn-primary" type="submit">Save</button>
                        </div>--%>
    <p>
         <c:forEach items="${tourist.tours}"  var ="tourPackage" varStatus="vs">
        <form:hidden path="tours[${vs.index}].id"/>
        <form:hidden path="tours[${vs.index}].placeName"/>
        <form:hidden path="tours[${vs.index}].packageType"/>
        <form:hidden path="tours[${vs.index}].packageName"/>
        <form:hidden path="tours[${vs.index}].price"/>
         </c:forEach>
    </p>

                </div>
            </form:form>

        <div id="container">

        </div>
</div>
</div>

<script>
    $(document).ready(function() {
        $("input").on("change", function () {
            console.log("on change attribute")
            this.setAttribute(
                "data-date",
                moment(this.value, "YYYY-MM-DD")
                    .format(this.getAttribute("data-date-format"))
            )
        }).trigger("change")
        $("#selectCategory").change(function () {
            var categoryId = $(this).val();
            console.log(categoryId);
            var tourId = ${tour.id}
            $.get("<c:url value="/getTourist" />",{id:categoryId,tourId:tourId}, function(data) {
                var content = '';
                console.log("testing")
                $('#container').html(data);
                /* $.each(data, function(){
                     content += '<option value="' + this.stateId + '">' + this.stateName + '</option>';
                 });

                 */
            });
        })
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
