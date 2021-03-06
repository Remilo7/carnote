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

    <title>Add new vehicle</title>

    <link href="<c:url value="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/static/css/style.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/static/css/bg1.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/static/css/form.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/static/css/buttons1.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/static/css/selectbox.css" />" rel="stylesheet">
</head>
<body onload="hideZeros(); fuelChange(${vehicle.ftype});">

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-4"></div>
        <div class="col-sm-4">

            <div class="row">
                <div class="col-sm-12">
                    <h1 class="text-center appname">CarNote</h1>
                    <h3 class="text-center pagetitle">Edit vehicle data</h3>
                </div>
            </div>

            <%-- Edit vehicle data form--%>

            <div class="row">
                <div class="col-sm-12 form-wrapper">
                    <form:form name="vehicleForm" action="editVehicle" method="post" onsubmit="return validateForm()" modelAttribute="vehicle">

                        <div id="errorMessage">
                            <p id="message"></p>
                        </div>

                        <form:input type="text" class="d-none" path="id" value="${vehicle.id}" />

                        <div class="group">
                            <form:input type="text" name="brand" path="brand" required="required" maxlength="30" />
                            <span class="highlight"></span>
                            <span class="bar"></span>
                            <label>Brand</label>
                        </div>

                        <div class="group">
                            <form:input type="text" path="model" required="required" maxlength="50" />
                            <span class="highlight"></span>
                            <span class="bar"></span>
                            <label>Model</label>
                        </div>

                        <div class="group">
                            <form:input type="text" name="year" path="year" />
                            <span class="highlight"></span>
                            <span class="bar"></span>
                            <label>Year</label>
                        </div>

                        <div class="group">
                            <form:select name="ftype" path="ftype" onchange="fuelChange(this);">
                                <form:option value="1" disabled="true" cssClass="placeholder">Fuel type</form:option>
                                <form:option value="1">Petrol</form:option>
                                <form:option value="2">Diesel</form:option>
                                <form:option value="3">Petrol + LPG</form:option>
                            </form:select>
                        </div>

                        <div class="group">
                            <form:input type="text" name="cap1" path="cap1" onchange="mainTankCap(this.value);" />
                            <span class="highlight"></span>
                            <span class="bar"></span>
                            <label>Main fuel tank capacity</label>
                        </div>

                        <div class="group range-wrap">
                            <form:input type="range" cssClass="range" id="tank1" path="level1" min="0" max="${vehicle.cap1}" />
                            <output class="bubble"></output>
                            <span class="highlight"></span>
                            <label>Main fuel tank level</label>
                        </div>

                        <div class="input-spacer" id="lpg-spacer"></div>

                        <div class="group" id="lpg-cap">
                            <form:input type="text" id="cap2" name="cap2" path="cap2" onchange="secTankCap(this.value);" />
                            <span class="highlight"></span>
                            <span class="bar"></span>
                            <label>LPG tank capacity</label>
                        </div>

                        <div class="group range-wrap" id="lpg-lev">
                            <form:input type="range" cssClass="range" id="tank2" path="level2" min="0" max="${vehicle.cap2}" />
                            <output class="bubble"></output>
                            <span class="highlight"></span>
                            <label>LPG tank level</label>
                        </div>

                        <div class="input-spacer"></div>

                        <div class="group">
                            <form:input type="text" name="milage" path="milage" />
                            <span class="highlight"></span>
                            <span class="bar"></span>
                            <label>Milage</label>
                        </div>

                        <form:button class="button type2 float-right">Edit</form:button>

                    </form:form>

                    <a href="vehicle?vId=${vehicle.id}"><button class="button type4 float-left">Cancel</button></a>
                </div>
            </div>

        </div>
        <div class="col-sm-4"></div>
    </div>
</div>

<script type="text/javascript" src="<c:url value="/resources/static/js/newVehicleForm.js" />"> </script>
<script type="text/javascript" src="<c:url value="/resources/static/js/range-slider.js" />"> </script>

</body>
</html>
