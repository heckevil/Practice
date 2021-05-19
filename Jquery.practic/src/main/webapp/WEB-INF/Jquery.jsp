<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Jquery!!</h1>
<div>jquery란 </div>
<ol>
	<li>html엘리먼트들을 선택하고 컨트롤 하기위한 JS</il>
	<li>그걸 간단한고 편하게 축약하고 사용할수 있는 라이브러리</li>
</ol>

<h3>기본 문법</h3>
 <div> 1 . $('제어대상').method1().method2() </div>
 제어 대상이 id값이라면 #ID 클래스 명이랑면 .class명 으로 넣어준다.
 jquery는 체인이 가능함으로 계속해서 매소드를 붙여서 연속해서 실행이 가능함.
 
 <h3>이벤트</h3>
$(selector).bind(eventName,function(event){})  
$(selector).unbind(eventName,function(event){}) 정확히 입력해야 바인드가 풀린다.

<div><input id="click_me" type="button" value="click_me"></div>
<div><input id="remove_event" type="button" value="unbind"></div>
<div><input id="trigger_event" type="button" value="trigger"></div>


<div class="welcome"></div>

<span id="id">$('제어대상').</span> <span id="method">method1().method2()</span>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
$('.welcome').html('hellow world!').css('background-color','yellow')
$('#id').css('background-color','red')
$('#method').css('background-color','orange')


 function clickHandler(e){
                alert('thank you');
            }

$(document).ready(function(){
		$('#click_me').click(clickHandler);
		$('#remove_event').click(function(e){
			$('#click_me').unbind('click',clickHandler);
		});
		$('#trigger_event').click(function(e){
			$('#click_me').bind('click',clickHandler);
		});
	
})

</script>
</body>
</html>