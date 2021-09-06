<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="model.member.MemberVO,model.post.*,java.util.ArrayList"%>
<%request.setCharacterEncoding("UTF-8"); %>
<%@ taglib tagdir= "/WEB-INF/tags" prefix= "myTags" %>
<% 
				MemberVO vo= (MemberVO)session.getAttribute("memberVO");
				%>
<jsp:useBean id="datas" class="java.util.ArrayList" scope="request" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인화면창</title>
<script type="text/javascript">
function forbid(){
	alert('로그인 해야만 글을 쓸수 있습니다!');
}
function goPost(pnum){
	document.location.href="ctrl.jsp?action=post&bnum="+pnum;
}
</script>

	
</head>
<body>
	<h2>메인화면창</h2>
	<hr>
	<%
if(session.getAttribute("memberVO")==null){
	
%>
	<myTags:login/>
	<%
}
else{
%>
	<h2><%=vo.getUserID() %>님 안녕하세요!</h2>
	<myTags:logout/>
	<%
}
%>
	<hr>
	<h2>게시판목록</h2>
	<br>
	<form action="ctrl.jsp?action=search" name="form1" method="post">
	<table>
	<tr>
	<td>
	<select name="col">
		<option selected value="title">제목</option>
		<option value="userID">작성자</option>
	</select>
	</td>
	<td><input type="text" name="word" placeholder="검색할 내용을 입력하세요" required></td>
	<td><input type="submit" value="검색하기"></td>
	</tr>
	</table>
	</form>
	
	
	<table>
		<thead>
			<tr>
				<th>글 번호</th>
				<th>글 제목</th>
				<th>작성자</th>
				<th>작성일자</th>
			</tr>
		</thead>
		<tbody>
			<%
							for(PostVO p:(ArrayList<PostVO>)datas){
								
							%>
			<tr>
				<td><%=p.getPnum() %></td>
				<td><a href="ctrl.jsp?action=post&pnum=<%=p.getPnum()%>"><%=p.getTitle() %></a></td>
				<td><%=p.getUserID() %></td>
				<th><%=p.getPdate() %></th>
			</tr>
			<%
							}
							%>
		</tbody>
	</table>
	<%
if(session.getAttribute("memberVO")!=null){
	
%>
	<input type="button" value="글쓰기"
		onClick="location.href='insertPost.jsp'">
		<input type="button" value="내 글 보기"
		onClick="location.href='ctrl.jsp?action=myPost'">
	<%
}
else{
	

%>
<input type="button" value="글쓰기"
		onClick="forbid()">		
	<%		
}
%>
<input type="button" value="전체 글 보기"
		onClick="location.href='ctrl.jsp?action=main'">
</body>
</html>