<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page session="true"%>
<c:set var="loginId" value="${sessionScope.id}"/>
<c:set var="loginOutLink" value="${loginId=='' ? '/login/login' : '/login/logout'}"/>
<c:set var="loginOut" value="${loginId=='' ? 'Login' : 'ID='+=loginId}"/>
<c:set var="loginOut" value="${loginId=='' ? 'Login' : 'Logout'}"/>
<c:set var="signLink" value="${loginId=='' ? '/register' : '/mypage'}"/>
<c:set var="sign" value="${loginId=='' ? 'Sign in' : 'MyPage'}"/>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>board</title>
  <link rel="stylesheet" href="<c:url value='/css/menu.css'/>">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
  <style>
    * {
      box-sizing: border-box;
      margin: 0;
      padding: 0;
      font-family: "Noto Sans KR", sans-serif;
    }
    a {
      text-decoration: none;
      color: black;
    }
    button,
    input {
      border: none;
      outline: none;
    }
    .board-container {
      width: 60%;
      height: 1200px;
      margin: 0 auto;
      /* border: 1px solid black; */
    }
    #board-name{
      width: 60%;
      margin: 0 auto;
      text-align: left;
    }
    #board-name >a{
      font-size: 30px;
    }
    .search-container {
      float: right;
      width: 500px;
      height: 50px;
      margin-top : 10px;
      margin-bottom: 30px;
      /*display: flex;*/
      justify-content: center;
      align-items: center;
      margin-right: 20px;
    }
    .search-form {
      height: 37px;
      display: flex;
    }
    .search-option {
      width: 100px;
      height: 100%;
      outline: none;
      margin-right: 5px;
      border: 1px solid #ccc;
      color: gray;
    }
    .search-option > option {
      text-align: center;
    }
    .search-input {
      color: gray;
      background-color: white;
      border: 1px solid #ccc;
      height: 100%;
      width: 350px;
      font-size: 15px;
      padding: 5px 7px;
      border-radius: 1px;
    }
    .search-input::placeholder {
      color: gray;
    }
    .search-button {
      /* 메뉴바의 검색 버튼 아이콘  */
      width: 80px;
      height: 100%;
      background-color: rgba(48, 66, 110, 0.76);
      color: rgb(248, 248, 248);
      display: flex;
      align-items: center;
      justify-content: center;
      font-size: 15px;
      border-radius: 1px;
    }
    table {
      border-collapse: collapse;
      width: 100%;
      border-top: 2px solid rgb(39, 39, 39);
    }
    tr:nth-child(even) {
      background-color: #f0f0f070;
    }
    th,
    td {
      width:300px;
      text-align: center;
      padding: 10px 12px;
      border-bottom: 1px solid #ddd;
    }
    td {
      color: rgb(53, 53, 53);
    }
    .no      { width:150px;}
    .title   { width:50%;  }
    td.title   { text-align: left;  }
    td.writer  { text-align: left;  }
    td.viewcnt { text-align: right; }
    td.title:hover {
      text-decoration: underline;
    }
    .paging {
      color: black;
      width: 100%;
      align-items: center;
    }
    .page {
      color: black;
      padding: 6px;
      margin-right: 10px;
    }
    .paging-active {
      background-color: rgb(216, 216, 216);
      border-radius: 5px;
      color: rgb(24, 24, 24);
    }
    .paging-container {
      width:100%;
      height: 70px;
      display: flex;
      margin-top: 50px;
      margin : auto;
    }
    .btn-write {
      background-color: rgb(236, 236, 236); /* Blue background */
      border: none; /* Remove borders */
      color: black; /* White text */
      padding: 6px 12px; /* Some padding */
      font-size: 16px; /* Set a font size */
      cursor: pointer; /* Mouse pointer on hover */
      border-radius: 5px;
      margin-left: 30px;
    }
    .btn-write:hover {
      text-decoration: underline;
    }
    .board_menu{
      background-color: white;
      float: left;
      margin-bottom: 30px;
      margin-left:20px;
    }
    .board_menu ul{
      background-color: white;
      height: 50px;
    }
    .board_menu >ul >li{
      width:150px;
    }
    .board_menu >ul >li> a:hover{
       border-bottom: none;
     }
    .board_menu >ul >li >a{
      color: #172038;
      font-size: 18px;
    }
    .top_menu{
      width: 100%;
      height:53px;
      border-bottom: 1px solid #ccc;
    }
  </style>
<script>
  $(document).ready(function(){
    goList("");
  });
</script>
</head>

<body>
<div id="menu">
  <ul>
    <li id="logo">board</li>
    <li><a href="<c:url value='/'/>">Home</a></li>
    <li><a href="<c:url value='/board'/>">Board</a></li>
    <li><a href="<c:url value='${loginOutLink}'/>">${loginOut}</a></li>
    <li><a href="<c:url value='${signLink}'/>">${sign}</a></li>
    <li><a href=""><i class="fa fa-search"></i></a></li>
  </ul>
</div>
<script>
  let msg = "${msg}";
  if(msg=="LIST_ERR")  alert("게시물 목록을 가져오는데 실패했습니다. 다시 시도해 주세요.");
</script>

<div class="top_menu">
  <div class="board_menu">
    <ul>
      <c:forEach var="boardDto" items="${boardList}">
      <li><a onclick="goList('${boardDto.bno}')">${boardDto.title}</a></li>
      </c:forEach>
    </ul>
  </div>
  <div class="search-container">
    <form action="<c:url value="/board"/>" class="search-form" method="get">
      <select class="search-option" name="option">
        <option value="A" ${ph.sc.option=='A' || ph.sc.option=='' ? "selected" : ""}>제목+내용</option>
        <option value="T" ${ph.sc.option=='T' ? "selected" : ""}>제목만</option>
        <option value="W" ${ph.sc.option=='W' ? "selected" : ""}>작성자</option>
      </select>

      <input type="text" name="keyword" class="search-input" type="text" value="${ph.sc.keyword}" placeholder="검색어를 입력해주세요">
      <input type="submit" class="search-button" value="검색">
    </form>
  </div>
</div>

<div style="text-align:center; clear: both">
  <div id="board-name">
    <a>전체 게시판</a>
  </div>
  <div class="board-container">

    <table>
      <tr>
        <th class="no">번호</th>
        <th class="title">제목</th>
        <th class="writer">이름</th>
        <th class="regdate">등록일</th>
        <th class="viewcnt">조회수</th>
      </tr>
      <tbody id="board-table">

      </tbody>
    </table>
    <br>
    <div class="paging-container">
      <div class="paging" id="paging">
<%--       --%>
<%--        <c:if test="${totalCnt!=null && totalCnt!=0}">--%>
<%--          <c:if test="${ph.showPrev}">--%>
<%--            <a class="page" href="<c:url value="/board/list${ph.sc.getQueryString(ph.beginPage-1)}"/>">&lt;</a>--%>
<%--          </c:if>--%>
<%--          <c:forEach var="i" begin="${ph.beginPage}" end="${ph.endPage}">--%>
<%--            <a class="page ${i==ph.sc.page? "paging-active" : ""}" href="<c:url value="/board/list${ph.sc.getQueryString(i)}"/>">${i}</a>--%>
<%--          </c:forEach>--%>
<%--          <c:if test="${ph.showNext}">--%>
<%--            <a class="page" href="<c:url value="/board/list${ph.sc.getQueryString(ph.endPage+1)}"/>">&gt;</a>--%>
<%--          </c:if>--%>
<%--        </c:if>--%>
      </div>
    </div>
  </div>
</div>

<script>
  let goList = function(bno) {
    $.ajax({
      type: 'GET',                // 요청 메서드
      url: '/sy/board/list',         // 요청 URI
      headers: {"content-type": "application/json; charset:UTF-8"}, // 요청 헤더
      dataType: 'json',          // 전송받을 데이터의 타입
      data: {"bno" : bno},
      success: function (data) {
        document.getElementById("board-name").innerHTML = "<a>" + data.board + "</a>";
        let str = "";
        let now = new Date();

        if(data.list.length==0){
          str += "<tr>등록된 게시글이 없습니다.</tr>";
          document.getElementById("paging").innerHTML = str;
          document.getElementById("board-table").innerHTML = "";
        }else {
          for (const i in data.list) {
            let reg_day = new Date(data.list[i].up_date);
            str += '<tr>';
            str += '<td class="no">' + data.list[i].pno.slice(1, 5) + '</td>';
            str += '<td class="title"><a href="/board&bno=' + data.list[i].bno + '">' + data.list[i].title + '</a></td>';
            str += '<td class="writer" style="text-align: center">' + data.list[i].writer + '</td>';
            if (reg_day >= now.getDate()) {
              str += '<td class="regdate">' + reg_day.getHours() + '시 ' + reg_day.getMinutes() + '분' + '</td>';
            } else {
              str += '<td class="regdate">' + reg_day.getFullYear() + '-' + (reg_day.getMonth() + 1) + '-' + reg_day.getDate() + '</td>';
            }
            str += '<td class="viewcnt">' + data.list[i].view_cnt + '</td>';
            str += '</tr>';
          }
          document.getElementById("board-table").innerHTML = str;
          document.getElementById("paging").innerHTML = "";
        }
      },
      error: function () {
        alert("error")
      } // 에러가 발생했을 때, 호출될 함수
    });
  }

</script>
</body>
</html>