<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<%
  request.setCharacterEncoding("UTF-8");
%>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>커뮤니티 글보기</title>
    <link rel="stylesheet" href="${contextPath}/static/css/community/communityview.css">
    <%@ include file="/WEB-INF/views/includes/header.jsp" %>
</head>
<body>
    <main>
        <!-- 게시물 정보 -->
        <div class="post-container">
            <div class="post-header">
                <table>
                    <tr>
                        <th>제목</th>
                        <td>${post.title}</td>
                    </tr>
                    <tr>
                        <th>닉네임</th>
                        <td>${post.nickname}</td>
                        <th>작성날짜</th>
                        <td>${post.date}</td>
                        <th>조회수</th>
                        <td>${post.viewCount}</td>
                    </tr>
                </table>
            </div>

            <!-- 게시물 내용 -->
            <div class="post-content">
                <textarea readonly>${post.content}</textarea>
            </div>

            <!-- 좋아요 및 댓글 정보 -->
            <div class="post-interactions">
                <span class="like-icon">❤️ 좋아요 ${post.likes}</span>
                <span class="comment-icon">💬 댓글 ${post.comments.size()}</span>
            </div>

            <!-- 댓글 목록 -->
            <div class="comments-section">
                <c:forEach var="comment" items="${post.comments}">
                    <div class="comment">
                        <strong>${comment.nickname}</strong>
                        <p>${comment.content}</p>
                        <button class="report-btn">신고</button>
                    </div>
                </c:forEach>
            </div>

            <!-- 댓글 입력 -->
            <div class="comment-input">
                <textarea placeholder="댓글을 남겨보세요."></textarea>
                <button class="register-btn">등록</button>
            </div>

            <!-- 게시물 관리 버튼 -->
            <div class="post-buttons">
                <button class="modify-btn" onclick="location.href='editPost.jsp?id=${post.id}'">수정</button>
                <button class="list-btn" onclick="location.href='postList.jsp'">목록</button>
                <button class="delete-btn" onclick="deletePost(${post.id})">삭제</button>
            </div>
        </div>
    </main>
    <script>
        // 삭제 기능 스크립트
        function deletePost(postId) {
            if (confirm("게시물을 삭제하시겠습니까?")) {
                location.href = `${contextPath}/deletePost.do?id=${postId}`;
            }
        }
    </script>
</body>
</html>
