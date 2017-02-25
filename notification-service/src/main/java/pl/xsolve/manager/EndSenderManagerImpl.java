package pl.xsolve.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;
import pl.xsolve.dto.MessageDTO;

@Component
public class EndSenderManagerImpl implements EndSenderManager {

    @Value("${mail.sender.url}")
    private String mailSenderUrl;

    protected RestOperations restOperations;

    @Autowired
    public EndSenderManagerImpl(RestOperations restOperations) {
        this.restOperations = restOperations;
    }

    @Override
    public void sendNotification(MessageDTO message) {
        restOperations.postForEntity(mailSenderUrl, message, ResponseEntity.class);
    }
}
