$(function(){
	
	$("#sanctionBtn").on("click",() =>{
		console.log("제재버튼 확인");
		
		
		
		
	});
	
	
	
	$("#reportDeleteBtn").on("click",() =>{
		//console.log("무시버튼 확인");
		$("#f_data").attr({
			"method":"post",
			"action":"/admin/report/reportDelete"
		});
		$("#f_data").submit();
	});
	
	
})