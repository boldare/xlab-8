package pl.xsolve.db;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pl.xsolve.db.model.Notification;

public interface NotificationRepository extends CrudRepository<Notification, Long> {

    @Query("SELECT n FROM Notification n")
    Notification getNotificationHolder();
}
