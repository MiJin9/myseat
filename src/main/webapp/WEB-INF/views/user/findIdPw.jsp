<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <title>fastcampus</title>
    <link rel="stylesheet" href="<c:url value='/css/user.css'/>">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>
    <style>
        h4{
            text-align: center;
            font-size: 40px;
            font-weight: 400;
        }
        .findLi {
            list-style: none;
            float: left;
            width: 50%;
            box-sizing: border-box;
            display: inline-block;
            font-size: 15px;
            border: 1px solid #d4d4d4;
            line-height: 46px;
            border-bottom: 2px solid #000;
        }
        ul{
            margin-top: 30px;
            text-align: center;
        }
        #emailBtn{
            width: 100%;
            margin-top: 0px;
        }
        input{
            background-color: white;
            width: 80%;
            height: 40px;
            border: 1px solid rgb(89, 117, 196);
            border-radius: 5px;
            padding: 0 10px;
            margin-bottom: 10px;
        }
        p{
            font-size: 17px;
            padding-bottom: 40px;
        }
    </style>
</head>
<body>

<form action="<c:url value="/user/findUser"/>" method="post">
    <div>
        <h4>계정찾기</h4>
        <ul>
            <li class="findLi"><a href="">아이디</a></li>
            <li class="findLi"><a href="">비밀번호</a></li>
        </ul>
        <div style="padding-top: 40px; padding-bottom: 40px; text-align: center">
            <p>가입한 계정의 이름과 닉네임을 입력해주세요.</p>
            <div>
                <input placeholder="이름">
                <input placeholder="닉네임">
            </div>
        </div>
        <div>
            <button id="emailBtn">이메일 찾기</button>
        </div>
    </div>
</form>
</body>
</html>