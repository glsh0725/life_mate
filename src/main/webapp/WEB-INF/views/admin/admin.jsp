<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
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

<script src="/js/jQuery-2.1.4.min.js"></script>

<body>
<main>
    <%-- 내용작성 --%>

    <div class="tabs">
        <!-- 탭 버튼 -->
        <button class="tablink" onclick="openTab(event, 'tab1')">회원 관리</button>
        <button class="tablink" onclick="openTab(event, 'tab2')">커뮤니티 관리</button>
    </div>

    <div id="tab1" class="tabcontent">

        <form name="search-form" autocomplete="off">
            <select id="search-type" name="type">
                <option selected value="">검색 내용 선택</option>
                <option value="id">아이디</option>
                <option value="nickname">닉네임</option>
            </select>
            <input type="text" id="search-user"/>
            <input type="button" onclick="getSearchList()" class="btn btn-outline-primary mr-2" value="검색"/>
        </form>

        <table id="usertable">
            <thead>
            <tr align="center">
                <td><b>아이디</b></td>
                <td><b>비밀번호</b></td>
                <td><b>닉네임</b></td>
                <td><b>이메일</b></td>
                <td><b>이메일 수신</b></td>
                <td><b>가입일</b></td>
                <td><b>삭제</b></td>
            </tr>
            </thead>

            <tbody><c:forEach var="user" items="${usersList}">
                <tr align="center">
                    <td>${user.usr_id}</td>
                    <td>${user.usr_password}</td>
                    <td>${user.usr_nickname}</td>
                    <td>${user.usr_email}</td>
                    <td>${user.usr_email_optout}</td>
                    <td>${user.usr_join_date}</td>
                    <td><a href="${contextPath}/admin/removeUser?id=${user.usr_id}"
                           onclick="return confirmDelete();" class="delete-link">삭제하기</a></td>
                </tr>
            </c:forEach>
            </tbody>

        </table>

         <div id="userPagination" class="pagination">
        <c:forEach var="i" begin="0" end="${totalPages - 1}" step="1">
            <a href="${pageContext.request.contextPath}/admin?page=${i}&size=10"> ${i + 1} </a>
        </c:forEach>
    </div>


    </div>


    <div id="tab2" class="tabcontent">


        <form name="search-form" autocomplete="off">
            <select id="search-type2" name="type">
                <option selected value="">검색 내용 선택</option>
                <option value="title">제목</option>
                <option value="nickname">닉네임</option>
            </select>
            <input type="text" id="search-community"/>
            <input type="button" onclick="getSearchList2()" class="btn btn-outline-primary mr-2" value="검색"/>
        </form>


        <table id=communitytable>
            <thead>
            <tr align="center">
                <td><b>번호</b></td>
                <td><b>제목</b></td>
                <td><b>닉네임</b></td>
                <td><b>신고 내역</b></td>
                <td><b>작성 날짜</b></td>
                <td><b>삭제</b></td>
            </tr>
            </thead>

            <c:forEach var="community" items="${communityList}">
                <tr align="center">
                    <td>${community.com_post_number}</td>
                    <td>${community.com_title}</td>
                    <td>${empty community.usr_nickname ? 'N/A' : community.usr_nickname}</td>
                    <td>${empty community.com_report_count ? 0 : community.com_report_count}건</td>
                    <td>${community.com_post_date}</td>
                    <td><a href="${contextPath}/admin/removeCommunity?number=${community.com_post_number}"
                           onclick="return confirmDelete();" class="delete-link">삭제하기</a></td>
                </tr>
            </c:forEach>
        </table>

        <div id="communityPagination" class="pagination">
        <c:forEach var="i" begin="0" end="${totalCommunityPages - 1}" step="1">
            <a href="${pageContext.request.contextPath}/admin?communityPage=${i}&communitySize=10"> ${i + 1} </a>
        </c:forEach>
    </div>
    </div>
</main>
<script src="${contextPath}/js/admin/admin.js"></script>
</body>
</html>