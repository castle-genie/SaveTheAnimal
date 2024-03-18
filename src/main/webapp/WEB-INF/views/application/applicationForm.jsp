<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1" />		
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
		<title>Insert title here</title>
		<link rel="shortcut icon" href="/resources/image/icon.png" />
		<link rel="apple-touch-icon" href="/resources/image/icon.png" />
		
		<link rel="stylesheet" type="text/css" href="/resources/include/css/application/applicationForm.css" />
		
	</head>
	<body>
		<div class="container">
		    <form id="volunteerForm">
		      <h2>봉사활동 신청</h2>
		      <!-- 아이디 입력란(백엔드에서 처리) -->
		      <!-- 봉사공고 아이디(팝업 뜨게한 버튼 누른 페이지의 volunteerId) -->
		      <input type="hidden" id="volunteerId" name="volunteerId" value="여기에_봉사공고_아이디_입력">
		      <!-- 로그인 정보로 얻어온 회원 아이디(백엔드에서 처리) -->
		      <input type="hidden" id="userId" name="userId" value="여기에_회원_아이디_입력">
		      <div class="form-group">
		        <!-- 봉사 다짐 입력란 -->
		        <label for="promise">봉사 다짐</label>
		        <textarea id="promise" name="promise" rows="4" required></textarea>
		      </div>
		      <button type="submit" id="applicationBtn">신청하기</button>
		    </form>
		  </div>
	</body>
</html>