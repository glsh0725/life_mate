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

    @Scheduled(fixedRate = 3600000) // 1시간마다 실행
    public void executeTasksInOrder() {
        System.out.println("Scheduled Task: Starting Sequential Execution");

        // 1. 유아 동반 데이터
        System.out.println("Scheduled Task: Fetching Infant Data");
        mateService.getInfantData();

        // 2. 반려동물 동반 데이터
        System.out.println("Scheduled Task: Fetching Pet Data");
        mateService.getPetData();

        // 3. 통합 데이터
        System.out.println("Scheduled Task: Fetching Combined Data");
        mateService.getCombinedData();

        // 4. 축제 데이터 전체
        System.out.println("Scheduled Task: Fetching All Festivals");
        festivalService.getAllFestivals();

        // 5. 특정 날짜의 축제 데이터
        String today = java.time.LocalDate.now().toString();
        System.out.println("Scheduled Task: Fetching Festivals for Date: " + today);
        festivalService.getFestivalsByDate(today);

        // 6. 특정 날짜와 주소의 축제 데이터
        String sampleAddress = "";
        System.out.println("Scheduled Task: Fetching Festivals for Date and Address: " + today + ", " + sampleAddress);
        festivalService.getFestivalsByDateAndAddress(today, sampleAddress);

        System.out.println("Scheduled Task: end Sequential Execution");
    }
}