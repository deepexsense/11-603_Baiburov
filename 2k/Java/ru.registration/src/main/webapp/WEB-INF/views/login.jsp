<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Registration form</title>
    <link rel="stylesheet" href="<c:url value="/css/main_style.css"/>">
</head>
<body>
<div id="container">
    <form method="post">
        <div>
            <h1>
                Authentication
            </h1>
        </div>
        <div>
            <p>
                <label for="email">E-mail</label>
                <input type="email" name="email" id="email" required placeholder="E-mail">
            </p>
        </div>
        <div>
            <p>
                <label for="password">Password</label>
                <input type="password" name="password" id="password" required placeholder="Password"/>
            </p>
        </div>

        <div>
            <p>
                <label for="remember">Remember me</label>
                <input type="checkbox" id="remember" name="remember" value="checked">
            </p>
        </div>

        <button type="submit" name="login">Login</button>
        <button type="submit" name="registration">Sign up</button>
    </form>
</div>
</body>
</html>
