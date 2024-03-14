<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp" %>
	<link rel="stylesheet" href="/resources/include/assets/css/main.css">
	</head>
	<body>
	<main>
        <div class="donate_user">
            <h3>당신의 따뜻한 후원에 감사드립니다.</h3>
            <div class="donate_data_name">
                <div>
                <h1>후원 정보</h1>
                </div>
                <button type="button" id="donateUpdateBtn">후원변경 하기</button>
                <button type="button" id="donateDeleteBtn">후원해지 하기</button>
            </div>
            <form>
                <table id="donate_data">
                    <tr>
                        <th>결제 수단</th><td>${do_pm}</td>
                    </tr>
                    <tr>
                        <th>결제 금액</th><td>${do_price}</td>
                    </tr>
                    <tr>
                        <th>총 결제 금액</th><td>${do_sprice}</td>
                    </tr>
                    <tr>
                        <th>결제 일정</th><td>${do_day}</td>
                    </tr>
                    <tr>
                        <th>최초 결제 날짜</th><td>${do_fday}</td>
                    </tr>
                    <tr>
                        <th>후원번호</th><td>${do_id}</td>
                    </tr>
                </table>
            </form>
        </div>
    </main>
</body>
</html>