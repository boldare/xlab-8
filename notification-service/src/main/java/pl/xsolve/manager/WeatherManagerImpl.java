package pl.xsolve.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import pl.xsolve.dto.SnowReportDTO;

@Component
@Configuration
public class WeatherManagerImpl implements WeatherManager {

    @Value("${weather.service.url}")
    private String weatherServiceUrl;

    protected RestOperations restOperations;

    @Autowired
    public WeatherManagerImpl(RestOperations restOperations) {
        this.restOperations = restOperations;
    }

    @Override
    public SnowReportDTO getSnowReport() {
        SnowReportDTO report = restOperations.getForObject(weatherServiceUrl, SnowReportDTO.class);

        return report;
    }

    @Bean
    RestOperations restOperations() {
        return new RestTemplate();
    }

}
