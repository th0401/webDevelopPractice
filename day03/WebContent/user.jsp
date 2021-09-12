<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>상품구매창 실습!</title>
</head>
<body>

<%
	request.setCharacterEncoding("UTF-8");	
//	System.out.println("도착한 데이터["+request.getParameter("userID")+"]"); //로깅기법

	
%>
<%= session.getAttribute("userID") %>님 환영합니다! <br>
<h2>=== 상품목록 ===</h2>
<form action="add.jsp" name="form1" method="post">
	<select name="product">
		<option selected>청바지 가격:10000원</option>
		<option>셔츠 가격:20000원</option>
		<option>신발 가격:50000원</option>
		
	</select>
	<input type="number" value="1" name="cnt" min="1" max= "20">
	<input type="submit" value="상품 추가하기">
</form>

<a href="Mbuy.jsp" id="pls" onclick="cntPlus">주문하기</a>
<script type="text/javascript">
document.getElementById("pls").onclick=function(){
	<%int cnt=(Integer)application.getAttribute("cnt"); // 에플리케이션 객체에 저장된 값; 
	cnt++;
	application.setAttribute("cnt",cnt);
	%>
}
</script>
</body>
</html>