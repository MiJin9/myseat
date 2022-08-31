<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%--<c:set var="loginEmail" value="${pageContext.request.getSession(false)==null ? '' : pageContext.request.session.getAttribute('email')}"--%>
<c:set var="loginOut" value="${loginEmail=='' ? '로그인' : '로그아웃'}"/>
<c:set var="loginOutLink" value="${loginEmail=='' ? '/user/login' : '/user/logout'}"/>
<html>
<head>
    <meta charset="UTF-8">
    <title>myseat</title>
    <link rel="stylesheet" href="<c:url value='/css/menu.css'/>">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>
</head>
<body>
<div id="header">
    <ul id="ul">
        <li id="logo">logo</li>
        <li><a class="menuA" href="<c:url value='/'/>">Home</a></li>
        <li><a class="menuA" href="<c:url value='/place/map'/>">극장</a></li>
        <li><a class="menuA" href="<c:url value='/review/list'/>">후기</a></li>
<%--        <li><a class="menuA" href="<c:url value='${loginOutLink}'/>">${loginOut}</a></li>--%>
        <li><a class="menuA" href="<c:url value='/user/login'/>">로그인</a></li>
        <li><a class="menuA" href="<c:url value='/user/signUp'/>">회원가입</a></li>
        <li><a class="menuA" href=""><i class="fa fa-search"></i></a></li>
    </ul>
</div>
</body>
</html>
