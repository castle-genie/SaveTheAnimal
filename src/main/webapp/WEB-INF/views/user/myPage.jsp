<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp" %>
	<meta name="robots" content="index, follow, max-image-preview:large, max-snippet:-1, max-video-preview:-1">
	<link rel="stylesheet" href="/resources/include/assets2/css/main.css">
	
</head>
<body class="subpage">

<%@ include file="/WEB-INF/views/project/generic.jspf" %>   

	<!-- One -->
	<section id="One" class="wrapper style3">
		<div class="inner">
			<header class="align-center">
				<p>Save The Animal</p>
				<h2>My page</h2>
			</header>
		</div>
	</section>

	<!-- Two -->
	<section id="two" class="wrapper style2">
		<div class="inner">
			<div class="box">
				<div class="content">
				<c:if test="${empty userLogin}">
				  	<h4>로그인이 필요합니다</h4>
				  	<a href="/login">로그인 바로가기</a>
				</c:if>
				<c:if test="${not empty userLogin}">
					<header class="align-center">
						<p>Save The Animal</p>
						<h2>회원 정보</h2>
					</header>
					
					<div class="grid">
						<!-- 회원 프로필 -->
						<div class="image fit">   	
							<div class="my-3 p-4 bg-body rounded shadow-sm">
							    <h4 class="border-bottom pb-2 mb-0"><strong>My Profile</strong></h4>
							    <!-- 사용자 정보 출력 -->
							    <div class="d-flex text-body-secondary pt-3">
							      <svg class="bd-placeholder-img flex-shrink-0 me-2 rounded" width="20" height="32" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: 32x32" preserveAspectRatio="xMidYMid slice" focusable="false">
								      <rect width="100%" height="100%" fill="#fff"/>											      
							      </svg>
							      <div class="pb-3 mb-0 small lh-sm border-bottom w-100">
							        <div class="d-flex justify-content-between">
							          <strong class="text-gray-dark">이름</strong>
							        </div>
							        <!-- 사용자 이름 출력 -->
							        <span class="d-block">${userInfo.userName}</span>
							      </div>
							    </div>
							    <div class="d-flex text-body-secondary pt-3">
							      <svg class="bd-placeholder-img flex-shrink-0 me-2 rounded" width="20" height="32" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: 32x32" preserveAspectRatio="xMidYMid slice" focusable="false">
								      <rect width="100%" height="100%" fill="#fff"/>
							      </svg>     
							 		<div class="pb-3 mb-0 small lh-sm border-bottom w-100">
							        <div class="d-flex justify-content-between">
							          <strong class="text-gray-dark">이메일</strong>
							        </div>
							        <span class="d-block">${userInfo.userEmail}</span>
							      </div>
							    </div>
							    <div class="d-flex text-body-secondary pt-3">
									<svg class="bd-placeholder-img flex-shrink-0 me-2 rounded" width="20" height="32" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: 32x32" preserveAspectRatio="xMidYMid slice" focusable="false">
								      <rect width="100%" height="100%" fill="#fff"/>
							      	</svg>
									<div class="pb-3 mb-0 small lh-sm border-bottom w-100">
							        <div class="d-flex justify-content-between">
							          <strong class="text-gray-dark">핸드폰번호</strong>
							        </div>
							        <span class="d-block">${userInfo.userPhone}</span>
							      	</div>
							    </div>
							    <small class="d-block text-end mt-3">
							      <button type="button" id="goUpdateBtn" class="btn btn-small">회원정보 수정</button>
							    </small>
							  </div>					
						</div>

						<!-- 활동 내역 -->						
		 				<div class="image fit">
							<div class="my-3 p-4 bg-body rounded shadow-sm">
							    <h4 class="border-bottom pb-2 mb-0"><strong>My Activities</strong></h4>										    
							    <br/>
							    <p class="align-right">
							    	봉사 레벨 : <strong>Lv. ${userInfo.userLevel}</strong><br>
							    	봉사 횟수 : <strong>${userInfo.userLevel}</strong> 회
							    </p>
							    <div class="d-flex text-body-secondary pt-3">
							      <svg class="bd-placeholder-img flex-shrink-0 me-2 rounded" width="20" height="32" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: 32x32" preserveAspectRatio="xMidYMid slice" focusable="false">
								      <rect width="100%" height="100%" fill="#fff"/>								      
							      </svg>
							      <div class="pb-3 mb-0 small lh-sm border-bottom w-100">
							        <div class="d-flex justify-content-between">
							          <strong class="text-gray-dark">봉사활동 신청내역</strong>
							          <a href="#">확인하기</a>
							        </div>
							        <span class="d-block">신청한 봉사 일정 보여주기</span>
							      </div>
							    </div>
							    <div class="d-flex text-body-secondary pt-3">
							      <svg class="bd-placeholder-img flex-shrink-0 me-2 rounded" width="20" height="32" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: 32x32" preserveAspectRatio="xMidYMid slice" focusable="false">
								      <rect width="100%" height="100%" fill="#fff"/>								      
							      </svg>     
							 		<div class="pb-3 mb-0 small lh-sm border-bottom w-100">
							        <div class="d-flex justify-content-between">
							          <strong class="text-gray-dark">입양 · 임시보호 신청내역</strong>
							          <a href="#">확인하기</a>
							        </div>
							        <span class="d-block">입양 및 임시보호 신청 내역 및 결과 확인</span>
							      </div>
							    </div>
							    <div class="d-flex text-body-secondary pt-3">
									<svg class="bd-placeholder-img flex-shrink-0 me-2 rounded" width="20" height="32" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: 32x32" preserveAspectRatio="xMidYMid slice" focusable="false">
								      <rect width="100%" height="100%" fill="#fff"/>								      
							      	</svg>
									<div class="pb-3 mb-0 small lh-sm border-bottom w-100">
							        <div class="d-flex justify-content-between">
							          <strong class="text-gray-dark">작성 글 히스토리</strong>
							          <a href="/profile">확인하기</a>
							        </div>
							        <span class="d-block">게시판 작성 글 확인</span>
							      	</div>
							    </div>
							    <small class="d-block text-end mt-3">
							      <a href="#"></a>
							    </small>
							  </div>					
						</div>

						<!-- 기부 후원 내역 -->
					 	<div class="image fit">			
							<div class="my-3 p-4 bg-body rounded shadow-sm">
							    <h4 class="border-bottom pb-2 mb-0"><strong>My Donations</strong></h4>
							    <div class="d-flex text-body-secondary pt-3">
							      <svg class="bd-placeholder-img flex-shrink-0 me-2 rounded" width="20" height="32" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: 32x32" preserveAspectRatio="xMidYMid slice" focusable="false">
								      <rect width="100%" height="100%" fill="#fff"/>
							      </svg>
							      <div class="pb-3 mb-0 small lh-sm border-bottom w-100">
							        <div class="d-flex justify-content-between">
							          <strong class="text-gray-dark">후원 내역</strong>
							          <a href="#"></a>
							        </div>
							        <span class="d-block">후원 시작일, 후원 금액, 후원 누적 금액 확인</span>
							      </div>
							    </div>
							    <div class="d-flex text-body-secondary pt-3">
							      <svg class="bd-placeholder-img flex-shrink-0 me-2 rounded" width="20" height="32" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: 32x32" preserveAspectRatio="xMidYMid slice" focusable="false">
								      <rect width="100%" height="100%" fill="#fff"/>
							      </svg>     
							 		<div class="pb-3 mb-0 small lh-sm border-bottom w-100">
							        <div class="d-flex justify-content-between">
							          <strong class="text-gray-dark">결제 정보</strong>
							          <a href="#"></a>
							        </div>
							        <span class="d-block">결제 예정일, 결제 정보 내역 확인</span>
							      </div>
							    </div>							 
							    <small class="d-block text-end mt-3">
							      <a href="#">확인하기</a>
							    </small>
							  </div>					
						</div>
						<hr>
						<small class="d-block text-end mt-3">
							<button type="button" id="logoutBtn" class="btn btn-small">로그아웃</button>
						</small>
					</div>				
				</c:if>
										
				</div>
				<hr>
				<div>myPage.jsp 화면</div>
				<div>하위 메뉴 배치 해서 회원정보 ajax로 불러오기</div>
				<div>내 정보 수정 : updateProfile.jsp</div>
				<div>나의 활동, 후원 정보 : 각각 해당 페이지로 이동하여 확인하게 할지? 아니면 현재 화면에서 불러오기로 할지?</div>
				<hr>
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
	<script src="/resources/include/assets2/js/jquery.min.js"></script>
	<script src="/resources/include/assets2/js/jquery.scrollex.min.js"></script>
	<script src="/resources/include/assets2/js/skel.min.js"></script>
	<script src="/resources/include/assets2/js/util.js"></script>
	<script src="/resources/include/assets2/js/main.js"></script>
	<script>	
		$(function(){
			// 회원 정보 수정 이동 
			$("#goUpdateBtn").on("click", function(){				
				location.href="/updateProfile";
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
