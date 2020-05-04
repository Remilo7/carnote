<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>New fuel expense</title>

    <link href="<c:url value="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/static/css/style.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/static/css/style2.css" />" rel="stylesheet">
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
                    <h3 class="text-center pagetitle">Add new fuel expense</h3>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-12 form-wrapper">
                    <form:form name="expenseForm" action="addFuelExpense" method="post" onsubmit="return validateForm()" modelAttribute="expense">

                        <div id="errorMessage">
                            <p id="message"></p>
                        </div>

                        <div class="d-none">
                            <form:input type="text" class="hidden" path="carId" value="${vehicle.id}"/>
                            <form:input type="text" class="hidden" path="typeId" value="6"/>
                            <form:input type="text" class="hidden" path="ftype" value="${fuel}"/>

                            <c:choose>
                                <c:when test="${fuel==1}">
                                    <form:input type="text" class="hidden" path="name" value="PB"/>
                                    <c:set var="cap" value="${vehicle.cap1}" />
                                </c:when>
                                <c:when test="${fuel==2}">
                                    <form:input type="text" class="hidden" path="name" value="ON"/>
                                    <c:set var="cap" value="${vehicle.cap1}" />
                                </c:when>
                                <c:otherwise>
                                    <form:input type="text" class="hidden" path="name" value="LPG"/>
                                    <c:set var="cap" value="${vehicle.cap2}" />
                                </c:otherwise>
                            </c:choose>
                        </div>

                        <div class="group">
                            <form:input type="date" name="date" path="date" required="required" />
                            <span class="highlight"></span>
                            <span class="bar"></span>
                            <label>Date (DD.MM.RRRR)</label>
                        </div>

                        <div class="group">
                            <form:input type="text" name="milage" path="milage" required="required" />
                            <span class="highlight"></span>
                            <span class="bar"></span>
                            <label>Milage</label>
                        </div>

                        <div class="group">
                            <form:input type="text" name="price" path="price" pattern="(\d+\.\d{1,2})" required="required" />
                            <span class="highlight"></span>
                            <span class="bar"></span>
                            <label>Price</label>
                        </div>

                        <div class="group">
                            <form:input type="text" name="litres" path="litres" />
                            <span class="highlight"></span>
                            <span class="bar"></span>
                            <label>Litres tanked</label>
                        </div>

                        <div class="group range-wrap">
                            <form:input type="range" cssClass="range" path="level" min="0" max="${cap}" />
                            <output class="bubble"></output>
                            <span class="highlight"></span>
                            <label>Tank level</label>
                        </div>

                        <div class="input-spacer"></div>

                        <form:button class="button type2 float-right">Add</form:button>

                    </form:form>

                    <a href="vehicle?vId=${vehicle.id}"><button class="button type4 float-left">Cancel</button></a>
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
