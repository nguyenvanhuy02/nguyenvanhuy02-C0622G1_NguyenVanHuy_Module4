<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 14/10/2022
  Time: 2:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form action="/choiceSandwich" method="post">
    <table>
        <tr>
            <input type="checkbox" name="lettuce" value="Lettuce">Lettuce
            <input type="checkbox" name="tomato " value="tomato">Tomato
            <input type="checkbox" name="mustard" value="mustard">Mustard
            <input type="checkbox" name="sprouts" value="sprouts">Sprouts
        </tr>
        <pre>
            <input type="submit" value="Save">
        </pre>
    </table>
</form>
<p> Kết quả: ${lettuce},${tomato},${mustard},${sprouts}</p>
</body>
</html>
