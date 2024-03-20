$(function(){
	const userId = document.getElementById("userId").value;
	
	$("#fbReportUpdateBtn").on("click", () => {	
		if(userId != "null"){	
			$("#f_data").attr({
				"method": "post",
				"action": "/report/reportModify"
			});
			$("#f_data").submit();
		}else{
			alert("로그인 후 이용 가능한 서비스입니다.");
		}
	});
})