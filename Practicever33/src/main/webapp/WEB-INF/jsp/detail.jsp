<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>디테일</title>
</head>
<body>
	<div>
		제목 : ${vo.title }
	</div>
	<div>
		내용 : ${vo.ctnt }
	</div>
	<a href="/list">목록으로</a>
	<a href="/mod?no=${vo.iboard }">수정</a>
	<a href="/del?no=${vo.iboard }">삭제</a>
</body>
</html>