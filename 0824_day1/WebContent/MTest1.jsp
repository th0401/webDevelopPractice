<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%-- 한글 안깨지게 하는 메서드 --%>
<jsp:useBean id="coffee" class="test.Coffee" />

<jsp:setProperty property="*" name="coffee"/>

<!DOCTYPE html>

<%-- 계산하는 기능을 호출 --%>
<% if(request.getMethod().equals("POST")){coffee.coffeeOrder(); }%>


<html>
<head>
<meta charset="UTF-8">
<title>커피 키오스크</title>
</head>
<body>


<h2>커피주문</h2>
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
<h3>가격표: <jsp:getProperty property="result" name="coffee"/></h3>


</body>
</html>