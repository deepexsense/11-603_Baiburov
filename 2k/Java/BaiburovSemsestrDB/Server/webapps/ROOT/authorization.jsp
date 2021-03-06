<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="bootstrap-3.3.7/docs/favicon.ico">
    <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet">

    <title>Auth</title>

    <!-- Bootstrap core CSS -->
    <link href="bootstrap-3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body id="body">

<div class="container" style="margin-top: 11%">
    <form class="form-signin" action="/login" method="POST">
        <h1 align="center" class="form-signin-heading" style="font-family: 'sans-serif', cursive;">Sign in</h1>
        <label for="inputEmail" class="sr-only">Login</label>
        <input name="login" type="text" id="inputEmail" class="form-control" placeholder="Login" value="<% if (request.getAttribute("incorrect_password") != null) {%><%=request.getAttribute("login")%><%}%>" required autofocus maxlength="10">
        <label for="inputPassword" class="sr-only">Password</label>
        <input name="password" type="password" id="inputPassword" class="form-control" placeholder="Password" required maxlength="10">
        <div class="checkbox">
            <label>
                <input name="cookie" type="checkbox" value="true"> Remember me
            </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        <a class="btn btn-lg btn-primary btn-block" href="/registration" role="button">Sign up</a>
        <% if (request.getAttribute("user_not_find") != null) {%>
        <%=request.getAttribute("user_not_find")%>
        <%}%>
        <% if (request.getAttribute("incorrect_password") != null) {%>
        <%=request.getAttribute("incorrect_password")%>
        <%}%>
        <c:set var="guest1" value="${guest}" scope="request"/>
        <c:out value="${guest1}"/>
    </form>

</div> <!-- /container -->


<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
