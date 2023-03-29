package clone.bzm.lounge.user.application.port.out.event;

import org.springframework.context.ApplicationEvent;

public interface UserEventPort {

    void publishEvent(ApplicationEvent event);
}
