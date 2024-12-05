document.addEventListener("DOMContentLoaded", function () {
    const calendar = document.getElementById("calendar");
    const yearSelect = document.getElementById("year-select");
    const monthSelect = document.getElementById("month-select");
    const prevMonthButton = document.createElement("button");
    const nextMonthButton = document.createElement("button");

    prevMonthButton.textContent = "이전 달";
    nextMonthButton.textContent = "다음 달";

    const calendarControls = document.querySelector(".calendar-controls");
    calendarControls.appendChild(prevMonthButton);
    calendarControls.appendChild(nextMonthButton);

    function populateYearAndMonth() {
        const currentYear = new Date().getFullYear();
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
        monthSelect.value = new Date().getMonth();
    }

    function generateCalendar(year, month) {
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
        let rowCreated = false;

        for (let i = 0; i < 6; i++) {
            let rowHtml = "<tr>";
            let cellsCreated = false;
            for (let j = 0; j < 7; j++) {
                if (i === 0 && j < firstDay || day > daysInMonth) {
                    rowHtml += "<td></td>";
                } else {
                    rowHtml += `<td class="calendar-day" data-date="${year}-${month + 1}-${day}">${day}</td>`;
                    day++;
                    cellsCreated = true;
                }
            }
            rowHtml += "</tr>";
            if (cellsCreated) {
                html += rowHtml;
                rowCreated = true;
            }
        }
        html += "</tbody></table>";

        if (rowCreated) {
            calendar.innerHTML = html;
        }

        const days = document.querySelectorAll(".calendar-day");
        days.forEach(day => {
            day.addEventListener("click", function () {
                const selectedDate = this.dataset.date;
                fetchFestivalsByDate(selectedDate);
            });
        });
    }

    function fetchFestivalsByDate(date) {
        window.location.href = `${contextPath}/festival?date=${date}`;
    }

    yearSelect.addEventListener("change", function () {
        generateCalendar(Number(yearSelect.value), Number(monthSelect.value));
    });

    monthSelect.addEventListener("change", function () {
        generateCalendar(Number(yearSelect.value), Number(monthSelect.value));
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
        generateCalendar(currentYear, currentMonth);
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
        generateCalendar(currentYear, currentMonth);
    });

    populateYearAndMonth();
    const today = new Date();
    generateCalendar(today.getFullYear(), today.getMonth());
});