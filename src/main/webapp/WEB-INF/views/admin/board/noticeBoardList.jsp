<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/admin/admin.jspf"%>
<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
	<div
		class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
		<h1 class="h2">공지사항</h1>
	</div>
	<div class="container">
		<!-- 여기에 페이지 구현하세요 -->
		<section id="two" class="wrapper style2">
			<div class="inner">
				<div class="box">
					<div class="content">
						<div class="table-wrapper">
							<table class="alt">
								<thead>
									<tr class="text-center">
										<td>제목</td>
										<td>조회수</td>
										<td>작성일</td>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${noticeBoardList}" var="list">
										<tr>
											<td><a
												href="noticeBoardDetail?nboardId=${list.nboardId}">
													${list.nboardTitle} </a></td>
											<td>${list.nboardCnt }</td>
											<td><fmt:formatDate value="${list.nboardDate }"
													pattern="yyyy.MM.dd" /></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<button type="button" onclick="location.href='/admin/noticeBoardCreate'" 
							class="btn btn-success btn-sm">공지사항 작성</button>
						</div>
					</div>
				</div>
			</div>
		</section>
	</div>


</main>
<script src="/resources/include/assets/dist/js/bootstrap.bundle.min.js"></script>

<script
	src="https://cdn.jsdelivr.net/npm/chart.js@4.3.2/dist/chart.umd.js"
	integrity="sha384-eI7PSr3L1XLISH8JdDII5YN/njoSsxfbrkCTnJrzXt+ENP5MOVBxD+l6sEG4zoLp"
	crossorigin="anonymous"></script>
<script src="/resources/include/js/dashboard.js"></script>
<script src="/resources/include/js/user/userList.js"></script>
</body>
</html>
