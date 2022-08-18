<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 18.08.2022
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All cars</title>
</head>
<body>

<h2 align="center">List of cars in database</h2>

<jstl:if test="${not empty requestScope.allCars}">

    <table align="center" border="1" >

        <tr>
            <th>Id</th>
            <th>Mark</th>
            <th>Price</th>
            <th>In rent</th>
        </tr>
        <jstl:forEach items="${requestScope.allCars}" var="cars">

            <tr>
            <td><jstl:out value="${cars.id}"/></td>
            <td><jstl:out value="${cars.name}"/></td>
            <td><jstl:out value="${cars.price}"/></td>
            <td><jstl:out value="${cars.rented}"/></td>
            </tr>
        </jstl:forEach>
    </table>

    <jstl:if test="${not requestScope.notDeleted}">
        <h4 align="center">${notDeleted}</h4>
    </jstl:if>

    <form align="center" method="post" action="controller?action=allCars" >
        <p><label>Enter car id for deleting
        <br>
            <input type="text" name="carId">
        </label></p>
        <input type="submit" value="Delete">
    </form>
</jstl:if>

<jstl:if test="${empty requestScope.allCars}">
    <h3 align="center">There are no cars in database</h3>
</jstl:if>

<p align="center"><button><a href="main.jsp">Back</a> </button></p>
</body>
</html>
