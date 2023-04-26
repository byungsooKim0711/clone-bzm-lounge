package clone.bzm.lounge.userhistory.adapter.in.event;

import clone.bzm.lounge.user.application.port.out.event.SignInEvent;
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
    public void onApplicationEvent(SignInEvent event) {
        useCase.saveSignInHistory(
                new UserSignInHistoryCommand(
                        event.getSignInUserId(),
                        event.getDevice(),
                        event.getIp(),
                        event.getService(),
                        event.getType().name()
                )
        );
    }
}
