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
        #findUl{
            margin-top: 30px;
            text-align: center;
        }
        #emailBtn, #loginBtn{
            width: 100%;
            margin-top: 0px;
            background-color: rgb(89, 117, 196);
            color: white;
            font-weight: bold;
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
        #email{
            background-color: white;
        }
        #pw{
            background-color: #edeaea;
        }
        #pwA{
            color: black;
            background-color: #edeaea;
        }
        #emailA{
            color: black;
            background-color: white;
        }
    </style>
</head>
<body>

<form action="" method="post" id="form">
    <div style="width: 100%">
        <h4>계정찾기</h4>
        <ul id="findUl">
            <li class="findLi" id="email"><a href="javascript:void(0)" id="emailA">이메일 찾기</a></li>
            <li class="findLi" id="pw"><a href="javascript:void(0)" id="pwA">비밀번호 찾기</a></li>
        </ul>
        <div id="idPwCommon" style="padding-top: 40px; padding-bottom: 40px; text-align: center">
            <p id="pText">가입한 계정의 이름과 닉네임을 입력해주세요.</p>
            <div id="inputLoc">
                <input placeholder="이름" id="name">
                <input placeholder="닉네임" id="nickname">
            </div>
            <div id="emailResult" style="display: none;">
                <h5 style="font-size: 15px">요청하신 이메일 찾기 결과입니다.</h5>
                <div id="emailLoc">
                    <p id="emailPlace" style="font-size: 15px; padding-bottom: 0; margin-top: 25px;"></p>
                </div>
            </div>
        </div>
        <div>
            <input type="button" id="emailBtn" value="이메일 찾기">
            <input type="button" id="loginBtn" style="display: none" value="로그인">
        </div>
    </div>
</form>
<script>
    $("#pwA").on("click", function (){
        $("#pw").css("background-color", "white");
        $("#pwA").css("background-color", "white");
        $("#email").css("background-color", "#edeaea");
        $("#emailA").css("background-color", "#edeaea");
    });

    $("#emailA").on("click", function (){
        $("#pw").css("background-color", "#edeaea");
        $("#pwA").css("background-color", "#edeaea");
        $("#email").css("background-color", "white");
        $("#emailA").css("background-color", "white");
    });

    $("#emailBtn").on("click", function (){
        let name = $("#name").val();
        let nickname = $("#nickname").val();
        if($("#name").val()==""){
            alert("이름을 입력해주세요.")
            return;
        }

        if($("#nickname").val()==""){
            alert("닉네임을 입력해주세요.")
            return;
        }

        $.ajax({
            url : "/myseat/user/findEmail",
            type : "post",
            data : {"name" : name,
                    "nickname" : nickname},
            dataType : 'text',
            success:function (result){
                $("#pText").css('display', 'none')
                $("#inputLoc").css('display', 'none')
                $("#emailBtn").css('display', 'none')
                $("#emailResult").css('display', 'block')
                $("#loginBtn").css('display', 'block')
                $("#emailPlace").text(result);
            },
            error:function(){
                alert("error : 서버요청실패");
            }
        });
    });
    $("#loginBtn").on("click", function(){
        location.href="<c:url value='/user/login'/>";
    });
</script>
</body>
</html>