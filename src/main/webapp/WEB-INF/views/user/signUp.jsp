<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <title>fastcampus</title>
    <link rel="stylesheet" href="<c:url value='/css/menu.css'/>">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>
    <style>
        * { box-sizing:border-box; }
        a { text-decoration: none; }
        form {
            width:400px;
            height:500px;
            display : flex;
            flex-direction: column;
            align-items:center;
            position : absolute;
            top:60%;
            left:50%;
            transform: translate(-50%, -50%) ;
            border: 1px solid rgb(89,117,196);
            border-radius: 10px;
        }
        input[type='text'], input[type='password'] {
            width: 300px;
            height: 38px;
            border : 1px solid rgb(89,117,196);
            border-radius:5px;
            padding: 0 10px;
            margin-bottom: 14px;
        }

        input[type='checkbox']{
            margin-right: 5px;
            vertical-align:-1px;
        }

        #signUpBtn {
            background-color: rgb(89,117,196);
            color : white;
            width:300px;
            height:50px;
            font-size: 17px;
            border : none;
            border-radius: 5px;
            margin : 20px 0 30px 0;
        }

        #title {
            font-size : 50px;
            margin: 30px 0 25px 0;
        }

        #terms{
            font-size: 9px;
        }
    </style>
</head>
<body>

<form action="<c:url value="/user/signUp"/>" method="post">
    <h3 id="title">회원 가입</h3>
    <div>
        <input type="text" name="email" id="email" placeholder="이메일" autofocus>
        <input type="text" id="emailHidden" value="0">
        <span><p id="emailCheck" style="font-size: 12px"></p></span>
    </div>

    <div id="pwPlacepw">
        <input type="password" name="pw" id="pw" placeholder="비밀번호">
        <span><p id="pwText" style="font-size: 12px"></p></span>
    </div>
    <div id="pwPlace">
        <input type="password" name="pwCheck" id="pwCheck" placeholder="비밀번호 확인">
        <span><p id="pwCheckText" style="font-size: 12px"></p></span>
    </div>
    <input type="text" name="name" id="name" placeholder="이름">
    <div>
        <input type="text" name="nickname" id="nickname" placeholder="닉네임">
        <span><p id="nickCheckText" style="font-size: 12px"></p></span>
    </div>
    <label id="terms">
        <input type="checkbox" id="termsCheck">내자리에서 제공하는 서비스 약관에 동의합니다.
    </label>
    <button id="signUpBtn">회원가입</button>
    <script>
        $("#pw").focusout(function(){
            var reg = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,15}$/;
            var pw = $("#pw").val();
            if (!reg.test(pw)) {
                $("#pwText").css("color","red");
                $("#pwText").text("숫자와 영문을 포함, 8~15자리 사이로 입력해주세요");
            }else{
                $("#pwText").css("color","green");
                $("#pwText").text("사용가능한 비밀번호입니다.");
            }
        });

        //비밀번호 확인과 비밀번호 일치여부 확인
        $("#pwCheck").focusout(function(){
            if($("#pw").val() != $("#pwCheck").val()){
                $("#pwCheckText").css("color", "red");
                $("#pwCheckText").text("비밀번호가 일치하지 않습니다.");
                $("#pwCheck").css("margin-bottom", "2px");
                $("#pwCheck").css("height", "35px");
                $("#pwPlace").css("margin-bottom", "12px");
            }else{
                $("#pwCheckText").css("color", "green");
                $("#pwCheckText").text("비밀번호가 일치합니다.");
            }
        });

        //이메일 중복 여부 확인
        $("#email").focusout(function (){
            let email = $(this).val();
            let regExp = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
            if(email==""){
                $("#emailCheck").text("");
                return;
            }

            $.ajax({
                url : "/myseat/user/check",
                type : "post",
                data : email,
                headers : { "content-type": "application/json"},
                dataType : 'text',
                success:function(result) {
                    if(result==0){
                        if(!regExp.test(email)){
                            $("#emailCheck").text("이메일 형식이 올바르지 않습니다.");
                            $("#emailCheck").css("color","red");
                        }else{
                            $("#emailCheck").text("사용 가능한 이메일입니다.");
                            $("#emailCheck").css("color","green");
                            $('input[id=emailHidden]').attr('value', 1);
                            // $("#email").attr("readonly",true);
                        }
                    }else{
                        $("#emailCheck").text("이미 사용중이거나 탈퇴한 이메일입니다.");
                        $("#emailCheck").css("color","red");
                    }
                },
                error:function(){
                    alert("error : 서버요청실패");
                }
            })
        })

        //닉네임 중복 여부 확인
        $("#nickname").focusout(function (){
            let nickname = $(this).val();
            if(nickname==""){
                $("#emailCheck").text("");
                return;
            }

            $.ajax({
                url : "/myseat/user/checkNickname",
                type : "post",
                data : nickname,
                headers : { "content-type": "application/json"},
                dataType : 'text',
                success:function(result) {
                    if(result==0){
                        $("#nickCheckText").text("사용 가능한 닉네임입니다.");
                        $("#nickCheckText").css("color","green");
                        $('input[id=emailHidden]').attr('value', 1);
                        // $("#email").attr("readonly",true);
                    }else{
                        $("#nickCheckText").text("이미 사용중이거나 탈퇴한 닉네임입니다.");
                        $("#nickCheckText").css("color","red");
                    }
                },
                error:function(){
                    alert("error : 서버요청실패");
                }
            })
        })

        //회원가입 시 빈칸 유무 확인
        $("#signUpBtn").on("click", function(){
            if(!$("#email").val()){
                alert("이메일을 입력해주세요.");
                return false;
            }

            if(!$("#pw").val()){
                alert("비밀번호 입력해주세요.");
                return false;
            }

            if($("#pwCheckText").text()!=""){
                alert("비밀번호를 일치하게 작성해주세요.");
                return false;
            }

            if(!$("#name").val()){
                alert("이름을 입력해주세요.");
                return false;
            }

            if(!$("#nickname").val()){
                alert("닉네임을 입력해주세요.");
                return false;
            }

            if(!$("#termsCheck").is(":checked") == true){
                alert("약관 동의를 해주세요.");
                return false;
            }
        });
    </script>
</form>
</body>
</html>