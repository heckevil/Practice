<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트</title>
</head>
<body>
	<div>
		<h1>글리스트</h1>
	</div>
	<div>
		<h3>로그인성공</h3>
	</div>
	<div><h2>${loginuser.nm }님 ${loginuser.id}으로 로그인 하셨습니다.</h2></div>
	<table>
		<tr>
			<th>no.</th>
			<th>작성자</th>
			<th>title</th>
			<th>날짜</th>
		</tr>
		<c:forEach var="list" items="${list }">
			<tr onclick="moveTodetail(${list.iboard})">
				<td>${list.iboard }</td>
				<td>${list.nm }</td>
				<td>${list.title }</td>
				<td>${list.regdt }</td>
			</tr>
		</c:forEach>
	</table>
	<a href="write"><button>글쓰기</button></a>
	<a href="logout"><button>로그아웃</button></a>
</body>
<script>
function moveTodetail(iboard){
	location.href='detail?no='+iboard;
	
}
</script>
</html>