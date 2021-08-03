<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<% request.setCharacterEncoding("utf-8"); %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">

		<!-- jquery연결시 필요한 태그 -->
		<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
		<script type="text/javascript">
		  $(document).ready(function() {
			    $(".main").hover(
			      function() {
			        $(".submenu").stop().slideDown(400);
			      },
			      function() {
			        $(".submenu").stop().slideUp(600);
			      }
			    );
			    
			    $(".main").hover(
					      function() {
					        $(".submenu1").stop().slideDown(400);
					      },
					      function() {
					        $(".submenu1").stop().slideUp(600);
					      }
					);
			    
			    $(".main").hover(
					      function() {
					        $(".submenu2").stop().slideDown(400);
					      },
					      function() {
					        $(".submenu2").stop().slideUp(600);
					      }
					);
			    $(".main").hover(
					      function() {
					        $(".submenu3").stop().slideDown(400);
					      },
					      function() {
					        $(".submenu3").stop().slideUp(600);
					      }
					);
			    $(".main").hover(
					      function() {
					        $(".submenu4").stop().slideDown(400);
					      },
					      function() {
					        $(".submenu4").stop().slideUp(600);
					      }
					);


			    $(".submenu").hover(
			      function() {
			        $(".submenu").stop().slideDown(400);
			      },
			      function() {
			        $(".submenu").stop().slideUp(600);
			      }
			    )
			  
			  });

		</script>
	<style>
	* {
	margin: 0;
	padding: 0;
	
	}
	li {list-style: none; }
	body {width: 1200px; margin: 0 auto; }
	a{text-decoration:none; color: black;}
	           
	
	
	.main{
		width: 100%; 
		margin-bottom: 50px; 
		margin-top:0px;
		text-align: center; 
		height: 40px; 
	}
	
	.main:after {
		content: ""; 
		display: block; 
		clear: both; }
	
	.mainmenu>li {
		float: left; 
		width: 25%; 
		line-height: 40px; 
	}
	.mainmenu span {
		font-size: 15px; 
		font-weight: bold; 
	}
	
	.submenu{
		width:25%;
		display: none; 
		padding: 15px;
		border-bottom: 1px solid #ccc;
		height:150px;
		position: fixed;
		align-content: center;
		margin-left: 0px; 
		}
	
	.submenu1 {
		width:25%;
		display: none; 
		padding: 15px;
		border-bottom: 1px solid #ccc;
		height:150px;
		position: absolute;
		align-content: center;
		}
		
	.submenu2 {
	width:25%;
		display: none; 
		padding: 15px;
		border-bottom: 1px solid #ccc;
		height:150px;
		position: absolute;
		align-content: center;
		}
	
	.submenu3 {
	width:25%;
		display: none; 
		padding: 15px;
		border-bottom: 1px solid #ccc;
		height:150px;
		position: absolute;
		align-content: center;
		}
	
/* 	.submenu4 {
	width:25%;
		display: none; 
		padding: 15px;
		border-bottom: 1px solid #ccc;
		background-color: #B3FFEDC3;
		height:150px;
		position: fixed;
		align-content: center;
		}
	 */
	#sub {
		float: none;
		height:40px;
		padding-left: 10px;
	}
	/* .main {
	margin-left: 500px;
	
	} */
	
	            
	.none:after {content: ""; display: block; clear: both}
	
	.logo{
		text-align: left;
		padding-left: 0px;
		margin-left: 0px;
		float: left;
		padding-right: 100px;
		font-family: 'Nanum Gothic', sans-serif;
		padding: 0;
		margin: 0;
		padding-top: 0;
		margin-top: 0;
	}
	
	.login{
		text-align: right;
		font-family: 'Nanum Gothic', sans-serif;
		padding: 0;
		margin: 0;
		
	}
	.logout{
	color:#905639;
	font-family: 'Nanum Gothic', sans-serif;
	
	}
	.welcome{
	font-family: 'Nanum Gothic', sans-serif;
	}
	.subject{
	color:#D6C197;
	}
	
	</style>

<!-- 로고 -->
<nav class="navbar sticky-top navbar-light">
	  <div class="container-fluid">
		    <a class="navbar-brand" href="${contextPath}/main.do">
		      <img src="${contextPath}/resources/image/logo.png" alt="" width="40" height="40" class="d-inline-block align-text-top">
		      <h4>AmarePets</h4>
		    </a>
		    
		   <ul class="nav navbar-right">
					<div style="text-align: right;">
						<c:choose>
								<c:when test="${isLogOn == true && member != null }">
									<h3 class="welcome">Welcome! ${member.userNAME}</h3>
									<a class="logout" href="${contextPath}/member/logout.do"><h3>Log out</h3></a>
								</c:when>
								<c:otherwise>
									<a class="login" href="${contextPath}/member/loginForm.do"><h3>Log in</h3></a>
								</c:otherwise>
							</c:choose>
					</div>
		   </ul>
	  </div>
</nav>
	
	<div>
		<div class="main">
			<ul class="mainmenu">
				
				<!--  About  -->
			<li><span class="subject">About</span>
				<ul class="submenu">
					<li id="sub"><a href="${contextPath }/about/about.do">소개</a></li>
				</ul>
			</li>
			
			<!-- Pets -->
			<li><span class="subject">Pets</span>
				<ul class="submenu1">
						<li id="sub"><a href="${contextPath}/protect/listBoards.do">유기동물</a></li>
						<li id="sub"><a href="${contextPath}/miss/m_listBoards.do">실종동물</a></li>
					<!-- 	<li id="sub"><a href="#">임시보호 요청</a></li> -->
						<!-- <li id="sub"><a href="#">애완용품</a></li> -->
				</ul>
			</li>
			
			<!-- Notice -->
			<li><span class="subject">Notice</span>
				<ul class="submenu2">
					<li id="sub"><a href="${contextPath }/notice/listNotices.do">공지사항</a></li>
				</ul>
			</li>
			
			<!-- Info -->
			<li><span class="subject">Information</span>
				<ul class="submenu3">
					<li id="sub"><a href="${contextPath}/board/faqPage.do">자주하는 질문</a></li>
						<li id="sub"><a href="${contextPath}/member/shelter_location.do">보호소 위치</a></li>
						<li id="sub"><a href="${contextPath}/board/listBoards.do">문의하기</a></li>
				</ul>
			</li>
			
			<!-- MyPage -->
			<!-- <li><span class="subject">MyPage</span>
				<ul class="submenu4">
					<li id="sub"><a href="#">개인정보수정</a></li>
					<li id="sub"><a href="#">반려동물</a></li>
				</ul>
			</li>	 -->
			</ul>
		</div>
	
	</div>