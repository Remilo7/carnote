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

    <title>Edit fuel expense</title>

    <link href="<c:url value="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/static/css/style.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/static/css/bg3.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/static/css/form.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/static/css/buttons1.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/static/css/selectbox.css" />" rel="stylesheet">
</head>
<body>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-4"></div>
        <div class="col-sm-4">

            <div class="row">
                <div class="col-sm-12">
                    <h1 class="text-center appname">CarNote</h1>
                    <h3 class="text-center pagetitle">Edit fuel expense</h3>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-12 form-wrapper">
                    <form:form name="fuelExpenseForm" action="updateFuelExpense" method="post" onsubmit="return validateForm()" modelAttribute="expense">

                        <div id="errorMessage">
                            <p id="message"></p>
                        </div>

                        <div class="d-none">
                            <form:input type="text" class="hidden" path="typeId" value="${oldExpense.type.id}"/>
                            <form:input type="text" class="hidden" path="ftype" value="${oldExpense.ftype}"/>
                            <form:input type="text" class="hidden" path="id" value="${oldExpense.id}"/>
                            <form:input type="text" class="hidden" path="carId" value="${oldExpense.car.id}"/>
                            <form:input type="text" class="hidden" path="name" value="${oldExpense.name}"/>

                            <c:choose>
                                <c:when test="${oldExpense.car.ftype==1}">
                                    <c:set var="cap" value="${oldExpense.car.cap1}" />
                                </c:when>
                                <c:when test="${oldExpense.car.ftype==2}">
                                    <c:set var="cap" value="${oldExpense.car.cap1}" />
                                </c:when>
                                <c:otherwise>
                                    <c:set var="cap" value="${oldExpense.car.cap2}" />
                                </c:otherwise>
                            </c:choose>
                        </div>

                        <div class="group">
                            <form:input type="date" name="date" path="date" value="${oldExpense.date}" required="required" />
                            <span class="highlight"></span>
                            <span class="bar"></span>
                            <label>Date (DD.MM.RRRR)</label>
                        </div>

                        <div class="group">
                            <form:input type="text" name="milage" path="milage" value="${oldExpense.milage}" required="required" />
                            <span class="highlight"></span>
                            <span class="bar"></span>
                            <label>Milage</label>
                        </div>

                        <div class="group">
                            <form:input type="text" id="price" name="price" path="price" value="${oldExpense.price}" onkeyup="addDot(this);" required="required" />
                            <span class="highlight"></span>
                            <span class="bar"></span>
                            <label>Price</label>
                        </div>

                        <div class="group">
                            <form:input type="text" id="litres" name="litres" path="litres" value="${oldExpense.litres}" onkeyup="addDot(this);" required="required" />
                            <span class="highlight"></span>
                            <span class="bar"></span>
                            <label>Litres tanked</label>
                        </div>

                        <div class="group range-wrap">
                            <form:input type="range" cssClass="range" path="level" value="${oldExpense.level}" min="0" max="${cap}" />
                            <output class="bubble"></output>
                            <span class="highlight"></span>
                            <label>Tank level</label>
                        </div>

                        <div class="input-spacer"></div>

                        <form:button class="button type2 float-right">Save</form:button>

                    </form:form>

                    <a href="vehicle?vId=${oldExpense.car.id}"><button class="button type4 float-left">Cancel</button></a>
                </div>
            </div>

        </div>
        <div class="col-sm-4"></div>
    </div>
</div>

<script type="text/javascript" src="<c:url value="/resources/static/js/newFuelExpenseForm.js" />"> </script>
<script type="text/javascript" src="<c:url value="/resources/static/js/range-slider.js" />"> </script>

</body>
</html>
