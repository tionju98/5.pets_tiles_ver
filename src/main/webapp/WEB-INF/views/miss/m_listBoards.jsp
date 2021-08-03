<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />  
<c:set var="m_boardsList" value="${missMap.m_boardsList }" />
<c:set var="totBoards" value="${missMap.totBoards }" />
<c:set var="section" value="${missMap.section }" />
<c:set var="pageNum" value="${missMap.pageNum }" /> 
<%
	request.setCharacterEncoding("UTF-8");
%>    
<!DOCTYPE html> 
<html>
	<head>
	<meta charset="UTF-8">
	<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" >
	<link href="${pageContext.request.contextPath}/resources/css/kfonts2.css" rel="stylesheet" >
	<title>실종 동물</title>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript" src="${contextPath}/resources/jquery/jquery-3.6.0.min.js"></script>
	<script type="text/javascript">
	function fn_boardForm(isLogOn, missForm, loginForm) {
		if(isLogOn != '' && isLogOn != 'false') {
			location.href=missForm;
		}
		else{
			alert("로그인 후 글쓰기가 가능합니다")
			location.href=loginForm+'?action=/miss/missForm.do';
		}
	}
	</script>
	<style type="text/css">
		#tr_btn_modify {
			display: none;
		}
	
		.table{
		     width: 60%;
		    margin-left: auto;
		    margin-right: auto;
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

	<div id="wrapper">
			<form action="${contextPath}/miss/m_searchBoards.do" name="frmSearch">
				<div>
					<input name="searchWord" class="" type="text" onkeyup="keywordSearch()" />
					<input name="search" class="" type="submit" value="검색"/>
				</div>
			</form>
			<h2>실종동물 게시판</h2>
		</div>
	
	<br>
		<c:choose>
		
		<c:when test="${empty member.userID }">
			<tr height="10">
					<td colspan="5">
						<p align="center">
							<b><span style="font-size: 9pt;">로그인을 해주세요.</span></b>
						</p>
					</td>
				</tr>
		</c:when>
		
		<c:when test="${empty m_boardsList }">
			<tr height="10">
					<td colspan="5">
						<p align="center">
							<b><span style="font-size: 9pt;">등록된 게시물이 없습니다.</span></b>
						</p>
						<a class="btn btn-success" href="${contextPath}/miss/missForm.do">실종등록</a>
					</td>
				</tr>
		</c:when>
		
		<c:when test="${!empty m_boardsList }">
		<c:set var="num" value="${missMap.totBoards - ((missMap.pageNum-1)*10) }" />
		<c:forEach var="miss" items="${m_boardsList }" varStatus="m_boardNum">
			
				<div style="width: 45%; height: 170px; border: 1px solid gray; float: left; margin: 10px">
					<li>
						<div class="col-md-4">
						<a class="btn btn-success" href="${contextPath}/miss/missForm.do">실종등록</a>
						    <div>
						    	<div style="display: block;">
					        	    <a><img src="../resources/image/doggy.jpg" alt="sometext"/></a>
					            </div>
					            
						    </div>
						    <div>
						        <dl><dt>게시번호</dt><dd>${num }</dd></dl><br/>
						        <dl><dt>이름</dt><dd>${miss.missName}</dd></dl><br/>
						        <dl><dt>신고자</dt><dd>${miss.userNAME}</dd></dl><br/>
						        <dl><dt>품종</dt><dd>${miss.missKind}</dd></dl><br/>
						        <dl><dt>성별</dt><dd>${miss.missGender}</dd></dl><br/>
						        <dl><dt>분실날짜</dt><dd>${miss.missMissdate}</dd></dl><br/>
						        <dl><dt>분실장소</dt><dd>${miss.missPlace}</dd></dl><br/>
						        <dl><dt>특징</dt><dd>${miss.missCharacter}</dd></dl><br>
						        <div style="float: left;">
					        		<a href="${contextPath}/miss/m_viewBoard.do?missBoardNum=${miss.missBoardNum}"><p style="font-size: 12px;">  자세히 보기</p></a>
					        	</div>
						    </div>
						</div>
					</li>
				</div>
			<c:set var="num" value="${num-1 }"></c:set>
		</c:forEach>
		</c:when>
		
		</c:choose>
	<div style="clear: both;"></div> 

	<%-- <table class="table table-hover">
		<tr>
    			<td colspan="5" style="display:inline-block; align:right; border:white;">
    				<a href="javascript:fn_boardForm('${isLogOn}', '${contextPath}/miss/missForm.do', '${contextPath}/member/loginForm.do')">실종동물 등록하기</a>
    			</td>
    		</tr>
		<tr>
			<th style="width:10%;"><b>번호</b></th>
			<th style="width:20%;"><b>아이디</b></th>
			<th style="width:50%;"><b>제목</b></th>
			<th style="width:10%;"><b>카테고리</b></th>
			<th style="width:10%;"><b>날짜</b></th>
		</tr>
		
		
		<c:choose>
		
			<c:when test="${empty member.user_ID }">
			<tr height="10">
					<td colspan="5">
						<p align="center">
							<b><span style="font-size: 9pt;">로그인을 해주세요.</span></b>
						</p>
					</td>
				</tr>
		</c:when>
		
		
		
			<c:when test="${empty boardsList }">
				<tr height="10">
					<td colspan="5">
						<p align="center">
							<b><span style="font-size: 9pt;">등록된 글이 없습니다.</span></b>
						</p>
					</td>
				</tr>
		</c:when>
		
		
		<c:when test="${!empty boardsList }">
		<c:set var="num" value="${boardMap.totBoards - ((boardMap.pageNum-1)*10) }" />
		<c:forEach var="board" items="${boardsList }" varStatus="boardNum" >
			<tr align="center">
				<td>${num }</td>
				<td>${board.user_ID }</td>
				<td>
			 <c:if test="${board.qa_secret eq 'N'}" >
            <c:choose>
                <c:when test="${board.user_ID eq member.user_ID}">
                    <a href="${contextPath}/board/viewBoard.do?qa_No=${board.qa_No}">${board.qa_title }</a>
                </c:when>
                <c:otherwise>비밀글 입니다.</c:otherwise>
            </c:choose>
        </c:if>
        <c:if test="${board.qa_secret eq 'Y'}" >
            <a href="${contextPath}/board/viewBoard.do?qa_No=${board.qa_No}">${board.qa_title }</a>
        </c:if>
			 	
			 </td>
				<td>${board.qa_category }</td>
				<td>${board.qa_date }</td>
			</tr>
			<c:set var="num" value="${num-1 }"></c:set>
		</c:forEach>
		</c:when>
		
		</c:choose>
	</table> --%>

	<div class="class2">
		<c:if test="${totBoards != null }">
			<c:choose>
				<c:when test="${totBoards > 100 }">			<!-- 글 개수가 100 초과인 경우 -->
					<c:forEach var="page" begin="1" end="10" step="1">
						
						<c:if test="${section > 1 && page == 1 }">
							<a class="no-line"  href="${contextPath}/miss/m_listBoards.do?section=${section-1}&pageNum=${(section-1)*10 +1}">&nbsp; pre </a>
						</c:if>
						
						<a style="font-size: 20px; color: black;" class="no-line" href="">${(section-1)*10 +page}</a>		<!-- 실제페이지 숫자표시 -->
						
						<c:if test="${page == 10 }">
							<a class="no-line" href="${contextPath}/miss/m_listBoards.do?section=${section+1}&pageNum=${section*10 +1}">&nbsp; next </a>
						</c:if>						
						
					</c:forEach>
				</c:when>
				
				<c:when test="${totBoards == 100 }">			<!-- 등록된 글 개수가 100개인 경우 -->
					<c:forEach var="page" begin="1" end="10" step="1">
						<a class="no-line" href="#">${page}</a>
					</c:forEach>
				</c:when>
				
				<c:when test="${totBoards < 100}">			<!-- 글 개수가 100 미만인 경우 -->
					<c:forEach var="page" begin="1" end="${totBoards/10 +1}" step="1">
						<c:choose >
							<c:when test="${page == pageNum}">
								<a class="sel-page" href="${contextPath}/miss/m_listBoards.do?section=${section}&pageNum=${page}">${page}</a>
							</c:when>
							<c:otherwise>
								<a class="no-line" href="${contextPath}/miss/m_listBoards.do?section=${section}&pageNum=${page}">${page}</a>
							</c:otherwise>
						</c:choose>
					</c:forEach>				
				</c:when>
				
			</c:choose>
		</c:if>
	</div>

</body>
</html>