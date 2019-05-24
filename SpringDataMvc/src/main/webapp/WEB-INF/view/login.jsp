<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Login page</title>
</head>
<body>
<div align="center">
    <h2>Login pls:</h2>
    <form:form action="login" method="post" modelAttribute="user">
        <table border="0" cellpadding="5">
            <tr>
                <td>User name</td>
                <td><form:input path="username"/></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><form:input path="password"/></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Login"/></td>
            </tr>
        </table>
    </form:form>

</div>
</body>
</html>
