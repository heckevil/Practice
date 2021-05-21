<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>


<div>
<h1>디테일 페이지</h1>
</div>
<div>
	글번호 : <span id="iboard"></span>
</div>
<div>
	제목 : <span id="title"></span>
</div>
<div>
	글쓴이 : <span id="unm"></span>
</div>
<div>
	작성일시 : <span id="regdt"></span>
</div>

<div>
	<span id="ctnt"></span>
</div>
<%-- 	<c:if test="${LoginUser.iuser == vo.iuser }">
	<div>
		<a href="del?no=${vo.iboard }">삭제</a>
		<a href="mod?no=${vo.iboard }">수정</a>
	</div>
	</c:if> --%>

<script>
	function ajax(iboard){
		console.log('iboard : '+iboard);
		const param = {iboard}
		const init = {
				method : 'POST',
				body new URLSearchParams(param)
	}
		fetch('/user/join',init)
		.then(function(res) { return res.json(); })	
		.then(function(myJson){
			console.log(myJson);
			
			setData(myJson);
			
			}
		});
		
	function setData(data){
		var idElem = document.querySelector('#iboard');
		iboardElem.innerText=data.iboard;
		
		var titleElem= document.quryselector('#title');
		titleElem.innerText=data.title;
		
		var ctntElem= document.quryselector('#ctnt');
		ctntElem.innerText=data.ctnt;
		
		var regdtElem= document.quryselector('#regdt');
		regdtElem.innerText=data.regdt;
		
		var unmElem= document.quryselector('#unm');
		unmElem.innerText=data.unm;
		
	}
	
	ajax(${param.iboard});
</script>