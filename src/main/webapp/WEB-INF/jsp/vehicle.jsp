<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Vehicle Data</title>

    <link href="<c:url value="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/static/css/style.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/static/css/style3.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/static/css/buttons1.css" />" rel="stylesheet">
</head>
<body>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3"></div>
        <div class="col-sm-6">

            <div class="row">
                <div class="col-sm-12">
                    <h1 class="text-center appname">CarNote</h1>
                    <h3 class="text-center pagetitle">${vehicle.brand} ${vehicle.model}</h3>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-12 table-responsive table-wrapper table-vehicle-wrapper">

                    <input class="table-vehicle-search" id="myInput" type="text" placeholder="Search..">

                    <div class="table-autoscroll">
                        <table class="table table-hover text-center">
                            <thead>
                            <tr>
                                <th>Expense</th>
                                <th>Type</th>
                                <th>Date</th>
                                <th>Milage</th>
                                <th>Price</th>
                            </tr>
                            </thead>

                            <tbody id="myTable">
                            <c:forEach items="${expenseList}" var="expense">
                                <tr class="table-row" onclick="window.location='expense?eId=${expense.id}'">
                                    <td>${expense.name}</td>
                                    <td>${expense.type.name}</td>
                                    <td>${expense.date}</td>
                                    <td>${expense.milage} km</td>
                                    <td>${expense.price} zł</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>

                    <div class="bottom-zero">
                        <div class="d-flex justify-content-between">
                            <a href="newExpense?vId=${vehicle.id}"><button class="button type2">Add expense</button></a>

                            <c:choose>
                                <c:when test="${vehicle.ftype==1}">
                                    <a href="newFuelExpense?vId=${vehicle.id}&ft=1"><button class="button type2">Add refuelling</button></a>
                                </c:when>
                                <c:when test="${vehicle.ftype==2}">
                                    <a href="newFuelExpense?vId=${vehicle.id}&ft=2"><button class="button type2">Add refuelling</button></a>
                                </c:when>
                                <c:otherwise>
                                    <button type="button" class="button type2" data-toggle="modal" data-target="#myModal">Add refuelling</button>
                                </c:otherwise>
                            </c:choose>
                        </div>

                        <div class="col-sm-12 input-spacer"></div>

                        <div class="d-flex justify-content-between">
                            <a href="index"><button class="button type1">Import from .xslx</button></a>
                            <a href="index"><button class="button type1">Export to .xslx</button></a>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row p-0">
                <div class="col-sm-12 p-0">
                    <div class="input-spacer"></div>
                    <a href="index"><button class="btn btn-dark pull-left bottom-zero">Go back</button></a>
                </div>
            </div>

        </div>
        <div class="col-sm-3"></div>
    </div>
</div>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLongTitle">Choose tanked fuel</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body d-flex justify-content-between">
                <a href="newFuelExpense?vId=${vehicle.id}&ft=3"><button class="btn btn-warning">LPG</button></a>
                <a href="newFuelExpense?vId=${vehicle.id}&ft=1"><button class="btn btn-success">PB</button></a>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="<c:url value="https://code.jquery.com/jquery-3.2.1.slim.min.js" />"></script>
<script type="text/javascript" src="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/static/js/vehiclePage.js" />"> </script>

</body>
</html>