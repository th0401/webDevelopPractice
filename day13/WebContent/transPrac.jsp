<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
    <%request.setCharacterEncoding("UTF-8"); %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
    <jsp:useBean id="datas1" class="java.util.ArrayList" scope="request"/>
    <jsp:useBean id="datas2" class="java.util.ArrayList" scope="request"/>
    <%
   // System.out.println(datas1);
    //System.out.println(datas2);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>송금</title>
</head>
<body>
<h2>bank1명단</h2>
<table border="1">
<c:forEach var="v" items="${datas1}">
	<tr>
		<td>계좌</td>
		<td>${v.b1num}</td>
		<td>이름</td>
		<td>${v.name}</td>
		<td>잔액</td>
		<td>${v.balance}</td>
	</tr>
	
	</c:forEach>
</table>
<br>
<h2>bank2명단</h2>
<table border="1">
	<c:forEach var="v2" items="${datas2}">
	<tr>
		<td>계좌</td>
		<td>${v2.b2num}</td>
		<td>이름</td>
		<td>${v2.name}</td>
		<td>잔액</td>
		<td>${v2.balance}</td>
	</tr>
	</c:forEach>
</table>
<hr>
<h2>bank1에서 입금하기</h2>
<br>
<form action="ctrl.jsp?action=deposit1" method="post" name="form1">
<table border="1">
	<tr>
		<td>입금금액</td>
		<td><input type="text" name="balance" placeholder="숫자만 입력">원</td>
	</tr>
	<tr>
		<td>자신의 계좌 입력</td>
		<td><input type="text" name="b1num" placeholder="숫자만 입력"></td>
	</tr>
	<tr>
		<td>보낼 계좌 입력</td>
		<td><input type="text" name="b2num" placeholder="숫자만 입력"></td>
	</tr>
	<tr>		
		<td colspan="2" align="right"><input type="submit" value="입금하기"></td>
	</tr>
</table>
</form>
<hr>
<h2>bank2에서 입금하기</h2>
<br>
<form action="ctrl.jsp?action=deposit2" method="post" name="form1">
<table border="1">
	<tr>
		<td>입금금액</td>
		<td><input type="text" name="balance" placeholder="숫자만 입력">원</td>
	</tr>
	<tr>
		<td>자신의 계좌 입력</td>
		<td><input type="text" name="b2num" placeholder="숫자만 입력"></td>
	</tr>
	<tr>
		<td>보낼 계좌 입력</td>
		<td><input type="text" name="b1num" placeholder="숫자만 입력"></td>
	</tr>
	<tr>		
		<td colspan="2" align="right"><input type="submit" value="입금하기"></td>
	</tr>
</table>
</form>
</body>
</html>