<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>아마레 펫츠</title>
	  <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <link href="../../css/kfonts2.css" rel="stylesheet">
</head>
<body>
<div>
	</div>
	<%
		String d_animals = "총 사망한 동물 수";
		String d_dogs = "총 사망한 강아지 수";
		String d_cats = "총 사망한 고양이 수";
		String insert_animals = "등록된 유기 동물 수";
	%>
	
	<div>		
		<img alt="" src="${contextPath}/resources/image/friend.jpg" width="90%" height="100%">
	</div>
	<br/>
	<div class="container">
		<div class="text-left">
		<h3>DOG</h3>
		</div>
		<div>
		<p>asdfadf</p>
		</div>
	</div>
	
	<div class="container">
		<div class="text-left">
		<h3>CAT</h3>
		</div>
		<div>
		<p>asdfadf</p>
		</div>
	</div>

</body>

</html>