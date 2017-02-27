package pl.xsolve.clients;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.xsolve.model.TransactionDTO;
import pl.xsolve.model.WeatherDTO;

@FeignClient(name = "weather-service")
public interface WeatherClient {

    @RequestMapping(method = RequestMethod.GET, value = "/{city}")
    WeatherDTO askForWeather(@PathVariable("city") String city);
}
