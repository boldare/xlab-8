package pl.xsolve.manager;

import pl.xsolve.dto.MessageDTO;

public interface EndSenderManager {

    void sendNotification(MessageDTO message);
}
