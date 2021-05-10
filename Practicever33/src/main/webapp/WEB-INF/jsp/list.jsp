<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글목록</title>
</head>
<body>
	<div>
		<h1>글목록</h1>
	</div>
	<div>
		<table>
			<tr>
				<th>no</th>
				<th>title</th>

			</tr>


			<c:forEach var="list" items="${list }">
				<tr class = "record" onclick="moveToDetail(${list.iboard})">
					<td>${list.iboard }</td>
					<td>${list.title }</td>
				</tr>
			</c:forEach>
			<button onclick="location.href='/write'">글쓰기</button>

		</table>
	</div>
	<script>
		function moveToDetail(iboard){
			location.href="/detail?no="+iboard;
		}
	</script>
</body>
</html>