package clone.bzm.lounge.userhistory.adapter.in.event;

import clone.bzm.lounge.user.application.port.out.event.SignInEvent;
import clone.bzm.lounge.userhistory.application.port.in.UserHistoryUseCase;
import clone.bzm.lounge.userhistory.application.port.in.command.UserHistoryCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@RequiredArgsConstructor
@Component
class UserSignInEventConsumer {

    private final UserHistoryUseCase useCase;

    @Async
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void onApplicationEvent(SignInEvent event) {
        useCase.saveSignInHistory(
                new UserHistoryCommand(
                        event.getSignInUserId(),
                        event.getDevice(),
                        event.getIp(),
                        event.getService(),
                        event.getType().name()
                )
        );
    }
}
