<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<meta name="robots"
	content="index, follow, max-image-preview:large, max-snippet:-1, max-video-preview:-1">
<link rel="stylesheet" href="/resources/include/assets2/css/main.css">
<link rel="stylesheet"
	href="/resources/include/css/application/applicationView.css">

<script src="/resources/include/js/application/applicationView.js"></script>
</head>
<body class="subpage">

	<%@ include file="/WEB-INF/views/project/generic.jspf"%>

	<!-- One -->
	<section id="One" class="wrapper style3">
		<div class="inner">
			<header class="align-center">
				<p>Save The Animal</p>
				<h2>작성 글 히스토리</h2>
			</header>
		</div>
	</section>

	<!-- Two -->
	<section id="two" class="wrapper style2">
		<%-- post방식으로 전송 시 반드시 form 태그 추가해주어야 합니다. --%>
		<%-- <form name="f_data" id="f_data" method="get">
			<input type="hidden" name="applicationId" id="applicationId">
			<input type="hidden" name="userId" id="userId" value="${ userLogin.userId }" />
		</form> --%>
		<div class="inner">
			<div class="box">
				<div class="content">
					<c:if test="${empty userLogin}">
						<h4>로그인이 필요합니다</h4>
						<a href="/user/login" class="button">로그인 바로가기</a>
					</c:if>
					<c:if test="${not empty userLogin}">
						<div class="grid">
							<div class="image fit">
								<div class="my-3 p-4 bg-body rounded shadow-sm">
									<h4 class="border-bottom pb-2 mb-0">
										<strong>My History</strong>
									</h4>
									<br />
									<h5>
										<strong>자유게시판</strong>
									</h5>
									<div id="appView">
										<table id="appliTable">
											<thead>
												<tr class="text-center">
													<th class="col-md-1">작성일${freeBoardList.fboardTitle}</th>
													<th class="col-md-6">제목</th>
												</tr>
											</thead>
											<tbody>
												<c:choose>
													<c:when test="${ not empty view }">
														<tr class="text-center" data-id="${ list.applicationId }"
															data-num="${ list.applicationResult }">
															<td>${ freeBoard.fboard_date }</td>
															<td>${ list.volunteer.volunteerTitle }</td>
															<td>${ list.volunteer.volunteerTime }</td>
														</tr>
													</c:when>
													<c:otherwise>
														<tr>
															<td colspan="4" class="text-center">작성한 글이 없습니다.</td>
														</tr>
													</c:otherwise>
												</c:choose>
											</tbody>
										</table>
									</div>
									<h5>
										<strong>봉사후기 게시판</strong>
									</h5>
									<div id="appView">
										<table id="appliTable">
											<thead>
												<tr class="text-center">
													<th class="col-md-1">작성일</th>
													<th class="col-md-6">제목</th>
												</tr>
											</thead>
											<tbody>
												<c:choose>
													<c:when test="${ not empty view }">
														<tr class="text-center" data-id="${ list.applicationId }"
															data-num="${ list.applicationResult }">
															<td>${ freeBoard.fboard_date }</td>
															<td>${ list.volunteer.volunteerTitle }</td>
															<td>${ list.volunteer.volunteerTime }</td>
														</tr>
													</c:when>
													<c:otherwise>
														<tr>
															<td colspan="4" class="text-center">작성한 글이 없습니다.</td>
														</tr>
													</c:otherwise>
												</c:choose>
											</tbody>
										</table>
									</div>
									<h5>
										<strong>입양후기 게시판</strong>
									</h5>
									<div id="appView">
										<table id="appliTable">
											<thead>
												<tr class="text-center">
													<th class="col-md-1">작성일</th>
													<th class="col-md-6">제목</th>
												</tr>
											</thead>
											<tbody>
												<c:choose>
													<c:when test="${ not empty view }">
														<tr class="text-center" data-id="${ list.applicationId }"
															data-num="${ list.applicationResult }">
															<td>${ freeBoard.fboard_date }</td>
															<td>${ list.volunteer.volunteerTitle }</td>
															<td>${ list.volunteer.volunteerTime }</td>
														</tr>
													</c:when>
													<c:otherwise>
														<tr>
															<td colspan="4" class="text-center">작성한 글이 없습니다.</td>
														</tr>
													</c:otherwise>
												</c:choose>
											</tbody>
										</table>
									</div>
									<small class="d-block text-end mt-3"> <a href="#"></a>
									</small>
									<%--============ 페이징 출력 시작 ============--%>
									<nav aria-label="Page navigation example">
										<form id="page" name="page">
											<input type="hidden" name="userId" id="userId"
												value="${ userLogin.userId }" /> <input type="hidden"
												name="pageNum" id="pageNum"
												value="${ pageMaker.cvo.pageNum }" /> <input type="hidden"
												name="amount" id="amount" value="${ pageMaker.cvo.amount }" />
										</form>
										<ul class="pagination justify-content-center">
											<!-- 이전 바로가기 10개 존재 여부를 prev 필드의 값으로 확인 -->
											<c:if test="${pageMaker.prev}">
												<li class="page-item"><a
													href="${pageMaker.startPage - 1}" class="page-link">Previous</a>
													<%-- <a href="${pageMaker.startPage - 10}" class="page-link">Previous</a> --%>
												</li>
											</c:if>

											<!-- 바로가기 번호 출력 -->
											<c:forEach var="num" begin="${pageMaker.startPage}"
												end="${pageMaker.endPage}">
												<li
													class="page-item ${pageMaker.cvo.pageNum == num ? 'active':''}">
													<a href="${num}" class="page-link">${num}</a>
												</li>
											</c:forEach>

											<!-- 다음 바로가기 10개 존재 여부를 next 필드의 값으로 확인 -->
											<c:if test="${pageMaker.next}">
												<li class="page-item"><a
													href="${pageMaker.endPage + 1}" class="page-link">Next</a>
												</li>
											</c:if>
										</ul>
									</nav>
								</div>
							</div>
						</div>
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

</html>
