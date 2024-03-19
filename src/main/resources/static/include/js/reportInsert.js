$(function(){
	const userId = document.getElementById("userId").value;

	$("#fbReportInsertBtn").on("click", () => {	
		if(userId != "null"){	
			$("#f_data").attr({
				"method": "post",
				"action": "/report/reportInsertFB"
			});
			$("#f_data").submit();
		}else{
			alert("로그인 후 이용 가능한 서비스입니다.");
		}
	});
	
	$("#vbReportInsertBtn").on("click", () => {
		if(userId != "null"){	
			$("#f_data").attr({
				"method": "post",
				"action": "/report/reportInsertVB"
			});
			$("#f_data").submit();
		}else{
			alert("로그인 후 이용 가능한 서비스입니다.");
		}
	});
	
	$("#abReportInsertBtn").on("click", () => {
		if(userId != "null"){	
			$("#f_data").attr({
				"method": "post",
				"action": "/report/reportInsertFA"
			});
			$("#f_data").submit();
		}else{
			alert("로그인 후 이용 가능한 서비스입니다.");
		}
	});
	
	$("#fcReportInsertBtn").on("click", () => {
		if(userId != "null"){	
			$("#f_data").attr({
				"method": "post",
				"action": "/report/reportInsertFC"
			});
			$("#f_data").submit();
		}else{
			alert("로그인 후 이용 가능한 서비스입니다.");
		}
	});
	
	$("#vcReportInsertBtn").on("click", () => {
		if(userId != "null"){	
			$("#f_data").attr({
				"method": "post",
				"action": "/report/reportInsertVC"
			});
			$("#f_data").submit();
		}else{
			alert("로그인 후 이용 가능한 서비스입니다.");
		}
	});
	
	$("#acReportInsertBtn").on("click", () => {
		if(userId != "null"){	
			$("#f_data").attr({
				"method": "post",
				"action": "/report/reportInsertAC"
			});
			$("#f_data").submit();
		}else{
			alert("로그인 후 이용 가능한 서비스입니다.");
		}
	});
	
	
	
});