$(function(){
	const userId = document.getElementById("userId").value;
	
	$("#fbReportUpdateBtn").on("click", () => {	
		console.log("test call");
		$("#f_data").attr({
			"method": "post",
			"action": "/report/reportModify"
		});
		$("#f_data").submit();
	});

	$("#fbReportCancelBtn").on("click", () => {	
		$("#f_data").attr({
			"method": "post",
			"action": "/report/reportDelete"
		});
		$("#f_data").submit();
	});
	
	$(document).on("click", ".fcDetailBtn", function() {
		var reportId = $(this).parents("div .card").attr("data-num");
/*		console.log(reportId);
*/		
		$("#reportId").val(reportId);

		$("#detailForm").attr({
			"method":"get",
			"action":"/fcomment/fcommentDetail",
		    success: function() {
		        // 응답 처리
		        console.log('처리된 데이터:');
		    },
		    error: function(error) {
		        // 에러 처리
		        console.error('에러:', error);
		    }
		});
		$("#detailForm").submit();
	});

})