<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>About</title>
	  <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/kfonts2.css" rel="stylesheet">
</head>
<body>
	
	<div class="jumbotron">
		<div class="container">
			<h3>소개</h3>
		</div>
	</div>
	
		<div class="container mt-2">
		<div class="row">
			<div class="card" style="text-align:center; float:none; margin:auto">
				<div class="card-body">
				<img src="${contextPath}/resources/image/dcu.jpg" class="card-img-top" style="border: 10px;"/>
					<h3>AmarePets</h3>
					<p class="card-text">반려동물의 존재가 사람만큼 중요해진 지금, 실종/유기/보호 등의 기능들을 수행할 수 있는 웹 페이지입니다.<br>
					   회원 등록 시 개인/기업을 선택, 개인이라면 동물들의 실종/유기/보호 등의 관련 게시글을 게시할 수 있고<br/>
					   기업(보호소, 동물병원 등)이라면 유기/보호 등의 내용을 알릴 수 있습니다.<br/>
					   유기된 동물을 보호 중이거나 실종 동물들을 찾을 때에는 사용자의 해당 지역 검색이 가능합니다.<br/>
					   동물병원을 검색하고 싶을 때에도 사용자의 해당 지역에서 인근 병원을 편리하게 검색할 수 있습니다. <p><br/>
					<h4>Developer</h4>
					<h5>대구가톨릭대학교</h5>
					<h5>지능형 웹 알고리즘을 활용한 풀스택 개발자 양성 과정</h5>
					<p class="card-text">사이버보안전공 18 배 채 윤<br> 스마트IoT전공 17 신 현 주<br>
					스마트IoT전공 16 노 호 관<br> 의공학전공    16 김 병 수 </p><br/>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>