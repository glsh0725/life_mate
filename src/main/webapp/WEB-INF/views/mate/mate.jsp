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
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>메이트</title>
    <link rel="stylesheet" href="${contextPath}/css/mate/mate.css">
    <%@ include file="/WEB-INF/views/includes/header.jsp" %>
</head>
<body>
<main class="main-mate">
    <div class="region-choice">
        <h2>여행지를 선택해 주세요.</h2>
    </div>
    <div class="region-buttons">
        <button id="region-all" class="region-button" value="전국">전국</button>
        <button id="region-seoul" class="region-button" value="서울">서울</button>
        <button id="region-incheon" class="region-button" value="인천">인천</button>
        <button id="region-gyeonggi" class="region-button" value="경기">경기</button>
        <button id="region-gangwon" class="region-button" value="강원">강원</button>
        <button id="region-busan" class="region-button" value="부산">부산</button>
        <button id="region-daejeon" class="region-button" value="대전">대전</button>
        <button id="region-daegu" class="region-button" value="대구">대구</button>
        <button id="region-sejong" class="region-button" value="세종">세종</button>
        <button id="region-gwangju" class="region-button" value="광주">광주</button>
        <button id="region-ulsan" class="region-button" value="울산">울산</button>
        <button id="region-chungbuk" class="region-button" value="충청북도">충북</button>
        <button id="region-chungnam" class="region-button" value="충청남도">충남</button>
        <button id="region-gyeongbuk" class="region-button" value="경상북도">경북</button>
        <button id="region-gyeongnam" class="region-button" value="경상남도">경남</button>
        <button id="region-jeonbuk" class="region-button" value="전라북도">전북</button>
        <button id="region-jeonnam" class="region-button" value="전라남도">전남</button>
        <button id="region-jeju" class="region-button" value="제주">제주</button>
    </div>
    <div class="search-container">
        <input type="text" id="search-input" placeholder="시설명 검색">
        <button id="search-button">검색</button>
    </div>
    <div class="button-container">
        <button id="infant-button" class="filter-button">유아 동반</button>
        <button id="pet-button" class="filter-button">반려동물 동반</button>
    </div>
    <table>
        <thead>
        <tr>
            <th class="facility">시설명</th>
            <th class="city">시도/시군구</th>
            <th class="holiday">휴무일</th>
            <th class="facility-info">시설정보</th>
        </tr>
        </thead>
        <tbody>
        </tbody>
    </table>

    <!-- Modal -->
    <div id="mate-modal" class="modal">
        <div class="modal-content">
            <span class="close-btn">&times;</span>
        </div>
    </div>
</main>
</body>
<script>
    const contextPath = "${contextPath}";
</script>
<script src="${contextPath}/js/mate/mate.js"></script>
</html>