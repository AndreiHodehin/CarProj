<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 13.08.2022
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Car page
    </title>
</head>
<body>
<br/>
<h1 align="center"> Add car to database </h1>
<br/>
<h2 align="center">Enter the form</h2>

<jstl:if test="${not empty badInput}">
    <h3 align="center">${badInput}</h3>
</jstl:if>

<form align="center" method="post" action="controller?action=addCar">
    <p align="center">Mark of the car</p>
    <p><input type="text" name="name" size="10" ></p>
    <p align="center">Price per month</p>
    <p><input type="text" name="price" size="10" /></p>
    <p><input type="submit" value="Add" /></p>
</form>
<p align="center"> <button><a href="main.jsp">Back</a></button></p>
</body>
</html>
