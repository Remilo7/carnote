<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
        </div>
        <div class="col-sm-3"></div>
    </div>

    <div class="row">
        <div class="col-sm-3">
            <div class="col-sm-12 expenses-details" id="left-display">
                <div class="row">
                    <div class="col-5 text-left">

                        <c:choose>
                            <c:when test="${vehicle.ftype==2}">
                                <c:set var="mainFuelName" value="ON" />
                            </c:when>
                            <c:otherwise>
                                <c:set var="mainFuelName" value="PB" />
                            </c:otherwise>
                        </c:choose>

                        <h5>AVG ${mainFuelName}:</h5>
                        <h5>Last ${mainFuelName}:</h5>
                        <c:if test="${vehicle.ftype==3}">
                            <br>
                            <h5>AVG LPG:</h5>
                            <h5>Last LPG:</h5>
                        </c:if>
                        <br>
                        <h5>Insurance:</h5>
                        <h5>MOT:</h5>
                    </div>
                    <div class="col-7 text-right">
                        <h5><fmt:formatNumber type="number" maxFractionDigits="2" value="${avgMain}"/> L/100km</h5>
                        <h5><fmt:formatNumber type="number" maxFractionDigits="2" value="${lastMain}"/> L/100km</h5>
                        <c:if test="${vehicle.ftype==3}">
                            <br>
                            <h5><fmt:formatNumber type="number" maxFractionDigits="2" value="${avgLPG}"/> L/100km</h5>
                            <h5><fmt:formatNumber type="number" maxFractionDigits="2" value="${lastLPG}"/> L/100km</h5>
                        </c:if>
                        <br>
                        <h5>${insDate}</h5>
                        <h5>${motDate}</h5>
                    </div>
                </div>
            </div>
        </div>

        <div class="col-sm-6">
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

                                <c:choose>
                                    <c:when test="${expense.type.id==6}">
                                        <c:set var="expenseURL" value="fuelExpense?eId=${expense.id}" />
                                    </c:when>
                                    <c:otherwise>
                                        <c:set var="expenseURL" value="expense?eId=${expense.id}" />
                                    </c:otherwise>
                                </c:choose>

                                <tr class="table-row" onclick="window.location='${expenseURL}'">
                                    <td>${expense.name}</td>
                                    <td>${expense.type.name}</td>
                                    <td>${expense.date}</td>
                                    <td>${expense.milage} km</td>
                                    <td><fmt:formatNumber type="number" maxFractionDigits="2" value="${expense.price}"/> zł</td>
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
                                    <button type="button" class="button type2" data-toggle="modal" data-target="#fuelModal">Add refuelling</button>
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
        </div>

        <div class="col-sm-3">
            <div class="col-sm-12 expenses-details" id="right-display">
                <div class="row">
                    <div class="col-5 text-left">
                        <h5>Fuel sum:</h5>
                        <h5>Exploitation:</h5>
                        <h5>Repairs:</h5>
                        <h5>MOT:</h5>
                        <h5>Insurance:</h5>
                        <h5>Other:</h5>
                        <br>
                        <h5>Summary:</h5>
                    </div>
                    <div class="col-7 text-right">
                        <h5><fmt:formatNumber type="number" maxFractionDigits="2" value="${fuel_sum}"/> zł</h5>
                        <h5><fmt:formatNumber type="number" maxFractionDigits="2" value="${exp_sum}"/> zł</h5>
                        <h5><fmt:formatNumber type="number" maxFractionDigits="2" value="${rep_sum}"/> zł</h5>
                        <h5><fmt:formatNumber type="number" maxFractionDigits="2" value="${mot_sum}"/> zł</h5>
                        <h5><fmt:formatNumber type="number" maxFractionDigits="2" value="${ins_sum}"/> zł</h5>
                        <h5><fmt:formatNumber type="number" maxFractionDigits="2" value="${oth_sum}"/> zł</h5>
                        <br>
                        <h5><fmt:formatNumber type="number" maxFractionDigits="2" value="${sum}"/> zł</h5>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-sm-3"></div>
        <div class="col-sm-6">
            <div class="row p-0">
                <div class="col-sm-12 d-flex justify-content-between p-0">
                    <a href="index"><button class="btn btn-dark bottom-zero">Go back</button></a>
                    <button class="btn btn-danger bottom-zero" data-toggle="modal" data-target="#deleteModal">Delete car</button>
                </div>
            </div>
        </div>
        <div class="col-sm-3"></div>
    </div>
</div>

<div class="modal fade" id="fuelModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="fuelModalLongTitle">Choose tanked fuel</h5>
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

<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="deleteModalLongTitle">Confirm deleting your vehicle with all its data</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body d-flex justify-content-between">
                <button type="button" class="btn btn-dark" data-dismiss="modal">Cancel</button>
                <a href="deleteVehicle?vId=${vehicle.id}"><button class="btn btn-danger">Delete</button></a>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="<c:url value="https://code.jquery.com/jquery-3.2.1.slim.min.js" />"></script>
<script type="text/javascript" src="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/static/js/vehiclePage.js" />"> </script>

</body>
</html>