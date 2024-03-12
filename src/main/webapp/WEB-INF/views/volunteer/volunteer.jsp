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
            customButtons: {
                customButton: {
                    text: "일정 추가"
                }
            },
            initialDate: '2024-03-22',
            navLinks: false,
            editable: true,
            dayMaxEvents: true,
            events: {
                url: '/volunteer/volunteerList',
                method: 'GET',
                extraParams: {
                    custom_param1: 'value1',
                    custom_param2: 'value2'
                },
                success: function(data) {
                    console.log('Data loaded:', data);
                    calendar.removeAllEvents();
                    var events = [];
                    data.forEach(function(eventObj) {
                        var time = new Date(eventObj.volunteerTime);
                        var isoTimeString = time.toISOString();
                        events.push({
                            title: eventObj.volunteerTitle,
                            start: isoTimeString,
                            allDay: true,
                            extendedProps: {
                                volunteerId: eventObj.volunteerId
                            }
                        });
                    });
                    calendar.addEventSource(events);
                },
                failure: function() {
                    console.error('There was an error while fetching events.');
                },
                loading: function(isLoading) {
                    if (isLoading) {
                        console.log('Loading events...');
                    } else {
                        console.log('Events loaded.');
                    }
                }
            },
            eventClick: function(info) {
                var volunteerId = info.event.extendedProps.volunteerId;
                $.ajax({
                    url: '/volunteer/volunteerDetail' + volunteerId,
                    method: 'GET',
                    data: {
                        volunteerId: volunteerId
                    },
                    success: function(response) {
                        console.log('Event detail:', response);
                    },
                    error: function(xhr, status, error) {
                        console.error('Error: ', error)
                    }
                });
                info.jsEvent.preventDefault();
            }
        });

        calendar.render();

        calendarEl.querySelector('.fc-customButton-button').addEventListener('click', function() {
            location.href = "/volunteer/volunteerWriteForm";
        });
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
			<div class="calendar-container">
				<div id='calendar'></div>
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
		<script src="/resources/include/assets/js/jquery.min.js"></script>
		<script src="/resources/include/assets/js/jquery.scrollex.min.js"></script>
		<script src="/resources/include/assets/js/skel.min.js"></script>
		<script src="/resources/include/assets/js/util.js"></script>
		<script src="/resources/include/assets/js/main.js"></script>
	</body>
</html>