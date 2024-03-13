<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>결제화면 구현</title>

			<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
		<script src="/resources/include/js/jquery-3.7.1.min.js"></script>
		<script src="/resources/include/js/common.js"></script>
		<link rel="stylesheet" type="text/css" href="/resources/include/css/donatePay.css" />
		<script>
		$(function () {
			  $("#do_price").on("keyup", function () {
			    // 입력값에서 숫자만 추출합니다.
			    let num = $(this)
			      .val()
			      .replace(/[^0-9]/g, "");

			    // 세 자리마다 콤마를 추가합니다.
			    num = num.replace(/\B(?=(\d{3})+(?!\d))/g, ",");

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

		</script>
</head>
<body>
<header>
</header>
<main>
    <div class="donatePay_data">
        <h1>유기견의 가족이 되어주세요</h1>
        <form>
        	<h2>후원 정보</h2>
            <table class="priceSelect">
                <thead>
                    
                    <tr>
                        <th colspan="3">후원 금액을 선택해 주세요</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><label><input type="radio" name="do_price" value="10000" class="price_Select">10,000원</label></td>
                        <td><label><input type="radio" name="do_price" value="20000" class="price_Select">20,000원</label></td>
                        <td><label><input type="radio" name="do_price" value="30000" class="price_Select">30,000원</label></td>
                    </tr>
                    <tr>
                        <td><label><input type="radio" name="do_price" value="40000" class="price_Select">40,000원</label></td>
                        <td><label><input type="radio" name="do_price" value="50000" class="price_Select">50,000원</label></td>
                        <td><label><input type="radio" name="do_price" value="Select" class="price_Select">직접입력</label></td> <!-- 텍스트 누를시 다른 체크 박스 강제 아웃 시켜야 한다. -->
                    </tr>
                    <tr>
                        <td colspan="3"><label for="input_Select"><input type="text" id="do_price" name="do_price" class="input_Select" >원</label></td>
                    </tr>
                </tbody>
            </table>
            <div class="warning">
            	<p>※ 세이브 더 애니멀에 후원해 주셔서 감사합니다.</p>
            </div>
            <h2>결제 정보</h2>
            <table class="priceData">
                <thead>
                
                </thead>
                <tbody>
                    <tr>
                        <th>결제 수단</th>
                        <td><input type="text" value="카드결제" readonly></td>
                    </tr>
                    <tr>
                        <th>카드 주명</th>
                        <td><input type="text" id="do_ahName"></td>
                    </tr>
                    <tr>
                        <th>카드주 휴대폰</th>
                        <td><input type="text" id="do_ahPhone" placeholder="' - '없이 입력해주세요" minlength="10" maxlength="11"></td>
                    </tr>
                </tbody>
            </table>
            <div class="warning">
                <p>※ 신용카드후원 시 나이스빌링, 나이스_정기과금, 후원금_나이스 또는 Nice로 표시되어 청구됩니다.</p>
            </div>
            <div class="Privacy_Check">
                <label for="Privacy_Check1"><input type="checkbox" id="Privacy_Check1" name="Privacy_Check1" required>개인정보 수집 이용약관의 동의합니다.</label>
                <button type="button" id="Privacy_Check_Detail_Btn">상세 보기</button>
            </div>
        </form>
        
    
        <button class="donatePayBtn" onclick="serverAuth()">결제하기</button> <!-- FORM에 안들어감 -->
    </div>
    <script src="https://pay.nicepay.co.kr/v1/js/"></script>
    <script>
 // 후원 금액 입력란의 값이 변경될 때마다 실행되는 이벤트 핸들러
    $("#do_price").on("keyup", function () {
        // 입력된 금액을 amount 변수에 저장
        let amount = $(this).val();
        
        // 세이브더애니멀_정기후원의 상품 금액으로 설정
        $("#amount").val(amount);
    });
    
    function serverAuth() {
    	  AUTHNICE.requestPay({
    	    clientId: "S2_5cf74e98f5d141f88c7f15beddca90d9",
    	    method: "kakaopayCard", // 결제수단 "card" 입력시 카드결제로 변경됩니다.
    	    orderId: "유니크한-주문번호",
    	    amount: 1000, // 상품 금액
    	    goodsName: "세이브더애니멀_정기후원", // 상품 이름
    	    returnUrl: "/main", //API를 호출할 Endpoint 입력
    	    fnError: function (result) {
    	      alert("개발자확인용 : " + result.errorMsg + "");
    	    },
    	  });
    	}

    </script>
</main>

</body>
</html>