<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/write" method="post">
		<div>
			제목 : <input type="text" name="title">
		</div>
		<div>
			본문 : <input type="text" name="ctnt">
		</div>
		<div>
			<input type="submit" value="글쓰기">
		</div>
	</form>
</body>
</html>