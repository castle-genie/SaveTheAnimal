<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<meta name="robots"
	content="index, follow, max-image-preview:large, max-snippet:-1, max-video-preview:-1">
<link rel="stylesheet" href="/resources/include/assets2/css/main.css">

</head>
<body class="subpage">

	<%@ include file="/WEB-INF/views/project/generic.jspf"%>

	<!-- One -->
	<section id="One" class="wrapper style3">
		<div class="inner">
			<header class="align-center">
				<p>Save The Animal</p>
				<h2>자유게시판</h2>
			</header>
		</div>
	</section>
	<!-- Two -->
	<section id="two" class="wrapper style2">
		<div class="inner">
			<div class="box">
				<div class="content">
					<div class="table-wrapper">
						<table class="alt">
							<thead>
								<tr class="text-center">
									<td>제목</td>
									<td>작성자</td>
									<td>조회수</td>
									<td>작성일</td>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${freeBoardList}" var="list">
									<tr>
										<td><a
											href="freeBoardDetail?fboardId=${list.fboardId}&userId=<%= session.getAttribute("userId") %>">
												${list.fboardTitle} </a></td>
										<td>${list.userId }</td>
										<td>${list.fboardCnt }</td>
										<td><fmt:formatDate value="${list.fboardDate }"
												pattern="yyyy.MM.dd" /></td>
										<!-- <td>${list.fboardDate }</td> -->
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<br>
					<c:if test="${empty userLogin}">
						<ul class="actions">
							<li><a href="/user/login" class="button special"
								onclick="alert('글을 작성하려면 로그인이 필요합니다')">글쓰기</a></li>
						</ul>
					</c:if>
					<c:if test="${not empty userLogin}">
						<ul class="actions">
							<li><a href="/board/freeBoardCreate" class="button special">글쓰기</a></li>
						</ul>
					</c:if>
				</div>
			</div>
		</div>
	</section>
	<!-- Footer -->
	<footer id="footer">
		<div class="container">
			<ul class="icons">
				<li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
				<li><a href="#" class="icon fa-facebook"><span
						class="label">Facebook</span></a></li>
				<li><a href="#" class="icon fa-instagram"><span
						class="label">Instagram</span></a></li>
				<li><a href="#" class="icon fa-envelope-o"><span
						class="label">Email</span></a></li>
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
</body>
<script>
</script>
</html>