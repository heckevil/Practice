<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/write" method="post" accept-charset="utf-8">
		<div>
			제목 : <input type="text" name="title">
		</div>
		<div>
			본문 : <textarea type="text" name="ctnt" cols="10" rows="10"></textarea>
		</div>
		<input type="submit" value="글작성">
	</form>


</body>
</html>