<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.net.URLDecoder"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
  <link rel="stylesheet" href="<c:url value='/css/registerForm.css'/>">
  <script  src="http://code.jquery.com/jquery-latest.min.js"></script>
  <title>회원가입</title>
</head>
<body>

<form action="<c:url value="/register"/>" method="post" onsubmit="return formCheck(this)">
  <div class="title">회원가입</div>
  <div id="msg" class="msg">
    <c:if test="${not empty param.msg}">
      <i class="fa fa-exclamation-circle"> ${URLDecoder.decode(param.msg)}</i>
    </c:if>
  </div>
  <label for="">아이디</label>
  <div class="input-id-box">
    <input class="input-id-field" type="text" name="mid" onkeyup="inputIdChk()" placeholder="4~12자리의 영대소문자와 숫자 조합" maxlength="12" autofocus>
    <input type="button" id="midCheck" class="midCheck" value="중복 확인"/>
    <div id="sucId" style="clear:both;"></div>
    <input type="hidden" id="idDuplication" name="idDuplication" value="idUncheck"/>
  </div>
  <label for="">비밀번호</label>
  <input class="input-field" type="password" name="pwd" placeholder="8~12자리의 영대소문자와 숫자 조합" maxlength="12">
  <label for="">비밀번호 확인</label>
  <input class="input-field" type="password" name="pwd2" placeholder="8~12자리의 영대소문자와 숫자 조합" maxlength="12">
  <label for="">이름</label>
  <input class="input-field" type="text" name="mname" placeholder="홍길동">
  <label for="">이메일</label>
  <input class="input-field" type="text" name="email" placeholder="hong@board.co.kr">
  <label for="">생년월일</label>
  <div>
    <input class="input-yy-field" type="text" name="birth_yy" placeholder="년(4자)" maxlength="4">
    <select class="input-mm-field" type="text" name="birth_mm">
      <option value="0"> 월</option>
      <c:forEach var="i" begin="1" end="12">
        <option value="<c:out value='${i}'/>"><c:out value="${i}"/></option>
      </c:forEach>
    </select>
    <input class="input-dd-field" type="text" name="birth_dd" placeholder="일" maxlength="2">
  </div>
  <button>회원 가입</button>
</form>

<script>
  function inputIdChk(){
    document.getElementById("idDuplication").value = "idUncheck";
    document.getElementById("sucId").value = "";
  }

  function formCheck(frm) {
    let msg ='';

    if((frm.mid.value).trim()===""){
      setMessage('아이디는 필수 입력 항목입니다.');
      return false;
    }

    if(frm.mid.value.length<3) {
      setMessage('아이디는 4글자 이상이어야 합니다.', frm.id);
      return false;
    }

    if(frm.idDuplication.value==="idUncheck"){
      setMessage('아이디 중복확인이 필요합니다.', frm.id);
      return false;
    }

    if(frm.pwd.value.length<3) {
      setMessage('비밀번호는 8글자 이상이어야 합니다.', frm.pwd);
      return false;
    }

    if(frm.pwd.value!==frm.pwd2.value){
      setMessage('비밀번호가 일치하지 않습니다.', frm.pwd2);
      return false;
    }

    let pw_pattern =/^[a-zA-Z0-9]*$/;
    if(frm.pwd.value.search(pw_pattern)){
      setMessage('비밀번호에 입력할 수 없는 문자가 포함되어있습니다.');
      return false;
    }

    if(frm.mname.value===''){
      setMessage('이름은 필수 입력 항목입니다.', frm.mname);
      return false;
    }

    if(frm.email.value===''){
      setMessage('이메일은 필수 입력 항목입니다.', frm.email);
      return false;
    }

    if((!frm.email.value.includes("@")) || frm.email.value.slice(-4,-3)!=='.'){
      setMessage('이메일을 정확하게 입력하세요.', frm.email);
      return false;
    }

    let birth_pattern =/^[0-9]*$/;
    let year = frm.birth_yy.value;
    let month = frm.birth_mm.options[frm.birth_mm.selectedIndex].value;
    let day = frm.birth_dd.value;

    if(year.search(birth_pattern) || day.search(birth_pattern)){
      setMessage('생년월일에 입력할 수 없는 문자가 포함되어있습니다.');
      return false;
    }

    if(year.length<4){
      setMessage('년도는 4자리로 입력하세요.', frm.birth_yy);
      return false;
    }

    if(year<1900){
      setMessage('1900년 이상 출생자만 가입 가능합니다.', frm.birth_yy);
      return false;
    }

    if(month==="0"){
      setMessage('월을 선택하세요.', frm.birth_mm);
      return false;
    }

    if(day===''){
      setMessage('일을 입력하세요.', frm.birth_dd);
      return false;
    }

    if(day < 1 || day > 31){
      setMessage('일은 1일부터 31일까지 입력가능합니다.', frm.birth_dd);
      return false;
    }

    if((month ==="4" || month==="6" || month==="9" || month==="11") && day==="31"){
      setMessage('생년월일이 잘못 입력되었습니다.', frm.birth_dd);
      return false;
    }

    if(month === "2"){
      let isleap = (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
      if(day > 29 || (day == 29 && !isleap)){

        setMessage('생년월일이 잘못 입력되었습니다.', frm.birth_dd);
        return false;
      }
    }

    if(day>32){
      setMessage('일을 올바르게 입력하세요.', frm.birth_dd);
      return false;
    }

    return true;
  }

  function setMessage(msg, element){
    document.getElementById("msg").innerHTML = `<i class="fa fa-exclamation-circle"> ${'${msg}'}</i>`;

    if(element) {
      element.select();
    }
  }

  $(document).ready(function(){
    $("#midCheck").click(function(){
      let mid = {"mid":$("input[name=mid]").val()};

      if($("input[name=mid]").val().trim() === ""){
        document.getElementById("sucId").innerHTML = "아이디를 입력하세요.";
        document.getElementById("sucId").style.color = "red";
        return false;
      }

      let id_pattern =/^[a-zA-Z0-9]*$/;
      if($("input[name=mid]").val().search(id_pattern)){
        document.getElementById("sucId").innerHTML = "입력 불가능한 문자를 포함합니다.";
        document.getElementById("sucId").style.color = "red";
        return false;
      }

      $.ajax({
        type:'GET',                // 요청 메서드
        url: '/sy/idCheck',         // 요청 URI
        headers : { "content-type": "application/json; charset:UTF-8"}, // 요청 헤더
        dataType : 'text',          // 전송받을 데이터의 타입
        data : mid,
        success : function(data){
          if(data==="false") {             // result는 서버가 전송한 데이터
            document.getElementById("sucId").innerHTML = "이미 사용 중인 아이디입니다.";
            document.getElementById("sucId").style.color = "red";
          }
          else {
            document.getElementById("idDuplication").value = "idCheck";
            document.getElementById("sucId").innerHTML = "사용 가능한 아이디입니다.";
            document.getElementById("sucId").style.color = "#30426E";
          }
        },
        error : function(){ alert("error") } // 에러가 발생했을 때, 호출될 함수
      });
    });

  });
</script>
</body>
</html>