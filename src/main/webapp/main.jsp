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
                    <p>${sessionScope.user.name}</p>
                    <p><a href="addCar.jsp">addCar</a></p>
                    <p><a href="controller?action=logOut">LogOut</a></p>
                </jstl:if>
                <jstl:if test="${sessionScope.user.admin == false}">
                <p>${sessionScope.user.name}</p>
                <p><a href="controller?action=carsSet">Add Car to User</a></p>
                <p><a href="controller?action=logOut">LogOut</a></p>
                </jstl:if>
            </jstl:when>
            <jstl:otherwise>
                <p><a href="register.jsp">Register</a> </p>
                <p><a href="login.jsp"> Login</a> </p>

            </jstl:otherwise>

        </jstl:choose>


</body>
</html>
