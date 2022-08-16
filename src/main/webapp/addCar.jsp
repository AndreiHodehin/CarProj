<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 13.08.2022
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Car page
    </title>
</head>
<body>
<form method="post" action="controller?action=addCar">
    <p><input type="text" name="name" size="10" ></p>
    <p><input type="text" name="price" size="10" /></p>
    <p><input type="submit" value="Add" /></p>

</form>
</body>
</html>
