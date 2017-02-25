package pl.xsolve.manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import pl.xsolve.db.NotificationRepository;
import pl.xsolve.db.model.Notification;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
public class TimeIntervalManagerImpl implements TimeIntervalManger {


    private static final Logger log = LoggerFactory.getLogger(TimeIntervalManagerImpl.class);

    @Value("${notification.interval.seconds}")
    private int notificationIntervalSeconds;

    protected NotificationRepository notificationRepository;
    protected NotificationRepository dbRepository;

    @Autowired
    public TimeIntervalManagerImpl(NotificationRepository notificationRepository, NotificationRepository dbRepository) {
        this.notificationRepository = notificationRepository;
        this.dbRepository = dbRepository;
    }

    @Override
    public boolean shouldExecuteNotification() {
        Notification lastUpdate = notificationRepository.getNotificationHolder();
        long duration = getDurationSinceLastUpdate(lastUpdate);

        if (duration > notificationIntervalSeconds) {
            lastUpdate.setLastUpdate(new Date());
            dbRepository.save(lastUpdate);

            log.info("Attempting to execute notification service. Last notification was {} seconds ago",  duration);

            return true;
        } else {
            return false;
        }
    }

    protected long getDurationSinceLastUpdate(Notification lastUpdate) {
        long duration  = new Date().getTime() - lastUpdate.getLastUpdate().getTime();

        return TimeUnit.MILLISECONDS.toSeconds(duration);
    }
}
