<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />  
<%
	request.setCharacterEncoding("UTF-8");
%>    
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" >
	<link href="${pageContext.request.contextPath}/resources/css/kfonts2.css" rel="stylesheet" >
	<title>보호소 위치 </title>
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
	<style type="text/css">
		.table{
		    width: 100%;
		    border-collapse: collapse;
		    line-height: 24px;
		}
		th {
		    border-top:1px solid black;
		    border-bottom:1px solid black;
		    border-collapse: collapse;
		    text-align: center;
		    padding: 13px;
		    background: rgb(221, 221, 221);
		}
		td{
			border-bottom: 1px solid gray;
			padding : 10px;
		}
	
	</style>
</head>
<body>

	<table class="table table-hover">
	<tr style="align: right;">
    			<td colspan="5" style="display:inline-block; border:white;">
    			<form >
    				<select name="sido1" id="sido1"></select>
					<select name="gugun1" id="gugun1" onchange="handleOnChange(this)"></select>
					</form>
    			</td>
    		</tr>
		<tr>
		<tr>
			<th style="width:20%;"><b>보호소명</b></th>
			<th style="width:40%;"><b>보호소 주소</b></th>
			<th style="width:40%;"><b>보호소 전화번호</b></th>
		</tr>
		
		
		<c:choose>
			<c:when test="${empty membersList }">
				<tr height="10">
					<td colspan="5">
						<p align="center">
							<b><span style="font-size: 9pt;">조건을 설정해주세요.</span></b>
						</p>
					</td>
				</tr>
		</c:when>
		
		<c:when test="${!empty membersList }">
		<c:forEach var="member" items="${membersList }" >
			<tr align="center">
				<td>${member.user_NAME }</td>
				<td>${member.user_Address }</td>
			 <td>${member.user_PhoneNumber }</td>
			</tr>
		</c:forEach>
		</c:when>
		
		</c:choose>
	</table>
	<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/shelterLocation.js"></script>
</body>
</html>