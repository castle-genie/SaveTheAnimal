<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp" %>
	<meta name="robots" content="index, follow, max-image-preview:large, max-snippet:-1, max-video-preview:-1">
	<link rel="stylesheet" href="/resources/include/assets2/css/main.css">
	<script>
		$(function() {
			var userId = "<%= session.getAttribute("userId") %>";
			$.ajax({
			    url: '/application/applicatoinList?userId='+userId,
			    method: 'get',
			    success: function(response) {
			    	console.log(response);
			        var list = '<ul>';
			        $.each(response, function(index, item) {
			            list += '<li>공고 제목: ' + item.volunteerTitle + ', 아이디: ' + item.userId + '</li>';
			        });
			        list += '</ul>';
			        $('#appView').html(list);
			    },
			    error: function(xhr, status, error) {
			        console.log('Error: ', xhr, status, error)
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
				<h2>페이지 이름</h2>
			</header>
		</div>
	</section>

	<!-- Two -->
	<section id="two" class="wrapper style2">
		<div class="inner">
			<div class="box">
				<div class="content">
					<div class="grid">
						<div class="image fit">
							<div class="my-3 p-4 bg-body rounded shadow-sm">
							    <h4 class="border-bottom pb-2 mb-0"><strong>My Activities</strong></h4>										    
							    <br/>
							    <h5><strong>봉사활동 신청내역</strong></h5>
							    <div class="d-flex text-body-secondary pt-3">
							    	<div id="appView">	</div>
							    </div>
							    <small class="d-block text-end mt-3">
							      <a href="#"></a>
							    </small>
							  </div>					
						</div>
					</div>
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
</body>

</html> 
