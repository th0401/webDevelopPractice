<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="data" class="model.post.PostVO" scope="request"/>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글</title>

</head>
<body>
<h2>게시글</h2>
<hr>
<form action="ctrl.jsp" method="post" name="form1"> 
<input type="hidden" name="action" value="updateP">
<input type="hidden" name="pnum" value="${data.pnum}">
<input type="hidden" name="userID" value="${data.userID}">
<input type="hidden" name="pdata" value="${data.pdate}">
<table border="1">
	<tr>
		<td>글번호</td>
		<td>${data.pnum}</td>
	</tr>
	<tr>
		<td>제목</td>
		<td><input type="text" name="title" value="${data.title}" required placeholder="제목을 입력하세요"></td>
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
		<td><input type="text" name="content" value="${data.content}" required placeholder="내용을 입력하세요"></td>
	</tr>	
	<tr>
		<td colspan="2" align="right"><input type= "submit" value="글 수정 완료"></td>
	</tr>
	
</table>
</form>

<a href="ctrl.jsp?action=main">게시판으로가기</a>
</body>
</html>