<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp" %>    


<body class="subpage">

	<!-- Header -->
	<header id="header">
		<div class="logo"><a href="index.html">Hielo <span>by TEMPLATED</span></a></div>
		<a href="#menu">Menu</a>
	</header><!-- Nav -->
	<nav id="menu">
		<ul class="links">
			<li><a href="index.html">Home</a></li>
			<li><a href="generic.html">Generic</a></li>
			<li><a href="elements.html">Elements</a></li>
		</ul>
	</nav><!-- One -->
	<section id="One" class="wrapper style3">
		<div class="inner">
			<header class="align-center">
				<p>Save The Animal</p>
				<h2>회원 로그인 페이지</h2>
			</header>
		</div>
	</section><!-- Two -->
	<section id="two" class="wrapper style2">
		<div class="inner">
			<div class="box">
				<div class="content">
					<header class="align-center">
						<p>Save The Animal</p>
						<h2>회원 로그인</h2>
					</header>
					<form>
						<div class="row uniform">

							<label for="userId">회원 id</label>

							<input type="text" name="userId" id="userId" class="fit" placeholder="ID" />

							<label for="userId">비밀번호</label>					
							<input type="password" name="userPasswd" id="userPasswd" class="fit" placeholder="Password" /></td>

						</div>
					</form>
					<button type="button" id="loginBtn" name="loginBtn" class="button special fit">로그인</button>
					<a href="#">회원가입</a>
				</div>
			</div>
		</div>
	</section>
	<!-- Footer -->
	<footer id="footer">
		<div class="container">
			<ul class="icons">
				<li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
				<li><a href="#" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
				<li><a href="#" class="icon fa-instagram"><span class="label">Instagram</span></a></li>
				<li><a href="#" class="icon fa-envelope-o"><span class="label">Email</span></a></li>
			</ul>
		</div>
	</footer>
	<div class="copyright">
		Made with <a href="https://templated.co/">Templated</a>.
	</div>

	<!-- Scripts -->
</body>

</html>