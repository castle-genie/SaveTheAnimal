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
		
		<div id="userSearch">
			<form id="f_search" name="f_search">
				<%-- 페이징 처리를 위한 파라미터 --%>
				<input type="hidden" name="pageNum" id="pageNum" value="${pageMaker.cvo.pageNum}"/>
				<input type="hidden" name="amount" id="amount" value="${pageMaker.cvo.amount}"/>
				<div class="row g-2 align-items-center">
					<div class="col-auto">
						<label for="search">검색조건</label>
					</div>
					<div class="col-auto">	
						<select name="search" id="search" class="form-select form-select-sm">
							<option value="all">전체 목록 조회</option>
							<option value="b_title">글제목</option>
							<option value="b_content">글내용</option>
							<option value="b_name">작성자</option>
						</select>
					</div>
					<div class="col-auto">
						<input type="text" name="keyword" id="keyword" placeholder="검색어를 입력하세요"
						class="form-control form-control-sm" />
					</div>
					<div class="col-auto">
						<button type="button" id="searchBtn" class="btn btn-success btn-sm">검색</button>	
					</div>
				</div>
			</form>
		</div>
		

		
		<div id="userList">
			<table class="table table-striped">
				<thead>
					<tr class="text-center">
					<!-- 12 -->
						
						<th class="col-md-1">번호</th>
						<th class="col-md-1">ID</th>
						<th class="col-md-1">이름</th>
						<th class="col-md-2">이메일</th>
						<th class="col-md-2">핸드폰번호</th>
						<th class="col-md-1">봉사Lv</th>
						<th class="col-md-1">입양</th>
						<th class="col-md-1">제재</th>
						<th class="col-md-1">상태</th>
						<th class="col-md-1">가입일</th>
					</tr>
				</thead>
				<tbody id="list">
					<c:choose>
						<c:when test="${not empty userList}">
							<c:forEach var="user" items="${userList}" varStatus="status">
								<tr class="text-center" data-num="${user.userId}">
									<td class="text-center">${status.index + 1}</td>
									<td class="text-center">${user.userId}</td>
									<td class="text-center">${user.userName}</td>
									<td class="text-center">${user.userEmail}</td>
									<td class="text-center">${user.userPhone}</td>	
									
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
									<td class="text-center">${user.userRepcnt}</td>
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
									<td class="text-center">${user.userDate}</td>
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
		
		
		<%--============ 페이징 출력 시작 ============--%>	
		<nav aria-label="Page navigation example">
		  <ul class="pagination justify-content-center">
		  	<!-- 이전 바로가기 10개 존재 여부를 prev 필드의 값으로 확인 -->
		  	<c:if test="${pageMaker.prev}">
			    <li class="page-item">
			      <a href="${pageMaker.startPage - 1}" class="page-link">Previous</a>
			      <%-- <a href="${pageMaker.startPage - 10}" class="page-link">Previous</a> --%>
			    </li>		  	
		 	</c:if>
		 	
		 	<!-- 바로가기 번호 출력 -->
		 	<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
			    <li class="page-item ${pageMaker.cvo.pageNum == num ? 'active':''}">
			    	<a href="${num}" class="page-link">${num}</a>
			    </li>	
		 	</c:forEach>
		 	
		 	<!-- 다음 바로가기 10개 존재 여부를 next 필드의 값으로 확인 -->
			<c:if test="${pageMaker.next}">
			    <li class="page-item">
			      <a href="${pageMaker.endPage + 1}" class="page-link">Next</a>
			    </li>
			</c:if>
		  </ul>
		</nav>	
		
		
		
		
		
		
		
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
<script>
$(function(){
	/* 검색 후 검색 대상과 검색 단어 출력 
	let word="<c:out value='${user.keyword}' />";
	let value="";
	if(word!=""){
		$("#keyword").val("<c:out value='${user.keyword}' />");
		$("#search").val("<c:out value='${user.search}' />");
		
		if($("#search").val()!='b_content'){
			//:contains()는 특정 테스트를 포함한 요소반환
			if($("#search").val()=='b_title') value="#list tr td.goDetail";
			else if($("#search").val()=='b_name') value="#list tr td.name";	
			console.log($(value+":contains('"+word+"')").html());
			//$("#list tr td.goDetail:contains('노력')").html()
			//=> <span class='required'>노력</span>에 대한 명언
			$(value+":contains('"+word+"')").each(function(){
				let regex = new RegExp(word,'gi'); //대소문자 구분없이 모든 패턴 찾기
				$(this).html($(this).html().replace(regex,"<span class='required'>"+word+"</span>"));
			});
		}
	}	*/
	
	/* 페이징 처리 이벤트 */
	$(".page-item a").on("click", function(e){
		e.preventDefault();
		$("#f_search").find("input[name='pageNum']").val($(this).attr("href"));
		goPage();
	});
});

/* 검색을 위한 실질적인 처리 함수 */
function goPage() {
	if($("#search").val()=="all") {
		$("#keyword").val("");
	}
	$("#f_search").attr({
		"method":"get",
		"action":"/user/userList"
	});
	$("#f_search").submit();
}
</script> 
</body>
</html>
