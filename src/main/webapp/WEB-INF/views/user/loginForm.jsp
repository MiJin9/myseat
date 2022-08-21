<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>fastcampus</title>
    <link rel="stylesheet" href="<c:url value='/css/user.css'/>">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>

</head>
<body>

<form action="<c:url value="/user/login"/>" method="post" onsubmit="return formCheck(this);">
    <h3 id="title">로그인</h3>
    <div id="msg">
        <c:if test="${not empty param.msg}">
            <i class="fa fa-exclamation-circle"> ${URLDecoder.decode(param.msg)}</i>
        </c:if>
    </div>
    <input type="text" name="email" value="${cookie.email.value}" placeholder="이메일 입력" autofocus>
    <input type="password" name="pw" placeholder="비밀번호" style="margin-bottom: 25px">
    <input type="hidden" name="toURL" value="${param.toURL}">
    <button>로그인</button>
    <div style="width: 100%;">
        <label style="font-size: 13px; float: left; padding 0.3em"><input type="checkbox" name="rememberId" value="on" ${empty cookie.email.value ? "":"checked"}> 아이디 저장</label>
        <div style="float: right">
            <a href="/myseat/user/findUser" style="font-size: 13px">아이디/비밀번호 찾기</a> |
            <a href="/myseat/user/signUp" style="font-size: 13px">회원가입</a>
        </div>
    </div>
    <script>
        function formCheck(frm) {
            let msg ='';
            if(frm.id.value.length==0) {
                setMessage('id를 입력해주세요.', frm.id);
                return false;
            }
            if(frm.pwd.value.length==0) {
                setMessage('password를 입력해주세요.', frm.pwd);
                return false;
            }
            return true;
        }
        function setMessage(msg, element){
            document.getElementById("msg").innerHTML = ` ${'${msg}'}`;
            if(element) {
                element.select();
            }
        }
    </script>
</form>
</body>
</html>