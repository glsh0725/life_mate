<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
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
    <h1>월별 축제달력</h1>
    <section class="calendar-section">
        <div class="calendar-controls">
            <select id="year-select"></select>
            <select id="month-select"></select>
        </div>
        <div id="calendar"></div>
    </section>
    <form method="get" action="${contextPath}/festival">
        <input type="text" name="address" placeholder="주소로 검색" value="${searchAddress}" />
        <button type="submit">검색</button>
    </form>
    <h1>축제 리스트</h1>
    <main>
        <section class="festival-section">
            <ul class="festival-list">
                <c:forEach var="festival" items="${festivals}">
                    <li class="festival-item">
                        <div class="festival-title">${festival.fstvlNm}</div>
                        <div class="festival-dates">${festival.fstvlStartDate} ~ ${festival.fstvlEndDate}</div>
                        <div class="festival-address">${festival.address}</div>
                    </li>
                </c:forEach>
            </ul>
            <div class="pagination">
                <c:if test="${prevGroup > 0}">
                    <a href="${contextPath}/festival?page=${prevGroup}" class="prev">이전</a>
                </c:if>

                <c:forEach begin="${startPage}" end="${endPage}" var="pageNum">
                    <a href="${contextPath}/festival?page=${pageNum}"
                       class="${pageNum == currentPage ? 'active' : ''}">${pageNum}</a>
                </c:forEach>

                <c:if test="${nextGroup > 0}">
                    <a href="${contextPath}/festival?page=${nextGroup}" class="next">다음</a>
                </c:if>
            </div>
        </section>
    </main>
    <script src="${contextPath}/js/festival/festival.js"></script>
</body>
</html>