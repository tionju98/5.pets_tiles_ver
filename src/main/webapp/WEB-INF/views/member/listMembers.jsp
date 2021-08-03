<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<% request.setCharacterEncoding("utf-8"); %> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원 정보 출력</title>
</head>
<body>
	<table style="width:90%; margin: auto;" >
		<tr align="center" bgcolor="#FFEDC3" height="25px">
			<td><b>아이디</b></td>
			<td><b>비밀번호</b></td>
			<td><b>이름</b></td>
			<td><b>이메일</b></td>
			<td><b>주소</b></td>
			<td><b>삭제</b></td>
		</tr>
		<c:forEach var="member" items="${membersList}">
			<tr align="center" height="40px">
				<td>${member.userID}</td>
				<td>${member.userPW}</td>
				<td>${member.userNAME}</td>
				<td>${member.userEmail}</td>
				<td>${member.userAddress}</td>
				<td><a href="${contextPath}/member/removeMember.do?userID=${member.userID}">삭제하기</a></td>
			</tr>
		</c:forEach>
	</table>
	
	<a href="${contextPath}/member/memberForm.do"><h1 style="text-align: center;">회원가입</h1></a>
</body>
</html>