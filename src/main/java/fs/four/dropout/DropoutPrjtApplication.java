package fs.four.dropout;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class DropoutPrjtApplication {

	public static void main(String[] args) {
		SpringApplication.run(DropoutPrjtApplication.class, args);
	}

}
