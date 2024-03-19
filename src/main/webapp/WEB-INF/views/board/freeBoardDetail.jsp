
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%> 
<meta name="robots" content="index, follow, max-image-preview:large, max-snippet:-1, max-video-preview:-1">
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
					<header class="align-center">
						<p>부제목</p>
						<h2>${freeBoard.fboardTitle}</h2>
					</header>
					<div>
						<pre>${freeBoard.fboardContent}</pre>
					</div>
					<p>
						작성자: ${freeBoard.userId} <span style="float: right;"><fmt:formatDate
								value="${freeBoard.fboardDate }" pattern="yyyy.MM.dd" /></span>
					</p>
					<br>
					<ul class="actions text-end">
						<li><a href="freeBoardList" class="button special">목록</a></li>
						<c:if test="${sessionScope.userId eq freeBoard.userId}">
							<li><input type="button" value="수정" onclick="location.href='freeBoardModify?fboardId=${freeBoard.fboardId}'"></li>
							<li><input type="button" value="삭제" onclick="del(${freeBoard.fboardId})"></li>
							</c:if>
						<c:if test="${empty userLogin}">
						<li>
							<a href = "/user/login" onclick="alert('신고하려면 로그인이 필요합니다')">
								<button type="button" class="btn btn-primary button special">신고</button>
							</a>
						</li>
						</c:if>
						<c:if test="${not empty userLogin}">
							<li><%@ include file="/WEB-INF/views/report/fbReportInsert.jsp"%></li>
						</c:if>
					</ul>
				</div>
				<!-- 댓글 시작 -->
				<div>
				<hr />
				<ul>
					<!--  
					<li>
						<div>
							<p>첫번째 댓글 작성자</p>
							<p>첫번째 댓글</p>
						</div>
					</li>
					<li>
						<div>
							<p>두번째 댓글 작성자</p>
							<p>두번째 댓글</p>
						</div>
					</li>
					<li>
						<div>
							<p>세번째 댓글 작성자</p>
							<p>세번째 댓글</p>
						</div>
					</li>
					-->
					<c:forEach items="${fcomment}" var="fcomment">
					<li>
						<div>
							<p>${fcomment.userId} / ${fcomment.fcommentDate}</p>
							<p>${fcomment.fcommentContent}</p>
						</div>
					</li>
					</c:forEach>
				</ul>
				<div>
					<form method="post" action="/reply/write">

						<p>
							<label>댓글 작성자</label> <input type="text" name="writer">
						</p>
						<p>
							<textarea rows="5" cols="50" name="content"></textarea>
						</p>
						<p>
							<input type="hidden" name="fboardId" value="${freeBoard.fboardId}">
							<button type="submit">댓글 작성</button>
						</p>
					</form>
				</div>
				</div>
				<!-- 댓글 종료 -->
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
	<script src="/resources/include/js/reportInsert.js"></script>

</body>
<script>
	function del(fboardId) {
		var chk = confirm("정말 삭제하시겠습니까?");
		if (chk) {
			location.href='delete?fboardId=' + fboardId;
		}
	}
</script>
</html>
