<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 15.08.2022
  Time: 18:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>CarToUser</title>
</head>
<body>
<p> you can choose your car</p>
<jstl:forEach items="${requestScope.allCars}" var="car">
    <br/>
    <p>Id mark : ${car.id}</p>
    <p>Mark auto : ${car.name}</p>
    <p>Price auto : ${car.price}</p></p>
</jstl:forEach>
<form method="post" action="controller?action=carToUser">
<p><input type="text" name="CarId" />CarId</p>
<p><input type="submit" value="add" />add car to user</p>
</form>
</body>
</html>
