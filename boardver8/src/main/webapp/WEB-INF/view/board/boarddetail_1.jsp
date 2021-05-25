<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c' %>

<div>No.${data.iboard} | ${data.writerNm } | ${data.regdt}</div>

<div>
<div><a href="#" onclick="goBack();">돌아가기</a></div>
	<h1>제목 : ${data.title }</h1>
</div>
<div>작성자 : ${data.writerNm }</div>
<div>글번호 : ${data.iboard }</div>
<div>내용 : ${data.ctnt }</div>
<div><c:out value="${reqeustScope.data.ctnt}"/></div>

<a href="list"><button>목록으로</button></a>

<div>
	<form id="cmtFrm" data-iboard="${param.iboard}">
	<!--dataset.iboard로 가져올수 있음 출력값 iboard:  ~  -->
		<input type="text" id="cmt" >
		<input type="button" value="댓글달기" onclick="regCmt();">
	</form>

</div>
<div id="cmtList"></div>


<script src="/res/js/boardDetail.js"><</script>