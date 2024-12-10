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
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>커뮤니티</title>
    <link rel="stylesheet" href="${contextPath}/css/community/community.css">
    <%@ include file="/WEB-INF/views/includes/header.jsp" %>
</head>
<body>
    <main>
    <div class="board-container">

     <form action="${pageContext.request.contextPath}/community" method="get" id="adminForm">
        <c:forEach var="post" items="${postsList}">
            <div class="board-card">
                <div class="image-placeholder">이미지</div>
                <div class="tag">${post.com_post_number}</div>
                <div class="content">
                    <h3 class="title">${post.com_title}</h3>
                    <p class="location">${post.com_location}</p>
                    <p class="author">닉네임 | ${post.usr_nickname}</p>
                    <p class="date">작성날짜: ${post.com_post_date}</p>
                    <div class="stats">
                        ❤️ ${post.com_like_count} | 💬 ${post.com_comment_count} | 👀 ${post.com_view_count}
                    </div>
                </div>
            </div>
        </c:forEach>
        </form>
    </div>

    <%-- 페이지네이션 값 계산 --%>
        <c:set var="postsPerPage" value="8" />
        <c:set var="totalPosts" value="${totalPosts}" />
        <c:set var="currentPage" value="${param.page != null ? param.page : 1}" />
        <c:set var="totalPages" value="${(totalPosts + postsPerPage - 1) / postsPerPage}" />
        <c:set var="prevPage" value="${currentPage > 1 ? currentPage - 1 : 1}" />
        <c:set var="nextPage" value="${currentPage < totalPages ? currentPage + 1 : totalPages}" />

    <%-- 페이지네이션 --%>
    <div class="pagination">
        <button onclick="location.href='boardList.jsp?page=${prevPage}'">이전</button>
        <c:forEach var="page" items="${pages}">
            <button class="${page == currentPage ? 'active' : ''}"
                    onclick="location.href='boardList.jsp?page=${page}'">${page}</button>
        </c:forEach>
        <button onclick="location.href='boardList.jsp?page=${nextPage}'">다음</button>
    </div>

    <%-- 검색 및 글쓰기 --%>
    <div class="controls">
        <select name="sort" id="sort">
            <option value="title">제목</option>
            <option value="date">작성일</option>
            <option value="views">조회수</option>
        </select>
        <input type="text" id="search" placeholder="검색어를 입력하세요">
        <button onclick="searchPosts()">검색</button>
        <button onclick="location.href='communitywrite'">글쓰기</button>
    </div>
    </main>
</body>
</html>