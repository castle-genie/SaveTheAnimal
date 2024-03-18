$(function(){
		
	$(".goDetail").on("click", function(){
		let reportId = $(this).parents("tr").attr("data-num");

		$("#reportId").val(reportId);

		$("#detailForm").attr({
			"method":"get",
			"action":"/report/reportDetail"
		});

		$("#detailForm").submit();
	});
});

