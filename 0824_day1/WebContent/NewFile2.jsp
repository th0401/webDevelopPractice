<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% request.setCharacterEncoding("UTF-8"); %>

<jsp:useBean id="calc" class="test.CalcBean" />
<%-- CalcBean클래스에서 calc의 객체를 생성 == 객체화 == 인스턴스화 --%>

<jsp:setProperty property="*" name="calc"/>

<!DOCTYPE html>

<%-- 계산하는 기능을 호출 --%>
<% if(request.getMethod().equals("POST")){calc.calculate(); }%>


<html>
<head>
<meta charset="UTF-8">
<title>계산기 실습2</title>
</head>
<body>


<h2>계산기</h2>
<hr>
<form method="post" name="form1">
   <input type="text" id="num1" name="num1">
   <select name="op">
      <option selected>+</option>
      <option>-</option>
      <option>*</option>
      <option>/</option>
   </select>
   <input type="text" id="num2" name="num2">
   <input type="submit" value="계산하기" name="btn1">
   <input type="reset" value="다시입력" name="btn2">
</form>
<hr>
<h3>계산결과: <jsp:getProperty property="result" name="calc"/></h3>


</body>
</html>