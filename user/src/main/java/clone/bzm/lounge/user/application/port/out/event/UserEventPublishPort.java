package clone.bzm.lounge.user.application.port.out.event;

import clone.bzm.lounge.userevent.domain.UserEvent;

public interface UserEventPublishPort {

    void publishUserEvent(UserEvent<?> event);
}
