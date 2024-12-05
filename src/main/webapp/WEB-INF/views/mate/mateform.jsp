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
    <title>메이트 폼</title>
    <link rel="stylesheet" href="${contextPath}/static/css/mate/mate.css">
    <%@ include file="/WEB-INF/views/includes/header.jsp" %>
</head>
<body>
<main>
    <%-- 내용작성 --%>

    <div class="mate-form-container">
        <h1>여행지를 선택해 주세요.</h1>
        <form action="${pageContext.request.contextPath}/mate" method="post" id="mateForm">
            <div class="form-group-mate-form">
                <div class="form-group-defalut">
                    <button type="button">전국</button>
                </div>
                <div class="form-group-seoul">
                    <button type="button">서울</button>
                </div>
                <div class="form-group-incheon">
                    <button type="button">인천</button>
                </div>
                <div class="form-group-gyeonggi">
                    <button type="button">경기</button>
                </div>
                <div class="form-group-gyeonggi">
                    <button type="button">강원</button>
                </div>
                <div class="form-group-busan">
                    <button type="button">부산</button>
                </div>
                <div class="form-group-daejeon">
                    <button type="button">대전</button>
                </div>
                <div class="form-group-daegu">
                    <button type="button">대구</button>
                </div>
                <div class="form-group-sejeong">
                    <button type="button">세종</button>
                </div>
                <div class="form-group-gwanju">
                    <button type="button">광주</button>
                </div>
                <div class="form-group-ulsan">
                    <button type="button">울산</button>
                </div>
                <div class="form-group-chungcheongbuk">
                    <button type="button">충북</button>
                </div>
                <div class="form-group-Chungcheongnam">
                    <button type="button">충남</button>
                </div>
                <div class="form-group-gyeongsangbuku">
                    <button type="button">경북</button>
                </div>
                <div class="form-group-gyeongsangnam">
                    <button type="button">경남</button>
                </div>
                <div class="form-group-jeollabuk">
                    <button type="button">전북</button>
                </div>
                <div class="form-group-jeollanam">
                    <button type="button">전남</button>
                </div>
                <div class="form-group-jeju">
                    <button type="button">제주</button>
                </div>
            </div>
        </form>

        <h3>여행지 리스트(Test)</h3>
        <section class="mate-section">
            <ul class="mate-list">

            </ul>

        </section>
    </div>

</main>
</body>
</html>