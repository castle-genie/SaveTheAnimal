$(function(){
		
	$(".goDetail").on("click", function(){
		let reportId = $(this).parents("tr").attr("data-num");

		$("#reportId").val(reportId);

		$("#detailForm").attr({
			"method":"get",
			"action":"/admin/report/reportDetail"
		});

		$("#detailForm").submit();
	});
	
/*	$("#search").on("change", function(){
		if($("#search").val()=="all"){
			$("#keyword").val("전체 목록을 조회합니다.");
		}else if($("#search").val()!="all"){
			$("#keyword").val("");
			$("#keyword").focus();
		}
	});
	
	$("#searchData").on("click", function(){
		if($("#search").val()!="all"){
			if(!chkData("#keyword", "검색어를")) return;
		}
		goPage();

	});
*/	
	
	
	
});



/*function goPage(){
	if($("#search").val()=="all"){
		$("#keyword").val("");
	}
	$("#f_search").attr({
		"method":"get",
		"action":"/board/boardList"
	});
	$("#f_search").submit();
};
*/

