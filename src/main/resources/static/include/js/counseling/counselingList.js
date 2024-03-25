document.querySelectorAll("#counselingList tbody tr").forEach(function(row) {
    row.querySelector("td:nth-child(7)").addEventListener("click", function() {
        // 해당 상담의 ID 가져오기
        var counselingId = row.querySelector("td:nth-child(1)").innerText; // 예약 고유 ID 열의 값

        // 수정 페이지로 이동하기 위해 URL 생성
        var detailUrl = "/counseling/adminCounselingDetail?counselingId=" + counselingId;

        // 페이지 이동
        window.location.href = detailUrl;
    });
});