<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>디테일</title>
</head>
<body>

	<div>No.${vo.iboard} ${vo.nm } ${vo.regdt}</div>

	<div>
		제목 : ${vo.title }
	</div>
	<div>
		내용  :	${vo.ctnt }
	</div>
	<a href="list"><button>목록으로</button></a>
	<c:if test="${loginuser.iuser == vo.iuser }">
		<a href="mod?no=${param.no}"><button>수정</button></a>
		<a href="del?no=${param.no}"><button>삭제</button></a>
	</c:if>
</body>
</html>