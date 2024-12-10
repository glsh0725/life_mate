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
</head>
<body>
<main class="max fixed">
    <section id="welcome-page" class="main-section">
    <%@ include file="/WEB-INF/views/includes/header.jsp" %>
        <!-- 메인 슬라이드 -->
        <section class="main-slide">
            <div class="slide-container1">
                <div class="slide1"></div>
                <div class="slide-control-container">
                    <div class="slide-delay-bar">
                        <div class="delay-bar-progress"></div>
                    </div>
                    <span id="slide-indicator">01/03</span>
                    <div class="slide-controls">
                        <button id="prev">Prev</button>
                        <button id="toggle">Start</button>
                        <button id="next">Next</button>
                    </div>
                </div>
            </div>
            <div class="slide-container2">
                <div class="slide2"></div>
            </div>
        </section>

        <!-- 메인 소개 -->
        <div class="introduce">
            <section class="intro">
                <div class="intro-item">
                    <h2>소개글</h2>
                    <div class="intro-write">
                        <p>
                            반려해로는 사용자들이 맞춤형 여행 계획을 세울 수 있도록 돕는 플랫폼입니다.<br>
                            사용자는 함께할 반려를 선택하고 이를 기반으로 다양한 시설 정보를 확인하거나,
                            축제 정보를 통해 색다른 여행을 계획할 수 있습니다.<br>
                            또한, 커뮤니티의 공유 기록을 활용해 더욱 개인화된 여행을 준비할 수 있습니다.<br><br>
                            반려와의 특별한 여행, 반려해로와 함께 시작하세요!
                        </p>
                    </div>
                </div>
            </section>
            <section class="detail">
                <h2>자세히보기</h2>
                <div class="detail-list">
                    <div class="detail-item">
                        <h2>🐾 메이트</h2>
                        <a href="#mate-section" class="button">알아보기</a>
                    </div>
                    <div class="detail-item">
                        <h2>🐾 축제정보</h2>
                        <a href="#festival-section" class="button">알아보기</a>
                    </div>
                    <div class="detail-item">
                        <h2>🐾 커뮤니티</h2>
                        <a href="#community-section" class="button">알아보기</a>
                    </div>
                </div>
            </section>
        </div>
    </section>

    <section id="mate-section" class="main-section">
        <div class="box main-box">
            <h2>메이트</h2>
            <div class="main-box-header">
                <p>
                    메이트 탭은 유아, 반려동물 등 동반자를 고려하여, 사용자 맞춤형 여행 계획을
                    지원하는 데 목적이 있습니다.<br>
                    이를 통해 사용자가 동반자에게 적합한 여행지 정보를
                    쉽고 빠르게 탐색하고, 보다 즐겁고 편리한 여행을 경험할 수 있도록 돕습니다.
                </p>
            </div>
            <h2>주요기능설명</h2>
            <ul class="list">
                <li><strong>메이트 선택</strong> 동반자를 선택하여, 선택된 메이트에 맞는 추천 여행
                정보를 제공 (중복 선택 가능)</li>
                <li><strong>여행지 필터링</strong> 선택된 메이트에 따라 여행지 정보를 지역 및
                카테고리별로 필터링하여 탐색</li>
                <li><strong>시설 상세 정보 확인</strong> 특정 여행지나 시설의 세부 정보를 확인할
                수 있는 기능 제공</li>
                <li><strong>검색 기능</strong> 키워드 검색을 통해 특정 여행지나 시설을 신속히 탐색</li>
            </ul>
            <a class="main-button" href="/mate">메이트 바로가기 ➽</a>
        </div>
    </section>

    <section id="festival-section" class="main-section">
        <div class="box main-box">
            <h2>축제정보</h2>
            <div class="main-box-header">
                <p>
                    축제정보 탭은 사용자가 여행 기간 동안 즐길 수 있는 다양한 축제 정보를 제공하여,
                    여행 경험을 더욱 풍성하게 만드는 것을 목표로 합니다.<br>
                    월별 축제 일정 및 세부 내용을 제공함으로써, 사용자가 원하는 날짜와 관심사에 맞는
                    축제를 쉽게 찾을 수 있도록 돕습니다.
                </p>
            </div>
            <h2>주요기능설명</h2>
            <ul class="list">
                <li><strong>월별 축제 달력 제공</strong> 달력 형식으로 월별 축제 일정을 시각적으로
                확인할 수 있는 기능 제공</li>
                <li><strong>축제 리스트 보기</strong> 현재 또는 선택한 날짜의 축제 목록을 필터링하여
                시각적으로 제공</li>
                <li><strong>지역 검색 기능</strong> 검색할 지역을 입력하여 특정 지역 축제를 빠르게 찾을
                수 있는 기능 제공</li>
                <li><strong>축제 상세 정보 조회</strong> 선택한 축제의 위치, 일정, 축제 내용, 홈페이지 등
                세부 정보를 확인 가능</li>
            </ul>
            <a class="main-button" href="/festival">축제정보 바로가기 ➽</a>
        </div>
    </section>

    <section id="community-section" class="main-section">
        <div class="box main-box">
            <h2>커뮤니티</h2>
            <div class="main-box-header">
                <p>
                    커뮤니티 탭은 사용자들이 여행 경험을 공유하고, 다른 여행자들과 소통하며 유익한 정보를
                    주고받을 수 있도록 설계되었습니다.<br>
                    이를 통해 사용자 간 커뮤니티를 형성하고, 여행의 다양성과 즐거움을 배가시키는 것이 목적입니다.
                </p>
            </div>
            <h2>주요기능설명</h2>
            <ul class="list">
                <li><strong>게시물 작성 및 관리</strong> 사용자가 여행 경험을 게시물로 작성하고 수정
                또는 삭제할 수 있는 기능 제공</li>
                <li><strong>댓글 및 소통 기능</strong> 게시물에 댓글을 작성하고 좋아요를 누르는 등, 다른
                사용자와의 상호작용 지원</li>
                <li><strong>검색 및 필터링</strong> 제목, 닉네임, 지역 등으로 검색하거나 필터링하여 원하는 정보를
                쉽게 탐색 가능</li>
                <li><strong>신고 및 관리 기능</strong> 부적절한 게시물을 신고 기능 제공, 관리자 페이지와
                연계하여 품질 유지</li>
            </ul>
            <a class="main-button" href="/community">커뮤니티 바로가기 ➽</a>
        </div>
    </section>

    <button class="top-button">▲ Top</button>
    <%@ include file="/WEB-INF/views/includes/footer.jsp" %>
</main>
</body>
<script src="${contextPath}/js/main/main.js"></script>
</html>