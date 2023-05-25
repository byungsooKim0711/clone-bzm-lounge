package clone.bzm.lounge.userevent.adapter.in.event;

import clone.bzm.lounge.userevent.domain.UserPasswordChangeEvent;
import clone.bzm.lounge.userevent.domain.UserEvent;
import clone.bzm.lounge.userhistory.application.port.in.UserPasswordHistoryUseCase;
import clone.bzm.lounge.userhistory.application.port.in.command.UserPasswordHistoryCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@RequiredArgsConstructor
@Component
public class UserPasswordChangeEventConsumer {

    private final UserPasswordHistoryUseCase useCase;

    @Async
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void consumePasswordChangeEvent(UserEvent<UserPasswordChangeEvent> event) {
        UserPasswordChangeEvent eventData = event.getData();
        log.info("Consume password change event. userId: {}", eventData.getUserId());
        useCase.savePasswordHistory(
                new UserPasswordHistoryCommand(
                        eventData.getUserId(),
                        eventData.getModifiedAt()
                )
        );
    }
}
