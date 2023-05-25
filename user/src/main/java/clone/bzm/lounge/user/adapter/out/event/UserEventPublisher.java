package clone.bzm.lounge.user.adapter.out.event;

import clone.bzm.lounge.user.application.port.out.event.UserEventPublishPort;
import clone.bzm.lounge.userevent.domain.UserEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserEventPublisher implements UserEventPublishPort {

    private final ApplicationEventPublisher publisher;

    @Override
    public void publishUserEvent(UserEvent<?> event) {
        publisher.publishEvent(event);
    }
}
