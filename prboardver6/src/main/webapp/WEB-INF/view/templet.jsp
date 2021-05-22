<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${requestScope.title }</title>
<!-- title로 set한걸 쓸꺼임 -->
</head>
<body>
	<header>
		<ul>
			<li>메뉴1</li>
			<li>메뉴2</li>
			<li>메뉴3</li>
		</ul>
		
	</header>
	<section>
		<jsp:include page="/WEB-INF/view/${requestScoep.page }.jsp"></jsp:include>
		<!-- jsp:include page = "" 안에 있는 get된 페이지를 바꾸어가면서 뿌린다 -->
	</section>
</body>
</html>