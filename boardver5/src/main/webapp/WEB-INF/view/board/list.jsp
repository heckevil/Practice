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
	<div>로그인성공</div>
	<div>${LoginUser.unm}님 ${LoginUser.uid } 환영합니다</div>
	 <!--  Session으로 set해줬기 때문에 브라우저가 닫히지 않는한 남아있다. ->get으로 가져올수 있음.  -->
	 <a href="/user/logout">Logout</a>
	 
	 <div>
	 	<a href="write">글쓰기</a>
	 </div>
	 <div>
	 	<table>
	 		<tr>
	 			<th>no</th>
	 			<th>title</th>
	 			<th>글쓴이</th>
	 			<th>time</th>
	 		</tr>
	 		
	 		<c:forEach var="list" items="${list }">
	 			<tr onclick="moveToDetail(${list.iboard})">
	 				 <td>${list.iboard }</td>
	 				 <td>${list.title }</td>
	 				 <td>${list.unm }</td>
	 				 <td>${list.regdt }</td>
	 			</tr>
	 		</c:forEach>
	 		
	 	
	 	</table>
	 	
	 </div>
	 <script>
	 	function moveToDetail(iboard){
	 		location.href='/board/detail?no='+iboard;
	 	}
	 </script>
</body>
</html>