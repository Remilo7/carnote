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

    <!-- Primary Meta Tags -->
    <title>CarNote - notebook and calculator for expenses of your car</title>
    <meta name="title" content="CarNote - notebook and calculator for expenses of your car">
    <meta name="description" content="Store expenses of your vehicle, divided conveniently into categories. See calculated fuel consumption. Remember of MOT and insurance end date. ">

    <!-- Open Graph / Facebook -->
    <meta property="og:type" content="website">
    <meta property="og:url" content="http://carnote.herokuapp.com/">
    <meta property="og:title" content="CarNote - notebook and calculator for expenses of your car">
    <meta property="og:description" content="Store expenses of your vehicle, divided conveniently into categories. See calculated fuel consumption. Remember of MOT and insurance end date. ">
    <meta property="og:image" content="/resources/static/img/meta-logo.jpg">

    <title>Main page</title>

    <link href="<c:url value="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/static/css/style.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/static/css/bg1.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/static/css/buttons2.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/static/css/gears.css" />" rel="stylesheet">

    <link href="<c:url value="/resources/static/json/manifest.json" />" rel="manifest">

    <link rel="apple-touch-icon" sizes="16x16" href="<c:url value="/resources/static/img/icons/16.png" />">
    <link rel="apple-touch-icon" sizes="32x32" href="<c:url value="/resources/static/img/icons/32.png" />">
    <link rel="apple-touch-icon" sizes="48x48" href="<c:url value="/resources/static/img/icons/48.png" />">
    <link rel="apple-touch-icon" sizes="72x72" href="<c:url value="/resources/static/img/icons/72.png" />">
    <link rel="apple-touch-icon" sizes="76x76" href="<c:url value="/resources/static/img/icons/76.png" />">
    <link rel="apple-touch-icon" sizes="96x96" href="<c:url value="/resources/static/img/icons/96.png" />">
    <link rel="apple-touch-icon" sizes="120x120" href="<c:url value="/resources/static/img/icons/120.png" />">
    <link rel="apple-touch-icon" sizes="512x512" href="<c:url value="/resources/static/img/icons/512.png" />">
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

<%-- Settings modal --%>

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

<%-- PWA --%>

<script>
    // sprawdzamy czy przeglądarka posiada wsparcie dla service workera
    if ('serviceWorker' in navigator) {
        // próba instalacji
        navigator.serviceWorker.register('<c:url value="/resources/static/js/service-worker.js" />').then(function () {
            console.log('Service worker zainstalowany');
        }).catch(function (err) {
            // jeśli coś pójdzie nie tak- konsola nam powie co trzeba poprawić
            console.log('Service worker nie zainstalowany, sprawdź błąd:', err)
        });
    }
</script>

</body>
</html>