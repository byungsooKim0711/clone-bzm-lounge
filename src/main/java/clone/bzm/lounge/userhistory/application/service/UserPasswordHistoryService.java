package clone.bzm.lounge.userhistory.application.service;

import clone.bzm.lounge.userhistory.application.port.in.UserPasswordHistoryUseCase;
import clone.bzm.lounge.userhistory.application.port.in.command.UserPasswordHistoryCommand;
import clone.bzm.lounge.userhistory.application.port.out.jpa.UserPasswordHistorySavePort;
import clone.bzm.lounge.userhistory.domain.UserPasswordHistory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserPasswordHistoryService implements UserPasswordHistoryUseCase {

    private final UserPasswordHistorySavePort historySavePort;

    @Transactional
    @Override
    public void savePasswordHistory(UserPasswordHistoryCommand command) {
        historySavePort.save(
                UserPasswordHistory.builder()
                        .userId(command.userId())
                        .modifiedAt(command.modifiedAt())
                        .build()
        );
    }
}
