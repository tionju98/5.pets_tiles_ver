<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
	request.setCharacterEncoding("utf-8");
%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
    
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>상세페이지 조회</title>
	  <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/kfonts2.css" rel="stylesheet">
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript">
		function readURL(input) {
			if(input.files && input.files[0]) {			//input 태그에 첫번째 선택파일이 있을때
				var reader = new FileReader();
				reader.onload = function(e) {
					$('#preview').attr('src', e.target.result);		// input file로 이미지 파일을 선택시 	id가 preview인 <img>태그에 src속성 값에 이미지를 바로 보이도록 변경 
				}
				reader.readAsDataURL(input.files[0]);				// reader가 File내용을 읽어 DataURL형식의 문자열로 저장
			}
		}
		
		function fn_enable() {
			document.getElementById("no_title_update").disable=false;
			document.getElementById("no_content_update").disable=false;
			document.getElementById("tr_btn_modify").style.display="block";
			document.getElementById("tr_btn").style.display="none";
			$(".tr_updateEnable").css("visibility","visible");
		}
		
	
	</script>
	<style type="text/css">
		.header{
				border-bottom: 1px solid #dcdcdc;
  			  background: #fbfafa;
		}
   		.btn{
   		outline: 0;
	    display: inline-block;
	    line-height: 20px!important;
	    padding: 0 15px!important;
	    margin: 0;
	    font-size: 12px;
	    color: #333;
	    background-color: #D6C197;
    }
    .content{
    
    }
	</style>
</head>
<body>

<form action="${contextPath}/notice/viewNotice.do" name="view"method="get">
	
	<div class="jumbotron" style="margin-top: 20px;">
		<h3>공지사항</h3>
	</div>
	
	<div class="container" style="margin-bottom: 20px">
		<div class="header" style="margin-bottom: 20px; margin-top: 20px;">
			<div class="headline">
				<h4>${notice.no_title }</h4>
			</div>
			
			<div class="headline_content">
				<span>작성일 : </span> ${notice.no_date }&nbsp;&nbsp;&nbsp;&nbsp;
				<span>작성자 : </span> ${notice.no_writer }&nbsp;&nbsp;&nbsp;&nbsp;
				<span>조회수 : </span> ${notice.no_hits }
			</div>
		</div>
		
		<div class="content">
			
			
			<div class="">${notice.no_content}</div>
			
		
			<img src="#">
		
			<div style="text-align: center;">
				<a href="${contextPath}/notice/updateNotice.do?no_number=${notice.no_number}">
					<input type="button" value="수정" class="btn">
				</a>	
				<a href="${contextPath}/notice/removeNotice.do?no_number=${notice.no_number}">
					<input type="button" value="삭제" class="btn">
				</a>
        	  <input type=button value="목록" OnClick="javascript:history.back(-1)" class="btn">
			</div>
		</div>
	</div>
	
</form>

</body>
</html>