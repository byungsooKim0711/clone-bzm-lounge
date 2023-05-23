package clone.bzm.lounge.userhistory.adapter.out.jpa;

import clone.bzm.lounge.userhistory.application.port.out.jpa.UserPasswordHistorySavePort;
import clone.bzm.lounge.userhistory.domain.UserPasswordHistory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserPasswordHistoryJpaAdapter implements UserPasswordHistorySavePort {

    private final UserPasswordHistoryRepository repository;

    @Override
    public void save(UserPasswordHistory history) {
        repository.save(UserPasswordHistoryMapper.mapToJpaEntity(history));
    }
}
