<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<div>
		<form action="login" method="post">
			<div>
				<input type="text" name="uid" placeholder="아이디"></input>
			</div>
			<div>
				<input type="password" name="upw" placeholder="비밀번호"></input>
			</div>
			<div>
				<input type="submit" value="Login">u
			</div>
		</form>
	</div>
	<div>
		<a href="join">회원가입</a> <!-- /를 빼서 넣어줌 /넣을시 user 가 사라짐  -->
	</div>
</body>
</html>