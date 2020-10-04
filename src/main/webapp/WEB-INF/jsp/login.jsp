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

    <title>Log In</title>

    <link href="<c:url value="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/static/css/style.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/static/css/bg2.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/static/css/loginform.css" />" rel="stylesheet">

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
                                <div class="rememberMe">
                                    <input type="checkbox" name="remember-me" id="cbx" style="display: none;">
                                    <label for="cbx" class="check">
                                        <svg width="18px" height="18px" viewBox="0 0 18 18">
                                            <path d="M1,9 L1,3.5 C1,2 2,1 3.5,1 L14.5,1 C16,1 17,2 17,3.5 L17,14.5 C17,16 16,17 14.5,17 L3.5,17 C2,17 1,16 1,14.5 L1,9 Z"></path>
                                            <polyline points="1 9 7 14 15 4"></polyline>
                                        </svg>
                                    </label>
                                    Remember Me
                                </div>
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
                            <form:form name="registrationForm" action="addUser" method="post" modelAttribute="user" onsubmit="return validateForm()">

                                <form:input type="text" path="username" class="fadeIn first" name="username" placeholder="Username" />
                                <form:input type="password" path="password" class="fadeIn second" name="password" placeholder="Password" />
                                <input type="password" class="fadeIn third" id="retyped_password" placeholder="Retype password" />
                                <form:button type="submit" class="fadeIn fourth">Sign Up</form:button>

                                <c:if test="${param.succ == '1'}">
                                    <p class="text-success">Success. You can log in now.</p>
                                </c:if>

                                <c:if test="${param.succ == '0'}">
                                    <p class="text-danger">User already exists. Choose different username.</p>
                                </c:if>

                                <p class="text-danger d-hidden" id="passwordError"></p>

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
