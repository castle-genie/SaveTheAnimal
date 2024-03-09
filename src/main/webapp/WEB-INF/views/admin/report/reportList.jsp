<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/admin/admin.jspf"%>
<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
	<div
		class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
		<h1 class="h2">Dashboard</h1>
	</div>
	<div class="container">
	<div class="container">
		<div class="text-start mt-50"><h3>신고 리스트 테스트</h3></div>
		<hr/>
		<div id="reportList">
			<table class="table taple-striped">
				<thead>
					<tr class="text-center">
						<th class="col-md-1">신고번호</th>
						<th class="col-md-2">글분류</th>
						<th class="col-md-4">제목</th>
						<th class="col-md-2">작성자ID(제재횟수)</th>
						<th class="col-md-1">신고분류</th>
						<th class="col-md-1">작성일자</th>
						<th class="col-md-1">신고일자</th>
					</tr>
				</thead>
				<tbody id="list">
					<c:choose>
						<c:when test="${not empty reportList}">
							<c:forEach var="report" items="${reportList}" varStatus="status">
								<tr class="text-center" data-num="${report.reportId}">
									<td class="text-center">${report.reportId}</td>
									<td class="text-center"></td>
									<td class="goDetail text-start"></td>
									<td class="text-center"></td>
									<td class="text-center">${report.reportSort}</td>
									<td class="text-center"></td>
									<td class="text-center">${report.reportDate}</td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td colspan="5" class="text-center">신고된 컨텐츠가 존재하지 않습니다.</td>
							</tr>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		
		</div>
		
		
		
		
	</div>
	</div>

</main>
</div>
</div>
<script src="/resources/include/assets/dist/js/bootstrap.bundle.min.js"></script>

<script
	src="https://cdn.jsdelivr.net/npm/chart.js@4.3.2/dist/chart.umd.js"
	integrity="sha384-eI7PSr3L1XLISH8JdDII5YN/njoSsxfbrkCTnJrzXt+ENP5MOVBxD+l6sEG4zoLp"
	crossorigin="anonymous"></script>
<script src="/resources/include/js/dashboard.js"></script>
</body>
</html>
