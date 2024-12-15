<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<%
  request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>글쓰기</title>
    <link rel="stylesheet" href="${contextPath}/css/community/communitywrite.css">
    <link rel="stylesheet" href="${contextPath}/css/community/locationSelect.css">
    <%@ include file="/WEB-INF/views/includes/header.jsp" %>
</head>
<body>
    <main class="write-form-main">
    <br>
    <div class="write-form-container">
        <form action="${contextPath}/community/save" method="post" enctype="multipart/form-data">

            <div class="form-group">
                <label for="com_title">제목</label>
                <input type="text" id="com_title" name="com_title" placeholder="제목을 입력하세요" required>
            </div>

            <!-- 지역 선택 -->
            <div class="form-group">
                <label for="com_location">지역</label>
                <input type="text" id="com_location" name="com_location" placeholder="지역을 선택하세요" readonly required>
                <button type="button" id="openLocationModal">지역 선택</button>
            </div>

            <div class="form-group">
                <label for="com_duration">여행 태그</label>
                <select name="com_duration" id="com_duration" required>
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
                <label for="com_content">본문 내용</label>
                <textarea id="com_content" name="com_content" rows="8" placeholder="본문 내용을 입력하세요" required></textarea>
            </div>

            <div class="form-buttons">
                <button type="submit">작성 완료</button>
                <button type="button" onclick="history.back()">취소</button>
            </div>
        </form>
    </div>

    <!-- 지역 선택 모달창 -->
    <div id="locationModal" class="modal">
        <div class="modal-content">
            <span class="close-button" id="closeModal">X</span>

            <div class="location-selector">
                <div class="section-title">지역 선택</div>
                <select id="stateSelect" required>
                    <option value="">시/도를 선택하세요</option>
                    <option value="서울">서울</option>
                    <option value="부산">부산</option>
                    <option value="대구">대구</option>
                    <option value="인천">인천</option>
                    <option value="광주">광주</option>
                    <option value="대전">대전</option>
                    <option value="울산">울산</option>
                    <option value="경기도">경기도</option>
                    <option value="강원도">강원도</option>
                    <option value="충청북도">충청북도</option>
                    <option value="충청남도">충청남도</option>
                    <option value="경상북도">경상북도</option>
                    <option value="경상남도">경상남도</option>
                    <option value="전라북도">전라북도</option>
                    <option value="전라남도">전라남도</option>
                    <option value="제주특별자치도">제주특별자치도</option>
                </select>

                <select id="citySelect" required disabled>
                    <option value="">시군구를 선택하세요</option>
                </select>
            </div>

            <button id="confirmLocation">선택 완료</button>
        </div>
    </div>

    <script src="${contextPath}/js/community/locationSelect.js"></script>
    </main>
</body>
</html>
