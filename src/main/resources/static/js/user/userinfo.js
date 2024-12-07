function confirmDelete() {
    if (confirm("정말로 회원탈퇴를 진행하시겠습니까?")) {
        location.href = "${contextPath}/deleteAccount";
    }
}