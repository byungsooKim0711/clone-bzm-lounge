package clone.bzm.lounge.user.adapter.out.event;

import clone.bzm.lounge.user.application.port.out.event.SignInEvent;
import clone.bzm.lounge.user.application.port.out.event.UserEventPort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserEventPublisher implements UserEventPort {

    private final ApplicationEventPublisher publisher;

    @Override
    public void publishSignInEvent(SignInEvent event) {
        publisher.publishEvent(event);
    }
}
