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
    <link rel="stylesheet" href="${contextPath}/css/mate/mate.css">
    <%@ include file="/WEB-INF/views/includes/header.jsp" %>
</head>
<body>
<main>
    <%-- 내용작성 --%>
</main>
</body>
<script src="${contextPath}/js/mate/mate.js"></script>
</html>