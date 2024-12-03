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
    <title>메인</title>
    <link rel="stylesheet" href="${contextPath}/css/main/main.css">
    <%@ include file="/WEB-INF/views/includes/header.jsp" %>
</head>
<body>
    <main>
        <!-- 메인 슬라이드 -->
        <section class="main-slide">
            <div class="slide-container1">
                <div class="slide">
                    <img src="/static/images/slide1.jpg" alt="슬라이드 이미지 1">
                </div>
                <div class="slide">
                    <img src="/static/images/slide2.jpg" alt="슬라이드 이미지 2">
                </div>
                <div class="slide">
                    <img src="/static/images/slide3.jpg" alt="슬라이드 이미지 3">
                </div>
            </div>
            <div class="slide-container2">
                <div class="slide">
                    <img src="/static/images/slide4.jpg" alt="슬라이드 이미지 1">
                </div>
                <div class="slide">
                    <img src="/static/images/slide5.jpg" alt="슬라이드 이미지 2">
                </div>
                <div class="slide">
                    <img src="/static/images/slide6.jpg" alt="슬라이드 이미지 3">
                </div>
            </div>
            <div class="slide-controls">
                <button id="prev">Prev</button>
                <button id="start">Start</button>
                <button id="stop">Stop</button>
                <button id="next">Next</button>
            </div>
        </section>

        <!-- 메인 소개 -->
        <section class="intro">
            <div class="intro-item">
                <p>소개글 작성</p>
            </div>
        </section>
        <section class="detail">
            <div class="detail-item">
                <h2>메이트</h2>
                <a href="#" class="button">알아보기</a>
            </div>
            <div class="detail-item">
                <h2>축제정보</h2>
                <a href="#" class="button">알아보기</a>
            </div>
            <div class="detail-item">
                <h2>커뮤니티</h2>
                <a href="#" class="button">알아보기</a>
            </div>
        </section>
    </main>

    <%@ include file="/WEB-INF/views/includes/footer.jsp" %>
</body>
<script src="${contextPath}/js/main/main.js"></script>
</html>