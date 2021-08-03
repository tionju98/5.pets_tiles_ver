<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<% 
	request.setCharacterEncoding("UTF-8"); 
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>보호동물 등록</title>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript">
		function readURL(input, index) {
			if(input.files && input.files[0]) {			//input 태그에 첫번째 선택파일이 있을때
				var reader = new FileReader();
				reader.onload = function(e) {
					$('#preview' + index).attr('src', e.target.result);		// input file로 이미지 파일을 선택시 	id가 preview인 <img>태그에 src속성 값에 이미지를 바로 보이도록 변경 
				}
				reader.readAsDataURL(input.files[0]);				// reader가 File내용을 읽어 DataURL형식의 문자열로 저장
			}
		}
		
		
		var cnt = 1;
		function fn_addFile() {
			cnt++;
			
			var innerHtml = "";
			innerHtml += '<tr width=100% align=center>';
			
			
/* 			innerHtml += '<td>' + "<input type=file name='file    "+cnt+"       '                 onchange='readURL(this,"+cnt+")       '                                          />"
						 + '</td>';
 */						 
			innerHtml += '<td>' + "<input type=file name='file"+cnt+"'onchange='readURL(this,"+cnt+")'/>"
			 + '</td>';						 

			 
/* 			innerHtml += '<td>'	+ "<img id='preview    "+cnt+"                         '          width=640 height=480                                                             />"		 
						 + '</td>';
 */						 
						 
			innerHtml += '<td>'	+ "<img id='preview"+cnt+"'width=640 height=480/>"		 
			 + '</td>';						 
						 
			innerHtml += '</tr>';
			
			$("#tb_newImage").append(innerHtml);
		}
		
		</script>
	<style type="text/css">
		.text_center {
			text-align: center;
		}
	</style>
</head>
<body>
	<form action="${contextPath}/protect/addBoard.do" enctype="multipart/form-data" method="post">
		<h1 class="text_center">보호동물 등록</h1>
		<table align="center">
			<tr>
				<td width="200"><p align="right">공고번호</td>
				<td width="400"><input type="text" name="proNoticeNum" /></td>
			</tr>
			<tr>
				<td width="200"><p align="right">품종</td>
				<td width="400"><input type="text" name="proKind" /></td>
			</tr>
			<tr>
				<td width="200"><p align="right">성별</td>
				<td width="400">
					<input type="radio" name="proGender" value="수컷">수컷
					<input type="radio" name="proGender" value="암컷">암컷
				</td>
			</tr>
			<tr>
				<td width="200"><p align="right">나이</td>
				<td width="400"><input type="text" name="proAge" /></td>
			</tr>
			<tr>
				<td width="200"><p align="right">발견장소</td>
				<td width="400"><input type="text" name="proPlace" /></td>
			</tr>
			<tr>
				<td width="200"><p align="right">발견일자</td>
				<td width="400"><input type="date" name="proFindDate" onblur="$('.calendar').hide();" /></td>
			</tr>
			<tr>
				<td width="200"><p align="right">특징</td>
				<td width="400"><input type="text" name="proCharacter" /></td>
			</tr>
			<tr>
				<td width="200"><p align="right">중성화</td>
				<td width="400">
					<input type="radio" name="proNeutering" value="예">예
					<input type="radio" name="proNeutering" value="아니오">아니오
					<input type="radio" name="proNeutering" value="모릅니다">모릅니다
				</td>
			</tr>
			<tr>
				<td width="200"><p align="right">등록번호</td>
				<td width="400"><input type="text" name="proRegistNum" /></td>
			</tr>
			<tr>
				<td width="200"><p align="right">상태</td>
				<td width="400"><input type="text" name="proState" /></td>
			</tr>
			<tr>
				<td width="200"><p align="right">보호소</td>
				<td width="400"><input type="text" name="proShelter" /></td>
			</tr>
			<tr>
				<td width="200"><p align="right">미리보기</td>
				<td width="400"><img alt="미리보기" src="#" width="200" height="200" id="preview0" /></td>
			</tr>
			<tr>
				<td width="200"><p align="right">사진</td>
				<td><input type="file" name="imageFileName" onchange="readURL(this, 0)" /></td><br/>
			</tr>
<!-- 			
			<tr>
				<td colspan="3">
					<table width="100%" border="0" id="tb_newImage">
					</table>
				</td>
			</tr>

 			
			<tr height="200px">
				<td colspan="3"></td>
			</tr>
		
			<tr>
				<td align="right">이미지파일 첨부</td>
				<td align="left" colspan="2">
					<input type="button" value="새 이미지 파일 추가하기" onclick="fn_addFile()" />
				</td>
			</tr>
			
			<tr>
				<td colspan="4">
					<div id="d_file"></div>
				</td>
			</tr>
-->
			
			<tr>
				<td width="200"><p align="right">아이디</td>
				<td width="400"><input type="text" name="userID" /></td>
			</tr>
			<tr>
				<td width="200"><p>&nbsp;</p></td>
				<td width="400">
					<input type="submit" value="등록하기" />
					<input type="reset" value="다시입력" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>