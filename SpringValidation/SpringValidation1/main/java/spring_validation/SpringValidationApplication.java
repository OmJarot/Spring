package spring_validation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import spring_validation.ConfigurationProperties.DatabaseProperties;

@SpringBootApplication
@EnableConfigurationProperties({
		DatabaseProperties.class
})
public class SpringValidationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringValidationApplication.class, args);
	}

}
