<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
<form action="updateBoardAction.jsp" method="post" enctype="multipart/form-data">
	<table border="1">
	<input type="hidden" value="${data.id}" name="id">
		<tr>
			<td>글 제목</td>
			<td><input type="text" name="title" value="${data.title}" readonly></td>
		</tr>
		<tr>
			<td>글 내용</td>
			<td><input type="text" name="content" value="${data.content}" readonly></td>
		</tr>
		<tr>
			<td>파일업로드</td>
			<td><input type="file" name="fileUpload"></td>
		</tr>		
	</table>
</form>

<hr>
<a href="main.do">메인페이지로 이동</a>
</body>
</html>