<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<jsp:useBean id="data" class="model.board.BoardVO" scope="request"/>
<!DOCTYPE HTML>
<!--
	Stellar by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
<head>
<title>글 수정 /삭제창</title>
<style type="text/css">
#le{
float:right;
}
</style>
<script type="text/javascript">
	function del(){
		result=confirm("정말로 삭제하시겠습니까?");
		if(result==true){
			document.form1.action.value="delete";
			document.form1.submit();
		}
		else{
			return;
		}
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
		<nav id="nav">
			<ul>
				<li><a href="#intro" class="active">Introduction</a></li>
				<li><a href="#first">First Section</a></li>
				<li><a href="#second">Second Section</a></li>
				<li><a href="#cta">Get Started</a></li>
			</ul>
		</nav>

		<!-- Main -->
		<div id="main">

			<!-- Introduction -->
			<section id="intro" class="main">
				<h2>글수정 / 삭제</h2>
				<form method="post" action="ctrl.jsp" name= "form1">
				<input type="hidden" name="action" value="update">
				<input type="hidden" name="bnum" value="<%=data.getBnum()%>">
				
					<div class="row gtr-uniform">
						<div class="col-6 col-12-xsmall">
							<input type="text" name="title"  value= "<%=data.getTitle() %>"
								placeholder="Title" />
						</div>
						<div class="col-6 col-12-xsmall">
							<input type="text" name="writer"  value= "<%=data.getWriter() %>"
								placeholder="Name" />
						</div>
						
						<div class="col-12">
							<textarea name="content" placeholder="<%=data.getContent() %>"
								 rows="6"></textarea>
						</div>
						<div class="col-12">
							<ul class="actions">
								<li><input type="submit" value="내용 변경하기"
									class="primary" /></li>
								<li><input type="button" value="글 삭제하기" onClick="del()"/></li>
								
							</ul>
							<div id="le"><a href="ctrl.jsp?action=list" class="button primary">메인으로 돌아가기</a></div>
						</div>
					</div>
				</form>
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