package pl.xsolve.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.xsolve.clients.WeatherApi;
import pl.xsolve.models.dtos.GeneralDTO;
import pl.xsolve.models.dtos.Weather;

@RestController
public class WeatherController {

    protected final WeatherApi weatherApi;

    @Value("${apiId}")
    protected String apiId;

    @Autowired
    public WeatherController(WeatherApi weatherApi) {
        this.weatherApi = weatherApi;
    }

    @RequestMapping("/{cityName}")
    public Weather getWeather(@PathVariable String cityName) {
        GeneralDTO weather = weatherApi.getWeather(cityName + ",pl", apiId);

        return weather.getWeather().stream()
                                   .findFirst()
                                   .orElse(new Weather());
    }
}
