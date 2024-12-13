<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"  %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<%
  request.setCharacterEncoding("UTF-8");
%>

<link rel="stylesheet" href="${contextPath}/css/includes/header.css">

<header>
    <div class="auth-check">
        <c:choose>
            <c:when test="${not empty sessionScope.user}">
                <c:if test="${sessionScope.user.role eq 'admin'}">
                    <a href="${contextPath}/admin">관리자 페이지</a>
                </c:if>
                <a href="${contextPath}/userinfo">회원정보</a>
                <a href="${contextPath}/logout">로그아웃</a>
            </c:when>
            <c:otherwise>
                <a href="${contextPath}/join">회원가입</a>
                <a href="${contextPath}/login">로그인</a>
            </c:otherwise>
        </c:choose>
    </div>
    <div class="header-container">
        <a href="${contextPath}/main" class="logo">
            <img width="80" height="70" src="${contextPath}/images/logo.png">
            <img width="230" height="70" src="${contextPath}/images/name.png">
        </a>
        <nav class="navbar">
            <ul>
                <li>
                    <a href="${contextPath}/main" class="${pageContext.request.requestURI.contains('/main') ? 'active' : ''}">홈</a>
                </li>
                <li>
                    <a href="${contextPath}/mate" class="${pageContext.request.requestURI.contains('/mate') ? 'active' : ''}">메이트</a>
                </li>
                <li>
                    <a href="${contextPath}/festival" class="${pageContext.request.requestURI.contains('/festival') ? 'active' : ''}">축제정보</a>
                </li>
                <li>
                    <a href="${contextPath}/community" class="${pageContext.request.requestURI.contains('/community') ? 'active' : ''}">커뮤니티</a>
                </li>
            </ul>
        </nav>
    </div>
</header>