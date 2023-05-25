package clone.bzm.lounge.userevent.adapter.in.event;

import clone.bzm.lounge.userevent.domain.UserEvent;
import clone.bzm.lounge.userevent.domain.UserSignInEvent;
import clone.bzm.lounge.userhistory.application.port.in.UserSignInHistoryUseCase;
import clone.bzm.lounge.userhistory.application.port.in.command.UserSignInHistoryCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@RequiredArgsConstructor
@Component
class UserSignInEventConsumer {

    private final UserSignInHistoryUseCase useCase;

    @Async
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void onApplicationEvent(UserEvent<UserSignInEvent> event) {
        UserSignInEvent eventData = event.getData();
        useCase.saveSignInHistory(
                new UserSignInHistoryCommand(
                        eventData.getSignInUserId(),
                        eventData.getDevice(),
                        eventData.getIp(),
                        eventData.getService(),
                        eventData.getType().name()
                )
        );
    }
}
