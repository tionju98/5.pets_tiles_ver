<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	request.setCharacterEncoding("UTF-8");
%>      
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="miss" value="${missMap.miss}" />	<!-- board는 boardVO를 뜻함 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" >
	<link href="${pageContext.request.contextPath}/resources/css/kfonts2.css" rel="stylesheet" >
<title>상세조회 페이지</title>
<style type="text/css">
		input[type=radio] { vertical-align:middle; }
		#tr_btn_modify {
			display: none;
		}
		.tr_modEnable {
			visibility: hidden;
		}
		table{
		     width: 60%;
		    margin-left: auto;
		    margin-right: auto;
		    border-collapse: collapse;
		    line-height: 19px;
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
	
	function fn_enable() {
		document.getElementById("qa_title_mod").disabled=false;
		document.getElementById("qa_content_mod").disabled=false;
		document.getElementById("qa_category_mod").disabled=false;
		document.getElementById("qa_secret_mod").disabled=false;
		document.getElementById("tr_btn_modify").style.display="block";
		document.getElementById("tr_btn").style.display="none";
		$(".tr_modEnable").css("visibility", "visible");
	}
	
	function backToList(obj) {
		obj.action = "${contextPath}/miss/m_listBoards.do"
		obj.submit();
	}
	function removeList(obj) {
		obj.action = "${contextPath}/board/removeBoard.do?qa_No=${board.qa_No}"
		obj.submit();
	}
	
	function fn_modify_article(obj) {
		obj.action="${contextPath}/board/modBoard.do";
		obj.submit();
	}
	
	function fn_reply_form(url, qa_No) {
		var form = document.createElement("form");
		form.setAttribute("method", "post");
		form.setAttribute("action", url);
		
		var parentNoInput = document.createElement("input");
		parentNoInput.setAttribute("type", "hidden");
		parentNoInput.setAttribute("name", "parentNo");
		parentNoInput.setAttribute("value", parentNo);
		
		form.appendChild(parentNoInput);
		document.body.appendChild(form);
		form.submit();
	}
</script>
</head>
<body>

	<form action="${contextPath}/miss/m_addBoard.do" enctype="multipart/form-data" method="post">
		<h1 class="text_center">보호동물 등록</h1>
		<table align="center">
			<tr>
				<td width="200"><p align="right">동물 이름</td>
				<td width="400"><input type="text" name="missName" value="${miss.missName}" disabled /></td>
			</tr>
			<tr>
				<td width="200"><p align="right">작성자</td>
				<td width="400"><input type="text" name="userNAME" value="${miss.userNAME}" disabled /></td>
			</tr>
			<tr>
				<td width="200"><p align="right">작성자 이메일</td>
				<td width="400"><input type="text" name="userEmail" value="${miss.userEmail}" disabled /></td>
			</tr>
			<tr>
				<td width="200"><p align="right">작성자 주소</td>
				<td width="400"><input type="text" name="userAddress" value="${miss.userAddress}" disabled /></td>
			</tr>
			<tr>
				<td width="200"><p align="right">작성자 전화번호</td>
				<td width="400"><input type="text" name="userPhoneNumber" value="${miss.userPhoneNumber}" disabled /></td>
			</tr>
			<tr>
				<td width="200"><p align="right">품종</td>
				<td width="400"><input type="text" name="missKind" value="${miss.missKind}" disabled /></td>
			</tr>
			<tr>
				<td width="200"><p align="right">성별</td>
				<td width="400">
					<input type="text" name="missGender" value="${miss.missGender}" disabled/>
				</td>
			</tr>
			<tr>
				<td width="200"><p align="right">나이</td>
				<td width="400"><input type="text" name="missAge" value="${miss.missAge}" disabled /></td>
			</tr>
			<tr>
				<td width="200"><p align="right">실종장소</td>
				<td width="400"><input type="text" name="missPlace" value="${miss.missPlace}" disabled /></td>
			</tr>
			<tr>
				<td width="200"><p align="right">실종일자</td>
				<td width="400"><input type="text" name="missMissdate" value="${miss.missMissdate}"  disabled /></td>
			</tr>
			<tr>
				<td width="200"><p align="right">특징</td>
				<td width="400"><input type="text" name="missCharacter" value="${miss.missCharacter}" disabled /></td>
			</tr>
			<tr>
				<td width="200"><p align="right">등록번호</td>
				<td width="400"><input type="text" name="missRegistNum" value="${miss.missRegistNum}" disabled /></td>
			</tr>
			<tr>
				<td width="200"><p align="right">이미지대신</td>
				<td width="400"><input type="text" name="missImg" value="${miss.missImg}" disabled /></td>
			</tr>
			<!-- <tr>
				<td width="200"><p align="right">미리보기</td>
				<td width="400"><img alt="미리보기" src="#" width="200" height="200" id="preview0" /></td>
			</tr>
			<tr>
				<td width="200"><p align="right">사진</td>
				<td><input type="file" name="imageFileName" onchange="readURL(this, 0)" /></td><br/>
			</tr> -->
			<tr>
				<td width="200"><p align="right">아이디</td>
				<td width="400"><input type="text" name="userID" value="${miss.userID}" disabled /></td>
			</tr>
				<tr id="tr_btn_modify" align="right">
				<td colspan="2">
					<input type="button" class="btn btn-success" value="수정반영하기" onclick="fn_modify_article(frmBoard)" />
					<input type="button" class="btn btn-danger" value="취소" onclick="backToList(frmBoard)" />
				</td>
			</tr>
			
			<tr id="tr_btn">
				<td colspan="3" align="center">
				<c:if test="${member.userID == board.userID }">
					<input type="button" class="btn btn-warning" value="수정하기" onclick="fn_enable()" />
					<input type="button" class="btn btn-danger" value="삭제하기" onclick="removeList(this.form)">
					</c:if>
					<input type="button" class="btn btn-primary" value="게시글목록" onclick="backToList(this.form)">
					<input type="button" value="답급달기" onclick="fn_reply_form('${contextPath}/miss/m_listBoards.do', ${miss.missBoardNum})" />   <!-- 요청명과 글번호를 전달함  -->
				</td>
			</tr>
		</table>
	</form>
<%-- <form name="frmBoard" method="post" >
	<h1 align="center">게시판 상세정보 출력</h1>
	<table border="1" align="center" width="80%" >
			
			<tr>
				<td width="200"><p align="center">문의번호</td>
				<td colspan="2" width="300">
					<input type="text" name="qa_No" value="${board.qa_No}" disabled/>
					<input type="hidden" name="qa_No" value="${board.qa_No }" />
				</td>
			</tr>
				
			<tr>
				<td width="200"><p align="center">제목</td>
				<td colspan="2" width="300"><input type="text" id="qa_title_mod" name="qa_title" value="${board.qa_title}" disabled /> </td>
			</tr>
			
			<tr>
				<td width="200"><p align="center">문의종류</td>
				<td colspan="2" width="300"><select name="qa_category" id="qa_category_mod" disabled>
					<option value="${board.qa_category}" >${board.qa_category}</option>
					<option value="동물" >동물</option>
					<option value="개인" >개인</option>
					<option value="단체" >단체</option>
					<option value="기타" >기타</option>
				</select> </td>
			</tr>
			
			<tr>
				<td width="200"><p align="center">내용</td>
				<td colspan="2" width="300"><textarea rows="4" id="qa_content_mod" cols="40" name="qa_content" disabled>${board.qa_content}</textarea> </td>
			</tr>
			
			<tr>
				<td width="200"><p align="center">등록일</td>
				<td colspan="2" width="300"><input type="text" name="qa_date" value="${board.qa_date}" disabled/> </td>
			</tr>
			
			<tr>
				<td><p align="center">공개여부</td>
				<td colspan="2" width="300"><select name="qa_secret" id="qa_secret_mod" disabled>
					<option value="${board.qa_secret}" >공개여부 : ${board.qa_secret}</option>
					<option value="Y" >공개</option>
					<option value="N" >비공개</option>
				</select> </td>
			</tr>
			
			<tr>
				<td width="200"><p align="center">등록자</td>
				<td colspan="2" width="300"><input type="text" name="user_id" value="${board.user_ID}" disabled/> </td>
			</tr>
			
			<tr id="tr_btn_modify" align="right">
				<td colspan="2">
					<input type="button" class="btn btn-success" value="수정반영하기" onclick="fn_modify_article(frmBoard)" />
					<input type="button" class="btn btn-danger" value="취소" onclick="backToList(frmBoard)" />
				</td>
			</tr>
			
			<tr id="tr_btn">
				<td colspan="3" align="center">
				<c:if test="${member.user_ID == board.user_ID }">
					<input type="button" class="btn btn-warning" value="수정하기" onclick="fn_enable()" />
					<input type="button" class="btn btn-danger" value="삭제하기" onclick="removeList(this.form)">
					</c:if>
					<input type="button" class="btn btn-primary" value="게시글목록" onclick="backToList(this.form)">
					<input type="button" value="답급달기" onclick="fn_reply_form('${contextPath}/board/replyForm.do', ${board.qa_No})" />   <!-- 요청명과 글번호를 전달함  -->
				</td>
			</tr>
	</table>
	</form> --%>
</body>
</html>