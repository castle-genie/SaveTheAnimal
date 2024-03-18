<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp" %>
	<meta name="robots" content="index, follow, max-image-preview:large, max-snippet:-1, max-video-preview:-1">
	<link rel="stylesheet" href="/resources/include/assets2/css/main.css">
	
</head>
<body class="subpage">

<%@ include file="/WEB-INF/views/project/generic.jspf" %>   

	<!-- One -->
	<section id="One" class="wrapper style3">
		<div class="inner">
			<header class="align-center">
				<p>Save The Animal</p>
				<h2>adoptionView</h2>
			</header>
		</div>
	</section>

	<!-- Two -->
	<section id="two" class="wrapper style2">
		<div class="inner">
			<div class="box">
				<div class="content">
					<header class="align-center">
						<p>입양 가능 동물 리스트</p>
						<h2>입양 공고</h2>
					</header>
					<div>
						 <div class="container">
        <div class="text-center">
            <h3>입양 가능 동물 리스트</h3>
        </div>
        <div id="animalSearch" class="text-right"></div>

        <div id="apList">
            <div class="row">
                <c:choose>
                    <c:when test="${not empty apList}">
                        <c:forEach var="animal" items="${apList}" varStatus="status">
                            <div class="col-md-4 mb-4 ">
                                <div class="card">
                                    <img src="<c:if test='${not empty animal.animalFile}'>/uploadStorage/animal/${animal.animalFile}</c:if>
                                         <c:if test='${empty animal.animalFile}'>/resources/images/common/noanimal11.png</c:if>"
                                       class="card-img-top l"  alt="Animal Image">
                                    <div class="card-body">
                                        <table>
                              
                                        		<td class="goDetail">
                                        		 <td class="goDetail">
    												<a href="/ap/apDetail?animalId=${animal.animalId}">${animal.animalName}</a>
												</td>

                                        	</tr>
                                        	<tr >
                                        		<td> <p class="card-text species">${animal.animalSpecies}</p></td>
                                        	</tr>
                                        	<tr>
                                        		<td> <p class="card-text kg">${animal.animalKg}</p></td>
                                        	</tr>
                                        	<tr>
                                        		<td><p class="card-text gender">${animal.animalGender}</p></td>
                                        	</tr>
                                        	
                                                    
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <div class="col-md-12 text-center">
                            <p>등록된 게시물이 존재하지 않습니다.</p>
                        </div>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>
   <script src="/resources/include/js/ap/apList.js"></script>
					</div>
				</div>
			</div>
		</div>
	</section>
	
