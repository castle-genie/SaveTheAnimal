<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp" %>
	<meta name="robots" content="index, follow, max-image-preview:large, max-snippet:-1, max-video-preview:-1">
	<link rel="stylesheet" href="/resources/include/assets2/css/main.css">
	
	<!-- css 적용 -->
	<link rel="stylesheet" href="/resources/include/css/volunteer/volunteerDetail.css">
	
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=94063d37acee8b8586233e93d841bf07&libraries=services"></script>
	<script>
		// 모달 팝업 열기
		function openModal() {
		  var modal = document.getElementById("myModal");
		  modal.style.display = "block";
		}
	
		// 모달 팝업 닫기
		function closeModal() {
		  var modal = document.getElementById("myModal");
		  modal.style.display = "none";
		}
	
		// 페이지가 로드된 후 실행되는 함수
		window.onload = function() {
		  // 닫기 버튼 클릭 시 모달 팝업 닫기
		  document.getElementsByClassName("close")[0].onclick = function() {
		    closeModal();
		  };

		  // 모달 외부 영역 클릭 시 모달 팝업 닫기
		  window.onclick = function(event) {
		    var modal = document.getElementById("myModal");
		    if (event.target == modal) {
		      closeModal();
		    }
		  };
		};
			
		$(function() {
			var volunteerId = ${ detail.volunteerId };
			/* 지도 api 추가 스크립트 */
			var mapVisible = false;
			$(document).on("click", "#showMap", function() {
				mapVisible = !mapVisible;
				if(mapVisible) {
					$("#map").css("display", "block")
				} else {
					$("#map").css("display", "none");
				}
				let roadaddress = $(this).html();
				let title = $(this).attr("title");
				const container = document.getElementById('map'); // 지도를 표시할 div 
				const options = {
						center: new kakao.maps.LatLng(33.450701, 126.570667),
				        level: 5 // 지도의 확대 레벨
				    };  
				// 지도를 생성합니다    
				const map = new kakao.maps.Map(container, options); 
				// 주소-좌표 변환 객체를 생성합니다
				var geocoder = new kakao.maps.services.Geocoder();
				// 주소로 좌표를 검색합니다
				geocoder.addressSearch(roadaddress, function(result, status) {
				    // 정상적으로 검색이 완료됐으면 
				     if (status === kakao.maps.services.Status.OK) {
				        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
				        // 결과값으로 받은 위치를 마커로 표시합니다
				        var marker = new kakao.maps.Marker({
				            map: map,
				            position: coords
				        });
				        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
				        map.setCenter(coords);
				    } 
				});    
			})
			/* 참가 인원 구하기 스크립트 */
			$.ajax({
                url: '/application/'+volunteerId,
                method: 'GET',
                dataType : 'json',
                success: function(applicationCount) {
                	// applicationCount를 가져오는 데 성공했을 때만 실행됩니다.
                    // 가져온 applicationCount 값을 사용하여 해당 행(tr)에 추가합니다.
                    var tr = '<tr><th>모집 인원</th><td>' + applicationCount + '명 / ' + '${detail.volunteerLimit}명' + '</td></tr>';
                    // 위에서 생성한 tr을 해당 행 앞에 추가합니다.
                    $('table tbody tr:nth-child(3)').before(tr);
                },
                error: function(xhr, status, error) {
                    console.error('Error: ', error)
                }
            });
		})
	</script>
</head>
<body class="subpage">

<%@ include file="/WEB-INF/views/project/generic.jspf" %>   

	<!-- One -->
	<section id="One" class="wrapper style3">
		<div class="inner">
			<header class="align-center">
				<p>Save The Animal</p>
				<h2>봉사활동 정보</h2>
			</header>
		</div>
	</section>

	<!-- Two -->
	<section id="two" class="wrapper style2">
		<div class="inner">
			<div class="box">
				<div class="content">
					<header class="align-center">
						<div class="container">
						  <div class="activity-info">
						    <img src="https://www.example.com/image.jpg" alt="봉사활동 이미지">
						    <div class="info-text">
						      <h2>${ detail.volunteerTitle }</h2>
						      <table>
						      	<tbody>
						      		<tr>
						      			<th>활동 날짜</th>
						      			<td>${ detail.volunteerTime }</td>
					      			</tr>
					      			<tr>
						      			<th>신청 마감</th>
						      			<td>${ detail.volunteerDue }</td>
					      			</tr>
					      			<tr>
						      			<th>참가 비용</th>
						      			<td>${ detail.volunteerCost }</td>
					      			</tr>
					      			<tr>
						      			<th>주 소</th>
						      			<td id="showMap">${ detail.volunteerLocation }</td>
					      			</tr>
						      	</tbody>
						      </table>
						    </div>
						  </div>
						  <div id="map"></div>
						  <div class="button-container">
						        <a href="#" class="button" onclick="openModal()">봉사 신청하기</a>
						  </div>
						  <div class="underline"></div>
						  <div class="details" style="text-align: left;">
						    <h2>세부사항</h2>
						    <p>${ detail.volunteerDetail }</p>
						  </div>
						</div>
					</header>
				</div>
			</div>
		</div>
		<!-- 모달 팝업 컨테이너 -->
		<div id="myModal" class="modal">
		  <div class="modal-content">
		    <span class="close">&times;</span>
		    <div class="container">
		    <form id="applicatoioForm">
		      <h2>봉사활동 신청</h2>
		      <!-- 아이디 입력란(백엔드에서 처리) -->
		      <!-- 봉사공고 아이디(팝업 뜨게한 버튼 누른 페이지의 volunteerId) -->
		      <input type="hidden" id="volunteerId" name="volunteerId" value="여기에_봉사공고_아이디_입력">
		      <!-- 로그인 정보로 얻어온 회원 아이디(백엔드에서 처리) -->
		      <input type="hidden" id="userId" name="userId" value="여기에_회원_아이디_입력">
		      <div class="form-group">
		        <!-- 봉사 다짐 입력란 -->
		        <label for="promise">봉사 다짐</label>
		        <textarea id="promise" name="promise" rows="4" required></textarea>
		      </div>
		      <button type="button" id="applicationBtn">신청하기</button>
		    </form>
		  </div>
		  </div>	
		</div>
	</section>
	
	
	<!-- Footer -->
	<footer id="footer">
		<div class="container">
			<ul class="icons">
				<li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
				<li><a href="#" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
				<li><a href="#" class="icon fa-instagram"><span class="label">Instagram</span></a></li>
				<li><a href="#" class="icon fa-envelope-o"><span class="label">Email</span></a></li>
			</ul>
		</div>
	</footer>
	<div class="copyright">
		Made with <a href="https://templated.co/">Templated</a>.
	</div>

	<!-- Scripts -->
	<script src="/resources/include/assets2/js/jquery.min.js"></script>
	<script src="/resources/include/assets2/js/jquery.scrollex.min.js"></script>
	<script src="/resources/include/assets2/js/skel.min.js"></script>
	<script src="/resources/include/assets2/js/util.js"></script>
	<script src="/resources/include/assets2/js/main.js"></script>
	<script>
		// 로그인 상태를 확인하는 함수
		function checkLoggedIn() {
			 // 세션 스토리지에서 사용자 아이디를 가져옴
		    var userId = sessionStorage.getItem('userId');
		    console.log('userId:', userId);
		    
		    // 사용자 아이디가 있는지 확인하고 반환
		    if(userId !== null) {
		        return true; // 로그인 상태
		    } else {
		        return false; // 비로그인 상태
		    }
		}	
	
		$(function() {
		    $("#applicationBtn").on("click", function() {
		        if (!checkLoggedIn()) { // 사용자가 로그인하지 않은 경우
		            alert('로그인이 필요합니다.');
		            window.location.href = "/login"; // 로그인 페이지로 이동
		        } else { // 사용자가 로그인한 경우
		            $("#applicationForm").attr({
		                method : "post",
		                action : "/application/submit"
		            });
		            $("#applicationForm").submit(); // 폼 제출
		        }
		    });
		});
	</script>
</body>

</html> 