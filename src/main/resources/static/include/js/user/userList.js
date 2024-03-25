$(function(){	
	
	let keyword = $("#keyword").val();
	let search = $("#search").val();
	
	/* 날짜 검색 화면 제어 */
	if(search != "user_date"){
		let now = new Date();
		$(".dateArea").hide();
		let start = getDateFormat(new Date(now.setMonth(now.getMonth()-1)));
		let end = getDateFormat(new Date());
		$("#startDate").val(start);
		$("#endDate").val(end);		
	} else {
		$(".selectArea").hide();
	}

	
	/* 검색 대상이 변경될 때마다 처리 이벤트 */	
	$(".selectArea, .dateArea").hide();
	$("#u_search").on("change", function() {
	    // 선택된 옵션에 따라 해당하는 영역 보이기
	    if ($("#u_search").val() == "userAct") {
	        $(".selectArea").show();
	        $(".dateArea").hide();
	    } else if ($("#u_search").val() == "userDate") {
	        $("#keyword").val("");
	        $(".dateArea").show();
	        $(".selectArea").hide();
	    } else {
			$("#keyword").val("");
			$(".selectArea, .dateArea").hide();
		}		
	});
	
	
	/* 검색버튼 클릭시 처리 이벤트 */
	$("#searchBtn").on("click", function(e){
		if ($("#u_search").val() =="") {
			console.log("분류");
			return;
		} else if($("#u_search").val()!="userDate") {
			$("#startDate").val("");
			$("#endDate").val("");	
			if(!chkData("#keyword","상태값을")) return; 		
		} else {				
			if ($("#u_search").val()=="userAct") {
				let keyword = $("#user_act").val();
				console.log("user_act : "+keyword);
			} else if ($("#u_search").val()=="userDate") {
				if(!chkData("#startDate","시작날짜를")) return; 	
				else if(!chkData("#endDate","종료날짜를")) return; 	
				else if($("#startDate").val()>$("#endDate").val()) {
					alert("시작날짜가 종료날짜보다 더 클 수 없습니다.");
					return; 	
				}
			} else {
				console.log("조건에 맞는게 없음");
				return;
			}
		} 				
    	
		$("#pageNum").val(1);// 페이지 초기화		
		actionProcess("#searchForm", "get", "/user/userList");
	});
	
	
	$("#allSearchBtn").on("click", function(){
		locationProcess("/user/userList");
	});

	
	/* 페이징 처리 이벤트 : (24/03/18) actionProcess(); 대체*/
	$(".page-item a").on("click", function(e){
		e.preventDefault();
		$("#searchForm").find("input[name='pageNum']").val($(this).attr("href"));
		actionProcess("#searchForm", "get", "/user/userList");
	}); 
	
	/*
	$(".page-item a").on("click", function(e){
		e.preventDefault();        
    
    // URL에서 페이지 번호를 가져옴
    let pageNum = new URL($(this).attr("href"), window.location.href).searchParams.get("pageNum");

    // 검색 폼의 페이지 번호 업데이트
    $("#searchForm").find("input[name='pageNum']").val(pageNum);
    
    // 검색 폼의 모든 데이터를 가져와서 URL 파라미터 형식으로 전달
    let formData = $("#searchForm").serialize();
    
    // 페이지 이동
    window.location.href = "/user/userList?" + formData;
	});
	
	// 현재 URL을 가져옴
	let currentUrl = new URL(window.location.href);

	// 쿼리 파라미터와 값 가져오기
	let pageNum = currentUrl.searchParams.get("pageNum");
	let amount = currentUrl.searchParams.get("amount");
	let search = currentUrl.searchParams.get("search");
	let keyword = currentUrl.searchParams.get("keyword");
	let startDate = currentUrl.searchParams.get("startDate");
	let endDate = currentUrl.searchParams.get("endDate");
	
	// 가져온 값들을 콘솔에 출력하거나 다른 곳에 활용할 수 있음
	console.log("pageNum:", pageNum);
	console.log("amount:", amount);
	console.log("search:", search);
	console.log("keyword:", keyword);
	console.log("startDate:", startDate);
	console.log("endDate:", endDate); 
	
	// 가져온 쿼리 파라미터의 값들을 사용하여 새로운 URL 생성
	let newUrl = "/user/userList?" + 
	    "pageNum=" + pageNum +
	    "&amount=" + amount +
	    "&search=" + search +
	    "&keyword=" + keyword +
	    "&startDate=" + startDate +
	    "&endDate=" + endDate;

// 새로운 URL로 페이지 이동
window.location.href = newUrl;
	*/
		

	
}); // $ 함수 종료문

/* 함수명: getDateFormat(날짜 데이터) 
 * 설명 : dataValue의 값을 년-월-일 형식(예시: 2018-01-01)으로 반환.*/
function getDateFormat(dataValue) {
	var year = dataValue.getFullYear();
	
	var month = dataValue.getMonth() + 1;
	month = (month<10) ? "0"+month : month;
 	
	var day = dataValue.getDate();
	day = (day<10) ? "0"+day : day;
 	
 	var result = year+"-"+month+"-"+day;
 	return result;
}

const actionProcess = function(form, method, action) {
	$(form).attr({
		"method":method,
		"action":action
	});
	$(form).submit();
}

const locationProcess = function(url) {
	location.href = url;
}



// 검색 상태를 URL 매개 변수에 저장하는 함수
function updateSearchState() {
    let selectedOption = $("#u_search").val();
    let startDate = $("#startDate").val();
    let endDate = $("#endDate").val();

    // URL 매개 변수로 검색 상태 설정
    let url = "/user/userList?";
    url += "u_search=" + encodeURIComponent(selectedOption);
    if (selectedOption === "userAct") {
        url += "&user_act=" + encodeURIComponent($("#user_act").val());
    } else if (selectedOption === "userDate") {
        url += "&startDate=" + encodeURIComponent(startDate);
        url += "&endDate=" + encodeURIComponent(endDate);
    }

    // 현재 페이지 URL을 변경하여 검색 상태를 유지
    window.history.replaceState(null, null, url);
}