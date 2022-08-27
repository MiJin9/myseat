<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page session="true" %>
<%--<c:set var="loginEmail" value="${sessionScope.email}"/>--%>
<c:set var="loginNickname" value="${sessionScope.nickname}"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>fastcampus</title>
    <link rel="stylesheet" href="<c:url value='/css/review.css'/>">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
    <style>
        #listBtn {
            float: right;
        }
    </style>
</head>
<body>
<script>
    let msg = "${msg}";
    if(msg=="WRT_ERR") alert("게시물 등록에 실패하였습니다. 다시 시도해 주세요.");
    if(msg=="MOD_ERR") alert("게시물 수정에 실패하였습니다. 다시 시도해 주세요.");
</script>
<div class="container">
    <h2 class="writing-header">리뷰 ${mode=="new" ? "쓰기" : "읽기"}</h2>
    <form id="form" class="form" action="" method="" style="margin-top: 10px">
        <input type="hidden" name="bno" value="${reviewDto.bno}">
        <c:if test="${mode eq 'new'}">
        <select name="sort" id="sort" style="margin-bottom: 5px; background-color: #f8f8f8">
            <option value="0">--카테고리를 선택해주세요--</option>
            <option value="1">영화</option>
            <option value="2">공연</option>
        </select>
        </c:if>
        <c:if test="${mode ne 'new'}">
            <input type="text" value="${reviewDto.sort=="1" ? "영화" : "공연"}" readonly>
        </c:if>
        <input name="title" id="title" type="text" placeholder="  제목을 입력해 주세요." ${mode=="new" ? "" : "readonly='readonly'"} value="<c:out value='${reviewDto.title}'/>"><br>
        <textarea name="content" rows="20" id="content"
                  placeholder=" 내용을 입력해 주세요." ${mode=="new" ? "" : "readonly='readonly'"}>${reviewDto.content}</textarea><br>

        <c:if test="${mode eq 'new'}">
            <button type="button" id="writeBtn" class="btn btn-write"><i class="fa fa-pencil"></i> 등록</button>
        </c:if>
        <c:if test="${mode ne 'new'}">
        <button type="button" id="writeNewBtn" class="btn btn-write"><i class="fa fa-pencil"></i> 글쓰기</button>
        </c:if>
        <c:if test="${reviewDto.nickname eq loginNickname}">
            <button type="button" id="modifyBtn" class="btn btn-modify"><i class="fa fa-edit"></i> 수정</button>
            <button type="button" id="removeBtn" class="btn btn-remove"><i class="fa fa-trash"></i> 삭제</button>
        </c:if>

        <button type="button" id="listBtn" class="btn btn-list" onclick="location.href='<c:url value="/review/list"/>'">
            <i class="fa fa-bars"></i> 목록
        </button>
    </form>
</div>
<script>
    $(function () {
        let formCheck = function () {
            let title = document.getElementById("title");
            let content = document.getElementById("content");
            let sort = document.getElementById("sort");
            if (title.value == "") {
                alert("제목을 입력해주세요.");
                title.focus();
                return false;
            }
            if (content.value == "") {
                alert("내용을 입력해주세요.");
                content.focus();
                return false;
            }
            if (sort.value == "0") {
                alert("카테고리를 선택해주세요.");
                sort.focus();
                return false;
            }
            return true;
        }
        $("#writeBtn").on("click", function () {
            let form = $("#form");
            form.attr("action", "<c:url value='/review/write'/>");
            form.attr("method", "post");
            if (formCheck())
                form.submit();
        });
        $("#modifyBtn").on("click", function (){
            let form = $("#form");
            let isReadonly = $("input[name=title]").attr('readonly');
            if(isReadonly=='readonly'){
                $("input[name=title]").attr('readonly', false);
                $("textarea").attr('readonly', false);
                $(".writing-header").html("리뷰 수정");
                $("#modifyBtn").html("<i class='fa fa-edit'></i>등록");
                return;
            }
            form.attr("action", "<c:url value='/review/modify'/>");
            form.attr("method", "post");
            form.submit();
        });
        $("#removeBtn").on("click", function (){
            let form = $("#form");
            if(!confirm("정말로 삭제하시겠습니까?")) return;
            form.attr("action", "<c:url value='/review/remove'/>");
            form.attr("method", "post");
            form.submit();
        });
    });
</script>
</body>
</html>