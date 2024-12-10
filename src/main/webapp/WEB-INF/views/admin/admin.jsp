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
    <title>관리자 페이지</title>
    <link rel="stylesheet" href="${contextPath}/css/admin/admin.css">
    <%@ include file="/WEB-INF/views/includes/header.jsp" %>
</head>
<body>
<main>
    <%-- 내용작성 --%>

    <div class="tabs">

        <button class="tablink" onclick="openTab(event, 'tab1')">회원 관리</button>
        <button class="tablink" onclick="openTab(event, 'tab2')">커뮤니티 관리</button>

        <div id="tab1" class="tabcontent">
            <table>
                <tr align="center">
                    <td><b>아이디</b></td>
                    <td><b>비밀번호</b></td>
                    <td><b>닉네임</b></td>
                    <td><b>이메일</b></td>
                    <td><b>이메일 수신</b></td>
                    <td><b>가입일</b></td>
                </tr>

                <c:forEach var="user" items="${usersList}">
                    <tr align="center">
                        <td>${user.usr_id}</td>
                        <td>${user.usr_password}</td>
                        <td>${user.usr_nickname}</td>
                        <td>${user.usr_email}</td>
                        <td>${user.usr_email_optout}</td>
                        <td>${user.usr_join_date}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>

        <div id="tab2" class="tabcontent">
            <table>
                <tr align="center">
                    <td><b>번호</b></td>
                    <td><b>제목</b></td>
                    <td><b>닉네임</b></td>
                    <%--<td><b>게시물 관리</b></td>--%>
                    <td><b>신고 내역</b></td>
                    <td><b>작성날짜</b></td>
                </tr>

                <c:forEach var="community" items="${communityList}">
                    <tr align="center">
                        <td>${community.com_post_number}</td>
                        <td>${community.com_title}</td>
                        <td>${community.usr_nickname}</td>
                            <%--<td>${}</td>--%>
                        <td>${community.com_report_count}</td>
                        <td>${community.com_post_date}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>


    </div>

</main>
<script src="${contextPath}/js/admin/admin.js"></script>
</body>
</html>