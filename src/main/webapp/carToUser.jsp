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
<h2>Your credential</h2>

<p>Your id: ${sessionScope.user.id}</p>
    <p>Your name: ${sessionScope.user.name}</p>



<h1> You can choose your car</h1>
<table >
    <tr>
        <th>№</th>
        <th>Mark</th>
        <th>Price</th>

    </tr>

    <jstl:forEach items="${requestScope.allCars}" var="car">
        <tr>

            <td><jstl:out value="${car.id}"/></td>
            <td><jstl:out value="${car.name}"/></td>
            <td><jstl:out value="${car.price}"/></td>

        </tr>
    </jstl:forEach>
</table>
<form method="post" action="controller?action=carToUser">
<p><input type="text" name="CarId" />CarId</p>
<p><input type="submit" value="add" />add car to user</p>
</form>

</body>
</html>
