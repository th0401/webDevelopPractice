<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<ol>
		<li><a href="control.jsp?action=main">전체목록보기</a></li>
	</ol>

	<hr>

	<h2>전체목록</h2>
	<form action="control.jsp?action=insertMDB" method="post">
		<input type="hidden" name="userID" value="킹받은티모">
		<table>
			<tr>
				<td>댓글작성</td>
				<td><input type="text" name="msg" placeholder="댓글을 입력해보아요!"></td>
				<td><input type="submit" value="댓글작성"></td>
			</tr>
		</table>
	</form>
	<c:forEach var="v" items="${datas}">
		<c:set var="m" value="${v.m}" />
		<h3>[${m.userID}] ${m.msg} &gt;&gt; [좋아요 ${m.favcount} | 댓글
			${m.replycount} | ${m.udate}]</h3>
		<form action="control.jsp?action=insertRDB" method="post">
			<input type="hidden" name="userID" value="아무무"> <input
				type="hidden" name="meid" value="${m.meid}">
			<table>
				<tr>
					<td>댓글작성</td>
					<td><input type="text" name="rmsg" placeholder="답글을 입력해보아요!"></td>
					<td><input type="submit" value="답글작성"></td>
				</tr>
			</table>
		</form>
		<ol>
			<c:forEach var="r" items="${v.rlist}">
				<li>${r.userID}>> ${r.rmsg} [${r.udate}]</li>
			</c:forEach>
		</ol>
	</c:forEach>

</body>
</html>