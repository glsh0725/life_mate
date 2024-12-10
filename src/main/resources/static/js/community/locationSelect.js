// 시/도와 시군구 데이터를 객체로 정의
const regions = {
    "서울": ["강남구", "강동구", "강북구", "관악구", "광진구", "구로구", "금천구", "노원구", "도봉구", "동대문구", "동작구", "마포구", "서대문구", "서초구", "성동구", "성북구", "송파구", "양천구", "영등포구", "용산구", "은평구", "종로구", "중구", "중랑구"],
    "부산": ["강서구", "금정구", "기장군", "남구", "동구", "동래구", "부산진구", "북구", "사상구", "사하구", "서구", "수영구", "연제구", "영도구", "중구", "해운대구"],
    "대구": ["남구", "달서구", "달성군", "동구", "북구", "수성구", "서구", "중구"],
    "인천": ["강화군", "계양구", "남동구", "동구", "미추홀구", "부평구", "서구", "연수구", "옹진군", "중구"],
    "광주": ["광산구", "남구", "동구", "북구", "서구"],
    "대전": ["대덕구", "동구", "서구", "유성구", "중구"],
    "울산": ["남구", "동구", "북구", "울주군", "중구"],
    "경기도": ["가평군", "고양시", "과천시", "광명시", "광주시", "구리시", "군포시", "김포시", "남양주시", "동두천시", "부천시", "성남시", "수원시", "시흥시", "안산시", "안성시", "안양시", "양주시", "양평군", "여주시", "오산시", "용인시", "의왕시", "의정부시", "이천시", "파주시", "평택시", "포천시", "하남시", "화성시"],
    "강원도": ["강릉시", "고성군", "동해시", "삼척시", "속초시", "양구군", "양양군", "영월군", "원주시", "인제군", "정선군", "춘천시", "태백시", "평창군", "홍천군", "화천군", "횡성군"],
    "충청북도": ["괴산군", "단양군", "보은군", "영동군", "옥천군", "음성군", "제천시", "청주시", "충주시"],
    "충청남도": ["계룡시", "공주시", "금산군", "논산시", "당진시", "보령시", "부여군", "서산시", "서천군", "아산시", "예산군", "천안시", "청양군", "태안군", "홍성군"],
    "경상북도": ["경산시", "경주시", "고령군", "구미시", "군위군", "기곡군", "김천시", "문경시", "봉화군", "상주시", "안동시", "영덕군", "영양군", "영주시", "예천군", "울릉군", "울진군", "의성군", "청도군", "칠곡군", "포항시"],
    "경상남도": ["거제시", "거창군", "고성군", "김해시", "남해군", "밀양시", "사천시", "산청군", "양산시", "의령군", "창녕군", "창원시", "통영시", "하동군", "함안군", "함양군", "합천군"],
    "전라북도": ["고창군", "군산시", "김제시", "남원시", "무주군", "부안군", "순창군", "완주군", "익산시", "임실군", "전주시", "정읍시", "진안군"],
    "전라남도": ["고흥군", "곡성군", "광양시", "구례군", "나주시", "담양군", "무안군", "보성군", "순천시", "신안군", "여수시", "영광군", "영암군", "완도군", "장성군", "장흥군", "진도군", "함평군", "해남군", "화순군"],
    "제주특별자치도": ["제주시", "서귀포시"]
};

// 페이지 로드 시 모달이 열리지 않도록 기본 상태를 설정
window.addEventListener('DOMContentLoaded', function() {
    document.getElementById('locationModal').style.display = 'none'; // 모달이 로드될 때 닫히도록 설정
});

// 시/도를 선택할 때 시군구를 업데이트
document.getElementById("stateSelect").addEventListener("change", function() {
    const state = this.value;
    const citySelect = document.getElementById("citySelect");
    citySelect.innerHTML = '<option value="">시군구를 선택하세요</option>'; // 기존 옵션 지우기

    if (state) {
        const cities = regions[state];
        cities.forEach(function(city) {
            const option = document.createElement("option");
            option.value = city;
            option.textContent = city;
            citySelect.appendChild(option);
        });
        citySelect.disabled = false; // 시군구 선택 활성화
    } else {
        citySelect.disabled = true; // 시군구 선택 비활성화
    }
});

// 선택 완료 버튼

document.getElementById("confirmLocation").addEventListener("click", function() {
    const state = document.getElementById("stateSelect").value;
    const city = document.getElementById("citySelect").value;

    console.log("선택된 시/도:", state);
    console.log("선택된 시군구:", city);

    // 선택된 지역을 화면에 표시
    if (state && city) {
        const com_location = document.getElementById("com_location");
        com_location.value = state + " " + city;  // 'value' 속성에 값을 설정하여 input에 반영
    } else {
        alert("시/도와 시군구를 모두 선택하세요.");
    }

    // 모달 창을 닫기
    document.getElementById("locationModal").style.display = "none";
});

// 모달 열기
document.getElementById('openLocationModal').addEventListener('click', function() {
    document.getElementById('locationModal').style.display = 'flex'; // 모달 창 열기
});

// 모달 닫기
document.getElementById('closeModal').addEventListener('click', function() {
    document.getElementById('locationModal').style.display = 'none'; // 모달 창 닫기
});

// 모달 외부 클릭 시 모달 닫기
window.addEventListener('click', function(event) {
    if (event.target === document.getElementById('locationModal')) {
        document.getElementById('locationModal').style.display = 'none';
    }
});