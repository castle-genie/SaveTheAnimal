<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp" %>    
<link rel="stylesheet" href="/resources/include/assets/css/main.css">
<style>
	.form-container {
	    width: 55%; 
	    margin: 0 auto;
	}
</style>
</head>
<body class="subpage">

	<!-- Header -->
	<header id="header">
		<div class="logo"><a href="/">SaveTheAnimal <span>by team3</span></a></div>
		<a href="#menu">Menu</a>
	</header><!-- Nav -->
	<nav id="menu">
		<ul class="links">
			<li><a href="/">Home</a></li>
			<li><a href="/project/volunteer">봉사모집</a></li>
			<li><a href="/project/adoption">입양</a></li>
			<li><a href="donate.html">후원</a>
			<li><a href="/project/freeboard">자유게시판</a>
			<li><a href="#">봉사후기게시판</a>
			<li><a href="#">입양후기게시판</a>
			<li><a href="#">공지사항</a>
			<li><a href="/login">로그인</a>
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
					<c:if test="${empty userLogin}">
						<header class="align-center">
							<p>Save The Animal</p>
							<h2>회원 로그인</h2>
						</header>						
							<div class="form-container">
								<form id="loginForm">
							<div class="row uniform">
								<div class="6u$ 12u$(large)">
									<label for="userId">아이디</label>
								</div>								
								<div class="6u$ 12u$(large)">
									<input type="text" name="userId" id="userId"  placeholder="ID" />									
								</div>
								<div class="6u$ 12u$(large)">
									<label for="userPasswd">비밀번호</label>
								</div>	
								<div class="6u$ 12u$(large)">	
									<input type="password" name="userPasswd" id="userPasswd"  placeholder="Password" />
								</div>
							</div>
							</form>
						<button type="button" id="loginBtn" name="loginBtn" class="button special fit big">로그인</button>
						</div>
						<div class="align-center">
							<a href="/join" class="button alt small">회원가입</a>              
							<a href="/findId" class="button alt small">ID 찾기</a>
							<a href="#" class="button alt small">비밀번호 찾기</a>
						</div>
					</c:if>
					<c:if test="${not empty userLogin}">
					  	<h4>${userLogin.userName}님이 로그인하였습니다.</h4>
					  	<button type="button" id="logoutBtn">로그아웃</button>
					</c:if>
				</div>
			</div>
		<div>login.jsp 화면</div>
		<div>아이디, 비밀번호 입력 폼</div>
		<div>로그인 버튼 : 입력 버튼 누르고 성공시 메인페이지 이동 실패시 알림메시지 띄우고 현재페이지 재요청</div>
		<div>아이디 찾기 : </div>
		<div>비밀번호 재설정 : </div>
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
	<script>
	$(function(){
		$("#loginBtn").on("click", function(){
			if (!chkData("#userId", "아이디를")) return;
			else if (!chkData("#userPasswd", "비밀번호를")) return;
			else {
				$("#loginForm").attr({
					"method":"post",
					"action":"/login"
				});
				$("#loginForm").submit();
			}
			
		});
		
		$("#logoutBtn").on("click", function(){
			alert("로그아웃하여 메인페이지로 이동합니다.");
			location.href = "/logout";
		});
		
		let errorMsg = "${errorMsg}";
		if(errorMsg != ""){
			alert(errorMsg);
			errorMsg = "";
		}
		
	});
	</script>
</body>

</html>
