package clone.bzm.lounge.userhistory.application.service;

import clone.bzm.lounge.userhistory.application.port.in.UserHistoryUseCase;
import clone.bzm.lounge.userhistory.application.port.in.command.UserHistoryCommand;
import clone.bzm.lounge.userhistory.application.port.out.jpa.UserHistorySavePort;
import clone.bzm.lounge.userhistory.domain.UserHistoryInfo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserHistoryService implements UserHistoryUseCase {

    private final UserHistorySavePort historySavePort;

    @Transactional
    @Override
    public void saveSignInHistory(UserHistoryCommand command) {
        historySavePort.save(
                UserHistoryInfo.builder()
                        .signInUserId(command.signInUserId())
                        .device(command.device())
                        .ip(command.ip())
                        .service(command.service())
                        .type(command.type())
                        .build()
        );
    }
}
