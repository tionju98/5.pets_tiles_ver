<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" href="css/board.css">
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
</head>
<body>
		<div class="jumbotron">
			<h3>게시글 작성</h3>
		</div>
        <div style="text-align: center; margin-top: 20px; margin-bottom: 20px;" >
        
        <!-- 공지사항 작성 form -->
        <form action="${contextPath}/notice/addNotice.do" method="post"  style="display:inline-block;">
        	<!-- 공지사항 제목 -->
        	<div class="writer_header" style="padding: 20px;">
        		<input type="text" name="no_title" placeholder="제목" style="width:600px;">
        	</div>
        	<!-- 공지사항 내용 -->
        	<div class="writer_content">
        		<textarea name="no_content" rows="8" cols="42"style="height: 300px; width:600px;"></textarea>
        	</div>
        	<!-- 공지사항 첨부파일 -->
        	<div class="writer_img" style="padding: 20px;">
        		<input type="file" name="no_image" id="no_image"/>
        		<div class="select_img"><img src="" /></div>
        		
        		<script>
        			$("#no_image").change(function(){
        				if(this.files && tis.files[0]){
        					var reader = new FileReader;
        					reader.onload = function(data){
        						$(".select_img img").attr("src", data.target.result).width(500);
        					}
        					reader.readAsDataURL(this.files[0]);
        				}
        			});
        			
        		</script>
        		
        	</div>
        	<!-- 공지사항 등록버튼 -->
            <div style="margin-top: 20px; text-align: right;">
            	<input type="submit" value="등록" class="btn">
            	<input type=button value="취소" OnClick="javascript:history.back(-1)" class="btn">
            </div>
        	
        </form>
        </div>
</body>
</html>
