package clone.bzm.lounge.userhistory.adapter.in.event;

import clone.bzm.lounge.user.application.port.out.event.PasswordChangeEvent;
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
    public void consumePasswordChangeEvent(PasswordChangeEvent event) {
        log.info("Consume password change event. userId: {}", event.getUserId());
        useCase.savePasswordHistory(
                new UserPasswordHistoryCommand(
                        event.getUserId(),
                        event.getModifiedAt()
                )
        );
    }

    @Async
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void signOut(PasswordChangeEvent event) {
        if (!event.isSessionClear()) {
            /* skip */
            return;
        }

        log.info("Consume session clear event. userId: {}", event.getUserId());
    }

}
