<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>축제정보</title>
    <link rel="stylesheet" href="${contextPath}/css/festival/festival.css">
    <%@ include file="/WEB-INF/views/includes/header.jsp" %>
    <script>
        const contextPath = "${contextPath}";
    </script>
</head>
<body>
    <main class="festival-main">
        <h1>월별 축제달력</h1>
        <section class="calendar-section">
            <div class="calendar-controls">
                <select id="year-select"></select>
                <select id="month-select"></select>
            </div>
            <div id="calendar"></div>
        </section>
        <form class="festival-search-form" method="get" action="${contextPath}/festival">
            <input type="hidden" id="selected-date" name="date" value="${selectedDate}" />
            <input type="text" name="address" placeholder="지역 검색" value="${selectedAddress}" />
            <button type="submit">검색</button>
        </form>
        <h1>축제 리스트</h1>
        <section class="festival-section">
            <ul class="festival-list">
                <c:forEach var="festival" items="${festivals}">
                    <li class="festival-item">
                        <div class="festival-title">${festival.fstvlNm}</div>
                        <div class="festival-dates">${festival.fstvlStartDate} ~ ${festival.fstvlEndDate}</div>
                        <div class="festival-address">${festival.address}</div>
                    </li>
                    <script>
                        window.festivalData = window.festivalData || [];
                        window.festivalData.push({
                            fstvlNm: "${festival.fstvlNm}",
                            opar: "${festival.opar}",
                            fstvlStartDate: "${festival.fstvlStartDate}",
                            fstvlEndDate: "${festival.fstvlEndDate}",
                            fstvlCo: "${festival.fstvlCo}",
                            mnnstNm: "${festival.mnnstNm}",
                            auspcInsttNm: "${festival.auspcInsttNm}",
                            suprtInsttNm: "${festival.suprtInsttNm}",
                            phoneNumber: "${festival.phoneNumber}",
                            homepageUrl: "${festival.homepageUrl}",
                            relateInfo: "${festival.relateInfo}",
                            rdnmadr: "${festival.rdnmadr}",
                            lnmadr: "${festival.lnmadr}",
                            referenceDate: "${festival.referenceDate}",
                        });
                    </script>
                </c:forEach>
            </ul>
            <div class="pagination">
                <c:if test="${prevGroup > 0}">
                    <a href="${contextPath}/festival?page=${prevGroup}&date=${selectedDate}&address=${selectedAddress}" class="prev">이전</a>
                </c:if>
                <c:forEach begin="${startPage}" end="${endPage}" var="pageNum">
                    <a href="${contextPath}/festival?page=${pageNum}&date=${selectedDate}&address=${selectedAddress}"
                       class="${pageNum == currentPage ? 'active' : ''}">${pageNum}</a>
                </c:forEach>
                <c:if test="${nextGroup > 0}">
                    <a href="${contextPath}/festival?page=${nextGroup}&date=${selectedDate}&address=${selectedAddress}" class="next">다음</a>
                </c:if>
            </div>
        </section>
        <div id="festival-modal" class="modal">
            <div class="modal-content">
                <span class="close-btn">X</span>
                <h2 id="modal-title"></h2>
                <p><strong>개최 장소:</strong> <span id="modal-opar"></span></p>
                <p><strong>축제 시작일:</strong> <span id="modal-start-date"></span></p>
                <p><strong>축제 종료일:</strong> <span id="modal-end-date"></span></p>
                <p><strong>축제 내용:</strong> <span id="modal-description"></span></p>
                <p><strong>주최 기관:</strong> <span id="modal-mnnstNm"></span></p>
                <p><strong>주관 기관:</strong> <span id="modal-auspcInsttNm"></span></p>
                <p><strong>후원 기관:</strong> <span id="modal-suprtInsttNm"></span></p>
                <p><strong>전화번호:</strong> <span id="modal-phoneNumber"></span></p>
                <p><strong>홈페이지:</strong> <span id="modal-homepage"></span></p>
                <p><strong>관련 정보:</strong> <span id="modal-relateInfo"></span></p>
                <p><strong>도로명 주소:</strong> <span id="modal-rdnmadr"></span></p>
                <p><strong>지번 주소:</strong> <span id="modal-lnmadr"></span></p>
                <p><strong>데이터 기준일:</strong> <span id="modal-referenceDate"></span></p>
            </div>
        </div>
    </main>
    <script src="${contextPath}/js/festival/festival.js"></script>
</body>
</html>