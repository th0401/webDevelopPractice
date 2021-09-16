<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="meid"%>
<form action="control.jsp?action=deleteMDB" method="post">
				<input type="hidden" name="mcnt" value="${mcnt}">
				<input type="hidden" name="meid" value="${m.meid}">				
				<input type="submit" value="댓글 삭제하기">
			</form>