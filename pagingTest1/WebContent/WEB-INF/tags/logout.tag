<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
		<c:when test="${uVO!=null}">
		<h2>${uVO.userID}님 안녕하세요!</h2>
		<br>
			<form action="logout.do" method="post">
				<input type="submit" value="로그아웃">
			</form>
		</c:when>
	</c:choose>