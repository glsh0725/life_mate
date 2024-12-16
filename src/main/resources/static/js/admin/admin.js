document.addEventListener("DOMContentLoaded", function () {
    const urlParams = new URLSearchParams(window.location.search);
    const communityPage = urlParams.get('communityPage');

    if (communityPage) {
        openTab(null, 'tab2');
        loadCommunityPage(communityPage - 1);
    } else {
        openTab(null, 'tab1');
        const firstTabLink = document.getElementsByClassName("tablink")[0];
        if (firstTabLink) {
            firstTabLink.classList.add("active");
        }
    }
});

function openTab(evt, tabName) {
    var i, tabcontent, tablinks;

    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }

    tablinks = document.getElementsByClassName("tablink");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }

    document.getElementById(tabName).style.display = "block";
    if (evt) evt.currentTarget.className += " active";

    if (tabName === 'tab1') {
        loadUserPage(0);
    } else if (tabName === 'tab2') {
        loadCommunityPage(0);
    }
}

function loadUserPage(page) {
    currentUserPage = page;
    $.get(`${contextPath}/admin`, { userPage: page, userSize: 10 })
        .done(function (data) {
            $('#usertable tbody').html(data.usersListHTML);
            generatePagination(currentUserPage, data.totalPages, 'user');
        });
}

function loadCommunityPage(page) {
    currentCommunityPage = page;
    $.get(`${contextPath}/admin`, { communityPage: page, communitySize: 10 })
        .done(function (data) {
            $('#communitytable tbody').html(data.communityListHTML);
            generatePagination(currentCommunityPage, data.totalPages, 'community');
        });
}

function generatePagination(currentPage, totalPages, type) {
    let pagination = '';
    for (let i = 0; i < totalPages; i++) {
        if (i === currentPage) {
            pagination += `<a href="javascript:void(0);" class="active">${i + 1}</a> `;
        } else {
            pagination += `<a href="javascript:void(0);" onclick="load${type.charAt(0).toUpperCase() + type.slice(1)}Page(${i})">${i + 1}</a> `;
        }
    }

    if (type === 'user') {
        $('#userPagination').html(pagination);
    } else if (type === 'community') {
        $('#communityPagination').html(pagination);
    }
}

$(document).on('click', '.pagination-link', function(event) {
    event.preventDefault();
    const targetPage = $(this).data('page');
    loadCommunityPage(targetPage);
});

function confirmDelete() {
    return confirm("정말로 삭제하시겠습니까?");
}

$(document).on("click", ".delete-link", function (e) {
    e.preventDefault();

    const deleteType = $(this).data("id") ? "user" : "community";
    const identifier = deleteType === "user" ? $(this).data("id") : $(this).data("number");
    const url = deleteType === "user" ? "/admin/removeUser" : "/admin/removeCommunity";

    if (confirmDelete()) {
        $.ajax({
            type: "GET",
            url: url,
            data: deleteType === "user" ? {id: identifier} : {number: identifier},
            success: function () {
                deleteType === "user" ? getSearchList() : getSearchList2();
            },
            error: function () {
                alert("삭제에 실패했습니다.");
            },
            complete: function () {
                $(this).prop("disabled", false).text("삭제하기");
            }
        });
    }
});

function getSearchList() {
    event.preventDefault();

    $.ajax({
        type: "GET",
        url: "/admin/userlist",
        contentType: "application/json; charset=UTF-8",
        success: function (data) {
            var searchType = $("#search-type").val();
            var searchKeyword = $("#search-user").val();

            if (searchKeyword) {
                if (searchType === "id") {
                    data = data.filter(user => user.usr_id.includes(searchKeyword));
                } else if (searchType === "nickname") {
                    data = data.filter(user => user.usr_nickname.includes(searchKeyword));
                }
            }

            if (data.length === 0) {
                let message = searchType === "id"
                    ? "해당 아이디가 존재하지 않습니다."
                    : "해당 닉네임이 존재하지 않습니다.";

                $("#usertable").empty();
                let noDataMessage = `
                    <tr>
                        <td colspan="6" align="center">${message}</td>
                    </tr>
                `;
                $("#usertable").html(noDataMessage);
                return;
            }

            $("#usertable").empty();

            let tablelist = `
            <table>
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
                <tbody>
            `;

            data.forEach(user => {
                tablelist += `
                <tr align="center">
                        <td>${user.usr_id}</td>
                        <td>${user.usr_password}</td>
                        <td>${user.usr_nickname}</td>
                        <td>${user.usr_email}</td>
                        <td>${user.usr_email_optout}</td>
                        <td>${user.usr_join_date}</td>
                        <td>
                        <a href="#" class="delete-link" data-id="${user.usr_id}">삭제하기</a>
                        </td>
                    </tr>
                `;
            });

            tablelist += `</tbody></table>`;

            $("#usertable").html(tablelist);
        },
        error: function (xhr, status, error) {
            alert("user :" + xhr.status + "\n"
                + "message" + xhr.responseText + "\n"
                + "error: " + error);
        }
    });
}

function getSearchList2() {
    event.preventDefault();

    $.ajax({
        type: "GET",
        url: "/admin/communitylist",
        contentType: "application/json; charset=UTF-8",
        success: function (data) {
            var searchType = $("#search-type2").val();
            var searchKeyword = $("#search-community").val();

            if (searchKeyword) {
                if (searchType === "title") {
                    data = data.filter(item => item.com_title && item.com_title.includes(searchKeyword));
                } else if (searchType === "nickname") {
                    data = data.filter(item => item.usr_nickname && item.usr_nickname.includes(searchKeyword));
                }
            }

            if (data.length === 0) {
                let message = searchType === "title"
                    ? "해당 게시글이 존재하지 않습니다."
                    : "해당 아이디가 존재하지 않습니다.";

                $("#communitytable").empty();
                let noDataMessage = `
                    <tr>
                        <td colspan="6" align="center">${message}</td>
                    </tr>
                `;
                $("#communitytable").html(noDataMessage);
                return;
            }

            $("#communitytable").empty();

            let tablelist = `
            
            <table>
            <tr align="center">
                        <td><b>번호</b></td>
                        <td><b>제목</b></td>
                        <td><b>닉네임</b></td>
                        <td><b>신고 내역</b></td>
                        <td><b>작성 날짜</b></td>
                        <td><b>삭제</b></td>
                    </tr>
            `;

            data.forEach(community => {
                const formattedDate = community.com_post_date
                    ? formatDate(community.com_post_date)
                    : "N/A";

                tablelist += `
                <tr align="center">
                            <td>${community.com_post_number || "N/A"}</td>
                            <td>${community.com_title || "N/A"}</td>
                            <td>${community.usr_nickname || "N/A"}</td>
                            <td>${community.com_report_count || 0}건</td>
                            <td>${community.com_post_date || "N/A"}</td>
                            <td>
                                <a href="#" class="delete-link" data-number="${community.com_post_number}">삭제하기</a>
                            </td>
                        </tr>
                `;
            });

            tablelist += `</table>`;

            $("#communitytable").html(tablelist);
        },
        error: function (xhr, status, error) {
            alert("community: " + xhr.status + "\n"
                + "message " + xhr.responseText + "\n"
                + "error: " + error);
        }
    });

    function formatDate(dateString) {
        const date = new Date(dateString);
        const year = String(date.getFullYear()).slice(-2);
        const month = String(date.getMonth() + 1).padStart(2, '0');
        const day = String(date.getDate()).padStart(2, '0');
        return `${year}-${month}-${day}`;
    }
}