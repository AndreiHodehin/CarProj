<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 13.08.2022
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <jstl:choose>
            <jstl:when test="${not empty sessionScope.user}">

                <jstl:if test="${sessionScope.user.admin == true }">
                    <br/>
                    <h3 align="center">Welcome administrator ${sessionScope.user.name}</h3>
                    <p align="center">Click to add car to base</p>
                    <p align="center"><a href="addCar.jsp">addCar</a></p>
                    <p align="center">Show all rented car</p>
                    <p align="center"><a href="controller?action=getRentedCar">Show</a> </p>

                    <p align="center">Data of all cars in garage</p>
                    <p align="center"><a href="controller?action=allCars">Base Of Cars</a> </p>

                    <p align="center">Data of all Users</p>
                    <p align="center"><a href="controller?action=allUsers">Base Of Users</a> </p>

                    <p align="center">Go away</p>
                    <p align="center"><a href="controller?action=logOut">LogOut</a></p>
                </jstl:if>

                <jstl:if test="${sessionScope.user.admin == false}">
                <br/>
                <p align="center">Welcome user, ${sessionScope.user.name}</p>
                <p align="center"><a href="controller?action=carsSet">User page</a></p>
                <p align="center"><a href="controller?action=logOut">LogOut</a></p>
                </jstl:if>

            </jstl:when>
            <jstl:otherwise>
                <br/>
                <br/>
                <h2 align="center">Welcome to renting car agency</h2>
                <br/>

                <h4 align="center">Please login or register</h4>
                <p align="center"><a href="login.jsp"> Login</a> </p>
                <p align="center"><a href="register.jsp">Register</a> </p>


            </jstl:otherwise>

        </jstl:choose>


</body>
</html>
