<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/admin/admin.jspf"%>
<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
        <h1 class="h2">입양 상담 신청 상세정보</h1>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-md-6 offset-md-3">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">예약 고유 ID: ${adminCounselingDetail.counselingId}</h5>
                        <p class="card-text">예약일정: <input type="date" id="counselingSchedule" value="${adminCounselingDetail.counselingSchedule}"></p>
                        <p class="card-text">회원ID: ${adminCounselingDetail.userId}</p>
                        <p class="card-text">입양공고ID: ${adminCounselingDetail.adoptionId}</p>
                        <p class="card-text">동물ID: ${adminCounselingDetail.animalId}</p>
                        <p class="card-text">예약신청일자: ${adminCounselingDetail.counselingDate}</p>
                        <p class="card-text">적격판정: <input type="text" id="counselingJudgment" value="${adminCounselingDetail.counselingJudgment}"></p>
                        <p class="card-text">상담내용: <textarea id="counselingDetail" rows="5" cols="30">${adminCounselingDetail.counselingDetail}</textarea></p>
                        <p class="card-text">입양/임시보호구분: <input type="text" id="counselingAdopt" value="${adminCounselingDetail.counselingAdopt}"></p>
                    </div>
                </div>
                <button type="button" id="sanctionBtn" class="btn btn-success btn-sm">수정하기</button>
            </div>
        </div>
    </div>
</main>

<script src="/resources/include/assets/dist/js/bootstrap.bundle.min.js"></script>
<script src="/resources/include/js/counseling/admincounselingDetail.js"></script>

<script
        src="https://cdn.jsdelivr.net/npm/chart.js@4.3.2/dist/chart.umd.js"
        integrity="sha384-eI7PSr3L1XLISH8JdDII5YN/njoSsxfbrkCTnJrzXt+ENP5MOVBxD+l6sEG4zoLp"
        crossorigin="anonymous"></script>
<script src="/resources/include/js/dashboard.js"></script>
</body>
</html>

