<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 14/10/2022
  Time: 4:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/result">
  <h1>Calculated</h1>
  <table>
    <tr>
      <input type="number" name="numberOne" placeholder="Enter number one">
      <input type="number" name="numberTwo" placeholder="Enter number two">
    </tr>
    <br>
    <tr>
      <input type="submit" value="Addition(+)" name="calculation">
      <input type="submit" value="Subtraction(-) " name="calculation">
      <input type="submit" value="Multiplication(*)" name="calculation">
      <input type="submit" value="Division(/)" name="calculation">
    </tr>
  </table>
</form>
<p>Result: ${result}</p>
</body>
</html>
