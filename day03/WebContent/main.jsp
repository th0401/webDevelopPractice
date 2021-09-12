<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>참치라이더</title>
</head>
<body>

<%
	request.setCharacterEncoding("UTF-8");
	session.setAttribute("username", request.getParameter("username"));
	System.out.println("도착한 데이터["+request.getParameter("username")+"]"); //로깅기법
	// 유지보수 : 같은 의미, 같은 값을 가지고 있다면 변수명을 일치시킨다!
	// 팀프로젝트 깃허브 블로그는 다 일치시켜야한다.
	// 설계 -> 변수명 정의, 주석
%>
<%= session.getAttribute("username") %>님 환영합니다! <br>
<h2>=== 상품목록 ===</h2>
<form action="addProduct.jsp" name="form1" method="post">
	<select name="product">
		<option>치킨</option>
		<option>피자</option>
		<option>햄버거</option>
		<option selected>한식</option>
		<option>중식</option>
	</select>
	<input type="number" value="1" name="cnt">
	<input type="submit" value="상품 추가하기">
</form>
<a href="buy.jsp">주문하기</a>


</body>
</html>