<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>

	<div>No.${vo.iboard} ${vo.nm } ${vo.regdt}</div>

	<div>제목 : ${vo.title }</div>
	<div>내용 : ${vo.ctnt }</div>
	<a href="list"><button>목록으로</button></a>
	<c:if test="${loginuser.iuser == vo.iuser }">
		<a href="mod?no=${param.no}"><button>수정</button></a>
		<a href="del?no=${param.no}"><button>삭제</button></a>
	</c:if>
	<div>
		<form action="regcmt" method="post">
			<input type="hidden" name="iboard" value="${vo.iboard }">
			<div>
				<textarea name="cmt" placeholder="댓글내용"></textarea>
				<input type="submit" value="댓글작성">
			</div>
		</form>
	</div>
	<div>
		<table>
			<tr>
				<th>내용</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>비고</th>
			</tr>
			<c:forEach var="cmt" items="${cmt }">
				<tr>
					<td>${cmt.cmt }</td>
					<td>${cmt.nm }</td>
					<td>${cmt.regdt}</td>
					<td>${loginuser.iuser }</td>
					<td>${cmt.iuser }</td>
					<td><c:if test="${loginuser.iuser == cmt.iuser }">
							<button onclick='delCmt(${vo.iboard},${cmt.icmt })'>삭제</button>
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
