<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${reqeustScope.title }</title>
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
	<!-- 다른 jsp파일을 이 jsp파일에 불러와서 뿌리는 명려어 -->
		<jsp:include page="/WEB-INF/view/${requestScope.page }.jsp"></jsp:include>
	</section>
</body>
</html>