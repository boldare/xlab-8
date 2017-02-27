package pl.xsolve.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.xsolve.model.TransactionDTO;
import pl.xsolve.services.NotificationService;

@RestController
public class NotificationController {

    protected final NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.GET)
    public TransactionDTO sendNotification(@PathVariable Long accountId) {
        return notificationService.sendNotification(accountId);
    }
}
