$(function(){
	const userId = document.getElementById("userId").value;

	$("#fbReportInsertBtn").on("click", () => {	
		$("#f_data").attr({
			"method": "post",
			"action": "/report/reportInsertFB"
		});
		$("#f_data").submit();
	});
	
	$("#vbReportInsertBtn").on("click", () => {
		$("#f_data").attr({
			"method": "post",
			"action": "/report/reportInsertVB"
		});
		$("#f_data").submit();
	});
	
	$("#abReportInsertBtn").on("click", () => {
		$("#f_data").attr({
			"method": "post",
			"action": "/report/reportInsertFA"
		});
		$("#f_data").submit();
	});
	
	$("#fcReportInsertBtn").on("click", () => {
		$("#f_data").attr({
			"method": "post",
			"action": "/report/reportInsertFC"
		});
		$("#f_data").submit();
	});
	
	$("#vcReportInsertBtn").on("click", () => {
		$("#f_data").attr({
			"method": "post",
			"action": "/report/reportInsertVC"
		});
		$("#f_data").submit();
	});
	
	$("#acReportInsertBtn").on("click", () => {
		$("#f_data").attr({
			"method": "post",
			"action": "/report/reportInsertAC"
		});
		$("#f_data").submit();
	});
	
	
	
});