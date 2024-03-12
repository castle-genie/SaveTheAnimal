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
		<script src="/resources/js/jquery-3.7.1.min.js"></script>
	</head>
	<body>
		<div>findIdForm.jsp : 아이디 찾기 이메일 입력 폼</div>
		<form id="findId">
			<label for="userEmail">이메일</label>
			<input type="email" id="userEmail" name="userEmail" placeholder="이메일 입력해 주세요" />	
		</form>
		<button type="button" id="findIdBtn" name="findIdBtn">아이디 찾기</button>
	</body>
</html>