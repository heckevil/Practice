<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>디테일</title>
</head>
<body>

		<div>
			제목 : ${list.title }
		</div>
		<div>
			본문 : ${list.ctnt }
		</div>
		<button onclick="location.href='/list'">목록으로</button>
</body>
</html>