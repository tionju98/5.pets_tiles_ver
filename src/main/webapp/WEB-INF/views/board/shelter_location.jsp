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
	<script type="text/javascript">
	var loopSearch = true;
	
	function keywordSearch() {
		if(loopSearch == false)
			return;
		
		var value = document.shSearch.searchWord.value;
		
		$.ajax({
			type: 'get',
			async: true,
			url: "${contextPath}/member/keywordSearch.do",
			data: {keyword:value},						/* 매개변수 이름 keyword로 JSON 데이터를 ajax로 전송함  */
			success: function(data, textStatus) {
				var jsonInfo = JSON.parse(data);
				displayResult(jsonInfo);
			},
			error: function(data, textStatus) {
				alert("에러가 발생했습니다." + data);
			},
			complete: function(data, textStatus) {
				
			}
		});
	}
	
	function displayResult(jsonInfo) {
	 	var count = jsonInfo.keyword.length;
	 	if(count>0) {
	 		var html = '';
	 		for(var i in jsonInfo.keyword) {
	 			html += "<a href=\"javascript:select('"+jsonInfo.keyword[i]+"')\">"+jsonInfo.keyword[i]+"</a><br/>";
	 		}
		 	var listView = document.getElementById("autocompleteList");
		 	listView.innerHTML = html;
		 	show('autocomplete');		 		
	 	}
	 	else {
	 		hide('autocomplete');
	 	}	 	
	}
		
	function select(selectedKeyword) {
		document.shSearch.searchWord.value=selectedKeyword;
		loopSearch = false;
		hide('autocomplete');
	}
	
	function show(elementId) {
		var element = document.getElementById(elementId);
		if(element) {
			element.style.display = 'block';
		}
	}
	
	function hide(elementId) {
		var element = document.getElementById(elementId);
		if(element) {
			element.style.display = 'none';
		}			
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
	<tr style="align: right;">
	<td><p>지역 입력 :</p></td>
    			<td colspan="5" style="display:inline-block; border:white;">
    			
    			<form action="${contextPath}/member/searchBoards.do" name="shSearch">
    				<input name="searchWord" class="" type="text" onkeyup="keywordSearch()" />
					<input name="search" class="btn btn-success" type="submit" value="검색" />
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
				<td>${member.userNAME }</td>
				<td>${member.userAddress }</td>
			 <td>${member.userPhoneNumber }</td>
			</tr>
		</c:forEach>
		</c:when>
		
		</c:choose>
	</table>
	<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>

</body>
</html>