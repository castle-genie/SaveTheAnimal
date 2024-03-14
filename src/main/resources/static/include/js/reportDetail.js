$(function(){
	const fboard = '자유게시판';
	const vfboard = '봉사후기게시판';
	const afboard = '입양후이야기';
	const fcomment = '자유게시판 댓글';
	const vfcomment = '봉사후기게시판 댓글';
	const afcomment = '입양후이야기 댓글';
	const boardSort = document.getElementById("boardSort").innerText;

	
	$("#sanctionBtn").on("click",() =>{
		console.log("제재버튼 확인");

		$.ajax({
			type:"post",
			url:"/admin/sanction/sanctionInsert",
			data:$("#f_data").serialize(),
			success:function(){
				if(boardSort == fboard){
					console.log("test");
					$("#f_data").attr({
						"method":"post",
						"action":"/admin/report/reportUpdateFB",
					});
				}else if(boardSort == vfboard){
					$("#f_data").attr({
						"method":"post",
						"action":"/admin/report/reportUpdateVB",
					});
				}else if(boardSort == afboard){
					$("#f_data").attr({
						"method":"post",
						"action":"/admin/report/reportUpdateAB",
					});
				}else if(boardSort == fcomment){
					$("#f_data").attr({
						"method":"post",
						"action":"/admin/report/reportUpdateFC",
					});
				}else if(boardSort == vfcomment){
					$("#f_data").attr({
						"method":"post",
						"action":"/admin/report/reportUpdateVC",
					});
				}else if(boardSort == afcomment){
					$("#f_data").attr({
						"method":"post",
						"action":"/admin/report/reportUpdateAC",
					});
				}
				$("#f_data").submit();
			},
			error:function(){
				console.log("실패");
				$("#f_data").submit();
			}
		});
	});
	
	
	
	$("#reportDeleteBtn").on("click",() =>{
		//console.log("무시버튼 확인");
		if(boardSort == fboard){
			console.log("test");
			$("#f_data").attr({
				"method":"post",
				"action":"/admin/report/reportUpdateFB",
			});
		}else if(boardSort == vfboard){
			$("#f_data").attr({
				"method":"post",
				"action":"/admin/report/reportUpdateVB",
			});
		}else if(boardSort == afboard){
			$("#f_data").attr({
				"method":"post",
				"action":"/admin/report/reportUpdateAB",
			});
		}else if(boardSort == fcomment){
			$("#f_data").attr({
				"method":"post",
				"action":"/admin/report/reportUpdateFC",
			});
		}else if(boardSort == vfcomment){
			$("#f_data").attr({
				"method":"post",
				"action":"/admin/report/reportUpdateVC",
			});
		}else if(boardSort == afcomment){
			$("#f_data").attr({
				"method":"post",
				"action":"/admin/report/reportUpdateAC",
			});
		}
		$("#f_data").submit();

	});
	
	
})