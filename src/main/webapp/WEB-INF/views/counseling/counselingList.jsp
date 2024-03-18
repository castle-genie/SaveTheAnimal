<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>상담 목록</title>
</head>
<body>
<h1>상담 목록</h1>
<table border="1">
    <thead>
    <tr>
        <th>상담일정</th>
        <th>회원ID</th>
        <th>입양공고ID</th>
        <th>동물ID</th>
        <th>상담일자</th>
        <th>적격판정</th>
        <!-- 필요에 따라 추가적인 컬럼들을 표시할 수 있습니다. -->
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${counselingList}" var="counseling">
        <tr>
            <td>${counseling.counselingSchedule}</td>
            <td>${counseling.userId}</td>
            <td>${counseling.adoptionId}</td>
            <td>${counseling.animalId}</td>
            <td>${counseling.counselingDate}</td>
            <td>${counseling.counselingJudgment}</td>
            <!-- 필요에 따라 추가적인 정보를 표시할 수 있습니다. -->
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
