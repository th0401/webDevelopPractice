<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
		<c:when test="${uVO!=null}">
			<form action="control.jsp?action=main" method="post">
				<input type="hidden" name="selUser" value="${uVO.userID}"> <input
					type="hidden" name="cnt" value="${mcnt}"> <input
					type="submit" value="내글보기">
			</form>
		</c:when>
	</c:choose>