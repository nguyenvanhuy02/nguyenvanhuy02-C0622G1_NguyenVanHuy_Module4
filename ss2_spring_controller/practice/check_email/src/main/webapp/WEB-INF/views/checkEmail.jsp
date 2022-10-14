<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 14/10/2022
  Time: 10:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Kiểm tra email đúng định dạng</h1>
<form action="validate" method="post">
    <input type="text" name="email"><br>
    <input type="submit" value="Validate">
</form>
<p> kết quả : ${email1.get("email")}</p>
</body>
</html>
