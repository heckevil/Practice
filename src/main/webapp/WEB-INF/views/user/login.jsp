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
    <div><input type="password" name="upw" placeholder="비밀번호"></div>
    <input type="submit" value="로그인">
</form>
<a href="/user/join">
    <button>회원가입</button>
</a>
<a href="https://accounts.google.com/o/oauth2/v2/auth?scope=https%3A//www.googleapis.com/auth/drive.metadata.readonly&access_type=offline&include_granted_scopes=true&response_type=code&state=state_parameter_passthrough_value&redirect_uri=http%3A%2F%2Flocalhost%3A8888%2Fuser%2FreceiveCode&client_id=211451799850-2a0egv7o5d6utv4ajied1v2bdqfcppd3.apps.googleusercontent.com">구글
    로그인</a>

</body>
</html>
