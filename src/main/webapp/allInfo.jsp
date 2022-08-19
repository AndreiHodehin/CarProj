<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 17.08.2022
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>get all Info</title>
</head>
<body>
<h3 align="center">All information about rented cars</h3>

    <jstl:if test="${not empty sessionScope.allInfo}">
        <table align="center">
            <tr>
                <th>Clients Id</th>
                <th>Clients name</th>
                <th>Car id</th>
                <th>Mark auto</th>
                <th>Price auto</th>
                <th>in Rent</th>
            </tr>

            <jstl:forEach items="${sessionScope.allInfo}" var="all">
                <tr>
                    <td><jstl:out value="${all.user.id}"/></td>
                    <td><jstl:out value="${all.user.name}"/></td>
                    <td><jstl:out value="${all.car.id}"/></td>
                    <td><jstl:out value="${all.car.name}"/></td>
                    <td><jstl:out value="${all.car.price}"/></td>
                    <td><jstl:out value="${all.car.rented}"/></td>
                </tr>

            </jstl:forEach>

        </table>
    </jstl:if>
<jstl:if test="${empty sessionScope.allInfo}">
    <h3 align="center">There aro no any car in rent</h3>
</jstl:if>
<h3 align="center">Stop rented car for one of the user</h3>
<form align="center" method="post" action="controller?action=adminStopRent">

    <p><label>User id for stop rent
        <br>
        <input type="number" name="userId">
    </label></p>

    <p><label>Car for stop rent:
        <br>
        <input type="number" name="carId" />
    </label></p>
    <p><input type="submit" value="Stop rent"></p>

</form>

<p align="center"><button><a href="main.jsp">Back</a> </button></p>
</body>
</html>
