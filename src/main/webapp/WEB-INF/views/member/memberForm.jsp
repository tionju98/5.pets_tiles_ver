<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width" initial-scale="1" >
<title>회원가입</title>
<style type="text/css">
		/* 전체 적용 디자인 */
*{
  margin: 0px;
  padding: 0px;
  text-decoration: none;
  font-family: 'Nanum Gothic', sans-serif;

}
.loginForm h2{
  text-align: center;
  margin: 60px;
 
}

.navbar-brand {
	font-family: 'Nanum Gothic', sans-serif;
}

.Form{
  left: 20%;
  padding: 0px 20px 0px 20px; 
}

.joinForm {
  width:600px;
 /*  padding: 10px, 20px; */
  text-align:center;
  display: inline-block;
}

.id {
  border: 1px solid;
  outline:auto;
  width: 100%;
  color: #636e72;
  font-size:16px;
  height:35px;
  background: none;
  border-radius: 3px;
  margin-bottom: 20px;
}

.pw {
  width: 100%;
  color: #636e72;
  font-size:16px;
  height:35px;
  background: none;
  border-radius: 3px;
  outline: auto;
  border: 1px solid;
  margin-bottom: 20px;
}

.name {
  width: 100%;
  color: #636e72;
  font-size:16px;
  height:35px;
  background: none;
  border-radius: 3px;
  outline: auto;
 border: 1px solid;
  margin-bottom: 20px;
}

.phonenumber {
  width: 100%;
  color: #636e72;
  font-size:16px;
  height:35px;
  background: none;
  border-radius: 3px;
  outline: auto;
  border: 1px solid;
  margin-bottom: 20px;
  margin-top: 5px;
}

.email {
  width: 100%;
  color: #636e72;
  font-size:16px;
  height:35px;
  background: none;
  border-radius: 3px;
  outline: auto;
  border: 1px solid;
  margin-bottom: 20px;
  margin-top: 5px;
}

.address {
  width: 100%;
  color: #636e72;
  font-size:16px;
  height:35px;
  background: none;
  border-radius: 3px;
  outline: auto;
  border: 1px solid;
  margin-bottom: 20px;
}

.address1{
	width: 130%;
	color: #636e72;
  	font-size:16px;
  	height:35px;
  	background: none;
  	border-radius: 3px;
  	outline: auto;
  	border: 1px solid;
  	margin-bottom: 20px;
}

.address2{
	width: 133%;
	color: #636e72;
  	font-size:16px;
  	height:35px;
  	background: none;
  	border-radius: 3px;
  	outline: auto;
  	border: 1px solid;
  	margin-bottom: 20px;
  	margin-left: 65px;
}

.Option{
	text-align: left;
	padding-left:0px;
}

.ic-label{
	width:100%;
	text-align: left;
}

.btn {
	display:inline-block;
  margin-bottom: 40px;
  width:100%;
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

.footer{
	margin-top: 100px;
	font-family: 'Nanum Gothic', sans-serif;
	font-size: 15px;
}

</style>
	
<!-- bootstrap CSS 추가 -->
<link rel="stylesheet" href="./css/bootstrap.min.css">
<!-- custom CSS 추가 -->
<link rel="stylesheet" href="./css/custom.css">
<link rel="stylesheet" href="join.css">
</head>
<body>

<form action="${contextPath}/member/addMember.do" method="post" class="joinForm">	
		<img src="${contextPath}/resources/image/join.png"  width="70" height="70"><h2 style="left:700px;"><b>JOIN!</b></h2>
	
		<div class="Form">
				<input type="text" class="id" placeholder="ID" name="userID" required />
		</div>
		
		<div class="Form">
				<input type="password" class="pw" placeholder="PW(문자,숫자,기호를 포함하여 8자 이상 사용)" name="userPW" required />
		</div>
		
		<div class="Form" >
				<input type="text" class="name" placeholder="NAME" name="userNAME" required />
		</div>
		
		<div class="Form">
				<input type="text" class="phonenumber" placeholder="PHONENUMBER('-'제외)" name="userPhoneNumber" required />
		</div>
		
		<div class="Form">
				<input type="email" class="email" placeholder="EMAIL" name="userEmail" required />
		</div>
		
		<div class="Form">
			<table> 
				<tr>
				 <td><input id="member_post" class="address1"  type="text" placeholder="Zip Code" readonly onclick="findAddr()" name="userAddress"></td>
  				 <td><input id="member_addr" class="address2"  type="text" placeholder="Address" readonly name="userAddress"> <br></td>
  			</table>
  			<input type="text" class="address" placeholder="Detailed_Address" name="userAddress" />
		</div>
		
		<div class="Form">
		<label for="IC" class="ic-label"><b>Individual/Corporation 선택</b></label>
		
			<div class="Option">
				<div class="radio">
				  <input type="radio" name="userIC" value="Individual" />Individual<br/>
				  <input type="radio" name="userIC" value="Corporation" />Corporation
				</div>
			</div>	
			
		</div>
		
		<input type="submit" class="btn form-control" value="JOIN">
		
		<!-- footer 추가하기 -->
		
</form>
	<!-- jQuery 추가 -->
	<!-- <script src="./js/jquery.min.js"></script> -->
	<!-- pooper 추가 -->
	<!-- <script src="./js/popper.js"></script> -->
	<!-- bootstrap.js 추가 -->
	<!-- <script src="./js/bootstrap.min.js"></script> -->
</body>

<!--  API -->
<script type="text/javascript">
function findAddr(){
	new daum.Postcode({
        oncomplete: function(data) {
        	
        	console.log(data);
        	
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
            // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            
            
            var roadAddr = data.roadAddress; // 도로명 주소 변수
            var jibunAddr = data.jibunAddress; // 지번 주소 변수
            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('member_post').value = data.zonecode;
            if(roadAddr !== ''){
                document.getElementById("member_addr").value = roadAddr;
            } 
            else if(jibunAddr !== ''){
                document.getElementById("member_addr").value = jibunAddr;
            }
         
        }
    }).open();
}
</script>
<script type="text/javascript" src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js" charset="text/html; UTF-8"></script>
</html>