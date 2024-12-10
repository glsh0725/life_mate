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

}
