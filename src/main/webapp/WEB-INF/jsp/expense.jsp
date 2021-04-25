<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="theme-color" content="#016188">

    <title>Expense Data</title>

    <link href="<c:url value="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/static/css/style.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/static/css/bg3.css" />" rel="stylesheet">
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
                    <h3 class="text-center pagetitle">${expense.name}</h3>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-12 table-wrapper table-vehicle-wrapper">

                    <h5><b>Date: </b>${expense.date}</h5>
                    <h5><b>Milage: </b>${expense.milage} km</h5>
                    <h5><b>Price: </b>${expense.price} zł</h5>
                    <h5><b>Description: </b></h5>
                    <h5>${expense.description}</h5>

                    <div class="d-flex justify-content-between">
                        <button class="button type4" data-toggle="modal" data-target="#deleteModal">Delete</button>
                        <a href="editExpense?eId=${expense.id}"><button class="button type3">Edit</button></a>
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

<%-- Modals --%>

<%-- Deletion confirmation modal --%>

<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="deleteModalLongTitle">Confirm deleting record</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body d-flex justify-content-between">
                <button type="button" class="btn btn-dark" data-dismiss="modal">Cancel</button>
                <a href="deleteExpense?eId=${expense.id}"><button class="btn btn-danger">Delete</button></a>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="<c:url value="https://code.jquery.com/jquery-3.2.1.slim.min.js" />"></script>
<script type="text/javascript" src="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" />"></script>

</body>
</html>