package fs.four.dropout.mate.vo;

import org.springframework.stereotype.Component;

@Component("mateVO")
public class MateVO {

    private char familyToilet;      // 가족 화장실 보유 여부
    private String bulidingNm;      // 건물 번호
    private Number longitude;       // 경도
    private String roadName;        // 도로명 이름
    private String roadNameAddress; // 도로명 주소
    private String riName;          // 리 명칭
    private char freeParking;       // 무료주차 가능여부
    private String address;         // 번지
    private String legaldong;       // 법정읍면동명칭
    private String branchName;      // 분점명
    private String blogUrl;         // 블로그 주소
    private char nursingRoom;       // 수유실 보유여부
    private String cityDistrict;    // 시군구 명칭
    private String city;            // 시도 명칭
    private String facilityName;    // 시설명
    private String postalCode;      // 우편번호
    private String businessHours;   // 운영 시간
    private Number latitude;        // 위도
    private char paidParking;       // 유료주차 가능여부
    private String strollerRental;  // 유모차 대여 여부
    private String instargramUrl;   // 인스타 주소
    private String entryAge;        // 입장 가능 나이
    private char entranceFee;       // 입장료 유무 여부
    private String phoneNumber;     // 전화번호
    private String streetAddress;   // 지번주소
    private char lastReviewed;      // 최종작성일
    private String category1;       // 카테고리1
    private String category2;       // 카테고리2
    private String category3;       // 카테고리3
    private char kidZone;           // 키즈존 여부
    private String facebookUrl;     // 페이스북 주소
    private String url;             // 홈페이지
    private String holiday;         // 휴무일

    public MateVO() {

    }

    public char getFamilyToilet() {
        return familyToilet;
    }

    public void setFamilyToilet(char familyToilet) {
        this.familyToilet = familyToilet;
    }

    public String getBulidingNm() {
        return bulidingNm;
    }

    public void setBulidingNm(String bulidingNm) {
        this.bulidingNm = bulidingNm;
    }

    public Number getLongitude() {
        return longitude;
    }

    public void setLongitude(Number longitude) {
        this.longitude = longitude;
    }

    public String getRoadName() {
        return roadName;
    }

    public void setRoadName(String roadName) {
        this.roadName = roadName;
    }

    public String getRoadNameAddress() {
        return roadNameAddress;
    }

    public void setRoadNameAddress(String roadNameAddress) {
        this.roadNameAddress = roadNameAddress;
    }

    public String getRiName() {
        return riName;
    }

    public void setRiName(String riName) {
        this.riName = riName;
    }

    public char getFreeParking() {
        return freeParking;
    }

    public void setFreeParking(char freeParking) {
        this.freeParking = freeParking;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLegaldong() {
        return legaldong;
    }

    public void setLegaldong(String legaldong) {
        this.legaldong = legaldong;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBlogUrl() {
        return blogUrl;
    }

    public void setBlogUrl(String blogUrl) {
        this.blogUrl = blogUrl;
    }

    public char getNursingRoom() {
        return nursingRoom;
    }

    public void setNursingRoom(char nursingRoom) {
        this.nursingRoom = nursingRoom;
    }

    public String getCityDistrict() {
        return cityDistrict;
    }

    public void setCityDistrict(String cityDistrict) {
        this.cityDistrict = cityDistrict;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getBusinessHours() {
        return businessHours;
    }

    public void setBusinessHours(String businessHours) {
        this.businessHours = businessHours;
    }

    public Number getLatitude() {
        return latitude;
    }

    public void setLatitude(Number latitude) {
        this.latitude = latitude;
    }

    public char getPaidParking() {
        return paidParking;
    }

    public void setPaidParking(char paidParking) {
        this.paidParking = paidParking;
    }

    public String getStrollerRental() {
        return strollerRental;
    }

    public void setStrollerRental(String strollerRental) {
        this.strollerRental = strollerRental;
    }

    public String getInstargramUrl() {
        return instargramUrl;
    }

    public void setInstargramUrl(String instargramUrl) {
        this.instargramUrl = instargramUrl;
    }

    public String getEntryAge() {
        return entryAge;
    }

    public void setEntryAge(String entryAge) {
        this.entryAge = entryAge;
    }

    public char getEntranceFee() {
        return entranceFee;
    }

    public void setEntranceFee(char entranceFee) {
        this.entranceFee = entranceFee;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public char getLastReviewed() {
        return lastReviewed;
    }

    public void setLastReviewed(char lastReviewed) {
        this.lastReviewed = lastReviewed;
    }

    public String getCategory1() {
        return category1;
    }

    public void setCategory1(String category1) {
        this.category1 = category1;
    }

    public String getCategory2() {
        return category2;
    }

    public void setCategory2(String category2) {
        this.category2 = category2;
    }

    public String getCategory3() {
        return category3;
    }

    public void setCategory3(String category3) {
        this.category3 = category3;
    }

    public char getKidZone() {
        return kidZone;
    }

    public void setKidZone(char kidZone) {
        this.kidZone = kidZone;
    }

    public String getFacebookUrl() {
        return facebookUrl;
    }

    public void setFacebookUrl(String facebookUrl) {
        this.facebookUrl = facebookUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHoliday() {
        return holiday;
    }

    public void setHoliday(String holiday) {
        this.holiday = holiday;
    }
}
