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
	<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" >
	<link href="${pageContext.request.contextPath}/resources/css/kfonts2.css" rel="stylesheet" >
	<title>문의 수정하기</title>
	<style type="text/css">
		.text_center {
			text-align: center;
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
</head>
<body>
	<form action="${contextPath}/board/addBoard.do" method="post">
		<h1 class="text_center">새글작성 페이지</h1>
		<table align="center">
			<tr>
				<td width="200"><p align="right">제목</td>
				<td width="400"><input type="text" name="qa_title" /> </td>
			</tr>
			
			<tr>
				<td width="200"><p align="right">카테고리</td>
				<!-- <td width="400"><input type="text" name="qa_category" /> </td> -->
				<td><select name="qa_category">
					<option value="동물" >동물</option>
					<option value="개인" >개인</option>
					<option value="단체" >단체</option>
					<option value="기타" >기타</option>
				</select> </td>
			</tr>
			
			<tr>
				<td width="200"><p align="right">내용</td>
				<td width="400"><textarea rows="20" cols="60" name="qa_content"></textarea> </td>
			</tr>
			
			<tr>
				<td width="200"><p align="right">아이디</td>
				<td width="400"><input type="text" name="user_id" readonly /> </td>
			</tr>
			<tr>
				<td width="200"><p>&nbsp;</p></td>
				<td width="400">
					<input type="submit" value="작성하기" />
					<input type="button" class="btn btn-success" value="게시글목록" onclick="backToList(this.form)">
					<input type="reset" value="다시입력" /> 
					
				</td>
			</tr>
		</table>
	</form>
</body>
</html>