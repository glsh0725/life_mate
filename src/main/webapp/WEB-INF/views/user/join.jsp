<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"  %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<%
  request.setCharacterEncoding("UTF-8");
%>


<html>
<head>
    <meta charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
    <link rel="stylesheet" href="${contextPath}/static/css/user/join.css">
    <%@ include file="/WEB-INF/views/includes/header.jsp" %>
</head>
<body>
    <main>
        <div class="join-container">
            <h1>회원가입</h1>
            <form action="${pageContext.request.contextPath}/join" method="post" id="joinForm">
                <div class="form-group-userId">
                    <label for="userId">아이디</label>
                    <input type="text" id="userId" name="userId" required minlength="6" maxlength="12">
                </div>

                <div class="form-group-password">
                    <label for="password">비밀번호</label>
                    <input type="password" id="password" name="password" required minlength="8" maxlength="16">
                </div>

                <div class="form-group-confirmPassword">
                    <label for="confirmPassword">비밀번호 확인</label>
                    <input type="password" id="confirmPassword" name="confirmPassword" required minlength="8" maxlength="16">
                </div>

                <div class="form-group-nickname">
                    <label for="nickname">닉네임</label>
                    <input type="text" id="nickname" name="nickname" required minlength="1" maxlength="8">
                </div>

                <div class="form-group-email">
                    <label for="email">이메일</label>
                    <input type="email" id="email" name="email" required>
                </div>

                <div class="form-group-emailOptOut">
                    <label>이메일 수신 여부</label>
                    <input type="radio" id="emailAgree" name="emailOptOut" value="Y" checked>
                    <label for="emailAgree">동의</label>
                    <input type="radio" id="emailDisagree" name="emailOptOut" value="N">
                    <label for="emailDisagree">거부</label>
                </div>

                <div class="form-group-termsAgree">
                    <input type="checkbox" id="termsAgree" name="termsAgree" required>
                    <label for="termsAgree">이용약관 및 개인정보 취급방침에 동의합니다.</label>
                </div>

                <div class="form-group-join">
                    <button type="submit">회원가입</button>
                </div>
            </form>
        </div>
        <script src="${pageContext.request.contextPath}/static/js/user/join.js"></script>
    </main>
</body>
</html>