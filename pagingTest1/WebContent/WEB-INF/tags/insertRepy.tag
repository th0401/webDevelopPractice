<%@ tag language="java" pageEncoding="UTF-8"%>
<%@attribute name="userID" %>
<%@attribute name="meid" %>
<form action="control.jsp?action=insertRDB" method="post">
					<input type="hidden" name="userID" value="${userID}"> 
					<input type="hidden" name="meid" value="${meid}">
					<input type="hidden" name="mcnt" value="${mcnt}">
					<input type="hidden" name="selUser" value="${selUser}">
					<table>
						<tr>
							<td>답글작성</td>
							<td><input type="text" name="rmsg" placeholder="답글을 입력해보아요!"></td>
							<td><input type="submit" value="답글작성"></td>
						</tr>
					</table>
				</form>