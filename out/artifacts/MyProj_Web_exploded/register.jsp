<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 13.08.2022
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<jstl:if test="${not empty requestScope.notAdd}">
    <p>This user is exists</p>
</jstl:if>

<form method="post" action="controller?action=register">
    <br/>
    <br/>
    <h2 align="center">Registration page</h2>
    <br/>
    <p align="center">Enter name</p>
    <p align="center"><input type="text" name="name" size="10"/></p>
    <p align="center">Enter password</p>
    <p align="center"><input type="password" name="password" size="10" /></p>
    <p align="center">
        <select size="3" name="admin">
            <option value = "true">Admin</option>
            <option value = "false">User</option>
        </select>
    </p>
    <p align="center"><input type="submit" value="Register" /></p>


</form>


</body>
</html>
