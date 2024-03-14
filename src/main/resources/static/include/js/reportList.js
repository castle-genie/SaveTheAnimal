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
});

