<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<%
	request.setCharacterEncoding("utf-8");
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>검색결과</title>
	<style type="text/css">
		.class1 {text-decoration: none;}
		.class2 {text-align: center; font-size: 30px;}
		.no-line {text-decoration: none;}
		.sel-page {text-decoration: none; color: red;}
		}

	</style>
	<style type="text/css">
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
	</style>
</head>
<body>
	<hgroup>
		<h1>게시판 검색 결과</h1>
	</hgroup>

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
						        <dl><dt>상태</dt><dd>${board.pro_state }</dd></dl><br/>
						        
						        
						        <div style="float: left;">
					        		<a><p style="font-size: 12px;">  자세히 보기</p></a>
					        	</div>
						    </div>
						</div>
					</li>
				</div>
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

</body>
</html>