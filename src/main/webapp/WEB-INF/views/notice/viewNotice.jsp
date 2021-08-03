<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
	request.setCharacterEncoding("utf-8");
%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="notice" value="${noticeMap.notice}" />				<!-- NoticeServiceImpl서비스의 viewNotice() 메서드에서 noticeVO를 notice로 저장함 -->
<c:set var="noticeImageFileList" value="${noticeMap.noticeImageFileList}" />
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>상세페이지 조회</title>
	  <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/kfonts2.css" rel="stylesheet">
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
		
	    function backToList(obj) {
	        obj.action = "${contextPath}/notice/listNotices.do"
	        obj.submit();
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

<form action="${contextPath}" name="frmBoard" enctype="multipart/form-data" name="view" method="post">
	
	<div class="jumbotron" style="margin-top: 20px;">
		<h3>공지사항</h3>
	</div>
	
	<div class="container" style="margin-bottom: 20px">
		<div class="header" style="margin-bottom: 20px; margin-top: 20px;">
			<div class="headline">
				<h4>${notice.noTitle }</h4>
			</div>
			
			<div class="headline_content">
				<span>작성일 : </span> ${notice.noDate }&nbsp;&nbsp;&nbsp;&nbsp;
				<span>작성자 : </span> ${notice.noWriter }&nbsp;&nbsp;&nbsp;&nbsp;
				<span>조회수 : </span> ${notice.noHits }
			</div>
		</div>
		
		<div class="content">
			
			
			<div class="">${notice.noContent}</div>
			
		<c:choose>
			<c:when test="${not empty noticeImageFileList && noticeImageFileList != 'null' }">
				<c:forEach var="item" items="${noticeImageFileList}" varStatus="status">
						<div style="padding: 10px;">
						<input type="hidden" name="originalFileName" value="${item.noticeImageFileName }" />
						<input type="hidden" name="noticeImageNo" value="${item.noticeImageNo}" />
						<img alt="사진" src="${contextPath}/noticeDownload.do?noNumber=${notice.noNumber}&noticeImageFileName=${item.noticeImageFileName}" id="preview${status.index }" width="300"><br/>
						</div>
				</c:forEach>
			</c:when>
		</c:choose>
			<div style="text-align: center;">
				<a href="${contextPath}/notice/updateNotice.do?noNumber=${notice.noNumber}">
					<input type="button" value="수정" class="btn">
				</a>	
				<a href="${contextPath}/notice/removeNotice.do?noNumber=${notice.noNumber}">
					<input type="button" value="삭제" class="btn">
				</a>
        	  <input type=button value="목록" onclick="backToList(this.form)"  class="btn">
			</div>
		</div>
	</div>
	
</form>

</body>
</html>