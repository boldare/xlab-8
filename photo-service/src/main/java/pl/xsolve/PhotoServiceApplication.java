package pl.xsolve;

import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableEurekaClient
public class PhotoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotoServiceApplication.class, args);
	}

	@Bean
	public Cloudinary cloudinary(@Value("${cloud_name}") String cloudName,
								 @Value("${api_key}") String apiKey,
								 @Value("${api_secret}") String apiSecret) {

		Map<String, String> configurationMap = new HashMap();
		configurationMap.put("cloud_name", cloudName);
		configurationMap.put("api_key", apiKey);
		configurationMap.put("api_secret", apiSecret);

		return new Cloudinary(configurationMap);
	}
}
