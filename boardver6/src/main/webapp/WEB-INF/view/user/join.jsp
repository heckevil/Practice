<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<form id="frm">
	<div>
		<input type="text" name="uid" placeholder="아이디">
	</div>
	<div>
		<input type="password" name="upw" placeholder="비밀번호">

	</div>
	<div>
		<input type="text" name="unm" placeholder="이름">


	</div>
	<div>
		성별 : <label>여성<input type="radio" name="gender" value="0"
			checked></label> <label>남성<input type="radio" name="gender"
			value="1"></label>

	</div>
	<div>
		<input type="button" value="화원가입" onclick="join();"> <a
			href="user/login"><button>초기화면</button></a>
	</div>
</form>
<script>
	function join() {
		var frmElem = document.querySelector('#frm');
		var uid = frmElem.uid.value;
		var upw = frmElem.upw.value;
		var unm = frmElem.unm.value;
		var gender = frmElem.gender.value;


		/* 서버로 전송하는 코딩 JSON 방식*/
		/* 자바에서의 객체만들기 */
		var param ={
				uid : uid,
				upw : upw,
				unm : unm,
				gender : gender
		}
		/* var param2 = { uid, upw, unm, gender }; 멤버필드명 변수명이 값을때 축약해서 쓸수있음 
		   var param2 = { uid, upw, 'ddd':unm, gender }; 중간에 하나 다를때,
		*/
		console.log(param);
			/* 데이터 추출 담당 */
		   ajax(param);
	}
	
	function ajax(param){
		/* 데이터 통신 담당  */
		
		const init = {
				method:'POST',
				body: new URLSearchParams(param)
				/* headers:{
					'Content-Type':'application/json',
				},
				//body: JSON.stringify(param),
				 */
			}
		
		fetch('/user/join',init)
		.then(function(res) { return res.json(); })	
		.then(function(myJson){
			console.log(myJson);
			switch(myJson.result){
			case 0:
				alert('회원가입 실패');
				break;
			case 1:
				location.href='/user/login';
				break;
			}
		});
	}
		
</script>