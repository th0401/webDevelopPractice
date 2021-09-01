<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,model.board.*,model.member.*"%>
	
	<jsp:useBean id="datas" class="java.util.ArrayList" scope="request"/>
	
<!DOCTYPE HTML>
<!--
	Stellar by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
<head>
<title>게시판실습!</title>
<script type="text/javascript">
	function check(bnum){
		writer=prompt("글 정보 변경을 위해 작성자명을 입력하세요");
		document.location.href="ctrl.jsp?action=edit&bnum="+bnum+"&writer="+writer;
	}
</script>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="assets/css/main.css" />
<noscript>
	<link rel="stylesheet" href="assets/css/noscript.css" />
</noscript>
</head>
<body class="is-preload">

	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Header -->
		<header id="header" class="alt">
			<span class="logo"><img src="images/logo.svg" alt="" /></span>
			<h1>게시판</h1>
			<p>
				Just another free, fully responsive site template<br /> built by <a
					href="https://twitter.com/ajlkn">@ajlkn</a> for <a
					href="https://html5up.net">HTML5 UP</a>.
			</p>
		</header>

		<!-- Nav -->
		<%if(session.getAttribute("memberVO")==null){
		
		%>
		<nav id="nav">
			<ul>
				<li><a href="login.jsp">로그인</a></li><!--  class="active" 표시되는것처럼보이는것 -->
				<li><a href="reg.jsp">회원가입하기</a></li>
				
			</ul>
		</nav>
		<%
		}
		else{
			%>
			<nav id="nav">
			<ul>
				<li><a href="ctrl.jsp?action=logout">로그아웃</a></li><!--  class="active" 표시되는것처럼보이는것 -->
				<li><a href="ctrl.jsp?action=updateMember">회원정보변경</a></li>
				<li><a href="ctrl.jsp?action=showMyPage">내글보기</a></li>
			</ul>
		</nav>
			<% 
		}
		%>
		<!-- Main -->
		<div id="main">

			<!-- Introduction -->
			<section id="intro" class="main">
				<!-- Table -->
				<div class="table-wrapper">
					<table>
						<thead>
							<tr>
								<th>글 번호</th>
								<th>글 제목</th>
								<th>작성자</th>
								<th>작성일자</th>
							</tr>
						</thead>
						<tbody>
							<%
							for(BoardVO vo:(ArrayList<BoardVO>)datas){
								
							%>
							<tr>
								<td><%=vo.getBnum() %></td>
								<td><a href="javascript:check(<%=vo.getBnum()%>)"><%=vo.getTitle() %></a></td>
								<td><%=vo.getWriter() %></td>
								<th><%=vo.getBdate() %></th>
							</tr>
							<%
							}
							%>
						</tbody>
						
					</table>
					<%
						if(session.getAttribute("memberVO")!=null){
					%>
					<a href="form.jsp" class="button primary">글 등록</a>
					<%
						}
						else{
					%>
					<p>글을 쓰려면 로그인을 하시기 바랍니다.</p>
					<%
						}
					%>
				</div>

			</section>
		</div>

		<!-- Footer -->
		<footer id="footer">
			<section>
				<h2>Aliquam sed mauris</h2>
				<p>Sed lorem ipsum dolor sit amet et nullam consequat feugiat
					consequat magna adipiscing tempus etiam dolore veroeros. eget
					dapibus mauris. Cras aliquet, nisl ut viverra sollicitudin, ligula
					erat egestas velit, vitae tincidunt odio.</p>
				<ul class="actions">
					<li><a href="generic.html" class="button">Learn More</a></li>
				</ul>
			</section>
			<section>
				<h2>Etiam feugiat</h2>
				<dl class="alt">
					<dt>Address</dt>
					<dd>1234 Somewhere Road &bull; Nashville, TN 00000 &bull; USA</dd>
					<dt>Phone</dt>
					<dd>(000) 000-0000 x 0000</dd>
					<dt>Email</dt>
					<dd>
						<a href="#">information@untitled.tld</a>
					</dd>
				</dl>
				<ul class="icons">
					<li><a href="#" class="icon brands fa-twitter alt"><span
							class="label">Twitter</span></a></li>
					<li><a href="#" class="icon brands fa-facebook-f alt"><span
							class="label">Facebook</span></a></li>
					<li><a href="#" class="icon brands fa-instagram alt"><span
							class="label">Instagram</span></a></li>
					<li><a href="#" class="icon brands fa-github alt"><span
							class="label">GitHub</span></a></li>
					<li><a href="#" class="icon brands fa-dribbble alt"><span
							class="label">Dribbble</span></a></li>
				</ul>
			</section>
			<p class="copyright">
				&copy; Untitled. Design: <a href="https://html5up.net">HTML5 UP</a>.
			</p>
		</footer>

	</div>

	<!-- Scripts -->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/jquery.scrollex.min.js"></script>
	<script src="assets/js/jquery.scrolly.min.js"></script>
	<script src="assets/js/browser.min.js"></script>
	<script src="assets/js/breakpoints.min.js"></script>
	<script src="assets/js/util.js"></script>
	<script src="assets/js/main.js"></script>

</body>
</html>