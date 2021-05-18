<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="join" method="post">
		<div>
			<input type="text" name="lgid" placeholder="아이디">
		</div>
		<div>
			<input type="password" name="lgpw" placeholder="비밀번호">

		</div>
		<div>
			<input type="text" name="lgnm" placeholder="이름">


		</div>
		<div>
			성별 : <label>여성<input type="radio" name="gender" value="0"
				checked></label> <label>남성<input type="radio" name="gender"
				value="1"></label>

		</div>
		<div>
			<input type="submit" value="회원가입">
			 <a href="user/login"><button>초기화면</button></a>
		</div>
	</form>
	
</body>
</html>