<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User Manager</title>
</head>
<body>
<div align="center">
    <h1>User manager</h1>
    <h3><a href="/products">Add User</a></h3>
    <table border="1" padding="5">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Age</th>
            <th>Email</th>
            <th>Create</th>
        </tr>
        <c:forEach var="product" items="${}">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td>${user.email}</td>
                <td>${user.createdDate}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
