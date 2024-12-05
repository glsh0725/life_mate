<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<%
    request.setCharacterEncoding("UTF-8");
%>


<html>
<head>
    <meta charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>메이트</title>
    <link rel="stylesheet" href="${contextPath}/static/css/mate/mate.css">
    <%@ include file="/WEB-INF/views/includes/header.jsp" %>
</head>
<body>
<main>
    <%-- 내용작성 --%>

    <div class="mate-container">
        <h1>함께할 메이트를 선택해 주세요.</h1>
        <form action="${pageContext.request.contextPath}/mate" method="post" id="mateForm">
            <div class="form-group-kid">
                <button type="button">유아</button>
            </div>
            <div class="form-group-pet">
                <button type="button">반려동물</button>
            </div>

            <div class="form-group-go">
                <button type="submit">여행하기</button>
            </div>
        </form>
    </div>

</main>
</body>
</html>