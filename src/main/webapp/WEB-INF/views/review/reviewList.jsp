<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page session="true"%>
<c:set var="loginId" value="${sessionScope.id}"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>fastcampus</title>
    <link rel="stylesheet" href="<c:url value='/css/list.css'/>">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
    <style>
        #writeBtn{
            float: right;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
<div style="text-align:center">
    <div class="board-container">
        <button id="writeBtn" class="btn-write" onclick="location.href='<c:url value="/review/write"/>'"><i class="fa fa-pencil" ></i> 글쓰기</button>
        <table>
            <tr>
                <th class="no">번호</th>
                <th class="title">제목</th>
                <th class="writer">닉네임</th>
                <th class="regdate">등록일</th>
                <th class="viewcnt">조회수</th>
            </tr>
                <tr>
                    <td class="no"></td>
                    <td class="title"><a></a></td>
                    <td class="writer"></td>
                    <td class="regdate"></td>
                    <td class="viewcnt"></td>
                </tr>
        </table>
        <br>
        <div class="paging-container">
            <div class="paging">

            </div>
        </div>
        <div class="search-container">
            <form action="<c:url value="/board/list"/>" class="search-form" method="get">
                <select class="search-option" name="option">
                    <option value="A">제목+내용</option>
                    <option value="T">제목만</option>
                    <option value="W">작성자</option>
                </select>

                <input type="text" name="keyword" class="search-input" type="text"placeholder="검색어를 입력해주세요">
                <input type="submit" class="search-button" value="검색">
            </form>
        </div>
    </div>
</div>
</body>
</html>