<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>
<div>
	<h1>글리스트</h1>
</div>
<div>
	<form action="list" method="get">
		<div>
			<input type="search" name="search"> 
			<input type="submit" value="검색">
		</div>

	</form>
</div>
<table>
	<tr>
		<th>no.</th>
		<th>작성자</th>
		<th>title</th>
		<th>날짜</th>
	</tr>
	<c:forEach var="list" items="${list }">
		<tr class="record" onclick="moveTodetail(${list.iboard})">
			<td>${list.iboard }</td>
			<td>${list.nm }</td>
			<td>${list.title }</td>
			<td>${list.regdt }</td>
		</tr>
	</c:forEach>
</table>
<div>
	<c:forEach begin="1" end="${requestScope.totalPage }" var="cnt">
		<a href="list?page=${cnt }&search=${param.search}"><span>${cnt }</span></a>
	</c:forEach>
</div>
<a href="write"><button>글쓰기</button></a>
<a href="logout"><button>로그아웃</button></a>
