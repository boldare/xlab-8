package pl.xsolve.workshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class DemoConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoConfigServerApplication.class, args);
	}
}
