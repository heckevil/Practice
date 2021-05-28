<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>
<link rel="stylesheet" href="/res/css/userMypage.css">
<div>
	<c:choose>
		<c:when test="${empty sessionScope.loginUser.profileImg}">
			<c:set var="img" value="/res/img/noprofile.jpg">
			</c:set>
		</c:when>
		<c:otherwise>
			<c:set var="img"
				value="/res/img/user/${sessionScope.loginUser.iuser }/${sessionScope.loginUser.profileImg }" />
		</c:otherwise>
	</c:choose>
</div>

<div>
	<form id="Frm" action="" method="post" enctype="multipart/form-data"
		onsubmit="return imgChk();">
		이미지 변경 : <input type="file" name="profileImg" accept="image/*">
		<input type="submit" value="이미지 업로드">

	</form>
	<div>
		<img src="${img}">
	</div>
	<div>Pk : ${requestScope.user.iuser }</div>
	<div>ID : ${requestScope.user.id}</div>
	<div>Name : ${requestScope.user.nm }</div>
</div>

<script>
	var frmElem = document.querySelector('#Frm');
	function imgChk() {
		if(frmElem.profileImg.files.length === 0){
			alert('이미지를 선택해 주세요');
			return false;
		}

		return true;
	}
</script>
