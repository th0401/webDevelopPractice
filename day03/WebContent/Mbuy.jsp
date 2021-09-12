<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결재창 실습!</title>
</head>
<body>

<h3>구매한 상품 목록</h3>
<hr>
<%
	request.setCharacterEncoding("UTF-8");
   
	ArrayList<String> list=(ArrayList)session.getAttribute("list");
	if(list==null){
		out.println("구매한 상품이 없습니다.");
	}
	else{
		  for(String v:list){
		         out.println(v+"<br>");
		      }
//		  out.println();
//		  out.println("총 가격은 "+totalResult+"원입니다!");
	}
%>

<hr>
<a href="index.jsp">처음으로 돌아가기</a>

</body>
</html>