<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import= "model.member.MemberVO"%>
    <jsp:useBean id="data" class="model.post.PostVO" scope="request"/>
      <% 
				MemberVO vo= (MemberVO)session.getAttribute("memberVO");
				%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글</title>
<script type="text/javascript">
	function del(){
		result=confirm("정말로 삭제하시겠습니까?");
		if(result==true){
			document.form1.action.value="deleteP";
			document.form1.submit();
		}
		else{
			return;
		}
	}
</script>
</head>
<body>
<h2>게시글</h2>
<hr>
<form action="ctrl.jsp" method="post" name="form1">
<input type="hidden" name="action" value="editP">
<input type="hidden" name="pnum" value="<%=data.getPnum() %>">
<table border="1">
	<tr>
		<td>글번호</td>
		<td><%=data.getPnum() %></td>
	</tr>
	<tr>
		<td>제목</td>
		<td><%=data.getTitle() %></td>
	</tr>
	<tr>
		<td>ID</td>
		<td><%=data.getUserID() %></td>
	</tr>
	<tr>
		<td>날짜</td>
		<td><%=data.getPdate() %></td>
	</tr>
	<tr>
		<td>내용</td>
		<td><%=data.getContent() %></td>
	</tr>
	<%
	if(vo.getUserID().equals(data.getUserID())){
			
	%>
	<tr>
		<td colspan="2" align="right"><input type= "submit" value="글 수정"></td>
	</tr>
	<%
	}
	%>
</table>
</form>
<%
	if(vo.getUserID().equals(data.getUserID())){
			
	%>
<input type="button" value="글 삭제" onClick="del()">
<%
	}
	%>
<a href="ctrl.jsp?action=main">게시판으로가기</a>
</body>
</html>