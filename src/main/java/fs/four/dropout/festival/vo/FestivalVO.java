package fs.four.dropout.festival.vo;

import lombok.Data;

@Data
public class FestivalVO {
    private String fstvlNm;          // 축제명
    private String opar;             // 개최 장소
    private String fstvlStartDate;   // 축제 시작일
    private String fstvlEndDate;     // 축제 종료일
    private String fstvlCo;          // 축제 내용
    private String mnnstNm;          // 주최 기관
    private String auspcInsttNm;     // 주관 기관
    private String suprtInsttNm;     // 후원 기관
    private String phoneNumber;      // 전화번호
    private String homepageUrl;      // 홈페이지 URL
    private String relateInfo;       // 관련 정보
    private String rdnmadr;          // 도로명 주소
    private String lnmadr;           // 지번 주소
    private String latitude;         // 위도
    private String longitude;        // 경도
    private String referenceDate;    // 데이터 기준일
    private String insttCode;        // 기관 코드

    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}