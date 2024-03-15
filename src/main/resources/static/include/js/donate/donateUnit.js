$(function (){
	 $("#donateUpdateBtn").click(function() {
        // 새 창으로 열릴 링크 URL
        var linkUrl = "/donate/donateUpdate"; // 원하는 링크 주소를 넣어주세요
        // 팝업 창 옵션 설정
        var popupOptions = "width=600,height=800,scrollbars=yes,resizable=yes";
        
        // 새 창으로 링크 열기 (팝업 창 형태)
        window.open(linkUrl, "_blank", popupOptions);
    });
    
    
    $("#donateDeleteBtn").click(function() {
        // 새 창으로 열릴 링크 URL
        var linkUrl = "/donate/donateDelete_check"; // 원하는 링크 주소를 넣어주세요
        // 팝업 창 옵션 설정
        var popupOptions = "width=600,height=800,scrollbars=yes,resizable=yes";
        
        // 새 창으로 링크 열기 (팝업 창 형태)
        window.open(linkUrl, "_blank", popupOptions);
    });
})