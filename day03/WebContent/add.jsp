<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품추가창 실습!</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");  
    String product=request.getParameter("product");      
    int cnt=Integer.parseInt(request.getParameter("cnt"));
    
    int price=0;
    if(product.equals("청바지 가격:10000원")) {
   	  price = 10000 * cnt;
  		}else if(product.equals("셔츠 가격:20000원")) {
  			price = 20000 * cnt;
  		}
  		else if(product.equals("신발 가격:50000원")) {
  			price = 50000 * cnt;
  		}
    
   // C: 사용자가 입력한 값들을 Java로 가져오는 작업
     
    		
//	int price=20000; // M: DB에서 값을 가져오는 작업
//	int total=price*cnt; // C: DB에서 가져온 값 x 사용자가 입력한 값
	// 세션에게 배열을 설정
	// -> "배열"=> 컬렉션프레임워크
	ArrayList<String> list=(ArrayList)session.getAttribute("list");
	if(list==null){
		list=new ArrayList<String>();
		session.setAttribute("list", list);
	}
	list.add(product+" "+cnt+"개"+" 금액 : "+price+"원");
	
%>


<script type="text/javascript">
	
	alert("<%=product%>(이)가 <%= cnt%>개 추가되었습니다! 금액 : <%=price%>원");
	history.go(-1); // 뒤로가기
</script>

</body>
</html>