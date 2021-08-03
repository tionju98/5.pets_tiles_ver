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

<style type="text/css">
*{
  margin: 0px;
  padding: 0px;
  text-decoration: none;
  font-family: 'Nanum Gothic', sans-serif;

}

.loginForm {
display: inline-block;
text-align: center;
width: 400px;
  /* height:600px; */
 /*  padding-top:500px;
 
  top:60%;
  left:50%;
  transform: translate(-50%,-50%); 
  */
  /* margin-bottom: 20px; */ */
}

.loginForm h2{
  text-align: center;
  margin: 30px;
}

.idForm{
  border-bottom: 2px solid #adadad;
  margin: 30px;
  padding: 10px 10px;
}

.pwForm{
  border-bottom: 2px solid #adadad;
  margin: 30px;
  padding: 10px 10px;
}

.id {
  width: 100%;
  border:none;
  outline:none;
  color: #636e72;
  font-size:16px;
  height:25px;
  background: none;
}

.pw {
  width: 100%;
  border:none;
  outline:none;
  color: #636e72;
  font-size:16px;
  height:25px;
  background: none;
}

.btn {
  position:relative;
  left:40%;
  transform: translateX(-50%);
  margin-bottom: 40px;
  width:80%;
  height:40px;
  background: #FFEDC3;
  background-position: left;
  background-size: 200%;
  color:white;
  font-weight: bold;
  border:none;
  cursor:pointer;
  transition: 0.4s;
  display:inline;
}

.btn:hover {
  background-position: right;
  background-color:#D6C197;
  color: white;
}

.bottomText {
  text-align: center;
}

</style>
	<meta charset="UTF-8">
	<title>로그인</title>
	
	<c:choose>
		<c:when test="${result == 'loginFailed'}">
			<script type="text/javascript">
			window.onload=function() {
				alert('아이디나 비밀번호가 틀립니다. 다시 로그인 하세요!');
			}
			</script>
		</c:when>
	</c:choose>
	
</head>
<body>
<form action="${contextPath}/member/login.do" method="post" class="loginForm">	<!-- LoginAction으로 실행되는 페이지 -->
		<div >
		<h2><b>WELCOME</b></h2>
		<div class="idForm">
			<input type="text" class="id" placeholder="ID" name="userID">
		</div>
		<div class="pwForm">
			<input type="password" class="pw" placeholder="PW" name="userPW">
		</div>
		<input type="submit" class="btn btn-warning form-control" value="LOG IN">
		<div class="bottomText">
			계정이 없으신가요? <a href="${contextPath}/member/memberForm.do" class="text-warning">회원가입</a></br>
			<!-- ID를 잊어버렸다면? <a href="#" class="text-warning">ID찾기</a></br>
			PW를 잊어버렸다면? <a href="#" class="text-warning">PW찾기</a> -->
		</div>
		</div>
</form>
	<!-- jQuery 추가 -->
	<script src="./js/jquery.min.js"></script>
	<!-- pooper 추가 -->
	<script src="./js/popper.js"></script>
	<!-- bootstrap.js 추가 -->
	<script src="./js/bootstrap.min.js"></script>
</body>
</html>