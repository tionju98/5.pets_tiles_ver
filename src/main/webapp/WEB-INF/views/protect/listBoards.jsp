<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="boardsList" value="${boardMap.boardsList }" />
<c:set var="totBoards" value="${boardMap.totBoards }" />
<c:set var="section" value="${boardMap.section }" />
<c:set var="pageNum" value="${boardMap.pageNum }" />
<c:set var="proPets" value="${articleMap.proPets }" />
<c:set var="imageFileList" value="${articleMap.imageFileList}" />
<% 
	request.setCharacterEncoding("UTF-8"); 
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>보호동물 등록 게시판</title>
	<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" >
	<link href="${pageContext.request.contextPath}/resources/css/kfonts2.css" rel="stylesheet" >
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript" src="${contextPath}/resources/jquery/jquery-3.6.0.min.js"></script>
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
	</script>
	
	<script type="text/javascript">
		function fn_boardForm(isLogOn, boardForm, loginForm) {
			if(isLogOn != '' && isLogOn != 'false') {
				location.href=boardForm;
			}
			else{
				alert("로그인 후 글쓰기가 가능합니다")
				location.href=loginForm+'?action=/protect/boardForm.do';
			}
		}
	</script>
	
	<style type="text/css">
		.class1 {text-decoration: none;}
		.class2 {font-size: 30px;}
		.no-line {text-decoration: none;}
		.sel-page {text-decoration: none; color: red;}
	</style>
	<style type="text/css">
		#wrapper {
			
		}
		dt { 
			float: left;
			margin-right: 15px;	
			border: 1px;
			border-color: blue;
			border-style: solid;
			font-size: 12px;
		}
		dd { 
			float: left;
			font-size: 3;
			margin: 0px;
			padding: 0px;
			font-size: 12px;
		}
		img {
			float: left;
			margin-right: 20px;
			margin-bottom: 50px;
			
			width:120px;
			height:120px;
			display: block;
		}
		p {
		}
	</style>

</head>
<body>
	<div id="wrapper">
		<form action="${contextPath}/protect/searchBoards.do" name="frmSearch">
			<div>
				<input name="searchWord" class="" type="text" onkeyup="keywordSearch()" />
				<input name="search" class="" type="submit" value="검색"/>
			</div>
		</form>
	</div><br>
		
	<c:set var="num" value="${boardMap.totBoards - ((boardMap.pageNum-1)*10) }" />
		<c:forEach var="board" items="${boardsList }" varStatus="boardNum">
			
				<div style="width: 45%; height: 300px; border: 1px solid gray; float: left; margin: 10px;">
					<li>
						<div class="col-md-4">
						    <div>
						    	<div style="display: block;">
		        	    			<c:choose>
										<c:when test="${not empty imageFileList && imageFileList != 'null' }">
											<c:forEach var="item" items="${imageFileList}" varStatus="status">
												<tr id="tr_${status.count}">
													<td>
														<input type="hidden" name="originalFileName" value="${item.imageFileName}" />
														<input type="hidden" name="imgaeFileNo" value="${item.imageFileNo}">
														<img alt="사진" src="${contextPath}/download.do?proBoardNum=${board.proBoardNum}&imageFileName=${item.imageFileName}" id="preview${status.index}" width="300"><br/>
													</td>
												</tr>				
											</c:forEach>							
										</c:when>
										
									</c:choose>
					            </div>
						    </div>
						    <div>
						        <dl><dt>공고번호</dt><dd>${board.proNoticeNum }</dd></dl><br/>
						        <dl><dt>접수일자</dt><dd>${board.proFindDate }</dd></dl><br/>
						        <dl><dt>품종</dt><dd>${board.proKind }</dd></dl><br/>
						        <dl><dt>성별</dt><dd>${board.proGender }</dd></dl><br/>
						        <dl><dt>발견장소</dt><dd>${board.proPlace }</dd></dl><br/>
						        <dl><dt>특징</dt><dd>${board.proCharacter }</dd></dl><br/>
						        <dl><dt>상태</dt><dd>${board.proState }</dd></dl><br>
						        <div style="float: left;">
					        		<a href="${contextPath}/protect/viewBoard.do?proBoardNum=${board.proBoardNum}"><p style="font-size: 12px;">  자세히 보기</p></a>
					        	</div>
						    </div>
						</div>
					</li>
				</div>
			<c:set var="num" value="${num-1 }"></c:set>
		</c:forEach>
	<div style="clear: both;"></div> 
	
	<div class="class2">
		<c:if test="${totBoards != null }">
			<c:choose>
				<c:when test="${totBoards > 100 }">			<!-- 글 개수가 100 초과인 경우 -->
					<c:forEach var="page" begin="1" end="10" step="1">
						
						<c:if test="${section > 1 && page == 1 }">
							<a class="no-line"  href="${contextPath}/board/listBoards.do?section=${section-1}&pageNum=${(section-1)*10 +1}">&nbsp; pre </a>
						</c:if>
						
						<a class="no-line" href="">${(section-1)*10 +page}</a>			<!-- 실제페이지 숫자표시 -->
						
						<c:if test="${page == 10 }">
							<a class="no-line" href="${contextPath}/board/listBoards.do?section=${section+1}&pageNum=${section*10 +1}">&nbsp; next </a>
						</c:if>						
						
					</c:forEach>
				</c:when>
				
				<c:when test="${totBoards == 100 }">			<!-- 등록된 글 개수가 100개인 경우 -->
					<c:forEach var="page" begin="1" end="10" step="1">
						<a class="no-line" href="#">${page}</a>
					</c:forEach>
				</c:when>
				
				<c:when test="${totBoards < 100 }">			<!-- 글 개수가 100 미만인 경우 -->
					<c:forEach var="page" begin="1" end="${totBoards/10 +1}" step="1">
						<c:choose >
							<c:when test="${page == pageNum}">
								<a class="sel-page" href="${contextPath}/board/listBoards.do?section=${section}&pageNum=${page}">${page}</a>
							</c:when>
							<c:otherwise>
								<a class="no-line" href="${contextPath}/board/listBoards.do?section=${section}&pageNum=${page}">${page}</a>
							</c:otherwise>
						</c:choose>
					</c:forEach>				
				</c:when>
				
			</c:choose>
		</c:if>
	</div>
	
	<a class="class1" href="javascript:fn_boardForm('${isLogOn}', '${contextPath}/protect/boardForm.do', '${contextPath}/member/loginForm.do')"><p class="class2">등록하기</a>
	
</body>
</html>