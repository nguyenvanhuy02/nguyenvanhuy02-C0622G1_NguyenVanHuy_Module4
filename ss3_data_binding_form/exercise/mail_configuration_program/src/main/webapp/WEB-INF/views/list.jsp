
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 17/10/2022
  Time: 1:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Settings</title>
</head>
<body>
<h3>Settings</h3>
<form:form method="post" action="/update" modelAttribute="email">
    <table>
        <tr>
            <td><form:label path="Languages">Languages: </form:label></td>
            <td>
                <form:select path="languages">
                    <form:options items="${languageList}"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <td><form:label path="pageSize">Page Size: </form:label></td>
            <td>
                <span>Show</span>
                <form:select path="pageSize">
                    <form:options items="${pageSizeList}"/>
                </form:select>
                <span>emails per page</span>
            </td>
        </tr>
        <tr>
            <td><form:label path="spamsFilter">Spams filter: </form:label></td>
            <td><form:checkboxes path="spamsFilter" items="${spamsFilterList}"/></td>
        </tr>
        <tr>
            <td><form:label path="signature">Signature: </form:label></td>
            <td><form:textarea path="signature"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Update"/></td>
            <td><input type="reset" value="Cancel"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>

