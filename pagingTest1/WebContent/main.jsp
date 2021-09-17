<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.user.UserVO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css">
<script type="text/javascript">
	function signUp(){
		window.open("signUp.jsp","회원가입","width=1000px,height=600px");
	}
</script>
</head>
<body>
<div class="content">
	<!-- 유저정보들 -->
	<mytag:userInfo />
	
	<hr>
	
	<!-- 로그인 회원가입폼 -->
	<mytag:login_signUp />
	
	<!-- 로그아웃폼 -->
	<mytag:logout />


	<hr>
	<!-- 옵션초기화로고 -->
	<ol>
		<li><a href="main.do"><img alt="로고" src="img/tc.jpg" style="width:80px;height:100px;"></a></li>
	</ol>
	<hr>
	
	<!-- 댓글더보기 -->
	<h2>전체목록</h2>
	<mytag:pagePlus />	
		
		<!-- 내글보기 -->
	<mytag:showMyMsg />
	
	<!-- 댓글작성 -->
	<mytag:insertMsg />
		
	<!-- 댓글,답글 보기 -->
	<c:forEach var="v" items="${datas}">
		<c:set var="m" value="${v.m}" />
		<!-- 댓글 리스트,좋아요 버튼 -->
		<h3>[${m.userID}] ${m.msg} &gt;&gt; [좋아요 ${m.favcount} | 댓글
			${m.replycount} | ${m.udate}]<mytag:likeUp meid="${m.meid}"/></h3>
			
			<!-- 댓글삭제 -->
			<c:if test="${uVO!=null && uVO.userID==m.userID}">
				<mytag:deleteMsg meid="${m.meid}"/>
			</c:if>
			
		<!-- 답글작성 -->				
		<c:choose>		
			<c:when test="${uVO!=null}">
			<mytag:insertRepy userID="${uVO.userID}" meid="${m.meid}" />				
			</c:when>
		</c:choose>
		<c:if test="${uVO==null}">
			<input type="text" size="25" disabled value="답글쓰려면 로그인!">
		</c:if>
		
		<!-- 답글 리스트 -->
		<ol>
			<c:forEach var="r" items="${v.rlist}">
				<li>${r.userID}>>${r.rmsg}[${r.udate}]
				<c:if test="${uVO!=null && uVO.userID==r.userID}">
				
				<!-- 답글 삭제 -->
				<mytag:deleteReply reid="${r.reid}"/>				
			</c:if></li>
			</c:forEach>
		</ol>
	</c:forEach>
</div>
	<div class="ad">
	<ul>
		<li><a href="https://bns2.plaync.com/"><img alt="nc게임 1" src="img/bs2.png" class="adbox"></a></li>
		<li><a href="https://lostark.game.onstove.com/Main"><img alt="로스트아크" src="img/loa.png" class="adbox"></a></li>
		<li><a href="https://lineagem.plaync.com/?LM=14020103"><img alt="nc게임 2" src="img/rm.png" class="adbox"></a></li>
	</ul>
</div>
</body>
</html>