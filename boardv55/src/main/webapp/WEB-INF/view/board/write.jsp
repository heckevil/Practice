<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>
	<div>글 작성</div>

	<form action="write" method="post">
		<div>
			제목 : <input type="text" name="title">
		</div>
		<div>
			내용 :
			<textarea type="text" name="ctnt"></textarea>
		</div>
		<input type="submit" value="작성">
	</form>
</body>
</html>