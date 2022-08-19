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
<h2 align="center">Your credential</h2>

<p align="center">Your id: ${sessionScope.user.id}</p>
    <p align="center">Your name: ${sessionScope.user.name}</p>



<h1 align="center"> Choose your car!!!</h1>


<h3 align="center">Available cars in garage</h3>

<jstl:if test="${not empty notAdd}">
    <h3 align="center">${notAdd}</h3>
</jstl:if>


<table align="center" >
    <tr>
        <th>№</th>
        <th>Mark</th>
        <th>Price</th>

    </tr>

    <jstl:forEach items="${sessionScope.allCars}" var="cars">
        <jstl:if test="${cars.rented == false}">
        <tr>
            <td><jstl:out value="${cars.id}"/></td>
            <td><jstl:out value="${cars.name}"/></td>
            <td><jstl:out value="${cars.price}"/></td>
        </tr>
        </jstl:if>

    </jstl:forEach>
</table>


<form align="center" method="post" action="controller?action=carToUser">
<p><label>Select car witch you like and insert carId:
    <br>
    <input type="text" name="CarId" />
</label></p>
<p><input type="submit" value="add" /></p>
</form>
<br>

<h3 align="center">Rented car</h3>
<table align="center" >
    <tr>
        <th>Id</th>
        <th>Mark</th>
        <th>Price</th>

    </tr>

    <jstl:forEach items="${sessionScope.clientCars}" var="carList">

        <tr>
            <td><jstl:out value="${carList.car.id}"/></td>
            <td><jstl:out value="${carList.car.name}"/></td>
            <td><jstl:out value="${carList.car.price}"/></td>

        </tr>

    </jstl:forEach>
</table>

<jstl:if test="${not empty notDeleted}">
    <h3 align="center">${notDeleted}</h3>
</jstl:if>

<h3 align="center">Stop renting car</h3>
<form align="center" method="post" action="controller?action=cancelRent">
    <p><input type="text" name="carId"/></p>
    <p><input type="submit" value="stop rent"></p>
</form>

<p align="center"> <button><a href="main.jsp">Back</a></button></p>
</body>
</html>
