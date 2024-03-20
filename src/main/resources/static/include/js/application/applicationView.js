$(function() {
	$(".cancelBtn").on("click", function() {
		var applicationId = $(this).parents("tr").attr("data-id");
		console.log(applicationId);
		$("#applicationId").val(applicationId);
		$("#f_data").attr({
			method:"post",
			action:"/application/applicationDelete"
		});
		$("#f_data").submit();
	})
})