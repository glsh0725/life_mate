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
    <title>아이디 / 비밀번호 찾기</title>
    <link rel="stylesheet" href="${contextPath}/css/user/forgot.css">
    <%@ include file="/WEB-INF/views/includes/header.jsp" %>
</head>
<body>
    <main class="main-forgot">
        <div class="forgot-id">
            <h2>아이디 찾기</h2>
            <form action="${contextPath}/forgot" method="post">
                <table>
                    <tr>
                        <td>이메일</td>
                        <td><input class="email" type="email" name="email" required></td>
                    </tr>
                </table>
                <div>
                    <button type="submit" name="action" value="findId">아이디 확인</button>
                </div>
            </form>
        </div>
        <div class="forgot-pwd">
            <h2>비밀번호 찾기</h2>
            <form action="${contextPath}/forgot" method="post">
                <table>
                    <tr>
                        <td>이메일</td>
                        <td><input class="email" type="email" name="email" required></td>
                    </tr>
                </table>
                <div>
                    <button type="submit" name="action" value="findPassword">메일 발송</button>
                </div>
            </form>
        </div>
        <%@ include file="/WEB-INF/views/includes/footer.jsp" %>
    </main>
</body>
</html>