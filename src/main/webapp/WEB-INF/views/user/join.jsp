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
    <meta charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
    <link rel="stylesheet" href="${contextPath}/css/user/join.css">
    <%@ include file="/WEB-INF/views/includes/header.jsp" %>
</head>
<body>
    <main>
        <div class="join-container">
            <h1>회원가입</h1>
            <form action="${pageContext.request.contextPath}/join" method="post" id="joinForm">
                <div class="form-group-userId">
                    <label for="usr_id">아이디</label>
                    <input type="text" id="usr_id" name="usr_id" required minlength="6" maxlength="12">
                </div>

                <div class="form-group-password">
                    <label for="usr_password">비밀번호</label>
                    <input type="password" id="usr_password" name="usr_password" required minlength="8" maxlength="16">
                </div>

                <div class="form-group-confirmPassword">
                    <label for="confirmPassword">비밀번호 확인</label>
                    <input type="password" id="confirmPassword" name="confirmPassword" required minlength="8" maxlength="16">
                </div>

                <div class="form-group-nickname">
                    <label for="usr_nickname">닉네임</label>
                    <input type="text" id="usr_nickname" name="usr_nickname" required minlength="1" maxlength="8">
                </div>

                <div class="form-group-email">
                    <label for="usr_email">이메일</label>
                    <input type="email" id="usr_email" name="usr_email" required>
                </div>

                <div class="form-group-emailOptOut">
                    <label>이메일 수신 여부</label>
                    <input type="radio" id="emailAgree" name="usr_email_optout" value="Y" checked>
                    <label for="emailAgree">동의</label>
                    <input type="radio" id="emailDisagree" name="usr_email_optout" value="N">
                    <label for="emailDisagree">거부</label>
                </div>

                <div class="form-group-termsAgree">
                    <input type="checkbox" id="termsAgree" name="termsAgree" required>
                    <label for="termsAgree">이용약관 및 개인정보 취급방침에 동의합니다.</label>
                </div>

                <div id="termsAgree-modal" class="termsModal">
                            <div class="terms_popup">
                                <span class="close-btn">&times;</span>
                                <textarea>
                                [HUMAN HEALTH] 이용약관

                                제1조(목적)
                                이 약관은 [HUMAN HEALTH] (이하 "회사")이 제공하는 모든 서비스(이하 "서비스")의 이용 조건 및 절차, 회원과 회사의 권리, 의무 및 책임사항을 규정함을 목적으로 합니다.

                                제2조(용어의 정의)
                                1. "서비스"란 회사가 제공하는 모든 온라인 서비스 및 기능을 말합니다.
                                2. "회원"이란 회사의 서비스에 접속하여 이 약관에 따라 회사와 이용계약을 체결하고 서비스를 이용하는 이용자를 말합니다.
                                3. "아이디(ID)"란 회원의 식별과 서비스 이용을 위하여 회원이 설정하고 회사가 승인한 이메일 주소 또는 문자와 숫자의 조합을 말합니다.
                                4. "비밀번호"란 회원이 설정한 아이디와 일치하는지 확인하고 회원의 비밀 보호를 위해 설정한 문자와 숫자의 조합을 말합니다.

                                제3조(약관의 효력 및 변경)
                                1. 이 약관은 회원이 회원가입 시 동의함으로써 효력이 발생합니다.
                                2. 회사는 필요한 경우 약관을 변경할 수 있으며, 변경된 약관은 서비스 내 공지하거나 회원의 이메일로 고지합니다.
                                3. 회원은 변경된 약관에 동의하지 않을 권리가 있으며, 변경된 약관에 동의하지 않을 경우 회원 탈퇴를 요청할 수 있습니다.

                                제4조(회원가입 및 이용계약 체결)
                                1. 회원가입은 이용자가 약관에 동의하고 회사가 정한 가입 양식에 따라 정보를 기입하여 가입 신청을 할시 성립됩니다.
                                2. 회사는 아래 각 호에 해당하는 경우 회원가입을 거부할 수 있습니다.
                                    1. 등록 내용에 허위, 오기가 있는 경우
                                    2. 기타 회원으로 등록하는 것이 회사의 기술상 현저히 지장이 있다고 판단되는 경우

                                제5조(회원의 의무)
                                1. 회원은 서비스 이용 시 법령, 약관, 공지사항 및 회사가 통지하는 사항을 준수해야 합니다.
                                2. 회원은 타인의 개인정보를 침해하거나 도용해서는 안 됩니다.
                                3. 회원은 회사의 명시적 동의 없이 서비스를 영리 목적으로 사용할 수 없습니다.

                                제6조(서비스 제공 및 중단)
                                1. 회사는 회원에게 아래와 같은 서비스를 제공합니다.
                                    1. 사용자 건강 관리
                                        • 회원의 신체 정보를 입력하여 건강 상태를 분석하고, 목표 설정 및 현재 상태를 비교하여 시각적으로 제공하는 기능
                                        • 체중, 체지방률, 골격근량 등 주요 건강 지표를 관리하고 기록할 수 있는 기능
                                    2. 활동 관리
                                        • 사용자가 운동 및 활동 데이터를 입력하여 일일 활동량과 대사량을 기록하고 관리할 수 있는 기능
                                        • 활동 템플릿을 사용하여 다양한 운동의 시간과 강도를 기록하는 기능 제공
                                    3. 식단 관리
                                        • 회원의 식단 정보를 입력하여 일일 칼로리, 탄수화물, 단백질, 지방 섭취량을 계산하고 기록할 수 있는 기능
                                        • 권장 칼로리와 단백질 섭취량에 대한 정보 제공 및 식사 기록을 바탕으로 한 시각적 분석 기능
                                    4. 건강 정보 제공
                                        • 스트레스 지수, 수면 시간 기록 등을 바탕으로 추천 건강 정보를 제공
                                        • 스트레칭 및 운동 관련 동영상 추천 기능 제공
                                    5. 커뮤니티 기능
                                        • 사용자들 간의 정보 공유 및 소통을 위한 커뮤니티 게시판 제공
                                        • 사용자가 글을 작성할 수 있는 기능, 특정 제목, 닉네임에 대한 검색 기능
                                    6. Q&A 게시판
                                        • 홈페이지 이용관련 질문을 등록하고 관리자가 답변을 달 수 있는 기능
                                2. 회사는 시스템 유지보수, 기술적 문제, 또는 기타 불가피한 사유가 있는 경우 서비스 제공을 일시적으로 중단할 수 있으며, 이에 대해 사전에 통지합니다.

                                제7조(계약 해지 및 회원 탈퇴)
                                1. 회원은 언제든지 서비스 내 회원 탈퇴 절차를 통해 이용계약을 해지할 수 있습니다.
                                2. 회사는 회원이 약관을 위반하거나 관련 법령을 위반한 경우 이용계약을 해지할 수 있습니다.

                                제8조(개인정보의 보호)
                                회사는 관련 법령이 정하는 바에 따라 회원의 개인정보를 보호하며, 개인정보의 보호 및 사용에 대해서는 별도의 "개인정보 처리방침"에 따릅니다.

                                제9조(책임 제한)
                                1. 회사는 천재지변, 전쟁, 테러, 자연재해 등 불가항력적인 사유로 인한 서비스 중단에 대하여 책임을 지지 않습니다.
                                2. 회사는 회원의 귀책 사유로 인한 서비스 이용의 장애에 대하여 책임을 지지 않습니다.

                                제10조(분쟁 해결)
                                이 약관에서 발생한 분쟁에 대하여 회사와 회원 간에 성실히 협의하되, 협의가 이루어지지 않을 경우 관련 법령에 따라 관할 법원에 소를 제기할 수 있습니다.

                                부칙
                                이 약관은 2024년 10월 18일부터 시행됩니다.
                                </textarea>

                            </div>
                        </div>

                <div class="form-group-join">
                    <button type="submit">회원가입</button>
                </div>
            </form>
        </div>
        <script src="${contextPath}/js/user/join.js"></script>
    </main>
</body>
</html>