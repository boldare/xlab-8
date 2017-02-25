package pl.xsolve;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FormatterServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FormatterServiceApplication.class, args);
	}
}
