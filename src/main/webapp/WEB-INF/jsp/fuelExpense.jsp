<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Fuel Expense Data</title>

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
                    <h3 class="text-center pagetitle">Refuelling - ${expense.name}</h3>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-12 table-wrapper table-vehicle-wrapper">

                    <h5><b>Date: </b>${expense.date}</h5>
                    <h5><b>Milage: </b>${expense.milage} km</h5>
                    <h5><b>Price: </b>${expense.price} zł</h5>
                    <h5><b>Litres tanked: </b>${expense.litres} L</h5>
                    <h5><b>Fuel level after tanking: </b>${expense.level} L</h5>

                    <div class="d-flex justify-content-between">
                        <a href="deleteFuelExpense?eId=${expense.id}"><button class="button type4">Delete</button></a>
                        <a href="editFuelExpense?eId=${expense.id}"><button class="button type3">Edit</button></a>
                    </div>
                </div>
            </div>

            <div class="row p-0">
                <div class="col-sm-12 p-0">
                    <div class="input-spacer"></div>
                    <a href="vehicle?vId=${expense.car.id}"><button class="btn btn-dark pull-left bottom-zero">Go back</button></a>
                </div>
            </div>

        </div>
        <div class="col-sm-3"></div>
    </div>
</div>

<script type="text/javascript" src="<c:url value="https://code.jquery.com/jquery-3.2.1.slim.min.js" />"></script>
<script type="text/javascript" src="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" />"></script>

</body>
</html>