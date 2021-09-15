<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.user.UserVO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function signUp(){
		window.open("signUp.jsp","회원가입","width=1000px,height=600px");
	}
</script>
</head>
<body>
	<!-- 유저정보들 -->
	<mytag:userInfo />
	
	<hr>
	
	<!-- 로그인 회원가입폼 -->
	<mytag:login_signUp />
	
	<!-- 로그아웃폼 -->
	<mytag:logout />


	<hr>
	<!-- 옵션초기화 -->
	
	<mytag:resetOption />
	<hr>
	
	<!-- 댓글더보기 -->
	<h2>전체목록</h2>
	<mytag:pagePlus />	
		
		<!-- 내글보기 -->
	<mytag:showMyMsg />
	
	<!-- 댓글작성 -->
	<mytag:insertMsg />
		
	<!-- 댓글 삭제,답글보기,작성,삭제 -->
	<mytag:inReplyShowMsgReply />

</body>
</html>