<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016.4.28
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/login.do" method="post">
    <table>
        <tr>
            <td>username:</td>
            <td><input type="text" value="zbl" name="name"/></td>
        </tr>
        <tr>
            <td>password</td>
            <td><input type="text" value="1234" name="password"/></td>
        </tr>
        <input type="submit" value="登录"/>
    </table>
</form>
</body>
</html>
