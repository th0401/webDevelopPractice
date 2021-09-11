<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="error.jsp"
	import="model.member.MemberVO,model.post.*,java.util.ArrayList"%>
<%request.setCharacterEncoding("UTF-8");%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="myTags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="datas" class="java.util.ArrayList" scope="request" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인화면창</title>
<script type="text/javascript">
	function forbid() {
		alert('로그인 해야만 글을 쓸수 있습니다!');
	}
	function goPost(pnum) {
		document.location.href = "ctrl.jsp?action=post&bnum=" + pnum;
	}
</script>


</head>
<body>
	<h2>메인화면창</h2>
	<hr>
	<c:choose>
		<c:when test="${memberVO==null}">
			<myTags:login />
		</c:when>
		<c:when test="${memberVO!=null}">
			<h2>${memberVO.userID}님 안녕하세요!</h2>
			<myTags:logout />
		</c:when>
	</c:choose>
	<hr>
	<h2>게시판목록</h2>
	<br>
	<form action="ctrl.jsp?action=search" name="form1" method="post">
		<table>
			<tr>
				<td><select name="col">
						<option selected value="title">제목</option>
						<option value="userID">작성자</option>
				</select></td>
				<td><input type="text" name="word" placeholder="검색할 내용을 입력하세요"
					required></td>
				<td><input type="submit" value="검색하기"></td>
			</tr>
		</table>
	</form>


	<table>
		<thead>
			<tr>
				<th>글 번호</th>
				<th>글 제목</th>
				<th>작성자</th>
				<th>작성일자</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach var="v" items="${datas}">
				<tr>
					<td>${v.pnum}</td>
					<td><a href="ctrl.jsp?action=post&pnum=${v.pnum}">${v.title}</a></td>
					<td>${v.userID}</td>
					<th>${v.pdate}</th>
				</tr>
			</c:forEach>

		</tbody>
	</table>
	<c:choose>
		<c:when test="${memberVO==null}">
			<input type="button" value="글쓰기" onClick="forbid()">
		</c:when>

		<c:when test="${memberVO!=null}">
			<input type="button" value="글쓰기"
				onClick="location.href='insertPost.jsp'">
			<input type="button" value="내 글 보기"
				onClick="location.href='ctrl.jsp?action=myPost'">
		</c:when>
	</c:choose>
	<input type="button" value="전체 글 보기"
		onClick="location.href='ctrl.jsp?action=main'">
</body>
</html>