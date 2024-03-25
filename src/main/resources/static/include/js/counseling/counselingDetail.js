document.getElementById("sanctionBtn").addEventListener("click", function() {
    // 수정하기 버튼을 클릭하면 해당 상담 정보의 ID를 가져옴
    var counselingId = "<%= counseling.getCounselingId() %>";

    // 수정 페이지로 이동하기 위해 URL을 생성
    var editUrl = "/adminCounselingEdita?counselingId=" + counselingId;

    // 페이지 이동
    window.location.href = editUrl;
});
$(function(){
    // 상담 상세 정보를 가져오는 함수 정의
    function getCounselingDetail() {
        const counselingId = $(this).closest('tr').data('counselingId');
        // counseling 객체에서 상담 ID를 가져옵니다.
        const url = "/counseling/adminCounselingDetail"; // 상세 정보를 가져오는 URL에 맞게 수정해야 합니다.

        // AJAX 요청을 수행하고 상담 상세 정보를 가져옵니다.
        $.ajax({
            type: "post",
            url: url,
            data: { counselingId: counselingId },
            success: function(response) {
                // 받은 데이터를 이용하여 HTML 엘리먼트에 정보를 채워넣습니다.
                $("#counselingId").text(response.counselingId);
                $("#counselingSchedule").text(response.counselingSchedule);
                $("#userId").text(response.userId);
                $("#adoptionId").text(response.adoptionId);
                $("#animalId").text(response.animalId);
                $("#counselingDate").text(response.counselingDate);
                $("#counselingJudgment").text(response.counselingJudgment);
                $("#counselingDetail").text(response.counselingDetail);
                $("#counselingAdopt").text(response.counselingAdopt);
            },
            error: function(error) {
                // 에러 처리
                console.error("상담 상세 정보를 가져오는데 실패했습니다:", error);
            }
        });
    }

    // 상담 상세 정보 가져오기 함수 호출
    getCounselingDetail();
});
