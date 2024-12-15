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
    <title>로그인</title>
    <link rel="stylesheet" href="${contextPath}/css/user/login.css">
    <%@ include file="/WEB-INF/views/includes/header.jsp" %>
    <script>
        var message = "${message}";

        if (message) {
            alert(message);
        }
    </script>
</head>
<body>
    <main>
        <div class="login-container">
            <h1>로그인</h1>
            <form action="${pageContext.request.contextPath}/login" method="post" id="loginForm">
                <div class="form-group-id">
                    <label for="usr_id">아이디</label>
                    <input type="text" id="usr_id" name="usr_id" required placeholder="아이디를 입력하세요">
                </div>

                <div class="form-group-password">
                    <label for="usr_password">비밀번호</label>
                    <input type="password" id="usr_password" name="usr_password" required placeholder="비밀번호를 입력하세요">
                </div>

                <div class="form-group-memory">
                    <input type="checkbox" id="idMemory" name="idMemory">
                    <label for="idmemory">아이디 기억</label>
                </div>

                <div class="form-group-login">
                    <button type="submit">로그인</button>
                </div>

                <div class="form-group-join">
                    <a href="${pageContext.request.contextPath}/join">회원가입</a>
                </div>

                <div class="form-group-forgot">
                    <a href="${pageContext.request.contextPath}/forgot">아이디/비밀번호 찾기</a>
                </div>
            </form>
        </div>
        <script src="${pageContext.request.contextPath}/static/js/user/login.js"></script>
    </main>
    <script src="${contextPath}/js/user/login.js"></script>
</body>
</html>