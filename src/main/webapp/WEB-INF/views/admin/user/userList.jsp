<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/admin/admin.jspf"%>
<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
	<div
		class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
		<h1 class="h2">회원 목록</h1>
	</div>
	<div class="container">
		<!-- 여기에 페이지 구현하세요 -->		
		<div id="userList">
			<table class="table table-bordered">
				<thead>
					<tr class="text-center">
					<!-- 12 -->
						<th class="col-md-1">ID</th>
						<th class="col-md-1">이름</th>
						<th class="col-md-2">이메일</th>
						<th class="col-md-2">핸드폰번호</th>
						<th class="col-md-1">가입일</th>
						<th class="col-md-1">활동상태</th>
						<th class="col-md-1">제재횟수</th>
						<th class="col-md-1">봉사횟수</th>
						<th class="col-md-1">봉사레벨</th>
						<th class="col-md-1">입양여부</th>
					</tr>
				</thead>
				<tbody id="list">
					<c:choose>
						<c:when test="${not empty userList}">
							<c:forEach var="user" items="${userList}" varStatus="status">
								<tr class="text-center" data-num="${user.userId}">
									<td class="text-center">${user.userId}</td>
									<td class="text-center">${user.userName}</td>
									<td class="text-center">${user.userEmail}</td>
									<td class="text-center">${user.userPhone}</td>
									<td class="text-center">${user.userDate}</td>
									<td class="text-center">
										<c:choose>
											<c:when test="${user.userAct==1}">
												활동
											</c:when>
											<c:when test="${user.userAct==2}">
												활동중지
											</c:when>
											<c:when test="${user.userAct==0}">
												비활동(탈퇴)
											</c:when>
										</c:choose>
									</td>
									<td class="text-center">${user.userRepcnt}</td>
									<td class="text-center">${user.userVolcnt}</td>
									<td class="text-center">${user.userLevel}</td>
									<td class="text-center">
										<c:choose>
											<c:when test="${user.userAdoptChk==1}">
												입양회원
											</c:when>
											<c:when test="${user.userAdoptChk==0}">
												없음
											</c:when>
										</c:choose>
									</td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td colspan="12" class="text-center">가입한 회원 내역이 존재하지 않습니다.</td>
							</tr>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		
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
