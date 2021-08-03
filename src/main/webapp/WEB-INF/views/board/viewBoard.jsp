<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
   request.setCharacterEncoding("UTF-8");
%>      
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="board" value="${boardMap.board}" />   <!-- board는 boardVO를 뜻함 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" >
   <link href="${pageContext.request.contextPath}/resources/css/kfonts2.css" rel="stylesheet" >
<title>상세조회 페이지</title>
<style type="text/css">
      input[type=radio] { vertical-align:middle; }
      #tr_btn_modify {
         display: none;
      }
      .tr_modEnable {
         visibility: hidden;
      }
      table{
           width: 60%;
          margin-left: auto;
          margin-right: auto;
          border-collapse: collapse;
          line-height: 19px;
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
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">      
   
   function fn_enable() {
      document.getElementById("qa_title_mod").disabled=false;
      document.getElementById("qa_content_mod").disabled=false;
      document.getElementById("qa_category_mod").disabled=false;
      document.getElementById("qa_secret_mod").disabled=false;
      document.getElementById("tr_btn_modify").style.display="block";
      document.getElementById("tr_btn").style.display="none";
      $(".tr_modEnable").css("visibility", "visible");
   }
   
   function backToList(obj) {
      obj.action = "${contextPath}/board/listBoards.do"
      obj.submit();
   }
   function removeList(obj) {
      obj.action = "${contextPath}/board/removeBoard.do?qaNo=${board.qaNo}"
      obj.submit();
   }
   
   function fn_modify_article(obj) {
      obj.action="${contextPath}/board/modBoard.do";
      obj.submit();
   }
   
   function fn_reply_form(url, qaNo) {
      var form = document.createElement("form");
      form.setAttribute("method", "post");
      form.setAttribute("action", url);
      
      var parentNoInput = document.createElement("input");
      parentNoInput.setAttribute("type", "hidden");
      parentNoInput.setAttribute("name", "parentNo");
      parentNoInput.setAttribute("value", parentNo);
      
      form.appendChild(parentNoInput);
      document.body.appendChild(form);
      form.submit();
   }
</script>
</head>
<body>
<form name="frmBoard" method="post" >
   <h1 align="center">게시판 상세정보 출력</h1>
   <table border="1" align="center" width="80%" >
         
         <tr>
            <td width="200"><p align="center">문의번호</td>
            <td colspan="2" width="300">
               <input type="text" name="qaNo" value="${board.qaNo}" disabled/>
               <input type="hidden" name="qaNo" value="${board.qaNo }" />
            </td>
         </tr>
            
         <tr>
            <td width="200"><p align="center">제목</td>
            <td colspan="2" width="300"><input type="text" id="qa_title_mod" name="qaTitle" value="${board.qaTitle}" disabled /> </td>
         </tr>
         
         <tr>
            <td width="200"><p align="center">문의종류</td>
            <td colspan="2" width="300"><select name="qaCategory" id="qa_category_mod" disabled>
               <option value="${board.qaCategory}" >${board.qaCategory}</option>
               <option value="동물" >동물</option>
               <option value="개인" >개인</option>
               <option value="단체" >단체</option>
               <option value="기타" >기타</option>
            </select> </td>
         </tr>
         
         <tr>
            <td width="200"><p align="center">내용</td>
            <td colspan="2" width="300"><textarea rows="4" id="qa_content_mod" cols="40" name="qaContent" disabled>${board.qaContent}</textarea> </td>
         </tr>
         
         <tr>
            <td width="200"><p align="center">등록일</td>
            <td colspan="2" width="300"><input type="text" name="qaDate" value="${board.qaDate}" disabled/> </td>
         </tr>
         
         <tr>
            <td><p align="center">공개여부</td>
            <td colspan="2" width="300"><select name="qaSecret" id="qa_secret_mod" disabled>
               <option value="${board.qaSecret}" >공개여부 : ${board.qaSecret}</option>
               <option value="Y" >공개</option>
               <option value="N" >비공개</option>
            </select> </td>
         </tr>
         
         <tr>
            <td width="200"><p align="center">등록자</td>
            <td colspan="2" width="300"><input type="text" name="user_id" value="${board.user_ID}" disabled/> </td>
         </tr>
         
         <tr id="tr_btn_modify" align="right">
            <td colspan="2">
               <input type="button" class="btn btn-success" value="수정반영하기" onclick="fn_modify_article(frmBoard)" />
               <input type="button" class="btn btn-danger" value="취소" onclick="backToList(frmBoard)" />
            </td>
         </tr>
         
         <tr id="tr_btn">
            <td colspan="3" align="center">
            <c:if test="${member.user_ID == board.user_ID }">
               <input type="button" class="btn btn-warning" value="수정하기" onclick="fn_enable()" />
               <input type="button" class="btn btn-danger" value="삭제하기" onclick="removeList(this.form)">
               </c:if>
               <input type="button" class="btn btn-primary" value="게시글목록" onclick="backToList(this.form)">
               <%-- <input type="button" value="답급달기" onclick="fn_reply_form('${contextPath}/board/replyForm.do', ${board.qa_No})" />   <!-- 요청명과 글번호를 전달함  --> --%>
            </td>
         </tr>
   </table>
   </form>
</body>
</html>