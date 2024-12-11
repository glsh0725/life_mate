package fs.four.dropout.mate.vo;

import java.util.Date;

public class MateVO {

    // 공통 필드
    private String facilityName; // 시설명
    private String contact; // 전화번호
    private String oldAddress; // 지번주소
    private String newAddress; // 도로명주소
    private String url; // 홈페이지
    private String businessHours; // 운영시간
    private String holiday; // 휴무일
    private Date lastUpdated; // 최종작성일
    private String city; // 시도 명칭
    private String cityDistrict; // 시군구 명칭

    // 유아 동반 관련 필드
    private String blogUrl; // 블로그 주소
    private String facebookUrl; // 페이스북 주소
    private String instargramUrl; // 인스타 주소
    private String entryFee; // 입장료 유무 여부
    private String freeParking; // 무료주차 가능여부
    private String paidParking; // 유료주차 가능여부
    private String entryAge; // 입장 가능 나이
    private String familyToilet; // 가족 화장실 보유 여부
    private String strollerRental; // 유모차 대여 여부
    private String nursingRoom; // 수유실 보유 여부
    private String kidZone; // 키즈존 여부

    // 반려동물 동반 관련 필드
    private String petCompanionFee; // 애견 동반 추가 요금
    private String petRestrictions; // 반려동물 제한사항
    private String parking; // 주차 가능여부
    private String indoor; // 장소(실내) 여부
    private String outdoor; // 장소(실외) 여부
    private String petSize; // 입장 가능 동물 크기
    private String petFriendly; // 반려동물 동반 가능정보

    public MateVO() {
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getOldAddress() {
        return oldAddress;
    }

    public void setOldAddress(String oldAddress) {
        this.oldAddress = oldAddress;
    }

    public String getNewAddress() {
        return newAddress;
    }

    public void setNewAddress(String newAddress) {
        this.newAddress = newAddress;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBusinessHours() {
        return businessHours;
    }

    public void setBusinessHours(String businessHours) {
        this.businessHours = businessHours;
    }

    public String getHoliday() {
        return holiday;
    }

    public void setHoliday(String holiday) {
        this.holiday = holiday;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityDistrict() {
        return cityDistrict;
    }

    public void setCityDistrict(String cityDistrict) {
        this.cityDistrict = cityDistrict;
    }

    public String getBlogUrl() {
        return blogUrl;
    }

    public void setBlogUrl(String blogUrl) {
        this.blogUrl = blogUrl;
    }

    public String getFacebookUrl() {
        return facebookUrl;
    }

    public void setFacebookUrl(String facebookUrl) {
        this.facebookUrl = facebookUrl;
    }

    public String getInstargramUrl() {
        return instargramUrl;
    }

    public void setInstargramUrl(String instargramUrl) {
        this.instargramUrl = instargramUrl;
    }

    public String getEntryFee() {
        return entryFee;
    }

    public void setEntryFee(String entryFee) {
        this.entryFee = entryFee;
    }

    public String getFreeParking() {
        return freeParking;
    }

    public void setFreeParking(String freeParking) {
        this.freeParking = freeParking;
    }

    public String getPaidParking() {
        return paidParking;
    }

    public void setPaidParking(String paidParking) {
        this.paidParking = paidParking;
    }

    public String getEntryAge() {
        return entryAge;
    }

    public void setEntryAge(String entryAge) {
        this.entryAge = entryAge;
    }

    public String getFamilyToilet() {
        return familyToilet;
    }

    public void setFamilyToilet(String familyToilet) {
        this.familyToilet = familyToilet;
    }

    public String getStrollerRental() {
        return strollerRental;
    }

    public void setStrollerRental(String strollerRental) {
        this.strollerRental = strollerRental;
    }

    public String getNursingRoom() {
        return nursingRoom;
    }

    public void setNursingRoom(String nursingRoom) {
        this.nursingRoom = nursingRoom;
    }

    public String getKidZone() {
        return kidZone;
    }

    public void setKidZone(String kidZone) {
        this.kidZone = kidZone;
    }

    public String getPetCompanionFee() {
        return petCompanionFee;
    }

    public void setPetCompanionFee(String petCompanionFee) {
        this.petCompanionFee = petCompanionFee;
    }

    public String getPetRestrictions() {
        return petRestrictions;
    }

    public void setPetRestrictions(String petRestrictions) {
        this.petRestrictions = petRestrictions;
    }

    public String getParking() {
        return parking;
    }

    public void setParking(String parking) {
        this.parking = parking;
    }

    public String getIndoor() {
        return indoor;
    }

    public void setIndoor(String indoor) {
        this.indoor = indoor;
    }

    public String getOutdoor() {
        return outdoor;
    }

    public void setOutdoor(String outdoor) {
        this.outdoor = outdoor;
    }

    public String getPetSize() {
        return petSize;
    }

    public void setPetSize(String petSize) {
        this.petSize = petSize;
    }

    public String getPetFriendly() {
        return petFriendly;
    }

    public void setPetFriendly(String petFriendly) {
        this.petFriendly = petFriendly;
    }
}
