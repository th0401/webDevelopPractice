<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form>
   <input type="text" name="test">
   
   <input type="submit" value="선택완료">
</form>
<hr>

[${param.test}]을 입력했습니다.


<c:choose>
   <c:when test="${param.test%2==0}">
      입력값은 짝수입니다
   </c:when>
   <c:when test="${param.test%2!=0}">
      입력값은 홀수입니다
   </c:when>  
</c:choose>

<hr>

<%
ArrayList<String> datas=  new ArrayList();
datas.add("apple");
datas.add("banana");
datas.add("kiwi");
pageContext.setAttribute("datas", datas);
%>
<table border="1">
	<c:forEach var="v" items="${datas}">
	<!-- items는 집합명 var는 포이치문 객체 -->
	<tr>
		<td>${v}</td>
	</tr>
	</c:forEach>
	
</table>








</body>
</html>