<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Primary Meta Tags -->
    <title>CarNote - notebook and calculator for expenses of your car</title>
    <meta name="title" content="CarNote - notebook and calculator for expenses of your car">
    <meta name="description" content="Store expenses of your vehicle, divided conveniently into categories. See calculated fuel consumption. Remember of MOT and insurance end date. ">

    <!-- Open Graph / Facebook -->
    <meta property="og:type" content="website">
    <meta property="og:url" content="http://carnote.herokuapp.com/">
    <meta property="og:title" content="CarNote - notebook and calculator for expenses of your car">
    <meta property="og:description" content="Store expenses of your vehicle, divided conveniently into categories. See calculated fuel consumption. Remember of MOT and insurance end date. ">
    <meta property="og:image" content="<c:url value="/resources/static/img/meta-logo.jpg" />">

    <title>Main page</title>

    <link href="<c:url value="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/static/css/style.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/static/css/bg1.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/static/css/buttons2.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/static/css/gears.css" />" rel="stylesheet">
</head>
<body>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3"></div>
        <div class="col-sm-6">

            <div class="row" id="settingsMobile">
                <div class="col-sm-12 p-0">
                    <div class="row">
                        <div class="col-9"></div>
                        <div class="col-3">
                            <a data-toggle="modal" data-target="#settingsModal">Modal<i></i><i></i></a>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-2"></div>
                <div class="col-sm-8">
                    <h1 class="text-center appname">CarNote</h1>
                </div>
                <div class="col-sm-2">
                    <a id="settingsDesktop" data-toggle="modal" data-target="#settingsModal"><i></i><i></i></a>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-12 table-responsive table-wrapper">
                    <table class="table table-index table-hover text-center">
                        <thead>
                            <tr>
                                <th>Brand</th>
                                <th>Model</th>
                                <th>Year</th>
                            </tr>
                        </thead>

                        <tbody>
                            <c:forEach items="${vehicleList}" var="vehicle">
                                <tr class="table-row" onclick="window.location='vehicle?vId=${vehicle.id}'">
                                    <td>${vehicle.brand}</td>
                                    <td>${vehicle.model}</td>
                                    <td>${vehicle.year}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-12 center-button">
                    <div class="button-row">
                        <div><a href="newVehicle" title="Add vehicle"></a></div>
                    </div>
                </div>
            </div>

        </div>
        <div class="col-sm-3"></div>
    </div>
</div>

<%-- Modals --%>

<div class="modal fade" id="settingsModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="deleteModalLongTitle">Settings</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body text-center">
                <a href="logout"><button class="btn btn-dark">Log Out</button></a>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="<c:url value="https://code.jquery.com/jquery-3.2.1.slim.min.js" />"></script>
<script type="text/javascript" src="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" />"></script>

</body>
</html>