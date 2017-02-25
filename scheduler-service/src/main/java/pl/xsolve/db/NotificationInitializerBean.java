package pl.xsolve.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.xsolve.SchedulerServiceApplication;
import pl.xsolve.db.model.Notification;

import java.util.Date;

@Component
public class NotificationInitializerBean implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(SchedulerServiceApplication.class);

    protected NotificationRepository repository;

    @Autowired
    public NotificationInitializerBean(NotificationRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Notification(new Date()));

        log.info("Database has been successfully initialized");
    }
}
