<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<br>
<br>
<hr>
<c:set var="filmName" value="${filmName}" scope="request"/>
<H2>   You have bought this film!(<c:out value="${filmName}"/>)</H2>
        <a href="/home">Go home!</a>
<hr>