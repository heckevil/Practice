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
	function join(){
		var FrmElem = document.queryselector('#Frm');
		var uid = FrmElem.uid.value;
		var upw = FrmElem.upw.value;
		var unm = FrmElem.unm.value;
		var gender = FrmElem.gender.value;
		
		var param = {uid, upw, unm, gender};
		
		ajax(param);
		
	}
	
	function ajax(param){
		
		const inite = {
				method : 'POST',
				body : new URlSearchParams(param)
				
		}
		
		fetch('/user/join',param){
			.then(function(res) {return res.Json();})
			.then(function(myJson){
				switch(myJson){
				case 1: 
					location.href='/user/login';
					break;
				case 0:
					arlet('회원가입을 할 수 없습니다.');
					break;
				}
				
			});
		}
		
	}
		
</script>