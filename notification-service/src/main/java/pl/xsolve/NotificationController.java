package pl.xsolve;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.xsolve.dto.MessageDTO;
import pl.xsolve.dto.NotificationResponseDto;
import pl.xsolve.dto.SnowReportDTO;
import pl.xsolve.manager.EndSenderManager;
import pl.xsolve.manager.FormatterManager;
import pl.xsolve.manager.WeatherManager;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    protected WeatherManager weatherManager;
    protected FormatterManager formatterManager;
    protected EndSenderManager endSenderManager;

    @Autowired
    public NotificationController(WeatherManager weatherManager, FormatterManager formatterManager, EndSenderManager endSenderManager) {
        this.weatherManager = weatherManager;
        this.formatterManager = formatterManager;
        this.endSenderManager = endSenderManager;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/notification")
    public NotificationResponseDto getNotification() {
        SnowReportDTO rawReport = weatherManager.getSnowReport();
        MessageDTO formattedMessage = formatterManager.format(rawReport);

        endSenderManager.sendNotification(formattedMessage);

        return new NotificationResponseDto("SENT");
    }
}
