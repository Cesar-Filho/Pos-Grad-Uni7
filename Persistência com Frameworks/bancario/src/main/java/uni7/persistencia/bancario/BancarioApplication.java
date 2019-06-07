package uni7.persistencia.bancario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class BancarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(BancarioApplication.class, args);
	}

}
