<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
		<h1>로그인</h1>
	</div>
	<form action="login" method="post">
		<div>${errmsg }</div>
		<div>
			<input type="text" name="uid" placeholder="아이디">
		</div>
		<div>
			<input type="password" name="upw" placeholder="비밀번호">
		</div>
  			<input type="submit" value="로그인">
  			<button type="button" onclick="location.href='join'">회원가입</button>
	</form>
</body>
</html>