<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<%
	request.setCharacterEncoding("UTF-8");
%>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>아이디 찾기</title>
	<script type="text/javascript">
		function id_search() {
			var frm = document.id_find_screen;
			
			if(frm.user_NAME.value.length < 1) {
				alert("이름을 입력해주세요");
				return;
			}
			
			if(frm.user_PhoneNumber.value.length != 13) {
				alert("핸드폰 번호를 정확하게 입력해주세요");
				return;
			}
			
			frm.method="post";
			frm.action="ID_Find_Result.jsp";
			frm.submit();
		}
	</script>
</head>
<body>
	<form name="id_find_screen" method="post">
		<h2><b>FIND ID</b></h2>
		<div class="id_Find">
			<input type="text" class="name" placeholder="NAME" name="user_NAME" />
		</div>
		
		<div class="phone_Find">
			<input type="text" class="phone" placeholder="PhoneNumber" name="user_PhoneNumber" />
		</div>
		
		<input type="submit" class="btn" value="FIND" onclick="id_search()" />
		<input type="submit" class="btn1" value="CANCEL" onclick="history.back()" />
		
	</form>
</body>
</html>