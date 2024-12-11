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
<main>
    <table border="1">
        <thead>
        <tr>
            <th>시설명</th>
            <th>시도/시군구</th>
            <th>홈페이지/블로그/소셜미디어</th>
            <th>전화번호</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="mate" items="${mateList}">
            <tr>
                <td>${mate.facilityName}</td>
                <td>${mate.city} ${mate.cityDistrict}</td>
                <td>
                    <c:choose>
                        <c:when test="${not empty mate.url && mate.url != '정보없음'}">
                            ${mate.url}
                        </c:when>
                        <c:when test="${not empty mate.blogUrl && mate.blogUrl != '정보없음'}">
                            ${mate.blogUrl}
                        </c:when>
                        <c:when test="${not empty mate.facebookUrl && mate.facebookUrl != '정보없음'}">
                            ${mate.facebookUrl}
                        </c:when>
                        <c:when test="${not empty mate.instargramUrl && mate.instargramUrl != '정보없음'}">
                            ${mate.instargramUrl}
                        </c:when>
                        <c:otherwise>
                            정보없음
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>${mate.contact}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</main>
</body>
<script src="${contextPath}/js/mate/mate.js"></script>
</html>