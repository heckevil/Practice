<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021-06-15
  Time: 오전 9:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div><h2>로그인</h2></div>
<h3>${errMsg}</h3>
<form action="/user/login" method="post">
    <div><input type="text" name="uid" placeholder="아이디"></div>
    <div><input type="text" name="upw" placeholder="비밀번호"></div>
    <input type="submit" value="로그인">
</form>
<a href="/user/join">
    <button>회원가입</button>
</a>
</body>
</html>
