<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>New expense</title>

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
                    <h3 class="text-center pagetitle">Add new expense</h3>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-12 form-wrapper">
                    <form:form name="expenseForm" action="addExpense" method="post" onsubmit="return validateForm()" modelAttribute="expense">

                        <div id="errorMessage">
                            <p id="message"></p>
                        </div>

                        <div class="d-none">
                            <form:input type="text" class="hidden" path="carId" value="${vehicle.id}"/>
                        </div>

                        <div class="group">
                            <form:input type="text" name="name" path="name" required="required" maxlength="50" />
                            <span class="highlight"></span>
                            <span class="bar"></span>
                            <label>Name</label>
                        </div>

                        <div class="group">
                            <form:select path="typeId">
                                <form:option value="1" disabled="true" cssClass="placeholder">Expense type</form:option>
                                <form:option value="1">Exploitation</form:option>
                                <form:option value="2">Repairs</form:option>
                                <form:option value="3">MOT</form:option>
                                <form:option value="4">Insurance</form:option>
                                <form:option value="5">Other</form:option>
                            </form:select>
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
                            <form:input type="text" name="price" path="price" onkeyup="addDot(this);" required="required" />
                            <span class="highlight"></span>
                            <span class="bar"></span>
                            <label>Price</label>
                        </div>

                        <div class="group">
                            <form:input type="text" name="description" path="description" />
                            <span class="highlight"></span>
                            <span class="bar"></span>
                            <label>Description</label>
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

<script type="text/javascript" src="<c:url value="/resources/static/js/newExpenseForm.js" />"> </script>

</body>
</html>
