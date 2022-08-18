<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 18.08.2022
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All User</title>
</head>
<body>
<br>
<h2 align="center">All Users in database</h2>

<jstl:if test="${not empty requestScope.allUsers}">
    <table align="center" border="2">
        <tr>
            <th>Id</th>
            <th>Name</th>
        </tr>
        <jstl:forEach items="${requestScope.allUsers}" var="user">
            <tr>
                <td><jstl:out value="${user.id}"/></td>
                <td><jstl:out value="${user.name}"/></td>
            </tr>
        </jstl:forEach>
    </table>

    <br>

    <h3 align="center">Delete user from database</h3>

    <jstl:if test="${not requestScope.notDeleted}">
        <h4 align="center">${notDeleted}</h4>
    </jstl:if>

    <form align="center" method="post" action="controller?action=allUsers">

        <p><label>Enter user id for deleting
            <br>
            <input type="text" name="userId">
        </label></p>
        <p><input type="submit" value="Delete"></p>

    </form>

</jstl:if>
<jstl:if test="${empty requestScope.allUsers}">
    <h3 align="center">There are no one user in database</h3>
</jstl:if>


<p align="center"><button><a href="main.jsp">Back</a> </button></p>
</body>
</html>
