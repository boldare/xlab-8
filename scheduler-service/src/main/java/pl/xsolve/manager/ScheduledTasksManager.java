package pl.xsolve.manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduledTasksManager {


    @Value("${notification.service.url}")
    private String notificationServiceUrl;

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasksManager.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    protected TimeIntervalManger timeIntervalManger;
    protected RestOperations restOperations;

    @Autowired
    public ScheduledTasksManager(TimeIntervalManger timeIntervalManger, RestOperations restOperations) {
        this.timeIntervalManger = timeIntervalManger;
        this.restOperations = restOperations;
    }

    @Scheduled(cron = "${execution.interval}")
    public void executeNotificationService() {
        executeWeatherNotification();
    }

    protected void executeWeatherNotification() {
        if (timeIntervalManger.shouldExecuteNotification()) {
            String notificationResult;
            try {
                notificationResult = restOperations.getForObject(notificationServiceUrl, String.class);
            } catch (Exception e) {
                notificationResult = "Can't send notification to: " + notificationServiceUrl + ". Service is not available.";
            }

            log.info("Scheduler executed on {}. Notification result: {}", dateFormat.format(new Date()), notificationResult);
        }
        log.info("Scheduler executed on {}. Skipping notification", dateFormat.format(new Date()));
    }
}
