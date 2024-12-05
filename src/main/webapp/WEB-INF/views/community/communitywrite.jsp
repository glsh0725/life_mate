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
    <title>글쓰기</title>
    <link rel="stylesheet" href="${contextPath}/css/community/communitywrite.css">
    <%@ include file="/WEB-INF/views/includes/header.jsp" %>
</head>
<body>
    <main class="write-form-main">
    <br>
    <div class="write-form-container">
        <form action="${contextPath}/community/save" method="post" enctype="multipart/form-data">

            <div class="form-group">
                <label for="title">제목</label>
                <input type="text" id="title" name="title" placeholder="제목을 입력하세요" required>
            </div>



            <div class="form-group">
                <label for="thumbnail">대표이미지</label>
                <input type="file" id="thumbnailimage" name="thumbnailimage" accept="image/*">
             </div>

            <div class="form-group">
                <label for="location">지역</label>
                <input type="text" id="location" name="location" placeholder="지역을 입력하세요 (예: 전라남도 순천시)" required>
            </div>
            <div class="form-group">
                <label for="tag">여행 태그</label>
                <select name="tag" id="tag" required>
                <option value="당일여행">당일여행</option>
                <option value="1박2일">1박2일</option>
                <option value="2박3일">2박3일</option>
                <option value="3박4일">3박4일</option>
                <option value="단거리여행">단거리여행</option>
                <option value="장거리여행">장거리여행</option>
                </select>
            </div>

            <div class="form-group">
                <label for="image">이미지 첨부</label>
                <input type="file" id="image" name="image" accept="image/*">
            </div>

            <div class="form-group">
                <label for="video">동영상 첨부</label>
                <input type="file" id="video" name="video" accept="video/*">
            </div>

            <div class="form-group">
                <label for="content">본문 내용</label>
                <textarea id="content" name="content" rows="8" placeholder="본문 내용을 입력하세요" required></textarea>
            </div>

            <div class="form-group">
                <label for="date">작성 날짜</label>
                <input type="date" id="date" name="date" value="<%= new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()) %>" readonly>
            </div>

            <div class="form-buttons">
                <button type="submit">작성 완료</button>
                <button type="button" onclick="history.back()">취소</button>
            </div>
        </form>
    </div>
    </main>
</body>
</html>
