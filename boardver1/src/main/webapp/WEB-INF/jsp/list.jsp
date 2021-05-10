<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 리스트</title>
<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}

.record {
	cursor: pointer;
}
</style>
</head>
<body>
	<div>
		<h1>글 리스트</h1>
	</div>
	<table>
		<tr>
			<th>No</th>
			<th>title</th>
		</tr>

		<c:forEach var="list" items="${list}">
			<tr class="record" onclick="moveTodetail(${list.iboard});">
				<td>${list.iboard}</td>
				<td>${list.title}</td>
				<td>${list.regdt}</td>
			</tr>
		</c:forEach>
		<a href="/write">글작성</a>
	</table>
	<script>
		function moveTodetail(iboard){
			location.href='/detail?no='+iboard;
			
		}
	
	</script>
</body>
</html>