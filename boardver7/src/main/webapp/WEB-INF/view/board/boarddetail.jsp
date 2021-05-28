<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>
<link rel="stylesheet" href="/res/css/boardDetail.css">
<div>No.${data.iboard} | ${data.writerNm } | ${data.regdt}</div>

<div>
	<div>
		<a href="#" onclick="goBack();">돌아가기</a>
	</div>
	<h1>제목 : ${data.title }</h1>
</div>
<div>작성자 : ${data.writerNm }</div>
<div>글번호 : ${data.iboard }</div>
<div>내용 : ${data.ctnt }</div>
<div>
	<c:out value="${reqeustScope.data.ctnt}" />
</div>

<a href="list"><button>목록으로</button></a>

<c:if test="${not empty sessionScope.loginUser.iuser}">
	<div>
		<form id="cmtFrm" onsubmit="return false;">
			<!--dataset.iboard로 가져올수 있음 출력값 iboard:  ~  -->
			<input type="text" id="cmt"> 
			<input type="button" value="댓글달기" onclick="regCmt();">
		</form>

	</div>
</c:if>


<!-- 댓글 list.js 들어가는곳  -->
<div id="cmtList" data-login_user_pk="${sessionScope.loginUser.iuser}"
	data-iboard="${param.iboard}"></div>
	
	
<div id="modal" class="displayNone">
	<div class="modal_content">
		<form id="cmtModFrm" action="#">
			<input type="hidden" id="icmt">
			<input type="text" id="cmt">

		</form>
		<input type="button" value="댓글수정" onclick="modAjax();">
		<input type="button" value="취소" onclick="closeModModal();">
	</div>
</div>

<script src="/res/js/boardDetail.js">
	
</script>