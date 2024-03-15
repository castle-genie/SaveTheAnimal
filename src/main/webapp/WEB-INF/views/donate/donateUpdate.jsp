<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp" %>
	<link rel="stylesheet" href="/resources/include/assets/css/main.css">
	<script> src="/resources/include/js/donate/donateUpdate.js"</script>
	<main>
	<div>
		<div><h1>후원변경</h1></div>
		<div><h2>수정하실 항목을 체크후 정보를 입력해 주세요</h2></div>
		
		<div>
		<form>
		<table>
			<tr>
				<th><input type="checkbox" class="donate_price_Btn"></th>
				<td><label for="do_price">결제 금액</label></td>
				<td><input type="text" id="do_price" name="do_price"></td>	
			</tr>
			<tr>
				<th><input type="checkbox" class="donate_PM_Btn"></th>
				<td><label for="do_price">결제 금액</label></td>
				<td><input type="text" id="do_pm" name="do_pm" value="신용카드" readonly="readonly"></td>	
			</tr>
		</table>
		
		<br>
		<br>
		<br>
		
		<table>
			<tr>
				<td rowspan="2"></td>
				<td>예금주 명</td>
				<td><input type="text" id="do_ahname" name="do_ahphone" value="${do_ahname}"></td>
			</tr>
			<tr>
				<td>예금주 번호</td>
				<td><input type="text" id="do_ahphone" name="do_ahphone" value="${do_ahphone}"></td>
			</tr>
		</table>
		
		<div>
		<button type="button" id="donate_Update_Btn" name="donate_update_Btn">후원 변경하기</button>
		</div>
		</form>
		</div>
		
	</div>
	
	<script>
	$(document).ready(function() {
	    $("#donate_update_Btn").click(function() {
	        // serverAuth() 함수 호출
	        serverAuth();
	    });
	});
			  
		function serverAuth() {
		// donateAmount 함수 정의
	    function donateAmount() {
	        var inputAmount = $('#do_price').val(); // 텍스트 입력된 값 가져오기
	        var amount_num = 0;
	
	        // 텍스트 입력값이 있는지 확인
	        if (inputAmount.trim() !== '') {
	            amount_num = parseInt(inputAmount);
	        }
	
	        return amount_num; // 계산된 값을 반환
	    }
	
	    // donateAmount 함수를 호출하여 amount 값을 설정
	    var donateAmount = amount_num();
		
	  AUTHNICE.requestPay({
	    clientId: 'S2_5cf74e98f5d141f88c7f15beddca90d9',
	    method: 'kakaopayCard',		// card= 신용카드 (카드정보 등록필요) kakaopayCard = 카카오 페이결제
	    orderId: "유니크한 상품 번호",
	    amount: donateAmount('amont_num'),
	    goodsName: '나이스페이-상품',
	    returnUrl: '/donate/donateUnit',
	    fnError: function (result) {
	      alert('고객용메시지 : ' + result.msg + '\n개발자확인용 : ' + result.errorMsg + '')
	    }
	  });
	}
	</script>
	</main>
	</body>
</html>