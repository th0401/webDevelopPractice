<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.member.MemberVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>post등록창</title>
</head>
<body>
<h2>post 등록창</h2>
<hr>
	
		<form action="ctrl.jsp?action=insertP" method="post" name="form1">
		<input type="hidden" name="userID" value="${memberVO.userID}">
			<table border="1">
				<tr>
					<th>제목</th>
				</tr>
				<tr>
					<th><input type="text" name="title" required placeholder="제목을 입력하세요"></th>
				</tr>
				<tr>
					<th>내용</th>
				</tr>
				<tr>
					<th><input type="text" name="content" required placeholder="내용을 입력하세요"></th>
				</tr>
				<tr>
					<th><input type="submit" value="작성완료"></th>
				</tr>
			</table>
			</form>
			<a href="ctrl.jsp?action=main">게시판으로가기</a>
	
	
</body>
</html>