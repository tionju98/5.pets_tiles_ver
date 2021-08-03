<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	request.setCharacterEncoding("UTF-8");
%>      
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<c:set var="proPets" value="${articleMap.proPets }" />
<c:set var="imageFileList" value="${articleMap.imageFileList}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" >
	<link href="${pageContext.request.contextPath}/resources/css/kfonts2.css" rel="stylesheet" >
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript" src="${contextPath}/resources/jquery/jquery-3.6.0.min.js"></script>
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
	
	<script type="text/javascript">
		function readURL(input) {
			if (input.files && input.files[0]) {							/* 이미지 파일 첨부 시 미리 보기 기능 */
				var reader = new FileReader();
				reader.onload = function(e) {
					$('#preview').attr("src", e.target.result);				/* e.target은 이벤트가 일어난 대상, 즉 input 자신을 가리킴*/
				}															/* result는 첨부파일들이 특수하게 가공된 URL을 출력해 줄것임. */
				reader.readAsDataURL(input.files[0]);
			}
		}
		
		function fn_enable(obj) {
			obj.action = "${contextPath}/protect/updateForm.do"
			obj.submit();
		}
		
		function backToList(obj) {
			obj.action = "${contextPath}/protect/listBoards.do"
			obj.submit();
		}
		function removeList(obj) {
			obj.action = "${contextPath}/protect/removeBoard.do?proBoardNum=${proPets.proBoardNum}"
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
				<td width="400"><input type="text" name="proNoticeNum" value="${proPets.proNoticeNum}" disabled /></td>
			</tr>
			<tr>
				<td width="200"><p align="right">품종</td>
				<td width="400"><input type="text" name="proKind" value="${proPets.proKind}" disabled /></td>
			</tr>
			<tr>
				<td width="200"><p align="right">성별</td>
				<td width="400"><input type="text" name="proGender" value="${proPets.proGender}" disabled /></td>
			</tr>
			<tr>
				<td width="200"><p align="right">나이</td>
				<td width="400"><input type="text" name="proAge" value="${proPets.proAge}" disabled /></td>
			</tr>
			<tr>
				<td width="200"><p align="right">발견장소</td>
				<td width="400"><input type="text" name="proPlace" value="${proPets.proPlace}" disabled /></td>
			</tr>
			<tr>
				<td width="200"><p align="right">발견일자</td>
				<td width="400"><input type="text" name="proFindDate" value="${proPets.proFindDate}" disabled /></td>
			</tr>
			<tr>
				<td width="200"><p align="right">특징</td>
				<td width="400"><input type="text" name="proCharacter" value="${proPets.proCharacter}" disabled /></td>
			</tr>
			<tr>
				<td width="200"><p align="right">중성화</td>
				<td width="400"><input type="text" name="proNeutering"  value="${proPets.proNeutering}" disabled /></td>
			</tr>
			<tr>
				<td width="200"><p align="right">등록번호</td>
				<td width="400"><input type="text" name="proRegistNum" value="${proPets.proRegistNum}" disabled /></td>
			</tr>
			<tr>
				<td width="200"><p align="right">상태</td>
				<td width="400"><input type="text" name="proState" value="${proPets.proState}" disabled /></td>
			</tr>
			<tr>
				<td width="200"><p align="right">보호소</td>
				<td width="400"><input type="text" name="proShelter" value="${proPets.proShelter}" disabled /></td>
			</tr>
			
			<c:choose>
				<c:when test="${not empty imageFileList && imageFileList != 'null' }">
					<c:forEach var="item" items="${imageFileList}" varStatus="status">
						<tr id="tr_${status.count}">
							<td width="200"><p align="right">사진${status.count}</td>
							<td>
								<input type="hidden" name="originalFileName" value="${item.imageFileName }" />
								<input type="hidden" name="imgaeFileNo" value="${item.imageFileNo }">
								<img alt="사진" src="${contextPath}/download.do?proBoardNum=${proPets.proBoardNum}&imageFileName=${item.imageFileName}" id="preview${status.index}" width="300"><br/>
							</td>
						</tr>				
					</c:forEach>							
				</c:when>
				
			</c:choose>


			
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