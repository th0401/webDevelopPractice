<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.member.MemberVO"%>
    <%request.setCharacterEncoding("UTF-8"); %>
   <% 
				MemberVO vo= (MemberVO)session.getAttribute("memberVO");
				%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<script type="text/javascript">
	function del(){
		result=confirm("정말로 삭제하시겠습니까?");
		if(result==true){
			document.form1.action.value="deleteM";
			document.form1.submit();
		}
		else{
			return;
		}
	}
</script>
</head>
<body>
<h2>마이페이지</h2>

<form action="ctrl.jsp" method="post" name="form1">
<input type="hidden" name="action" value="editM">
<table border="1">
	<tr>
		<td>아이디</td>
		<td><%=vo.getUserID() %></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><%=vo.getUserPW() %></td>
	</tr>
	<tr>
		<td>이름</td>
		<td><%=vo.getUserName() %></td>
	</tr>
	<tr>
		<td colspan="2" align="right"><input type= "submit" value="회원정보변경"></td>
	</tr>
</table>
</form>
<input type="button" value="회원탈퇴" onClick="del()">
<a href="ctrl.jsp?action=main">게시판으로가기</a>

</body>
</html>