<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>

<%
   // 변수 선언
   int result=0;

   if(request.getMethod().equals("POST")){
      String coffeeName=request.getParameter("coffeeName");
      
      int cnt=Integer.parseInt(request.getParameter("cnt"));
      
      // 파라미터 값은 문자열로 주고받음
      
      if(coffeeName.equals("아메리카노 : 2000원")) {
			result = 2000 * cnt;
		}else if(coffeeName.equals("카페라떼 : 2500원")) {
			result = 2500 * cnt;
		}
      
      
   }
%>

<html>
<head>
<meta charset="UTF-8">
<title>커피 키오스크2</title>
</head>
<body>


<h2>커피주문2</h2>
<hr>
<form method="post" name="form1">
   
   <select name="coffeeName">
      <option selected>아메리카노 : 2000원</option>
      <option>카페라떼 : 2500원</option>
   </select>
   <input type="text" id="cnt" name="cnt">
   <input type="submit" value="주문" name="btn1">
   <input type="reset" value="초기화" name="btn2">
</form>
<hr>
<hr>
<h3>가격표: <%= result %></h3>



</body>
</html>