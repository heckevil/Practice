<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail</title>
</head>
<body>
	<div></div><h1>디테일 페이지</h1></div>
	<div>글번호 : ${vo.iboard }</div>
	<div>제목 : ${vo.title }</div>
	<div>글쓴이 : ${vo.unm }</div>
	<div>작성일시 : ${vo.regdt }</div>
	
	<div>
		${vo.ctnt }
	</div>
	<c:if test="${LoginUser.iuser == vo.iuser }">
	<div>
		<a href="del?no=${vo.iboard }">삭제</a>
		<a href="mod?no=${vo.iboard }">수정</a>
	</div>
	</c:if>
</body>
</html>