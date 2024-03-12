<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=3.0" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		
		<title>Insert title here</title>
		
		<link rel="shortcut icon" href="/resources/image/icon.png" />
		<link rel="apple-touch-icon" href="/resources/image/icon.png" />
		
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" />
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
		<script src="/resources/include/js/jquery-3.7.1.min.js"></script>
		<script src="/resources/include/js/common.js"></script>
	</head>
	<body>
		<div class="container">
		<div>findIdForm.jsp : 아이디 찾기 이메일 입력 폼</div>
		
		<form id="findId">
			<label for="userEmail">이메일</label>
			<input type="email" id="userEmail" name="userEmail" placeholder="이메일 입력해 주세요" />	
		</form>
		<button type="button" id="findIdBtn" name="findIdBtn">아이디 찾기</button>
		
		<div>findId.jsp : 아이디 찾기 성공 페이지 - 아이디 보여주기</div>
		<div> 로그인 페이지로 돌아가기 </div>
		
		</div>
		
		<!-- 모달 예시 1-->
		<div class="modal modal-sheet position-static d-block bg-body-secondary p-4 py-md-5" tabindex="-1" role="dialog" id="modalSheet">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content rounded-4 shadow">
		      <div class="modal-header border-bottom-0">
		        <h1 class="modal-title fs-5">아이디 찾기 성공</h1>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <div class="modal-body py-0">
		        <p>아이디 확인하는 영역</p>
		        <p>회원님의 아이디는 XXXX입니다.</p>
		      </div>
		      <div class="modal-footer flex-column align-items-stretch w-100 gap-2 pb-3 border-top-0">
		        <button type="button" class="btn btn-primary">로그인 하기</button>
		        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">비밀번호 재설정</button>
		      </div>
		    </div>
		  </div>
		</div>	
		
		
		
		
		<!-- 모달 예시 2-->
		<div class="modal modal-sheet position-static d-block bg-body-secondary p-4 py-md-5" tabindex="-1" role="dialog" id="modalSignin">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content rounded-4 shadow">
		      <div class="modal-header p-5 pb-4 border-bottom-0">
		        <h1 class="fw-bold mb-0 fs-2">아이디 찾기</h1>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>

		      <div class="modal-body p-5 pt-0">
		        <form class="">
		          <div class="form-floating mb-3">
		            <input type="email" class="form-control rounded-3" id="floatingInput" placeholder="name@example.com">
		            <label for="floatingInput">Email 입력</label>
		          </div>
		          <button class="w-100 mb-2 btn btn-lg rounded-3 btn-primary" type="submit">아이디 찾기</button>
		          <small class="text-body-secondary">가입시 등록한 이메일로 회원 아이디를 확인할 수 있습니다.</small>
		          <!--<hr class="my-4">
		          
		           <h2 class="fs-5 fw-bold mb-3">Or use a third-party</h2>
		          <button class="w-100 py-2 mb-2 btn btn-outline-secondary rounded-3" type="submit">
		            <svg class="bi me-1" width="16" height="16"><use xlink:href="#twitter"/></svg>
		            Sign up with Twitter
		          </button>
		          <button class="w-100 py-2 mb-2 btn btn-outline-primary rounded-3" type="submit">
		            <svg class="bi me-1" width="16" height="16"><use xlink:href="#facebook"/></svg>
		            Sign up with Facebook
		          </button>
		          <button class="w-100 py-2 mb-2 btn btn-outline-secondary rounded-3" type="submit">
		            <svg class="bi me-1" width="16" height="16"><use xlink:href="#github"/></svg>
		            Sign up with GitHub
		          </button> -->
		        </form>
		      </div>
		    </div>
		  </div>
		</div>
		
	</body>
</html>