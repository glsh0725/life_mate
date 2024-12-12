function deletePost(postId) {
    if (confirm("게시물을 삭제하시겠습니까?")) {
        location.href = `${contextPath}/deletePost.do?id=${postId}`;
    }
}