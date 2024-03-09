$(function(){
	/* 회원가입 버튼 클릭 시 처리 이벤트 */
	$("#joinBtn").on("click", function() {
		// 입력값 체크
		if (!chkData("#userId", "아이디를")) return;
		if (!chkData("#userPasswd", "비밀번호를")) return;
		if (!chkData("#userPasswdCheck", "비밀번호 확인을")) return;
		if (!chkData("#name", "이름을")) return;
		if (!chkData("#userPhone", "핸드폰번호를")) return;
		if (!chkData("#userEmail", "이메일을")) return;
		
		/**
		
		
		let userName = $("#userName").val();
		let userPhone = $("#userPhone").val();
		let userEmail = $("#userEmail").val();*/
		
		// 회원가입 폼 유효성 검사//
		
		/* 아이디 유효성 검사 (첫글자 영문자로, 두번째부터 영문자와 숫자로 6글자 이상 15글자 이하.) */
		let userId = $("#userId").val();
		
		
		
        const idPattern = /(^[a-zA-Z][a-zA-Z0-9]{5,14}$)/g;  // 정규표현식 주기
        if(!idPattern.test(userId)){  // 패턴에 맞지 않았을 때 - 부정연산자 사용
            alert("아이디는 첫글자 영문자로, 두번째부터 영문자와 숫자로 \n6글자 이상 15글자 이하로 작성해 주셔야 합니다.");
            $("#userId").val("");
            $("#userId").focus();       
            return;
        }
        
        /* 비밀번호 유효성 검사 */
        let userPasswd = $("#userPasswd").val();
        let userPasswdCheck = $("#userPasswdCheck").val();

        // 비밀번호 8자~20자 유효성 검사
        const pwdPattern = /(^[a-zA-Z0-9]{8,20}$)/g;
        if (!pwdPattern.test(userPasswd)) {
            alert("유효하지 않은 비밀번호 입니다.");
            $("#userPasswd").val("");
            $("#userPasswd").focus();
            return;
        }
        // 비밀번호 일치여부 확인
        if (userPasswd != userPasswdCheck) {
            $("input[name='error']").attr("placeholder", "비밀번호와 비밀번호 확인은 일치해야 합니다.");
            //alert("비밀번호와 비밀번호 확인은 일치해야 합니다.\n다시 입력해 주세요.");
            $("#userPasswdCheck").val("");
            $("#userPasswdCheck").focus();
            return;
        }

        /** 이름 입력 검사 */
        let name = $("#user_name").val();

        if(name.replace(/\s/g, "") == "") {
            alert("이름을 입력해주세요.");
            $("#user_name").val("");
            $("#user_name").focus();
            return;
        }

        /** 생년월일 입력 검사 */
        if($("#birth").val().replace(/\s/g, "") == "") {
            alert("생년월일을 입력해주세요.");
            $("#birth").val("");
            $("#birth").focus();
            return;
        }

        /** 라디오버튼 선택여부 검사 */
        //$("라디오버튼CSS셀렉터").is(":checked")
        // -> 체크일 경우 : true
        if(!$("input[name='gender']").is(":checked")) {
            alert("성별을 선택해 주세요.");
            return;
        }

        /** 이메일 주소 입력여부 검사 */
        // console.log($("#email").val());
        if($("#email").val().replace(/\s/g,"")=="") {
            alert("이메일 주소를 입력하세요.");
            $("#email").val("");
            $("#email").focus();
            return;
        }
        if($("#emailDomain").val().replace(/\s/g,"")=="") {
            alert("이메일 주소를 입력하세요.");
            $("#emailDomain").val("");
            $("#emailDomain").focus();
            return;
        }

        /** 핸드폰 번호 입력 여부 검사 */
        if($("#hpno").val().replace(/\s/g,"")=="") {
            alert("핸드폰 번호를 입력하세요.");
            $("#hpno").val("");
            $("#hpno").focus();
            return;
        }

        /** 취미 체크박스 선택여부 검사 */
        if(!$("input[name='hobby']").is(":checked")) {
            alert("취미를 선택해 주세요.");
            return;
        }
        
        /* selectbox 선택여부 검사
            - $("select의 셀렉터 > option:selected").index() : 선택된 항목의 index 번호.
            - $("select의 셀렉터 > option:selected").val() : 선택된 항목의 값
            - $("select의 셀렉터").val() : 선택된 항목의 값을 반환
         */
        if ($("select[name='job'] > option:selected").index() < 1 ) {
            alert("직업을 선택해 주세요.");
            return;
        }


 
		
		/*$("#joinForm").attr({
			"method":"post",
			"action":"/join"				
		});
		$("#joinForm").submit();*/

	});
});




// 전체동의 체크박스
function selectAll(selectAll) {
    $('input[type="checkbox"]').prop('checked', selectAll.checked);
}