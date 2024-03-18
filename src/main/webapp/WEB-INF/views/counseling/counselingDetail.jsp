<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>상담 상세 정보</title>
</head>
<body>
<h1>상담 상세 정보</h1>
<table>
    <tr>
        <td>상담일정:</td>
        <td>${detail.counselingSchedule}</td>
    </tr>
    <tr>
        <td>회원ID:</td>
        <td>${detail.userId}</td>
    </tr>
    <tr>
        <td>입양공고ID:</td>
        <td>${detail.adoptionId}</td>
    </tr>
    <tr>
        <td>동물ID:</td>
        <td>${detail.animalId}</td>
    </tr>
    <tr>
        <td>상담일자:</td>
        <td>${detail.counselingDate}</td>
    </tr>
    <tr>
        <td>적격판정:</td>
        <td>${detail.counselingJudgment}</td>
    </tr>
    <!-- 필요에 따라 추가적인 정보를 표시할 수 있습니다. -->
</table>
</body>
</html>
