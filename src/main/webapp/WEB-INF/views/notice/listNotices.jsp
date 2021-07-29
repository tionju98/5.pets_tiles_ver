<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="noticesList" value="${noticeMap.noticesList }" />
<c:set var="totNotices" value="${noticeMap.totNotices }" />
<c:set var="section" value="${noticeMap.section }" />
<c:set var="pageNum" value="${noticeMap.pageNum }" />

<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<!-- <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/kfonts2.css" rel="stylesheet"> -->
	<title>게시글 목록</title>
	<style type="text/css">
		table{
		    width: 100%;
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
	<div id="container" style="margin-bottom: 20px; margin-top: 20px;">
    	<div  class="jumbotron"><h2>공지사항</h2></div>
    	<table>
    	
    		<tr style="align: right;">
    			<td colspan="5" style="display:inline-block; border:white;">
    				<a href="${contextPath}/notice/insertNotice.do">글 작성하기</a>
    			</td>
    		</tr>
    		
    		<tr>
    			<th style="width:10%;">글번호</th>
    			<th style="width:50%;'">글제목</th>
    			<th style="width:20%;">작성자</th>
    			<th style="width: 10%;">작성날짜</th>
    			<th style="width: 10%">조회수</th>
    		</tr>
    		
    		
    			<c:choose>
					<c:when test="${empty noticesList }">
						<tr height="10">
							<td colspan="4">
								<p align="center">
									<b><span style="font-size: 9pt;">등록된 글이 없습니다.</span></b>
								</p>
							</td>
						</tr>
					</c:when>
					
					<c:when test="${!empty noticesList  }">
						<c:forEach var="notice" items="${noticesList }" varStatus="noticeNum">
					
							<tr align="center">
								<td>${notice.no_number }</td>
								<%-- <td><a href="${contextPath}/notice/viewNotice.do?no_number=${notice.no_number}">${notice.no_title }</a></td> --%>
								<td><a href="${contextPath}/notice/viewNotice.do?no_number=${notice.no_number}">${notice.no_title }</a></td>
								<td>${notice.no_writer }</td>
								<td>${notice.no_date }</td>
								<td>${notice.no_hits }</td>
							</tr>
		
						</c:forEach>
					</c:when>
				</c:choose>
			</table>
				<!-- 페이징 -->
				<div class="class2">
					<c:if test="${totNotices != null }">
						<c:choose>
							<c:when test="${totNotices > 100 }">			<!-- 글 개수가 100 초과인 경우 -->
								<c:forEach var="page" begin="1" end="10" step="1">
									
									<c:if test="${section > 1 && page == 1 }">
										<a class="no-line"  href="${contextPath}/notice/listNotices.do?section=${section-1}&pageNum=${(section-1)*10 +1}">&nbsp; pre </a>
									</c:if>
									
									<a class="no-line" href="">${(section-1)*10 +page}</a>			<!-- 실제페이지 숫자표시 -->
									
									<c:if test="${page == 10 }">
										<a class="no-line" href="${contextPath}/notice/listNotices.do?section=${section+1}&pageNum=${section*10 +1}">&nbsp; next </a>
									</c:if>						
									
								</c:forEach>
							</c:when>
							
							<c:when test="${totNotices == 100 }">			<!-- 등록된 글 개수가 100개인 경우 -->
								<c:forEach var="page" begin="1" end="10" step="1">
									<a class="no-line" href="#">${page}</a>
								</c:forEach>
							</c:when>
							
							<c:when test="${totNotices < 100 }">			<!-- 글 개수가 100 미만인 경우 -->
								<c:forEach var="page" begin="1" end="${totNotices/10 +1}" step="1">
									<c:choose >
										<c:when test="${page == pageNum}">
											<a class="sel-page" href="${contextPath}/notice/listNotices.do?section=${section}&pageNum=${page}">${page}</a>
										</c:when>
										<c:otherwise>
											<a class="no-line" href="${contextPath}/notice/listNotices.do?section=${section}&pageNum=${page}">${page}</a>
										</c:otherwise>
									</c:choose>
								</c:forEach>				
							</c:when>
							
						</c:choose>
					</c:if>
				</div>
    	
    </div>
</body>
</html>