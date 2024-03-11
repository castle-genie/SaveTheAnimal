$(function(){
	
	$("#sanctionBtn").on("click",() =>{
		console.log("제재버튼 확인");

		$.ajax({
			type:"post",
			url:"/admin/sanction/sanctionInsert",
			data:$("#f_data").serialize(),
			success:function(){
				console.log("성공");
			},
			error:function(){
				console.log("실패");
				$("#f_data").submit();
			}
		});
/*		$.ajax({
			type:"post",
			url:"/admin/report/reportUpdate",
			data:$("#f_data").serialize(),
			success:function(){
				console.log("성공");
			},
			error:function(){
				console.log("실패");
				$("#f_data").submit();
			}
		});
*/		
		





/*		$("#f_data").attr({
			"method":"post",
			"action":"/admin/sanction/sanctionInsert"
		});
		$("#f_data").submit();
*/

		$("#f_data").attr({
			"method":"post",
			"action":"/admin/report/reportUpdate",
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