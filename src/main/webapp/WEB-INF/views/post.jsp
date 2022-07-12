<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page session="true"%>
<c:set var="loginId" value="${sessionScope.id}"/>
<c:set var="loginOutLink" value="${loginId=='' ? '/login/login' : '/login/logout'}"/>
<c:set var="loginOut" value="${loginId=='' ? 'Login' : 'Logout'}"/>
<c:set var="signLink" value="${loginId=='' ? '/register' : '#'}"/>
<c:set var="sign" value="${loginId=='' ? 'Sign in' : loginId}"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>post - ${loginId}</title>
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
        .title{
            font-size: 24px;
            padding-top: 10px;
            width: 100%;
            height: 60px;
        }
        .content{
            padding: 10px 5px 5px 3px;
            width: 100%;
            height: 450px;
            /*border: 1px solid #323232;*/
        }
        .container {
            width : 50%;
            margin : auto;
        }

        .writing-header {
            height: 70px;
            width: 100%;
            float: left;
            margin: 20px 0 0 0;
            padding-bottom: 10px;
            border-bottom: 1px solid #323232;
        }
        .writing-header .board-name{
            font-size: 18px;
        }
        .post_info{
            color:dimgray;
            margin-top: 8px;
            float: left;
            width: 400px;
        }
        select{
            width: 100%;
            height: 35px;
            margin: 5px 0px 10px 0px;
            border: 1px solid #e9e8e8;
            padding: 8px;
            background: #f8f8f8;
            outline-color: #e6e6e6;
        }
        input {
            width: 100%;
            height: 35px;
            margin: 5px 0px 10px 0px;
            border: 1px solid #e9e8e8;
            padding: 8px;
            background: #f8f8f8;
            outline-color: #e6e6e6;
        }

        textarea {
            width: 100%;
            background: #f8f8f8;
            margin: 5px 0px 10px 0px;
            border: 1px solid #e9e8e8;
            resize: none;
            padding: 8px;
            outline-color: #e6e6e6;
        }

        .frm {
            width:100%;
            clear: both;
        }
        .btn {
            background-color: rgb(236, 236, 236); /* Blue background */
            border: none; /* Remove borders */
            color: black; /* White text */
            padding: 6px 12px; /* Some padding */
            font-size: 16px; /* Set a font size */
            cursor: pointer; /* Mouse pointer on hover */
            border-radius: 5px;
            margin-bottom: 5px;

        }

        .btn:hover {
            text-decoration: underline;
        }


    /*  댓글 style  */

        #commentList{
            clear: both;
        }
        #commentList > ul {
            background-color: #f9f9fa;
            border:  1px solid rgb(235,236,239);
            border-bottom : 0;
            padding-bottom: 15px;
        }

        #commentList > ul > li {
            background-color: #f9f9fa;
            list-style-type: none;
            padding : 18px 18px 0 18px;
        }
        #commentarea{
            width : 50%;
            margin : auto;
        }

        .comment-content {
            overflow-wrap: break-word;
            width: 100%;
            border: none;
            margin: 0px;
            height: 45px;
        }

        .comment-bottom {
            width: 100%;
            font-size:9pt;
            color : rgb(97,97,97);
            padding: 8px 0 8px 0;
        }

        .comment-bottom > a {
            color : rgb(97,97,97);
            text-decoration: none;
            margin : 0 6px 0 0;
        }

        .comment-area {
            padding : 0 0 0 46px;
            color:black;
            margin: 0px 0px 0px 0px;
            border-bottom: 1px solid #ccc;
        }

        .commenter {
            font-size:12pt;
            font-weight:bold;
            color: black;
        }

        .commenter-writebox {
            padding : 15px 20px 20px 20px;
            width: 550px;
        }

        .comment-img {
            font-size:36px;
            position: absolute;
        }

        .comment-item {
            position:relative;
        }

        .up_date {
            margin : 0 8px 0 0;
        }

        #comment-writebox {
            background-color: white;
            border : 1px solid #e5e5e5;
            border-radius: 5px;
        }

        .comment-writebox-content > textarea {
            display: block;
            width: 100%;
            min-height: 17px;
            padding: 0 20px;
            border: 0;
            outline: 0;
            font-size: 13px;
            resize: none;
            box-sizing: border-box;
            background: transparent;
            overflow-wrap: break-word;
            overflow-x: hidden;
            overflow-y: auto;
        }

        #comment-writebox-bottom {
            padding : 0px 10px 20px 10px;
            min-height : 45px;
        }

        .comment-btn, .new-comment-btn {
            font-size:10pt;
            color : black;
            background-color: #eff0f2;
            text-decoration: none;
            padding : 9px 10px 9px 10px;
            border-radius: 5px;
            float : right;
        }

        #btn-write-comment, #btn-write-reply {
            margin-bottom: 20px;
            color : #009f47;
            background-color: #e0f8eb;
        }

        #btn-cancel-reply {
            background-color: #eff0f2;
            margin-right : 10px;
        }

        #btn-write-modify {
            color : #009f47;
            background-color: #e0f8eb;
        }

        #btn-cancel-modify {
            margin-right : 10px;
        }

        #reply-writebox {
            display : none;
            background-color: white;
            border : 1px solid #e5e5e5;
            border-radius: 5px;
            margin : 10px;
        }

        #reply-writebox-bottom {
            padding : 3px 10px 10px 10px;
            min-height : 35px;
        }

        #modify-writebox {
            background-color: white;
            border : 1px solid #e5e5e5;
            border-radius: 5px;
            margin : 10px;
        }

        #modify-writebox-bottom {
            padding : 3px 10px 10px 10px;
            min-height : 35px;
        }

        /* The Modal (background) */
        .modal {
            display: none; /* Hidden by default */
            position: fixed; /* Stay in place */
            z-index: 1; /* Sit on top */
            padding-top: 100px; /* Location of the box */
            left: 0;
            top: 0;
            width: 100%; /* Full width */
            height: 100%; /* Full height */
            overflow: auto; /* Enable scroll if needed */
            background-color: rgb(0,0,0); /* Fallback color */
            background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
        }

        /* Modal Content */
        .modal-content {
            background-color: #fefefe;
            margin: auto;
            padding: 20px;
            border: 1px solid #888;
            width: 50%;
        }

        /* The Close Button */
        .close {
            color: #aaaaaa;
            float: right;
            font-size: 28px;
            font-weight: bold;
        }

        .close:hover,
        .close:focus {
            color: #000;
            text-decoration: none;
            cursor: pointer;
        }
        .paging {
            color: black;
            width: 100%;
            text-align: center;
        }

        .page {
            color: black;
            text-decoration: none;
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
            margin-top: 50px;
            margin : auto;
        }
    </style>
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
    if(msg=="WRT_ERR") alert("게시물 등록에 실패하였습니다. 다시 시도해 주세요.");
    if(msg=="MOD_ERR") alert("게시물 수정에 실패하였습니다. 다시 시도해 주세요.");
</script>
<div class="container">
    <div>
    <div class="writing-header">
        <c:if test="${mode eq 'new'}">
            <h2 style="margin-top: 15px">글쓰기</h2>
        </c:if>
        <c:if test="${mode ne 'new'}">
            <div class="board-name">${boardDto.title}</div>
            <div class="post_info">
                <span style="margin-right: 40px">${postDto.writer}</span>
                <span>조회 ${postDto.view_cnt}</span>
            </div>
            <div style="float:right">
                <button type="button" id="writeNewBtn" class="btn btn-write"><i class="fa fa-pencil"></i> 글쓰기</button>
            </div>
        </c:if>
    </div>

    <form id="form" class="frm" action="" method="post">
        <input type="hidden" name="pno" value="${postDto.pno}">
        <c:if test="${mode eq 'new'}">
        <select id="boardSelect" name="bno">
            <c:forEach var="list" items="${BoardList}">
                <option value="<c:out value='${list.bno}'/> "><c:out value="${list.title}"/> </option>
            </c:forEach>
        </select>
        <input name="title" type="text" value="" placeholder="  제목을 입력해 주세요."/><br>
        <textarea name="content" rows="20" placeholder=" 내용을 입력해 주세요."></textarea><br>
        </c:if>
        <c:if test="${mode ne 'new'}">
            <input name="title" class="title" value="${postDto.title}" readonly/>
            <textarea name="content" class="content" readonly>${postDto.content}</textarea>
        </c:if>
        <c:if test="${mode eq 'new'}">
            <button type="button" id="writeBtn" class="btn btn-write"><i class="fa fa-pencil"></i> 등록</button>
        </c:if>
        <c:if test="${postDto.writer eq loginId}">
            <button type="button" id="modifyBtn" class="btn btn-modify"><i class="fa fa-edit"></i> 수정</button>
            <button type="button" id="removeBtn" class="btn btn-remove"><i class="fa fa-trash"></i> 삭제</button>
        </c:if>
        <button type="button" id="listBtn" class="btn btn-list"><i class="fa fa-bars"></i> 목록</button>
    </form>
    </div>
    </div>

    <c:if test="${mode ne 'new'}">
    <div id="commentarea">
        <div id="comment-writebox">
            <div class="commenter commenter-writebox">${id}</div>
            <div class="comment-writebox-content">
                <textarea name="comment" id="" cols="30" rows="3" placeholder="댓글을 남겨보세요"></textarea>
            </div>
            <div id="comment-writebox-bottom">
                <div class="register-box">
                    <a href="" class="comment-btn" id="btn-write-comment">등록</a>
                </div>
            </div>
        </div>
        <div id="commentList"></div>
    </c:if>
    </div>
<footer style="height: 70px;"></footer>
<script>
    $(document).ready(function(){
        let formCheck = function() {
            let form = document.getElementById("form");
            if(form.title.value == "") {
                alert("제목을 입력해 주세요.");
                form.title.focus();
                return false;
            }

            if(form.content.value == "") {
                alert("내용을 입력해 주세요.");
                form.content.focus();
                return false;
            }
            return true;
        }

        $("#writeNewBtn").on("click", function(){
            location.href="<c:url value='/board/post/create'/>";
        });

        $("#writeBtn").on("click", function(){
            let form = $("#form");
            form.attr("action", "<c:url value='/board/post'/>");
            form.attr("method", "post");

            if(formCheck())
                form.submit();
        });

        $("#modifyBtn").on("click", function(){
            let form = $("#form");
            let isReadonly = $("input[class=title]").attr('readonly');

            // 1. 읽기 상태이면, 수정 상태로 변경
            if(isReadonly=='readonly') {
                $(".writing-header").html("게시판 수정");
                $(".writing-header").attr("style", "font-size:30px;");
                $("input[class=title]").attr('readonly', false);
                $("textarea").attr('readonly', false);
                $("#modifyBtn").html("<i class='fa fa-pencil'></i> 등록");
                $("#commentList").html("");
                return;
            }

            // 2. 수정 상태이면, 수정된 내용을 서버로 전송
            if(formCheck()){
                let title = $("input[name=title]").val();
                let content = $("textarea").val();
                let dto = {
                    title: title,
                    content: content
                }
                $.ajax({
                    method: 'PATCH',                // 요청 메서드
                    url: '/sy/board/post/${postDto.pno}',         // 요청 URI
                    contentType: "application/json",
                    dataType: 'text',          // 전송받을 데이터의 타입
                    data: JSON.stringify(dto),
                    success: function (data) {
                        alert("성공적으로 수정하였습니다.");
                        location.href="<c:url value='/board/post/${postDto.pno}${searchCondition.queryString}'/>";
                    },
                    error: function () {
                        alert("error")
                    }
                });
            }
                // form.submit();

        });

        $("#removeBtn").on("click", function(){
            if(!confirm("정말로 삭제하시겠습니까?")) return;

            $.ajax({
                method: 'DELETE',                // 요청 메서드
                url: '/sy/board/post/${postDto.pno}',         // 요청 URI
                dataType: 'text',          // 전송받을 데이터의 타입
                success: function (data) {
                   alert("성공적으로 삭제하였습니다.");
                   location.href="<c:url value='/board${searchCondition.queryString}'/>";
                },
                error: function () {
                    alert("error")
                }
            });
        });

        $("#listBtn").on("click", function(){
            location.href="<c:url value='/board${searchCondition.queryString}'/>";
        });

        showComment();

        let commentCheck = function(obj){
            if(obj.val().trim()==""){
                alert("댓글을 입력하세요.");
                obj.focus();
                return false;
            }
            return true;
        }

        $("#btn-write-comment").on("click",function(){
            let comment = $("textarea[name=comment]").val();
            let pno = $("input[name=pno]").val();

            let dto = {
                comment: comment,
                pno: pno
            }

            $.ajax({
                method: 'POST',                // 요청 메서드
                url: '/sy/board/post/comment',         // 요청 URI
                contentType: "application/json",
                dataType: 'text',
                data: JSON.stringify(dto),
                success: function (data) {
                    alert("댓글을 성공적으로 등록하였습니다.");
                    showComment();
                },
                error: function () {
                    alert("error")
                }
            });
        });

        $("#commentarea").on("click", ".btn-modify", function(){
            let content_area = $(".comment-content", $(this).parent().parent());
            if(content_area.attr("readonly")) {
                let btn_str = "<a class='btn-modify' style='float:right;' >등록</a>";
                $(this).parent().append(btn_str);
                content_area.attr("readonly", false);
                content_area.attr("disabled", false);
                content_area.attr("style", "background-color:white; border:1px solid #ccc;");
            }
            else {
                if (commentCheck(content_area)) {
                    let cno = $(".btn-modify", $(this).parent()).attr("data-cno");
                    let comment = content_area.val();

                    let dto = {
                        cno: cno,
                        comment: comment
                    }
                    $.ajax({
                        method: 'PATCH',                // 요청 메서드
                        url: '/sy/board/post/comment/' + cno,    // 요청 URI
                        contentType: "application/json",
                        dataType: 'text',
                        data: JSON.stringify(dto),
                        success: function (data) {
                            alert("댓글을 성공적으로 수정하였습니다.");
                            showComment();
                        },
                        error: function () {
                            alert("error")
                        }
                    });
                }
            }
        });

        $("#commentarea").on("click", ".btn-delete", function(){
            let cno = $(this).attr("data-cno");
            alert(cno);
           $.ajax({
               method: 'DELETE',
               url: '/sy/board/post/comment/' + cno,
               dataType: 'text',
               success: function (data) {
                   alert("댓글을 성공적으로 삭제하였습니다.");
                   showComment();
               },
               error: function () {
                   alert("error");
               }
            });
        });

        $("#commentarea").on("click", ".btn-write", function(){
            if($("input[name='new_comment']", $(this).parent()).val()=='N'){
                $("input[name='new_comment']", $(this).parent()).val('Y');
                let re_comment = '';
                re_comment += "<textarea style='width: 90%' placeholder='댓글을 입력하세요.'></textarea>";
                re_comment += "<a class='new-comment-btn' style='float:right; margin-top:15px; font-size:13px;'>등록</a>";
                $(".new_comment-area", $(this).parent().parent()).html(re_comment);
            }else {
                $("input[name='new_comment']", $(this).parent()).val('N');
                $(".new_comment-area", $(this).parent().parent()).html("");
            }
        });

        $("#commentarea").on("click", ".new-comment-btn", function(){
            alert($("textarea", $(this).parent()).val());
            alert($(this).parent().parent().parent().attr("data-cno"));

            let comment = $("textarea", $(this).parent()).val()
            let pcno = $(this).parent().parent().parent().attr("data-cno");
            let pno = $(this).parent().parent().parent().attr("data-pno");

            let dto = {
                comment: comment,
                pcno: pcno,
                pno: pno
            }

            $.ajax({
                method: 'POST',                // 요청 메서드
                url: '/sy/board/post/comment',         // 요청 URI
                contentType: "application/json",
                dataType: 'text',
                data: JSON.stringify(dto),
                success: function (data) {
                    alert("댓글을 성공적으로 등록하였습니다.");
                    showComment();
                },
                error: function () {
                    alert("error")
                }
            });
        });
    });

    let showComment = function(){
        $.ajax({
            method:'GET',
            url: '/sy/board/post/comment/${postDto.pno}',         // 요청 URI
            success: function (data) {
                $("#commentList").html(toHtml(data));
            }
        })
    }

    let toHtml = function(data){
        let str = '<ul>';
        if(data.length==0){
            str += '<div style="color:dimgray; margin: 40px 0px 0px 20px;">등록된 댓글이 없습니다.</div>';
        }
        else {
            data.forEach(function (comment) {
                if(comment.cno != comment.pcno){
                str += '       <li class="comment-item" style="margin-left:40px;" data-cno="' + comment.cno + '" data-pno="' + comment.pno + '">';
                }
                else {
                str += '       <li class="comment-item" data-cno="' + comment.cno + '" data-pno="' + comment.pno + '">';
                }
                str += '        <span class="comment-img">';
                str += '            <i class="fa fa-user-circle" aria-hidden="true"></i>';
                str += '        </span>';
                str += '            <div class="comment-area">';
                str += '                <div class="commenter">' + comment.commenter + '</div>';
                str += '                <textarea class="comment-content" readonly disabled>' + comment.comment;
                str += '                </textarea>';
                str += '                <div class="comment-bottom">';
                str += '                    <span class="up_date">' + comment.up_date + '</span>';
                if(comment.cno == comment.pcno) {
                str += '                    <a class="btn-write"  data-cno="' + comment.cno + '" data-pno="' + comment.pno + '" data-pcno="' + comment.pcno + '">답글쓰기</a>';
                str += '                    <input type="hidden" name="new_comment" value="N"/>';
                }
                if('${loginId}'===comment.commenter){
                str += '                    <a class="btn-modify" data-cno="' + comment.cno + '" data-pno="' + comment.pno + '" data-pcno="' + comment.pcno + '">수정</a>';
                str += '                    <a href="#" class="btn-delete" data-cno="' + comment.cno + '" data-pno="' + comment.pno + '" data-pcno="' + comment.pcno + '">삭제</a>';
                }
                str += '                </div>';
                str += '                <div class="new_comment-area"></div>';
                str += '            </div>';
                str += '        </li>';
            })
        }
        str+="</ul>";
        return str;
    }
</script>
</body>
</html>
