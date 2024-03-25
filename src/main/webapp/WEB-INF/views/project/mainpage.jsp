<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp" %>
	<link rel="stylesheet" href="/resources/include/assets/css/main.css">
	</head>
	<body>
		<header id="header" class="alt"><div class="logo"><a href="/">SaveTheAnimal <span>by team3</span></a></div>
				<a href="#menu">Menu</a>
		</header>
		<!-- Nav -->
		<nav id="menu">
			<ul class="links">
				<li><a href="/">Home</a></li>
				<li><a href="/project/volunteer">봉사모집</a></li>
				<li><a href="/ap/apList">입양</a></li>
				<li><a href="/board/freeBoardList">자유게시판</a>
				<li><a href="/volunteerFeedbackBoard/volunteerFeedbackBoardList">봉사후기게시판</a>
				<li><a href="/adoptionFeedbackBoard/adoptionFeedbackBoardList">입양후기게시판</a>
				<li><a href="/noticeBoard/noticeBoardList">공지사항</a>
				<c:if test="${empty userLogin}">
					<li><a href="/user/login">로그인</a>
				</c:if>
				<c:if test="${not empty userLogin}">
					<li><a href="/user/mypage">My page</a>
					<li><a href="/user/logout">로그아웃</a></li>
				</c:if>
			</ul>
		</nav>
		<!-- Banner -->
		<section class="banner full">
			<article>
				<img src="/resources/images/slide06.jpg" alt="" width="1440" height="960">
				<div class="inner">
					<header>
						<p>For Abandoned Animal</p>
						<h2>SaveTheAnimal</h2>
					</header>
				</div>
			</article>
			<article>
				<img src="/resources/images/slide07.jpg" alt="" width="1440" height="960">
				<div class="inner">
					<header>
						<p>유기동물을 도와주세요</p>
						<h2>유기동물</h2>
					</header>
				</div>
			</article>
			<article>
				<img src="/resources/images/slide08.jpg" alt="" width="1440" height="960">
				<div class="inner">
					<header>
						<p>유기동물 자원봉사에 참여하세요</p>
						<h2>자원봉사</h2>
					</header>
				</div>
			</article>
			<article>
				<img src="/resources/images/slide09.jpg" alt="" width="1440" height="960">
				<div class="inner">
					<header>
						<p>유기동물 입양으로 새로운 가족을 만나보세요</p>
						<h2>입양</h2>
					</header>
				</div>
			</article>
			<article>
				<img src="/resources/images/slide10.jpg" alt="" width="1440" height="960">
				<div class="inner">
					<header>
						<p>유기동물 보호를 위한 다양한 아이디어를 추천받습니다</p>
						<h2>아이디어</h2>
					</header>
				</div>
			</article>
		</section>
		<!-- One -->
		<section id="one" class="wrapper style2">
			<div class="inner">
				<div class="grid-style">
				
					<div>
						<div class="box">
							<div class="image fit"><img src="/resources/images/pic02.jpg" alt="" width="600" height="300"></div>
							<div class="content">
								<header class="align-center">
									<p>maecenas sapien feugiat ex purus</p>
									<h2>Lorem ipsum dolor</h2>
								</header>
								<p> Cras aliquet urna ut sapien tincidunt, quis malesuada elit facilisis. Vestibulum sit amet tortor velit. Nam elementum nibh a libero pharetra elementum. Maecenas feugiat ex purus, quis volutpat lacus placerat malesuada.</p>
								<footer class="align-center"><a href="#" class="button alt">Learn More</a></footer>
							</div>
						</div>
					</div>
					
					<div>
						<div class="box">
							<div class="image fit"><img src="/resources/images/pic03.jpg" alt="" width="600" height="300"></div>
							<div class="content">
								<header class="align-center">
									<p>mattis elementum sapien pretium tellus</p>
									<h2>Vestibulum sit amet</h2>
								</header>
								<p> Cras aliquet urna ut sapien tincidunt, quis malesuada elit facilisis. Vestibulum sit amet tortor velit. Nam elementum nibh a libero pharetra elementum. Maecenas feugiat ex purus, quis volutpat lacus placerat malesuada.</p>
								<footer class="align-center"><a href="#" class="button alt">Learn More</a></footer>
							</div>
						</div>
					</div>

				</div>
			</div>
		</section>
		<!-- Two -->
		<section id="two" class="wrapper style3">
			<div class="inner">
				<header class="align-center">
					<p>Nam vel ante sit amet libero scelerisque facilisis eleifend vitae urna</p>
					<h2>Morbi maximus justo</h2>
				</header>
			</div>
		</section>
		<!-- Three -->
		<section id="three" class="wrapper style2">
			<div class="inner">
				<header class="align-center">
					<p class="special">Nam vel ante sit amet libero scelerisque facilisis eleifend vitae urna</p>
					<h2>Morbi maximus justo</h2>
				</header>
				<div class="gallery">
					<div>
						<div class="image fit">
							<a href="#"><img src="/resources/images/pic01.jpg" alt="" width="600" height="300"></a>
						</div>
					</div>
					<div>
						<div class="image fit">
							<a href="#"><img src="/resources/images/pic02.jpg" alt="" width="600" height="300"></a>
						</div>
					</div>
					<div>
						<div class="image fit">
							<a href="#"><img src="/resources/images/pic03.jpg" alt="" width="600" height="300"></a>
						</div>
					</div>
					<div>
						<div class="image fit">
							<a href="#"><img src="/resources/images/pic04.jpg" alt="" width="600" height="300"></a>
						</div>
					</div>
				</div>
			</div>
		</section>
		
		<!-- Footer -->
		<footer id="footer">
			<div class="container">
				<ul class="icons"><li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
					<li><a href="#" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
					<li><a href="#" class="icon fa-instagram"><span class="label">Instagram</span></a></li>
					<li><a href="#" class="icon fa-envelope-o"><span class="label">Email</span></a></li>
				</ul>
			</div>
		</footer>
		
		<div class="copyright">Made with <a href="https://templated.co/">Templated</a>.</div>

		<!-- Scripts -->
		<script src="/resources/include/assets/js/jquery.min.js"></script>
		<script src="/resources/include/assets/js/jquery.scrollex.min.js"></script>
		<script src="/resources/include/assets/js/skel.min.js"></script>
		<script src="/resources/include/assets/js/util.js"></script>
		<script src="/resources/include/assets/js/main.js"></script>
	</body>
</html>