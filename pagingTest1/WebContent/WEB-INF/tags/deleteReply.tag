<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="reid" %>
<form action="deleteRDB.do" method="post">
				<input type="hidden" name="mcnt" value="${mcnt}">
				<input type="hidden" name="reid" value="${reid}">				
				<input type="submit" value="답글 삭제하기">
			</form>