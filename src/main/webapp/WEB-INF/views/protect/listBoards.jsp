<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="boardsList" value="${boardMap.boardsList }" />
<c:set var="totBoards" value="${boardMap.totBoards }" />
<c:set var="section" value="${boardMap.section }" />
<c:set var="pageNum" value="${boardMap.pageNum }" />
<% 
	request.setCharacterEncoding("UTF-8"); 
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>보호동물 등록 게시판</title>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript" src="${contextPath}/resources/jquery/jquery-3.6.0.min.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.min.css">
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
	</div>
	
	<br>
		
		<c:set var="num" value="${boardMap.totBoards - ((boardMap.pageNum-1)*10) }" />
		<c:forEach var="board" items="${boardsList }" varStatus="boardNum">
			
				<div style="width: 45%; height: 170px; border: 1px solid gray; float: left; margin: 10px">
					<li>
						<div class="col-md-4">
						    <div>
						    	<div style="display: block;">
					        	    <a><img src="../resources/image/unnamed.jpg" alt="sometext"/></a>
					            </div>
					            
						    </div>
						    <div>
						        <dl><dt>공고번호</dt><dd>${board.pro_noticeNum }</dd></dl><br/>
						        <dl><dt>접수일자</dt><dd>${board.pro_findDate }</dd></dl><br/>
						        <dl><dt>품종</dt><dd>${board.pro_kind }</dd></dl><br/>
						        <dl><dt>성별</dt><dd>${board.pro_gender }</dd></dl><br/>
						        <dl><dt>발견장소</dt><dd>${board.pro_place }</dd></dl><br/>
						        <dl><dt>특징</dt><dd>${board.pro_character }</dd></dl><br/>
						        <dl><dt>상태</dt><dd>${board.pro_state }</dd></dl><br>
						        <div style="float: left;">
					        		<a href="${contextPath}/protect/viewBoard.do?pro_boardNum=${board.pro_boardNum}"><p style="font-size: 12px;">  자세히 보기</p></a>
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
	
	
	
	<a class="class1" href="${contextPath}/protect/boardForm.do"><p class="class2">등록하기</a>
	
	<a class="class1" href="javascript:fn_boardForm('${isLogOn}', '${contextPath}/protect/boardForm.do', '${contextPath}/member/loginForm.do')"><p class="class2">등록하기</a>
	
</body>
</html>