$(function() {
	/* 제출 버튼 클릭 시 처리 이벤트 */
	$("#updateBtn").on("click", function() {
		if(!chkData("#volunteerTitle", "제목을")) return;
		/*else if(!chkData("#volunteerTime", "활동 기간을")) return;
		else if(!chkData("#volunteerDue", "마감 기한을")) return;
		else if(!chkData("#volunteerLimit", "제한 인원을")) return;
		else if(!chkData("#volunteerLocation", "활동 장소를")) return;
		else if(!chkData("#volunteerDetail", "세부사항을")) return;*/
		
		else {
			// 봉사활동 신청 마감일을 ISO 8601 형식으로 변환
            /*var volunteerDue = $('#volunteerDue').val();
            console.log(volunteerDue);
            var formattedVolunteerDue = volunteerDue.replace('T', ' ').substring(0, 19); // T 문자 제거 후 뒷부분 삭제
            console.log(formattedVolunteerDue);
            $('#volunteerDue').val(formattedVolunteerDue); */
            
			$("#updateForm").attr({
				method : "post",
				action : "/volunteer/volunteerUpdate"
			});
			$("#updateForm").submit();
		}
	})
})

