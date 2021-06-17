<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021-06-15
  Time: 오전 9:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/user/join" method="post">
    <input type="text" name="uid" placeholder="아이디">
    <input type="text" name="upw" placeholder="비밀번호">
    <input type="text" name="nm" placeholder="이름">
    <input type="submit" value="회원가입">
</form>

</body>
</html>
