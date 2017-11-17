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
                Registration
            </h1>
        </div>
        <div>
            <c:if test="${not empty user_already_exist}">
                <span class="error">This email has already used</span><br>
                </c:if>
            <p>
                <label for="email">E-mail</label>
                <input type="email" name="email" id="email" required placeholder="E-mail">
            </p>
        </div>
        <div>
            <p>
                <label for="password">Password</label>
                <input type="password" name="password" id="password" required placeholder="Your password"/>
            </p>
        </div>

        <div>
            <c:if test="${not empty passwords_not_equal}">
                <span class="error">Passwords don't equal</span><br>
            </c:if>
            <p>
                <label for="repeat">Repeat</label>
                <input type="password" id="repeat" name="repeat" required placeholder="Your password"/>
            </p>
        </div>

        <div>
            <p>
                <label for="name">Username</label>
                <input type="text" id="name" name="name" required placeholder="Username">
            </p>
        </div>

        <div>
            <p>
                <label for="selectCountry">Country</label>
                <select id="selectCountry" name="selectCountry">

                    <option value=Russia>Russia</option>

                    <option value=USA>USA</option>

                    <option value=Canada>Canada</option>

                </select>
            </p>
        </div>

        <div>
            <p>
                <label>
                    <input type="radio" name="gender" value="Men" required>Men
                </label>
                <label>
                    <input type="radio" name="gender" value="Women" required>Women
                </label>
            </p>
        </div>

        <div>
            <p>
                <label for="subscribe">Subscribe</label>
                <input type="checkbox" id="subscribe" name="subscribe" value="checked">
            </p>
        </div>

        <button type="submit" name="submit">Sign up</button>
    </form>
</div>
</body>
</html>
