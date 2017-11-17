<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User table</title>
    <link rel="stylesheet" href="<c:url value="/css/styles.css"/>">
</head>
<body>
<div>
    <div id="content">
        <table>
            <tr>
                <th>Email</th>
                <th>Name</th>
                <th>Country</th>
                <th>Gender</th>
                <th>Subscribe</th>
            </tr>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.email}</td>
                    <td>${user.name}</td>
                    <td>${user.country}</td>
                    <td>${user.gender}</td>
                    <td>${user.subscribe}</td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <div id="container">
        <form method="post">
            <div>
                <h4>Choose sorting method</h4>
                <div>
                    <label for="sorting_type">Select sorting type</label>
                    <select id="sorting_type" name="sorting_type">
                        <c:choose>
                            <c:when test="${default_sorting_type eq 'name'}">
                                <option selected value=name>By name</option>

                                <option value=country>By country</option>

                                <option value=gender>By gender</option>

                                <option value=email>By email</option>
                            </c:when>
                            <c:when test="${default_sorting_type eq 'email'}">
                                <option value=name >By name</option>

                                <option value=country>By country</option>

                                <option value=gender>By gender</option>

                                <option selected value=email>By email</option>
                            </c:when>
                            <c:when test="${default_sorting_type eq 'country'}">
                                <option value=name >By name</option>

                                <option selected value=country>By country</option>

                                <option value=gender>By gender</option>

                                <option value=email>By email</option>
                            </c:when>
                            <c:when test="${default_sorting_type eq 'gender'}">
                                <option value=name >By name</option>

                                <option value=country>By country</option>

                                <option selected value=gender>By gender</option>

                                <option value=email>By email</option>
                            </c:when>
                            <c:otherwise>
                                <option value=name >By name</option>

                                <option value=country>By country</option>

                                <option value=gender>By gender</option>

                                <option value=email>By email</option>
                            </c:otherwise>
                        </c:choose>
                    </select>
                </div>
            </div>
            <p>
                <button type="submit" name="submit">Sort</button>
            </p>
        </form>
    </div>
</div>
</body>
</html>
