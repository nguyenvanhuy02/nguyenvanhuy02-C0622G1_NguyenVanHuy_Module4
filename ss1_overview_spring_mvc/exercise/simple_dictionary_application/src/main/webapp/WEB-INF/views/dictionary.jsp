<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 13/10/2022
  Time: 3:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Vietnamese Dictionary</h2>
<form action="/result" method="post">
  <input type="text" name="english" placeholder="Enter your word: "/>
  <input type = "submit" id = "submit" value = "Search"/>
</form>
<p>${result}</p>
</body>
</html>
