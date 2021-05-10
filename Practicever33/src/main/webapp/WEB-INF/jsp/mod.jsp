<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글수정</title>
</head>
<body>
	<form action="/mod" method="post">
		<input type="hidden" value="${param.no }" name="no">
		<div>
			제목 : <input type="text" name="title" value="${vo.title }">
		</div>
		<div>
			내용 :
			<textarea type="text" name="ctnt" cols="10" rows="10">${vo.ctnt }</textarea>
		</div>
		<input type="submit" value="수정">
	</form>
</body>
</html>