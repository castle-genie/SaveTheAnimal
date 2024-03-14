/* 수정 여부 체크용 */
let pwdCheck = 0; 
let phoneCheck = 0;
let emailCheck = 0;
/* 유효성 확인용 */
let isChanged = false;
let isValid = true;
let nameValid = true;
let pwdValid = true;
let phoneValid = true;
let emailValid = true;

let userId = $('#userId').val();

$(function() {
	// 수정 폼 값 변경 시 수정 버튼 활성화, 유효성 확인 값 변경
	$('.changable').on('change keyup', function() {
		console.log("항목 변경 이벤트");
        $('#updateProfileBtn').prop('disabled', false);       
        isChanged = true;
        isValid = false;
    });
	
	// 입력란 클릭 시 값 선택
    $('#updateForm input:not(#userId)').on('click', function() {
        $(this).select();
     });   
     
        
 	// 비밀번호 수정 토글
    $('#passwordToggle').change(function() {
        if ($(this).is(':checked')) {
            $('#pwdConfirm').prop('disabled', false); // 기존 비밀번호 입력란 활성화
            $('#pwdConfirmBtn').prop('disabled', false); // 비밀번호 확인 버튼 활성화
            $('#pwdConfirm').attr('placeholder', '기존 비밀번호 입력'); // placeholder 변경
        } else {
			$('#pwdConfirm').val("");
            $('#pwdConfirm').prop('disabled', true); // 기존 비밀번호 입력란 비활성화
            $('#pwdConfirmBtn').prop('disabled', true); // 기존 비밀번호 입력란 비활성화
            $('.new-password-area').hide(); // 새 비밀번호 입력란 숨기기
        }
    });   

	// 비밀번호 확인 버튼 클릭 시
    $('#pwdConfirmBtn').on('click', function() {
		let pwdConfirm = $('#pwdConfirm').val();
		let userId = $('#userId').val();
       
		/* ajax 비밀번호 일치 체크 */
		$.ajax({ 
			url : "/pwdConfirm",  
			type : "post",
			contentType:"application/json",
			data : JSON.stringify({
				"userId":userId,
				"userPasswd":pwdConfirm
			}),
			success: function(result) {
				if (result == 0) {                    
                    alert("비밀번호가 일치하지 않습니다.");
                    $("#pwdConfirm").val(""); 
                    $("#pwdConfirm").focus();              
                } else { // 일치하면
					$('#pwdConfirm').prop('disabled', true); // 기존 비밀번호 입력란 비활성화
					$('#pwdConfirmBtn').prop('disabled', true); // 비밀번호 확인 버튼 비활성화
					$('#pwdConfirm').attr('placeholder', '아래에 새 비밀번호를 입력하세요.'); // placeholder 변경
					$('.new-password-area').show(); // 새 비밀번호 입력란 보이기
					$('#userPasswd').focus(); // 새 비밀번호 입력란으로 포커스 이동.
					pwdCheck = 1; // 새로운 비밀번호 변경 하였음!! 	
									         
                }
			},
			error: (xhr, textStatus, errorThrown) => {
				alert("AJAX 요청 실패:\n"+ textStatus + " (HTTP-" + xhr.status + " / " + errorThrown + ")");
			}
		});
    });    
    
    // 핸드폰 번호 입력란의 값이 변경될 때마다 호출되는 함수
	$('#userPhone').on('input', function() {
		console.log("핸드폰 변경");

		isChanged = false;
	    // 입력된 값이 있는지 확인
	    let phoneNumber = $(this).val();
	    if (phoneNumber.trim() !== '') {
	        // 입력된 값이 있으면 중복 확인 버튼을 활성화
	        $('#phoneCheckBtn').prop('disabled', false);
	        phoneValid = false;
	    } 
	});

	/* 핸드폰 번호 유효성 체크, 중복 체크 */	
	$("#phoneCheckBtn").on("click", function(){
        let userPhone = $("#userPhone").val();
        const phonePattern = /(^01(?:0|1|[6-9])\d{7,8}$)/g; // 하이픈을 포함하지 않는 핸드폰번호
        if (!chkData("#userPhone", "핸드폰번호를")) {
			return;
        } else if(!phonePattern.test(userPhone)) {
            alert("핸드폰번호 11자리를 입력하세요.");
            $("#userPhone").val("");
            $("#userPhone").focus();
            return;
        }
        /* ajax 중복 체크 */	
        $.ajax({ 
			url : "/phoneCheck",  
			type : "post",
			data : {
				"userPhone":userPhone
			},
			success: function(result) {
				if (result === 1) {                    
                    alert("존재하는 번호입니다.");
                    $("#userPhone").val(""); 
                    $("#userPhone").focus();              
                } else {
                    alert("사용가능한 번호입니다.");
                    $('#phoneCheckBtn').prop('disabled', true);               
                    phoneCheck = 1; 
                    phoneValid = true;
                }
			},
			error: (xhr, textStatus, errorThrown) => {
				alert("AJAX 요청 실패:\n"+ textStatus + " (HTTP-" + xhr.status + " / " + errorThrown + ")");
			}
		});	            
	});
	
    // 이메일 입력란의 값이 변경될 때마다 호출되는 함수
	$('#userEmail').on('input', function() {
		emailValid = false;
	    // 입력된 값이 있는지 확인
	    let email = $(this).val();
	    if (email.trim() !== '') {
	        // 입력된 값이 있으면 중복 확인 버튼을 활성화
	        $('#emailCheckBtn').prop('disabled', false);
	        isValid = false;
	    } 
	});

	/* 이메일 유효성 체크, 중복 체크 */	
	$("#emailCheckBtn").on("click", function(){
        let userEmail = $("#userEmail").val();
        const emailPattern = /^[\w.%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$/;
        if (!chkData("#userEmail", "핸드폰번호를")) {
			return;
        } else if(!emailPattern.test(userEmail)) {
            alert("유효하지 않은 이메일 주소입니다. 다시 입력하세요.");
            $("#userEmail").val("");
            $("#userEmail").focus();
            return;
        }
        /* ajax 중복 체크 */
        $.ajax({ 
			url : "/emailCheck",  
			type : "post",
			data : {
				"userEmail":userEmail
			},
			success: function(result) {
				if (result === 1) {                    
                    alert("존재하는 이메일입니다.");
                    $("#userEmail").val(""); 
                    $("#userEmail").focus();              
                } else {
                    alert("사용가능한 이메일입니다.");
                    $('#emailCheckBtn').prop('disabled', true); 
                    emailCheck = 1;
                	emailValid = true;
                }
			},
			error: (xhr, textStatus, errorThrown) => {
				alert("AJAX 요청 실패:\n"+ textStatus + " (HTTP-" + xhr.status + " / " + errorThrown + ")");
			}
		});            
	});






       

// 회원정보 수정 버튼 클릭 시
    $('#updateProfileBtn').on('click', function() {
        /* 새로운 비밀번호 유효성 검사 */
        if (pwdCheck == 1) {
	        let userPasswd = $("#userPasswd").val();
	        const pwdPattern = /(^[a-zA-Z0-9]{8,20}$)/g;
	        
			if (!chkData("#userPasswd", "비밀번호를")) {
				return;		
	        }else if (!pwdPattern.test(userPasswd)) {
	            alert("비밀번호는 영문/숫자 8 ~ 20자리로 입력해주세요.");
	            $("#userPasswd").val("");
	            $("#userPasswd").focus();
	            return;
	        }
	             
	        let userPasswdCheck = $("#userPasswdCheck").val();
	        if (!chkData("#userPasswdCheck", "비밀번호 확인을")) {
				return;		        
	        } else if (userPasswd != userPasswdCheck) {// 비밀번호 일치여부 확인
	            alert("비밀번호와 비밀번호 확인은 일치해야 합니다.\n다시 입력해 주세요.");
	            $("#userPasswdCheck").val("");
	            $("#userPasswdCheck").focus();
	            return;
	        }
		}
        /* 이름 입력 검사 (한글 2~6자) */
        let userName = $("#userName").val();
		const namePattern = /^[가-힣]{2,6}$/g; 
		if (!chkData("#userName", "이름을")) {
			return;
		// 한글 2~6자 유효성 검사
        } else if(!namePattern.test(userName)) {
            alert("이름은 한글 2~6자로 입력해주세요");
            $("#userName").val("");
            $("#userName").focus();
            return;
        } else {
			nameValid = true;
		}
		
		if (pwdValid && nameValid && phoneValid && emailValid) {
			isValid = true;
		}
		
		
		
		console.log(isValid? "유효" : "유효하지 않음");
		console.log(isChanged? "값 변경됨" : "변경 없음");
		
		
		if (isChanged) {
			if(isValid) {
				
				if (confirm("입력한 값으로 수정하시겠습니까?")){
					/*$("#updateForm").attr({
						method="post",
						action="/updateProfile"
					});
					$("#updateForm").submit();*/
					alert("회원정보 수정 성공");
				} else {
					alert("회원정보 수정 취소");
				}
			}
		} else {
			console.log("변경된 항목이 없습니다.");
			return;
		}

    });


	//취소버튼
	$("#updateCancelBtn").on("click", function() {
		$("#updateForm").each(function(){
			console.log("취소버튼");			
			this.reset();
			$('#updateProfileBtn').prop('disabled', true);
		})
	});
  
});
