<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
	request.setCharacterEncoding("utf-8");
%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="notice" value="${noticleMap.notice }" />				<!-- NoticeServiceImpl서비스의 viewNotice() 메서드에서 noticeVO를 notice로 저장함 -->

<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>공지사항 수정</title>
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
<form action="${contextPath}/notice/modNotice.do" name="update"method="get" style="text-align: center;">
	
	<div class="jumbotron" style="margin-top: 20px; text-align: left;">
		<h3>공지사항</h3>
	</div>
	
	<div class="container" style="margin-bottom: 20px">
		
		
		<div class="content">
			
        	<!-- 공지사항 제목 -->
        	<div class="writer_header" style="padding: 20px;">
        		<input type="text" name="no_title" style="width:600px;" value="${notice.no_title }">
        		<input type="hidden" name="no_number" value="${notice.no_number }" />
        	</div>
        	<!-- 공지사항 내용 -->
        	<div class="writer_content">
        		<textarea name="no_content" rows="8" cols="42"style="height: 300px; width:600px;">${notice.no_content }</textarea>
        	</div>
        	<!-- 공지사항 첨부파일 -->
        	<div class="writer_img" style="padding: 20px;">
        		<input type="file" name="no_image"/>
        	</div>
		
			<img src="#">
		
			<div style="text-align: center;">
				<%-- <a href="${contextPath}/notice/updateNoticeDo.do?no_number=${notice.no_number}">
					<input type="button" value="수정" class="btn">
				</a> --%>
				<input type="submit" value="수정" class="btn">
        	  <input type=button value="목록" OnClick="javascript:history.back(-1)" class="btn">
			</div>
		</div>
	</div>
	
</form>

</body>
</html>