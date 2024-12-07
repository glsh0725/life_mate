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
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원정보</title>
    <link rel="stylesheet" href="${contextPath}/css/user/userinfo.css">
    <%@ include file="/WEB-INF/views/includes/header.jsp" %>
</head>
<body>
    <main>
        <div class="userinfo-container">
            <h1>회원정보</h1>
            <form action="${pageContext.request.contextPath}/userinfo" method="post" id="userinfoForm">

                <div class="form-group-nickname">
                    <label for="usr_nickname">닉네임</label>
                    <input type="text" id="usr_nickname" name="usr_nickname" required minlength="1" maxlength="10" />
                    <button type="button" class="change-button">변경</button>
                </div>

                <div class="form-group-password">
                    <label for="usr_password">현재 비밀번호</label>
                    <input type="password" id="usr_password" name="usr_password" required minlength="8" maxlength="16" />
                </div>

                <div class="form-group-updatePassword">
                    <label for="update_password">비밀번호 변경</label>
                    <input type="password" id="update_password" name="update_password" required minlength="8" maxlength="16" />
                </div>

                <div class="form-group-confirmPassword">
                    <label for="confirmPassword">비밀번호 변경 확인</label>
                    <input type="password" id="confirmPassword" name="confirmPassword" required minlength="8" maxlength="16" />
                </div>

                <div class="form-group-email">
                    <label for="usr_email">이메일</label>
                    <input type="email" id="usr_email" name="usr_email" required />
                </div>

                <div class="form-group-emailOptOut">
                    <label>이메일 수신 여부</label>
                    <input type="radio" id="emailAgree" name="emailOptOut" value="Y" checked />
                    <label for="emailAgree">동의</label>
                    <input type="radio" id="emailDisagree" name="emailOptOut" value="N" />
                    <label for="emailDisagree">거부</label>
                </div>

                <!-- 저장 및 회원탈퇴 버튼 -->
                <div class="form-buttons">
                    <button type="submit" class="save-button">저장</button>
                    <button type="button" class="delete-button" onclick="confirmDelete()">회원탈퇴</button>
                </div>
            </form>
        </div>
    </main>
    <script src="${contextPath}/js/user/userinfo.js"></script>
</body>
</html>
