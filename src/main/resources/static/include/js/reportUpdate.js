$(function(){
	const userId = document.getElementById("userId").value;
	
	$("#fbReportUpdateBtn").on("click", () => {	
		$("#f_data").attr({
			"method": "post",
			"action": "/report/reportModify"
		});
		$("#f_data").submit();
	});
})