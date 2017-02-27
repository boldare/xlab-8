package pl.xsolve.clients;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.xsolve.model.PhotoGenerateDTO;
import pl.xsolve.model.WeatherDTO;

@FeignClient(name = "photo-service")
public interface PhotoClient {

    @RequestMapping(method = RequestMethod.POST, value = "/")
    String getGeneratedPhotoUrl(@RequestBody PhotoGenerateDTO photoGenerateDTO);
}
