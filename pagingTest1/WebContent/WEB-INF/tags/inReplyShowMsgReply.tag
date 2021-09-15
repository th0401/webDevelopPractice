<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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