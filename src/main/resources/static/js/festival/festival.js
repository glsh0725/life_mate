document.addEventListener("DOMContentLoaded", function () {
    const calendar = document.getElementById("calendar");
    const yearSelect = document.getElementById("year-select");
    const monthSelect = document.getElementById("month-select");
    const prevMonthButton = document.createElement("button");
    const nextMonthButton = document.createElement("button");
    const selectedDateInput = document.getElementById("selected-date");

    const modal = document.getElementById("festival-modal");
    const closeModalButton = modal.querySelector(".close-btn");

    const modalTitle = document.getElementById("modal-title");
    const modalOpar = document.getElementById("modal-opar");
    const modalStartDate = document.getElementById("modal-start-date");
    const modalEndDate = document.getElementById("modal-end-date");
    const modalDescription = document.getElementById("modal-description");
    const modalMnnstNm = document.getElementById("modal-mnnstNm");
    const modalAuspcInsttNm = document.getElementById("modal-auspcInsttNm");
    const modalSuprtInsttNm = document.getElementById("modal-suprtInsttNm");
    const modalPhoneNumber = document.getElementById("modal-phoneNumber");
    const modalHomepage = document.getElementById("modal-homepage");
    const modalRelateInfo = document.getElementById("modal-relateInfo");
    const modalRdnmadr = document.getElementById("modal-rdnmadr");
    const modalLnmadr = document.getElementById("modal-lnmadr");
    const modalReferenceDate = document.getElementById("modal-referenceDate");

    prevMonthButton.textContent = "이전 달";
    nextMonthButton.textContent = "다음 달";

    const calendarControls = document.querySelector(".calendar-controls");
    calendarControls.appendChild(prevMonthButton);
    calendarControls.appendChild(nextMonthButton);

    function populateYearAndMonth(selectedDate) {
        const currentYear = new Date(selectedDate).getFullYear();
        const currentMonth = new Date(selectedDate).getMonth();

        for (let i = currentYear - 5; i <= currentYear + 5; i++) {
            const option = document.createElement("option");
            option.value = i;
            option.textContent = i;
            yearSelect.appendChild(option);
        }
        yearSelect.value = currentYear;

        for (let i = 0; i < 12; i++) {
            const option = document.createElement("option");
            option.value = i;
            option.textContent = i + 1;
            monthSelect.appendChild(option);
        }
        monthSelect.value = currentMonth;
    }

    function generateCalendar(year, month, selectedDate) {
        const daysInMonth = new Date(year, month + 1, 0).getDate();
        const firstDay = new Date(year, month, 1).getDay();

        let html = `<table>
            <thead>
                <tr>
                    <th>일</th>
                    <th>월</th>
                    <th>화</th>
                    <th>수</th>
                    <th>목</th>
                    <th>금</th>
                    <th>토</th>
                </tr>
            </thead>
            <tbody>`;

        let day = 1;
        let hasContent = false;

        for (let i = 0; i < 6; i++) {
            let rowHtml = "<tr>";
            hasContent = false;

            for (let j = 0; j < 7; j++) {
                const currentDate = `${year}-${String(month + 1).padStart(2, '0')}-${String(day).padStart(2, '0')}`;

                if (i === 0 && j < firstDay || day > daysInMonth) {
                    rowHtml += "<td></td>";
                } else {
                    const isSelected = selectedDate === currentDate ? "selected" : "";
                    rowHtml += `<td class="calendar-day ${isSelected}" data-date="${currentDate}">${day}</td>`;
                    day++;
                    hasContent = true;
                }
            }

            rowHtml += "</tr>";
            if (hasContent) {
                html += rowHtml;
            }
        }
        html += "</tbody></table>";
        calendar.innerHTML = html;

        document.querySelectorAll(".calendar-day").forEach(day => {
            day.addEventListener("click", function () {
                const selectedDate = this.dataset.date;
                selectedDateInput.value = selectedDate;
                fetchFestivalsByDate(selectedDate);
            });
        });
    }

    function fetchFestivalsByDate(date) {
        const url = `${contextPath}/festival?date=${date}`;
        window.location.href = url;
    }

    yearSelect.addEventListener("change", function () {
        generateCalendar(Number(yearSelect.value), Number(monthSelect.value), selectedDateInput.value);
    });

    monthSelect.addEventListener("change", function () {
        generateCalendar(Number(yearSelect.value), Number(monthSelect.value), selectedDateInput.value);
    });

    prevMonthButton.addEventListener("click", function () {
        let currentMonth = Number(monthSelect.value);
        let currentYear = Number(yearSelect.value);

        if (currentMonth === 0) {
            currentMonth = 11;
            currentYear--;
        } else {
            currentMonth--;
        }

        monthSelect.value = currentMonth;
        yearSelect.value = currentYear;
        generateCalendar(currentYear, currentMonth, selectedDateInput.value);
    });

    nextMonthButton.addEventListener("click", function () {
        let currentMonth = Number(monthSelect.value);
        let currentYear = Number(yearSelect.value);

        if (currentMonth === 11) {
            currentMonth = 0;
            currentYear++;
        } else {
            currentMonth++;
        }

        monthSelect.value = currentMonth;
        yearSelect.value = currentYear;
        generateCalendar(currentYear, currentMonth, selectedDateInput.value);
    });

    const today = new Date(selectedDateInput.value || new Date());
    populateYearAndMonth(today);
    generateCalendar(today.getFullYear(), today.getMonth(), selectedDateInput.value);

    document.querySelectorAll(".festival-item").forEach(item => {
        const festivalTitle = item.querySelector(".festival-title").textContent.trim();
        const imageName = `${festivalTitle}.jpg`;
        const imageUrl = `/images/festival/${imageName}`;

        const imgElement = document.createElement("img");
        imgElement.src = imageUrl;
        imgElement.alt = festivalTitle;

        imgElement.onerror = function () {
            imgElement.src = "/images/festival/default.jpg";
        };

        const imageContainer = document.createElement("div");
        imageContainer.className = "festival-image";
        imageContainer.appendChild(imgElement);
        item.prepend(imageContainer);
    });

    document.querySelectorAll(".festival-item").forEach((item, index) => {
        item.addEventListener("click", function () {
            const festival = window.festivalData[index];

            modalTitle.textContent = festival.fstvlNm;
            modalOpar.textContent = festival.opar || "N/A";
            modalStartDate.textContent = festival.fstvlStartDate;
            modalEndDate.textContent = festival.fstvlEndDate;
            modalDescription.textContent = festival.fstvlCo || "N/A";
            modalMnnstNm.textContent = festival.mnnstNm || "N/A";
            modalAuspcInsttNm.textContent = festival.auspcInsttNm || "N/A";
            modalSuprtInsttNm.textContent = festival.suprtInsttNm || "N/A";
            modalPhoneNumber.textContent = festival.phoneNumber || "N/A";
            modalHomepage.textContent = festival.homepageUrl || "N/A";
            modalHomepage.href = festival.homepageUrl || "#";
            modalRelateInfo.textContent = festival.relateInfo || "N/A";
            modalRdnmadr.textContent = festival.rdnmadr || "N/A";
            modalLnmadr.textContent = festival.lnmadr || "N/A";
            modalReferenceDate.textContent = festival.referenceDate || "N/A";

            modal.style.display = "block";
        });
    });

    closeModalButton.addEventListener("click", function () {
        modal.style.display = "none";
    });

    window.addEventListener("click", function (event) {
        if (event.target === modal) {
            modal.style.display = "none";
        }
    });
});