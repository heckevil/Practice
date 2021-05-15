<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c' %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>House name</title>
<style>
table {
	border: 1px soild black;
}
</style>
</head>
<body>
	<div style="height: auto; width: 100%; border: 1px solid black;">
		<h2>To day :</h2>
		<form action="houseparty" method="post">
			<input type="text" placeholder="아이디 입력" name="uid"> <input type="submit"
				value="추가">
		</form>
		<a href="/houselist"><button>가문원 관리</button></a>
	</div>
	
	<c:forEach var="td_player" items="${td_list}">
	</c:forEach>
	
	<!-- <table>
		<tr>
			<th>파티장</th>
			<th>I번파티</th>
			<th>이름</th>
			<th>직책</th>
		</tr>
		<tr>
			<td>~~~</td>
			<td>z번</td>
			<td>홍준호</td>
			<td>상사</td>
		</tr> -->

	</table>
</body>

</html>