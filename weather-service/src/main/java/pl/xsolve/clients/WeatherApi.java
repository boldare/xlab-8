package pl.xsolve.clients;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.xsolve.models.dtos.GeneralDTO;

@FeignClient(name = "weather-api", url = "http://api.openweathermap.org/")
public interface WeatherApi {

    @RequestMapping(method = RequestMethod.GET, value = "data/2.5/weather")
    GeneralDTO getWeather(@RequestParam("q") String cityName,
                          @RequestParam("appId") String appId);

}
