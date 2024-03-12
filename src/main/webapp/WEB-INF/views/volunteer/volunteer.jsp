<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp" %>
	<!-- 스타일 적용 -->
    <link rel="stylesheet" href="/resources/include/css/volunteer.css">
	<!-- 달력 api 적용 -->
	<script src='https://cdn.jsdelivr.net/npm/fullcalendar@6.1.11/index.global.min.js'></script>
    <script>
	
	  document.addEventListener('DOMContentLoaded', function() {
	    var calendarEl = document.getElementById('calendar');
	
	    var calendar = new FullCalendar.Calendar(calendarEl, {
	      headerToolbar: {
	        left: 'prevYear,prev,next,nextYear today',
	        center: 'title',
	        right: 'customButton dayGridMonth,dayGridWeek,dayGridDay'
	      },
	      customButtons : {
	    	  customButton : {
	    		  text : "일정 추가"
	    	  }
	      },
	      initialDate: '2024-03-22', // 초기 로딩 날짜
	      navLinks: false, // can click day/week names to navigate views
	      editable: true,
	      dayMaxEvents: true, // allow "more" link when too many events
	      events: {
	          url: '/volunteer/volunteerList', // 데이터를 가져올 URL
	          method: 'GET', // 데이터 요청 메소드 (GET 또는 POST)
	          extraParams: {
	            custom_param1: 'value1', // 필요한 경우 추가 매개 변수
	            custom_param2: 'value2'
	          },
	          success: function(data) {
	            // 성공적으로 데이터를 받았을 때의 동작
	            console.log('Data loaded:', data);
	         	// 이전에 추가된 이벤트를 모두 제거
	            calendar.removeAllEvents();
	            // 달력에 이벤트 추가
	            var events = [];
	            data.forEach(function(eventObj) {
	            	var time = new Date(eventObj.volunteerTime); // volunteerTiem 문자열을 Date 객체로 변환
	            	var isoTimeString = time.toISOString(); // ISO 8601 형식의 문자열로 변환
	              events.push({
	                title: eventObj.volunteerTitle,
	                start: isoTimeString,
	                allDay : true
	                // 필요한 경우 다른 필드들도 여기에 추가할 수 있습니다.
	              });
	            });
	            calendar.addEventSource(events);
	          },
	          failure: function() {
	            // 데이터 로드 실패 시 동작
	            console.error('There was an error while fetching events.');
	          },
	          loading: function(isLoading) {
	            // 데이터를 가져오는 동안 로딩 중임을 표시 설정
	            if (isLoading) {
	              console.log('Loading events...');
	            } else {
	              console.log('Events loaded.');
	            }
	          }
	        }
	      
	      });
	
	    calendar.render();
	    
		 // customButton 클릭 이벤트 처리
	    calendarEl.querySelector('.fc-customButton-button').addEventListener('click', function() {
	      // 여기에 일정 추가 팝업창을 띄우는 코드를 작성하세요.
	      location.href="/volunteer/volunteerWriteForm";
	      // 일정 추가 팝업창을 띄우려면 해당 기능을 구현해야 합니다.
	    });
		 
		 eventCLick : function(info) {
			 // 클릭한 일정의 ID 추출
			 var volunteerId = info.event.extendedProps.volunteerId;
			 
			 /AJAX 요청을 통해 클릭한 일정의 ID를 컨트롤러에 전달
			 $.ajax({
				 url: '/volunteer/volunteerDetail'+eventId,
				 method: 'GET',
				 data:  {
					 eventId : eventId
				 },
				 success : function(response) {
					 // 클릭한 일정의 상세 정보를 컨트롤러로부터 받아서 처리
					 console.log('Event detail:', response);
					 
					 // 여기 필요 로직 추가
				 },
				 error : function(xhr, status, error) {
					 console.error('Error: ', error)
				 }
			 });
			 
			 // 기본 동작인 팝업 열기 방지 
			 info.jsEvent.preventDefault();
		 }
	  });
	
	</script>
    <!-- 템플릿 적용 -->
    <link rel="stylesheet" href="/resources/include/assets/css/main.css">
	</head>
	<body>
			<!-- Header -->
		<header id="header">
			<div class="logo"><a href="index.html">Hielo <span>by TEMPLATED</span></a></div>
			<a href="#menu">Menu</a>
		</header><!-- Nav -->
		<nav id="menu">
			<ul class="links">
				<li><a href="index.html">Home</a></li>
				<li><a href="generic.html">Generic</a></li>
				<li><a href="elements.html">Elements</a></li>
			</ul>
		</nav><!-- One -->
		<section id="One" class="wrapper style3">
			<div class="inner">
				<header class="align-center">
					<p>Save The Animal</p>
					<h2>봉사 활동 신청</h2>
				</header>
			</div>
		</section><!-- Two -->
		<section id="two" class="wrapper style2">
			<div id='calendar'></div>
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
		<script src="/resources/include/assets/js/jquery.min.js"></script>
		<script src="/resources/include/assets/js/jquery.scrollex.min.js"></script>
		<script src="/resources/include/assets/js/skel.min.js"></script>
		<script src="/resources/include/assets/js/util.js"></script>
		<script src="/resources/include/assets/js/main.js"></script>
	</body>
</html>