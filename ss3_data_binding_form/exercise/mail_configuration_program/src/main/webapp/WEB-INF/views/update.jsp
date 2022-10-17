<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 17/10/2022
  Time: 3:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3 style="color:green;"> ${message}</h3>
<table>
    <tr>
        <td>Languages:</td>
        <td>${updateEmail.languages}</td>
    </tr>
    <tr>
        <td>Page Size:</td>
        <td>${updateEmail.pageSize}</td>
    </tr>
    <tr>
        <td>Spams filter:</td>
        <td>${updateEmail.spamsFilter}</td>
    </tr>
    <tr>
        <td>Signature:</td>
        <td>${updateEmail.signature}</td>
    </tr>
</table>
<a href="/settings">Back list</a>
</body>
</html>
