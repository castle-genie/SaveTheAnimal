$(function (){
	$("#do_price").on("keyup", function () {
			    // 입력값에서 숫자만 추출합니다.
			    let num = $(this)
			      .val()
			      .replace(/[^0-9]/g, "");


			    // 변환된 숫자를 입력 상자에 설정합니다.
			    $(this).val(num);
			  });

			  // 직접입력 라디오 버튼에 대한 변경 이벤트 처리
			  $(document).ready(function () {
			    $(".price_Select").change(function () {
			      if ($(this).val() === "Select") {
			        $(".input_Select").prop("disabled", false).focus();
			      } else {
			        $(".input_Select").prop("disabled", true).val("");
			      }
			    });
			  });

			  $(document).ready(function () {
			    $(".price_Select").click(function () {
			      // 모든 라벨의 클래스 제거
			      $(".price_Select").parent().removeClass("selected");

			      // 선택된 라벨에 클래스 추가
			      $(this).parent().addClass("selected");
			    });
			  });

			  $("#do_ahPhone").on("keyup", function () {
			    // 입력값에서 숫자만 추출합니다.
			    let num = $(this)
			      .val()
			      .replace(/[^0-9]/g, "");

			    $(this).val(num);
			  });
		
	
});