<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	request.setCharacterEncoding("UTF-8");
%>      
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" >
	<link href="${pageContext.request.contextPath}/resources/css/kfonts2.css" rel="stylesheet" >
<title>상세조회 페이지</title>
<style type="text/css">
		#tr_btn_mod {
			display: none;
		}
		table{
		    width: 70%;
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
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
		
	
	function fn_enable(obj) {
		obj.action = "${contextPath}/protect/updateForm.do"
		obj.submit();
	}
	
	function backToList(obj) {
		obj.action = "${contextPath}/protect/listBoards.do"
		obj.submit();
	}
	function removeList(obj) {
		obj.action = "${contextPath}/protect/removeBoard.do?pro_boardNum=${board.pro_boardNum}"
		obj.submit();
	}
	
</script>
</head>
<body>
<form action="${contextPath}" name="frmBoard" method="post" enctype="multipart/form-data">
	<h1 align="center">게시판 상세정보 출력</h1>
	<table border="1" align="center" width="80%" >
			
			
			<tr>
				<td width="200"><p align="right">공고번호</td>
				<td width="400"><input type="text" name="pro_noticeNum" value="${vo.pro_noticeNum}" disabled /></td>
			</tr>
			<tr>
				<td width="200"><p align="right">품종</td>
				<td width="400"><input type="text" name="pro_kind" value="${vo.pro_kind}" disabled /></td>
			</tr>
			<tr>
				<td width="200"><p align="right">성별</td>
				<td width="400"><input type="text" name="pro_gender" value="${vo.pro_gender}" disabled /></td>
			</tr>
			<tr>
				<td width="200"><p align="right">나이</td>
				<td width="400"><input type="text" name="pro_age" value="${vo.pro_age}" disabled /></td>
			</tr>
			<tr>
				<td width="200"><p align="right">발견장소</td>
				<td width="400"><input type="text" name="pro_place" value="${vo.pro_place}" disabled /></td>
			</tr>
			<tr>
				<td width="200"><p align="right">발견일자</td>
				<td width="400"><input type="text" name="pro_findDate" value="${vo.pro_findDate}" disabled /></td>
			</tr>
			<tr>
				<td width="200"><p align="right">특징</td>
				<td width="400"><input type="text" name="pro_character" value="${vo.pro_character}" disabled /></td>
			</tr>
			<tr>
				<td width="200"><p align="right">중성화</td>
				<td width="400"><input type="text" name="pro_neutering"  value="${vo.pro_neutering}" disabled /></td>
			</tr>
			<tr>
				<td width="200"><p align="right">등록번호</td>
				<td width="400"><input type="text" name="pro_registNum" value="${vo.pro_registNum}" disabled /></td>
			</tr>
			<tr>
				<td width="200"><p align="right">상태</td>
				<td width="400"><input type="text" name="pro_state" value="${vo.pro_state}" disabled /></td>
			</tr>
			<tr>
				<td width="200"><p align="right">보호소</td>
				<td width="400"><input type="text" name="pro_shelter" value="${vo.pro_shelter}" disabled /></td>
			</tr>
			<tr>
				<td width="200"><p align="right">사진</td>
				<td>
				<input type="hidden" name="originalFileName" value="${protect.imageFileName }" />
				<img alt="사진" src="C:\\workspace-sts\\article_image\\"+${protect.pro_boardNum }+"\\"+"${protect.imageFileName }" id="preview" width="300"><br/>
				</td>
			</tr>
			
			<tr id="tr_btn">
				<td colspan="2" align="center">
					<input type="button" value="수정하기" onclick="fn_enable(this.form)" />
					<input type="button" value="삭제하기" onclick="removeList(this.form)">
					<input type="button" value="게시글목록" onclick="backToList(this.form)">
				</td>
			</tr>
	</table>
	</form>
</body>
</html>