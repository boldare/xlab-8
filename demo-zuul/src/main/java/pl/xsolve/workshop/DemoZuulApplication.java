package pl.xsolve.workshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import pl.xsolve.workshop.filter.SimpleFilter;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class DemoZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoZuulApplication.class, args);
	}

    @Bean
    public SimpleFilter simpleFilter() {
        return new SimpleFilter();
    }
}
