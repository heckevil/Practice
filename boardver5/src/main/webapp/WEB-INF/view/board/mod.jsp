<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="mod" method="post">
	<input type="hidden" value="${param.no }" name="no">	
	<div>
		 	제목 : <input type="text" name="title" value="${vo.title}">
		</div>
		<div>
			내용 : <textarea name="ctnt" >${vo.ctnt}</textarea>
		</div>
		<div>
			<input type="submit" value="글쓰기"> <input type="reset"
				value="초기화">
		</div>
	</form>
</body>
</html>