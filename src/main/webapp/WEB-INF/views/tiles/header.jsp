<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>fastcampus</title>
    <link rel="stylesheet" href="<c:url value='/css/menu.css'/>">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>
</head>
<body>
<div id="header">
    <ul>
        <li id="logo">fastcampus</li>
        <li><a href="<c:url value='/'/>">Home</a></li>
        <li><a href="<c:url value='/board/list'/>">좌석</a></li>
        <li><a href="<c:url value='/board/list'/>">후기</a></li>
        <li><a href="<c:url value='/user/login'/>">로그인</a></li>
        <li><a href="<c:url value='/user/signUp'/>">회원가입</a></li>
        <li><a href=""><i class="fa fa-search"></i></a></li>
    </ul>
</div>
</body>
</html>
