<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가문원 관리</title>
</head>
<body>
	<div>
		<h1>가문원 목록</h1>
	</div>
	<div>가문원 추가</div>
	<form action="/houselist" method="post">
		<input type="text" name="nm" placeholder="이름">
		 <select name="hno">
		 	<option value="2">Paladin</option>
		 	<option value="1">명화적</option>
		 	<option value="3">Silence</option>
		 </select>
			<select name ="idep">
				<option value="4">가문원</option>
				<option value="1">가문장</option>
				<option value="2">부가문장</option>
				<option value="3">간부</option>

			 </select>
			<input type="submit" value="추가">
	</form>
	<a href="/houseparty"><button>초기화면</button></a>
	<table>
		<tr>
			<th>이름</th>
			<th>가문명</th>
			<th>직급</th>
		</tr>
		<c:forEach var="all_list" items="${all_list}">
			<tr>
				<td>${all_list.nm }</td>
				<td>${all_list.hnm }</td>
				<td>${all_list.dpname }</td>
			</tr>
		</c:forEach>
	</table>
	<%-- <select>
		<option selected>길드원</option>
		<c:forEach var="all_list" items="${all_list }">
				<option>${all_list.nm }</option>
		</c:forEach>
	</select> --%>
</body>
</html>