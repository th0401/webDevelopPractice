<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.member.MemberVO"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="data" class="model.post.PostVO" scope="request" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글</title>
<script type="text/javascript">
	function del() {
		result = confirm("정말로 삭제하시겠습니까?");
		if (result == true) {
			document.form1.action.value = "deleteP";
			document.form1.submit();
		} else {
			return;
		}
	}
</script>
</head>
<body>
	<h2>게시글</h2>
	<hr>
	<form action="ctrl.jsp" method="post" name="form1">
		<input type="hidden" name="action" value="editP"> <input
			type="hidden" name="pnum" value="${data.pnum}">
		<table border="1">
			<tr>
				<td>글번호</td>
				<td>${data.pnum}</td>
			</tr>
			<tr>
				<td>제목</td>
				<td>${data.title}</td>
			</tr>
			<tr>
				<td>ID</td>
				<td>${data.userID}</td>
			</tr>
			<tr>
				<td>날짜</td>
				<td>${data.pdate}</td>
			</tr>
			<tr>
				<td>내용</td>
				<td>${data.content}</td>
			</tr>
			
			<c:choose>
				<c:when test="${memberVO!=null && memberVO.userID==data.userID}">
					<tr>
						<td colspan="2" align="right"><input type="submit"
							value="글 수정"></td>
					</tr>
				</c:when>
			</c:choose>
		</table>
	</form>
	
	<c:choose>
		<c:when test="${memberVO!=null && memberVO.userID==data.userID}">
			<tr>
				<input type="button" value="글 삭제" onClick="del()">
			</tr>
		</c:when>
	</c:choose>
	<a href="ctrl.jsp?action=main">게시판으로가기</a>
</body>
</html>