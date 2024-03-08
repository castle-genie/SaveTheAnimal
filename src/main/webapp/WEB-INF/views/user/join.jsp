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
			<li><a href="/">Home</a></li>
			<li><a href="/project/volunteer">봉사모집</a></li>
			<li><a href="/project/adoption">입양</a></li>
			<li><a href="donate.html">후원</a>
			<li><a href="/project/freeboard">자유게시판</a>
			<li><a href="#">봉사후기게시판</a>
			<li><a href="#">입양후기게시판</a>
			<li><a href="#">공지사항</a>
			<li><a href="/user/login">로그인</a>
		</ul>
	</nav><!-- One -->
	<section id="One" class="wrapper style3">
		<div class="inner">
			<header class="align-center">
				<p>Save The Animal</p>
				<h2>회원 가입 페이지</h2>
			</header>
		</div>
	</section><!-- Two -->
	<section id="two" class="wrapper style2">
		<div class="inner">
			<div class="box">
				<div class="content">
					<header class="align-center">
						<p>Save The Animal</p>
						<h2>회원 가입</h2>
					</header>
					<form id="joinForm">
						<div class="row uniform">
							<div class="table-wrapper">
								<table>
								<thead><tr></tr></thead>
									<tbody>
										<tr>
											<td>
												<label for="id" class="align-center">아이디</label>
											</td>
											<td>
												<input type="text" name="id" id="id"  placeholder="영문/숫자 6~15자리" />
											</td>	
											<td>
												<button type="button" class="button alt small">중복 확인</button>
											</td>
										</tr>
										<tr>
											<td>
												<label for="pwd" class="align-center">비밀번호</label>
											</td>	
											<td>
												<input type="password" name="pwd" id="pwd" placeholder="영문/숫자 8~20자리" />
												<br>
												<input type="password" name="pwdCheck" id="pwdCheck" placeholder="위와 동일하게 입력" />
											</td>
											<td></td>
										</tr>
										<tr>
											<td>
												<label for="name" class="align-center">이름</label>
											</td>	
											<td>
												<input type="text" name="name" id="name" placeholder="한글 2~6자" />
											</td>
											<td></td>
										</tr>
										<tr>
											<td>
												<label for="email" class="align-center">이메일</label>
											</td>
											<td>
												<input type="email" name="email" id="email"  placeholder="이메일 입력" />
											</td>
											<td>
												<button type="button" class="button alt small">중복 확인</button>
											</td>
										</tr>
										<tr>
											<td>
												<label for="phone" class="align-center">핸드폰번호</label>
											</td>
											<td>
												<input type="text" name="phone" id="phone"  placeholder="이메일 입력" />
											</td>
											<td>
												<button type="button" class="button alt small">중복 확인</button>
											</td>
										</tr>
									</tbody>
									<tfoot>
										<tr>
											<td colspan="3">
											</td>
										</tr>
										<tr>
											<td colspan="3">
												<input type="checkbox" name="agreeAll" id="agreeAll" />
												<label for="agreeAll">전체 동의</label>
											</td>
										</tr>
										<tr>
											<td colspan="3"> 
												<input type="checkbox" name="agreePrivInfo" id="agreePrivInfo" />
												<label for="agreePrivInfo">개인정보 수집 및 이용 동의</label>
												<input type="checkbox" name="agreeTerms" id="agreeTerms" />
												<label for="agreeTerms">회원 약관 동의</label>
											</td>
										</tr>										
									</tfoot>
								</table>
							</div>
		
							<!-- <div class="6u$ 12u$(small)">
								<label>이름</label>	
								<input type="text" name="name" id="name" placeholder="한글 2~6자" />
							</div>
							<div class="6u$ 12u$(small)">
								<label>이메일</label>	
								<input type="email" name="email" id="email"  placeholder="이메일 입력" />
							</div>
							<div class="6u$ 12u$(small)">
								<label>핸드폰번호</label>	
								<input type="text" name="phone" id="phone"  placeholder="'-' 기호 제외 입력" />
							</div>
							<div class="6u$ 12u$(small)">
								<input type="checkbox" name="agreeAll" id="agreeAll" />
								<label for="agreeAll">전체 동의</label>	
							</div>
							<div class="6u$ 12u$(xsmall)">								
								<input type="checkbox" name="agreePrivInfo" id="agreePrivInfo" />
								<label for="agreePrivInfo">개인정보 수집 및 이용 동의</label>
							</div>
							<div class="6u$ 12u$(xsmall)">								
								<input type="checkbox" name="agreeTerms" id="agreeTerms" />
								<label for="agreeTerms">회원 약관 동의</label>
							</div> -->
						</div>
					</form>
					<button type="button" id="joinBtnBtn" name="joinBtn" class="button special fit">회원 가입</button>
				</div>
			</div>
		<div>join.jsp 화면</div>
		<div>아이디, 비밀번호, 비밀번호확인, 이름, 이메일, 핸드폰번호, 약관동의 체크박스 입력 폼</div>
		<div>회원가입하기 버튼 : 입력 버튼 누르고 성공시 메인페이지 이동 및 메뉴 접근 가능! 로그인 버튼 대신 마이페이지 메뉴 생성?</div>
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