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
        <%-- 예제 데이터 --%>
        <c:forEach var="post" items="${postList}">
            <div class="board-card">
                <div class="image-placeholder">이미지</div>
                <div class="tag">${post.tag}</div>
                <div class="content">
                    <h3 class="title">${post.title}</h3>
                    <p class="location">${post.location}</p>
                    <p class="author">닉네임 | ${post.author}</p>
                    <p class="date">작성날짜: ${post.date}</p>
                    <div class="stats">
                        ❤️ ${post.likes} | 💬 ${post.comments} | 👀 ${post.views}
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>

    <%-- 페이징 --%>
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