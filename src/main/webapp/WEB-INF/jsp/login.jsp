<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Log In</title>

    <link href="<c:url value="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/static/css/style.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/static/css/loginform.css" />" rel="stylesheet">

</head>
<body
<c:if test="${param.succ == '1' || param.succ=='0'}">
    onload="displayRegister()"
</c:if>
>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3"></div>
        <div class="col-sm-6">

            <div class="row">
                <div class="col-sm-12">
                    <h1 class="text-center appname">CarNote</h1>
                    <h3 class="text-center pagetitle" id="pageTitle">Log In</h3>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-12">

                    <div class="wrapper fadeInDown" id="loginForm">
                        <div class="formContent">

                            <div class="input-spacer"></div>

                            <!-- Login Form -->
                            <form action="${pageContext.request.contextPath}/j_spring_security_check" method='POST'>
                                <input type="text" class="fadeIn first" name="username" placeholder="Username">
                                <input type="password" class="fadeIn second" name="password" placeholder="Password">
                                <input type="submit" class="fadeIn third" value="Log In">
                            </form>

                            <c:if test="${param.error == true}">
                                <p class="text-danger">Incorrect username or password.</p>
                            </c:if>

                            <div class="formFooter">
                                <a class="underlineHover" onclick="displayRegister()">Sign Up</a>
                            </div>

                        </div>
                    </div>

                    <div class="wrapper fadeInDown" id="registerForm">
                        <div class="formContent">

                            <div class="input-spacer"></div>

                            <!-- Register Form -->
                            <form:form name="registrationForm" action="addUser" method="post" modelAttribute="user">

                                <form:input type="text" path="username" class="fadeIn first" name="username" placeholder="Username" />
                                <form:input type="password" path="password" class="fadeIn second" name="password" placeholder="Password" />
                                <form:button type="submit" class="fadeIn third">Sign Up</form:button>

                                <c:if test="${param.succ == '1'}">
                                    <p class="text-success">Success. You can log in now.</p>
                                </c:if>

                                <c:if test="${param.succ == '0'}">
                                    <p class="text-danger">User already exists. Choose different username.</p>
                                </c:if>

                                <div class="formFooter">
                                    <a class="underlineHover" onclick="displayLogin()">Log In</a>
                                </div>

                            </form:form>

                        </div>
                    </div>
                </div>
            </div>

        </div>
        <div class="col-sm-3"></div>
    </div>
</div>

<script type="text/javascript" src="<c:url value="/resources/static/js/loginForm.js" />"> </script>

</body>
</html>
