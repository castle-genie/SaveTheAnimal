
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
							<li><input type="button" value="수정"
								onclick="location.href='freeBoardModify?fboardId=${freeBoard.fboardId}'"></li>
							<li><input type="button" value="삭제"
								onclick="del(${freeBoard.fboardId})"></li>
						</c:if>
						<c:if test="${empty userLogin}">
<<<<<<< HEAD
							<li><a href="/user/login"
								onclick="alert('신고하려면 로그인이 필요합니다')">
									<button type="button" class="btn btn-primary button special">신고</button>
							</a></li>
						</c:if>
						<c:if test="${not empty userLogin}">
							<li><%@ include
									file="/WEB-INF/views/report/fbReportInsert.jsp"%></li>
=======
							<li>
								<a href="/user/login" onclick="alert('신고하려면 로그인이 필요합니다')">
									<button type="button" class="btn btn-primary button special">신고</button>
								</a>
							</li>
						</c:if>
						<c:if test="${not empty userLogin}">
							<c:choose>
								<c:when test="${freeBoard.reUserId eq sessionScope.userId}">
									<li><%@ include file="/WEB-INF/views/report/fbReportUpdate.jsp"%></li>
								</c:when>
								<c:otherwise>
									<li><%@ include file="/WEB-INF/views/report/fbReportInsert.jsp"%></li>
								</c:otherwise>
								
							</c:choose>
>>>>>>> a85d71ee7582a32dafdaf288a388a4093451ac06
						</c:if>
					</ul>
					<%@ include file="/WEB-INF/views/board/fcomment.jsp"%>
				</div>
				<!-- 댓글 시작 -->
<<<<<<< HEAD
				<div>
					<hr />
					<div>
						<input type="text" id="userId" placeholder="댓글작성자">
						<input type="text" id="fcommentContent" placeholder="댓글내용">
						<button id="comment-write-btn" onclick="commentWrite()">댓글작성</button>
					</div>
				</div>
				<!-- 댓글 종료 -->
=======
>>>>>>> a85d71ee7582a32dafdaf288a388a4093451ac06
			</div>
		</div>
		<!-- 댓글 종료 -->
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
	<script src="/resources/include/js/reportUpdate.js"></script>

</body>
<script>
	function del(fboardId) {
		var chk = confirm("정말 삭제하시겠습니까?");
		if (chk) {
			location.href='delete?fboardId='+fboardId;
		}
	}
	const commentWrite = () =>{
		const writer = document.getElementById("userId").value;
		const contents = document.getElementById("fcommentContent").value;
		const board = '${freeBoard.fboardId}';
		$.ajax({
			type: "post",
			url: "/comment/save",
			data: {
				userId: writer,
				fcommentContent: contents,
				fboardId: board
			},
			dataType: "json",
			success: function(commentList){
				console.log("댓글작성완료");
			},
			error: function() {
				console.log("댓글작성실패");
			}
		});
	}
</script>
</html>