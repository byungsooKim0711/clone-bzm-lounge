package clone.bzm.lounge.userhistory.application.service;

import clone.bzm.lounge.userhistory.application.port.in.UserSignInHistoryUseCase;
import clone.bzm.lounge.userhistory.application.port.in.command.UserSignInHistoryCommand;
import clone.bzm.lounge.userhistory.application.port.out.jpa.UserSignInHistorySavePort;
import clone.bzm.lounge.userhistory.domain.UserSignInHistory;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserSignInHistoryService implements UserSignInHistoryUseCase {

    private final UserSignInHistorySavePort historySavePort;

    @Transactional
    @Override
    public void saveSignInHistory(UserSignInHistoryCommand command) {
        historySavePort.save(
                UserSignInHistory.builder()
                        .signInUserId(command.signInUserId())
                        .device(command.device())
                        .ip(command.ip())
                        .service(command.service())
                        .type(command.type())
                        .build()
        );
    }
}
