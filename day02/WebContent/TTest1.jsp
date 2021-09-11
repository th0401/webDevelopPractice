<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
   #red{
      color: red;
   }
   #blue{
      color: red;
   }
</style>
</head>
<body>

<%
   for(int i=1;i<=10;i++) {
      if(i%2==1){
%>
         <span id="red"><%=i %></span><BR>
   <%
      }
      else{
   %>
         <span id="blue"><%=i %></span><BR>
<%
      }
   }
%>

</body>
</html>