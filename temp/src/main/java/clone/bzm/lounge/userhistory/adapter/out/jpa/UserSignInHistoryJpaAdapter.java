package clone.bzm.lounge.userhistory.adapter.out.jpa;

import clone.bzm.lounge.userhistory.application.port.out.jpa.UserSignInHistorySavePort;
import clone.bzm.lounge.userhistory.domain.UserSignInHistory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserSignInHistoryJpaAdapter implements UserSignInHistorySavePort {

    private final UserSignInHistoryJpaRepository repository;

    @Override
    public void save(UserSignInHistory userLoginHistory) {
        repository.save(UserSignInHistoryMapper.mapToJpaEntity(userLoginHistory));
    }
}
