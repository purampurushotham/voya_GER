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
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-autocomplete/1.0.7/jquery.auto-complete.js"></script>
</head>
<body>
<div align="center">
            <h1>Tours List</h1>
            <h3>
    <a href="newTour">New Tour</a>
            </h3>
    <div class="row">
        <div class="col-md-8"></div>
        <div class="col-md-3">
            <div class="md-form">
                <input type="text" id="searchTour" class="form-control" />
                <label for="searchTour">Search By package Name</label>
            </div>
        </div>
    </div>
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
<script>
    $(document).ready(function (e) {
        $("#searchTour").autocomplete({
            minLength: 1,
            source: function (request, response) {
                $.getJSON("/getTourPackages", request, function (result) {
                    console.log(result);
                    response($.map(result, function (item,index) {
                        console.log(item);
                        var name = item[0]
                        return {
                            // following property gets displayed in drop down
                            label: name,
                            // following property gets entered in the textbox
                            value: name,
                            // following property is added for our own use
                            tag_url: "http://" + window.location.host + "/viewTour?id="+ item[1]
                        }
                    }));
                });
            },
            select:function (event,ui) {
                window.location.href = ui.item.tag_url;
            },
        /*$("#searchTour").autocomplete({
            source:'/getTourPackages',
            select:function (event,ui) {
                var keyword = ui.item.label;
                alert(ui.item)
                console.log(ui.item)

            },*/
           /* source: function (request, response) {
                    console.log("success")
                    console.log(data)
                    response(data)
                });*/
        });
    })
</script>
</body>
</html>
