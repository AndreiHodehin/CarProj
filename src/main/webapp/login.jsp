<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 13.08.2022
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
<jstl:if test="${not empty requestScope.notExists}">
    <p>Tis user not exist</p>
</jstl:if>


<h2>Enter your credentials</h2>
<form action="controller?action=login" method="post">
    <p>Login: </p>
    <input type="text" name="name"/>
    <br/>
    <br/>
    <p>Password: </p>
    <input type="password" name="password">
    <br/>
    <input type="submit" value="Login">
</form>

</body>
</html>
