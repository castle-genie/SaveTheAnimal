<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
                        <h5 class="card-title">예약 고유 ID: ${counseling.counselingId}</h5>
                        <p class="card-text">예약일정: ${counseling.counselingSchedule}</p>
                        <p class="card-text">회원ID: ${counseling.userId}</p>
                        <p class="card-text">입양공고ID: ${counseling.adoptionId}</p>
                        <p class="card-text">동물ID: ${counseling.animalId}</p>
                        <p class="card-text">예약신청일자: ${counseling.counselingDate}</p>
                        <p class="card-text">적격판정: ${counseling.counselingJudgment}</p>
                        <p class="card-text">상담내용: ${counseling.counselingDetail}</p>
                        <p class="card-text">입양/임시보호구분: ${counseling.counselingAdopt}</p>
                    </div>
                </div>
                <button type="button" id="sanctionBtn" class="btn btn-success btn-sm">수정하기</button>

            </div>
        </div>

    </div>
</main>
</div>
</div>
<script src="/resources/include/assets/dist/js/bootstrap.bundle.min.js"></script>
<script src="/resources/include/js/counseling/counselingDetail.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js@4.3.2/dist/chart.umd.js" integrity="sha384-eI7PSr3L1XLISH8JdDII5YN/njoSsxfbrkCTnJrzXt+ENP5MOVBxD+l6sEG4zoLp" crossorigin="anonymous"></script>
<script src="/resources/include/js/dashboard.js"></script>
</body>
</html>
