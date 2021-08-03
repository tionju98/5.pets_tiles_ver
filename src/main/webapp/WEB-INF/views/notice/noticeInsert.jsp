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
    <title>Document</title>
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/kfonts2.css" rel="stylesheet">
    <style type="text/css">
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
    </style>
    <script>
    function readURL(input, index) {
		if(input.files && input.files[0]) {			//input 태그에 첫번째 선택파일이 있을때
			var reader = new FileReader();
			reader.onload = function(e) {
				$('#preview').attr('src', e.target.result);		// input file로 이미지 파일을 선택시 	id가 preview인 <img>태그에 src속성 값에 이미지를 바로 보이도록 변경 
			}
			reader.readAsDataURL(input.files[0]);				// reader가 File내용을 읽어 DataURL형식의 문자열로 저장
		}
	}
    
    function backToList(obj) {
        obj.action = "${contextPath}/notice/listNotices.do"
        obj.submit();
     }
    </script>
</head>
<body>
		<div class="jumbotron">
			<h3>게시글 작성</h3>
		</div>
        
        <!-- 공지사항 작성 form -->
        <form action="${contextPath}/notice/addNotice.do" method="post" enctype="multipart/form-data" style="text-align: center; margin-top: 20px; margin-bottom: 20px; display:inline-block;">
        	<!-- 공지사항 제목 -->
        	<div class="writer_header" style="padding: 20px;">
        		<input type="text" name="noTitle" placeholder="제목" style="width:600px;">
        	</div>
        	<!-- 공지사항 내용 -->
        	<div class="writer_content">
        		<textarea name="noContent" rows="8" cols="42"style="height: 300px; width:600px;"></textarea>
        	</div>
        	<!-- 공지사항 첨부파일 -->
        	<div class="writer_img" style="padding: 20px;">
        	
        		<input type="file" name="noticeImageFileName" onchange="readURL(this, 0)" />
        		<div class="select_img"><img alt="미리보기" src="#" width="200" height="200" id="preview" /></div>
        		
        		
        	</div>
        	<!-- 공지사항 등록버튼 -->
            <div style="margin-top: 20px; text-align: right;">
            	<input type="submit" value="등록" class="btn">
            	<input type=button value="취소"  onclick="backToList(this.form)" class="btn">
            </div>
        	
        </form>
</body>
</html>
