<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.user.UserVO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table border="1">
		<c:forEach var="v" items="${newUsers}">
			<tr>
				<td>아이디</td>
				<td>${v.userID}</td>
				<td>비밀번호</td>
				<td>${v.userPW}</td>
				<td>이름</td>
				<td>${v.name}</td>
			</tr>
		</c:forEach>
	</table>
	<hr>

	<c:choose>
		<c:when test="${uVO==null}">
			<form action="control.jsp?action=login" method="post">	
			<input type="hidden" name="mcnt" value="${mcnt}">		
				<table border="1">
					<tr>
						<td>아이디</td>
						<td><input type="text" name="userID"
							placeholder="아이디를 입력하세요."></td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><input type="password" name="userPW"
							placeholder="비밀번호를 입력하세요."></td>
					</tr>
					<tr>

						<td colspan="2" align="right"><input type="submit"
							value="로그인하기"></td>
					</tr>
				</table>
			</form>
		</c:when>
	</c:choose>

	<c:choose>
		<c:when test="${uVO!=null}">
			<form action="control.jsp?action=logout" method="post">
				<input type="submit" value="로그아웃">
			</form>
		</c:when>
	</c:choose>


	<hr>
	<ol>
		<li><a href="control.jsp?action=main">전체목록보기</a></li>
	</ol>

	<hr>

	<h2>전체목록</h2>
	<a href="control.jsp?action=main&mcnt=${mcnt+1}&selUser=${selUser}">댓글더보기</a>
		<!-- 내글보기 -->
	<c:choose>
		<c:when test="${uVO!=null}">
			<form action="control.jsp?action=main" method="post">
				<input type="hidden" name="selUser" value="${uVO.userID}"> <input
					type="hidden" name="cnt" value="${mcnt}"> <input
					type="submit" value="내글보기">
			</form>
		</c:when>
	</c:choose>
	<!-- 댓글작성 -->
	<c:choose>
		<c:when test="${uVO!=null}">
			<form action="control.jsp?action=insertMDB" method="post">
				<input type="hidden" name="userID" value="${uVO.userID}">
				<input type="hidden" name="mcnt" value="${mcnt}">
				<table>
					<tr>
						<td>댓글작성</td>
						<td><input type="text" name="msg" placeholder="댓글을 입력해보아요!"></td>
						<td><input type="submit" value="댓글작성"></td>
					</tr>
				</table>
			</form>
		</c:when>
	</c:choose>
	<c:if test="${uVO==null}">
			<input type="text" size="25" disabled value="댓글쓰려면 로그인!">
		</c:if>
	<!-- 댓글보기 -->
	<c:forEach var="v" items="${datas}">
		<c:set var="m" value="${v.m}" />
		<h3>[${m.userID}] ${m.msg} &gt;&gt; [좋아요 ${m.favcount} | 댓글
			${m.replycount} | ${m.udate}]</h3>
			<c:if test="${uVO!=null && uVO.userID==m.userID}">
				<form action="control.jsp?action=deleteMDB" method="post">
				<input type="hidden" name="mcnt" value="${mcnt}">
				<input type="hidden" name="meid" value="${m.meid}">
				<input type="submit" value="댓글 삭제하기">
			</form>
			</c:if>
			
		<c:choose>
			<c:when test="${uVO!=null}">
				<form action="control.jsp?action=insertRDB" method="post">
					<input type="hidden" name="userID" value="${uVO.userID}"> 
					<input type="hidden" name="meid" value="${m.meid}">
					<input type="hidden" name="mcnt" value="${mcnt}">
					<table>
						<tr>
							<td>답글작성</td>
							<td><input type="text" name="rmsg" placeholder="답글을 입력해보아요!"></td>
							<td><input type="submit" value="답글작성"></td>
						</tr>
					</table>
				</form>
			</c:when>
		</c:choose>
		<c:if test="${uVO==null}">
			<input type="text" size="25" disabled value="답글쓰려면 로그인!">
		</c:if>

		<ol>
			<c:forEach var="r" items="${v.rlist}">
				<li>${r.userID}>>${r.rmsg}[${r.udate}]</li>
				<c:if test="${uVO!=null && uVO.userID==r.userID}">
				<form action="control.jsp?action=deleteRDB" method="post">
				<input type="hidden" name="mcnt" value="${mcnt}">
				<input type="hidden" name="reid" value="${r.reid}">
				<input type="submit" value="답글 삭제하기">
			</form>
			</c:if>
			</c:forEach>
		</ol>
	</c:forEach>

</body>
</html>