<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

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
	<title>보호소 검색결과 </title>
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript">
	function backToList(obj) {
		obj.action = "${contextPath}/member/shelter_location.do"
		obj.submit();
	}
	</script>
	<style type="text/css">
		.table{
		    width: 60%;
		    margin-left: auto;
		    margin-right: auto;
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
				<td>${member.userNAME }</td>
				<td>${member.userAddress }</td>
			 <td>${member.userPhoneNumber }</td>
			</tr>
		</c:forEach>
		</c:when>
		
		</c:choose>
	</table>
	<form name="frm">
		<input type="button" value="보호소 목록" onclick="backToList(this.form)">
	</form>
	<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>

</body>
</html>
