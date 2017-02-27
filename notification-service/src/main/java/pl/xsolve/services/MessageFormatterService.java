package pl.xsolve.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pl.xsolve.clients.PhotoClient;
import pl.xsolve.clients.WeatherClient;
import pl.xsolve.model.PhotoGenerateDTO;
import pl.xsolve.model.UserAccountDTO;
import pl.xsolve.model.WeatherDTO;

@Service
public class MessageFormatterService {

    protected final PhotoClient photoClient;
    protected final WeatherClient weatherClient;

    @Value("${notification.message-formatter-service.template-email}")
    protected String emailTemplateMessage;

    @Autowired
    public MessageFormatterService(PhotoClient photoClient, WeatherClient weatherClient) {
        this.photoClient = photoClient;
        this.weatherClient = weatherClient;
    }

    public String getPreparedWeatherMessage(UserAccountDTO userAccountDTO) {
        WeatherDTO weatherDTO = weatherClient.askForWeather(userAccountDTO.getCity());
        String formattedMessage = prepareWeatherMessage(userAccountDTO, weatherDTO);
        String weatherImage = prepareWeatherImage(userAccountDTO, weatherDTO);
        return "<html><body>" + formattedMessage + "<img src='" + weatherImage + "'></body></html>";
    }

    private String prepareWeatherMessage(UserAccountDTO userAccountDTO, WeatherDTO weatherDTO) {
        return String.format(emailTemplateMessage, userAccountDTO.getName(), userAccountDTO.getCity(), weatherDTO.getMain(), weatherDTO.getDescription());
    }

    private String prepareWeatherImage(UserAccountDTO userAccountDTO, WeatherDTO weatherDTO) {
        PhotoGenerateDTO photoGenerateDTO = new PhotoGenerateDTO();
        photoGenerateDTO.setImageUrl(userAccountDTO.getImageUrl());
        photoGenerateDTO.setWeatherType(weatherDTO.getMain());
        return photoClient.getGeneratedPhotoUrl(photoGenerateDTO);
    }
}
