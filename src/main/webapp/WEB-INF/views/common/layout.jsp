<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title><tiles:insertAttribute name="title" /></title>
	<style type="text/css">
		#container{
			width: 100%;
			height:100%;
			position: absolute;
			left: 0px;
			right: 0px;
			text-align: center;
			border: 0px solid #bcbcbc;
		}
		#menu{
			padding:5px;
			margin-bottom: 5px;
			boder: 0px solid #bcbcbc;
		}
		#footer{
			position: relative;
			width: 100%;
			margin: 0px auto;
			bottom: 0px;
			clear: both;
			padding:5px;
			border: 0px solid #bcbcbc;
		}
	</style>
	</head>
<body>
	<div id="container">
		
		<div id="menu">
			<tiles:insertAttribute name="menu" />
		</div>
		
		<div id="content">
			<tiles:insertAttribute name="body" />
		</div>
		<div id="footer">
			<tiles:insertAttribute name="footer" />
		</div>
		
	</div>
	
</body>
</html>