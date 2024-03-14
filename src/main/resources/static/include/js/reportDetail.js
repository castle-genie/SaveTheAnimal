$(function(){
	const fboard = '자유게시판';
	const vfboard = '봉사후기게시판';
	const afboard = '입양후이야기';
	const fcomment = '자유게시판 댓글';
	const vfcomment = '봉사후기게시판 댓글';
	const afcomment = '입양후이야기 댓글';
	const boardSort = document.getElementById("boardSort").innerText;

	$("#sanctionBtn").on("click", () => {
	    // AJAX 요청을 수행하고 프로미스를 반환하는 함수 정의
	    function ajaxRequest(url, data) {
	        return new Promise(function(resolve, reject) {
	            $.ajax({
	                type: "post",
	                url: url,
	                data: data,
	                success: function(response) {
	                    resolve(response);
	                },
	                error: function(error) {
	                    reject(error);
	                }
	            });
	        });
	    }
	
	    // 첫 번째 AJAX 요청
	    ajaxRequest("/admin/sanction/sanctionInsert", $("#f_data").serialize())
	        .then(() => {
	            // boardSort에 따라 다른 AJAX 요청을 선택적으로 실행
	            let reportUpdateUrl;
	            switch (boardSort) {
	                case fboard:
	                    reportUpdateUrl = "/admin/report/reportUpdateFB";
	                    break;
	                case vfboard:
	                    reportUpdateUrl = "/admin/report/reportUpdateVB";
	                    break;
	                case afboard:
	                    reportUpdateUrl = "/admin/report/reportUpdateAB";
	                    break;
	                case fcomment:
	                    reportUpdateUrl = "/admin/report/reportUpdateFC";
	                    break;
	                case vfcomment:
	                    reportUpdateUrl = "/admin/report/reportUpdateVC";
	                    break;
	                case afcomment:
	                    reportUpdateUrl = "/admin/report/reportUpdateAC";
	                    break;
	                default:
	                    // 기타 경우에는 추가적인 AJAX 요청이 필요 없음
	                    return Promise.resolve();
	            }
	            // 선택된 AJAX 요청 실행
	            return ajaxRequest(reportUpdateUrl, $("#f_data").serialize());
	        })
	        .then(() => {
	            // AJAX 요청 성공 후 추가 작업 수행
	            console.log("test");
	            $("#f_data").attr({
	                "method": "post",
	                "action": "/admin/report/repcntUpdate"
	            });
	            // 폼 제출
	            $("#f_data").submit();
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