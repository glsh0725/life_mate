package fs.four.dropout.batch;

import fs.four.dropout.mate.service.MateServiceImpl;
import fs.four.dropout.festival.service.FestivalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ApiBatchTask {

    @Autowired
    private MateServiceImpl mateService;

    @Autowired
    private FestivalServiceImpl festivalService;

    // 유아 동반 데이터 배치
    @Scheduled(fixedRate = 3600000) // 1시간마다 실행
    public void fetchInfantData() {
        System.out.println("Scheduled Task: Fetching Infant Data");
        mateService.getInfantData();
    }

    // 반려동물 동반 데이터 배치
    @Scheduled(fixedRate = 3600000)
    public void fetchPetData() {
        System.out.println("Scheduled Task: Fetching Pet Data");
        mateService.getPetData();
    }

    // 통합 데이터 배치
    @Scheduled(fixedRate = 3600000)
    public void fetchCombinedData() {
        System.out.println("Scheduled Task: Fetching Combined Data");
        mateService.getCombinedData();
    }

    // 축제 데이터 전체 배치
    @Scheduled(fixedRate = 3600000) // 1시간마다 실행
    public void fetchAllFestivals() {
        System.out.println("Scheduled Task: Fetching All Festivals");
        festivalService.getAllFestivals();
    }

    // 특정 날짜의 축제 데이터 배치
    @Scheduled(fixedRate = 3600000)
    public void fetchFestivalsByDate() {
        String today = java.time.LocalDate.now().toString();
        System.out.println("Scheduled Task: Fetching Festivals for Date: " + today);
        festivalService.getFestivalsByDate(today);
    }

    // 특정 날짜와 주소의 축제 데이터 배치
    @Scheduled(fixedRate = 3600000)
    public void fetchFestivalsByDateAndAddress() {
        String today = java.time.LocalDate.now().toString();
        String sampleAddress = "";
        System.out.println("Scheduled Task: Fetching Festivals for Date and Address: " + today + ", " + sampleAddress);
        festivalService.getFestivalsByDateAndAddress(today, sampleAddress);
    }
}