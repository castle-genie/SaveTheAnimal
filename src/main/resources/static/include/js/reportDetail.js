$(function(){
	
	$("#sanctionBtn").on("click",() =>{
		//console.log("제재버튼 확인");
		$("#f_data").attr({
			"method":"post",
			"action":"/admin/report/reportUpdate"
		});
		$("#f_data").attr({
			"method":"post",
			"action":"/admin/sanction/sanctionInsert"
		});
		
		
		
		$("#f_data").submit();
	});
	
	
	
	$("#reportDeleteBtn").on("click",() =>{
		//console.log("무시버튼 확인");
		$("#f_data").attr({
			"method":"post",
			"action":"/admin/report/reportUpdate"
		});
		$("#f_data").submit();
	});
	
	
})