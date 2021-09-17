<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
		<c:when test="${uVO!=null}">
			<form action="insertMDB.do" method="post">
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