<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<title>자유게시판</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/resources/include/assets/css/main.css">
</head>
<body>
<h2 width="50%">자유게시판</h2>


	<div class="table-wrapper">
		<table>
			<thead>
				<tr>
					<th>제목</th>
					<th>작성자</th>
					<th>좋아요</th>
					<th>조회수</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${freeBoardList }" var="list">
				<tr>
					<td>${list.fboardTitle}</td>
					<td>${list.userId }</td>
					<td>${list.fboardLike }</td>
					<td>${list.fboardCnt }</td>
					<td>${list.fboardDate }</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>