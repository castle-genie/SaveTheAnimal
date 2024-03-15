$(function (){
	$("#donate_delete_Btn").click(function() {
        // 새 창으로 열릴 링크 URL
        var linkUrl = "/donate/donateDelete"; // 원하는 링크 주소를 넣어주세요
        
        // 새 창으로 링크 열기 (팝업 창 형태)
        window.open(linkUrl, "target");
    });
});