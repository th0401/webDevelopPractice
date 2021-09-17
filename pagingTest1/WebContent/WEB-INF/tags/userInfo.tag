<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table border="1">
		<c:forEach var="v" items="${newUsers}">
			<tr>
				<td>아이디</td>
				<td><a href="main.do?mcnt=${mcnt}&selUser=${v.userID}">${v.userID}</a></td>
				<td>비밀번호</td>
				<td>${v.userPW}</td>
				<td>이름</td>
				<td>${v.name}</td>
			</tr>
		</c:forEach>
	</table>