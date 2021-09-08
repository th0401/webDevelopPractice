<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*,javax.sql.*,javax.naming.*"%>
    <%request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	Connection conn=null;
	PreparedStatement pstmt=null;
	try{
		Context initContext=new InitialContext();
		Context envContext = (Context)initContext.lookup("java:/comp/env");
		DataSource ds= (DataSource)envContext.lookup("jdbc/orcl");
		// 프로그래머가 지향하는 "낮은 결합도"-> 프로그램이 유연해진다!★★★★★★★★★★ 응집 결합도
		
		
		conn=ds.getConnection();
		String sql="insert into test values(?,?)";
		
		if(request.getParameter("name")!=null){
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("name"));
			pstmt.setString(2, request.getParameter("email"));
			pstmt.executeUpdate();
		}
	}catch(Exception e){
		e.printStackTrace();
	}
	
	
%>
<!-- DB연결이 해제되면 커넥션 객체를 직접 소멸xxx 커넥션풀이 자원을 반납해주는 형태o -->
<form  method="post">
	<input type="text" name="name">
	<input type="text" name="email">
	<input type="submit" value="추가하기">
</form>

<hr>

<%
	try{
	String sql="select * from test";
	pstmt=conn.prepareStatement(sql);
	ResultSet rs=pstmt.executeQuery();
	while(rs.next()){
		  out.println(rs.getString("name")+"님 이메일주소는 "+rs.getString("email")+" <br>");

	}
	rs.close();
	pstmt.close();
	conn.close();
	}
	catch(Exception e){
		System.out.println(e);
	}





%>

</body>
</html>