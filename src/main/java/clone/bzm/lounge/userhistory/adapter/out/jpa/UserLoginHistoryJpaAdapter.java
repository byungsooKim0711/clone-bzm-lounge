package clone.bzm.lounge.userhistory.adapter.out.jpa;

import clone.bzm.lounge.userhistory.application.port.out.jpa.UserHistorySavePort;
import clone.bzm.lounge.userhistory.domain.UserLoginHistory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserLoginHistoryJpaAdapter implements UserHistorySavePort {

    private final UserLoginHistoryJpaRepository repository;

    @Override
    public UserLoginHistory save(UserLoginHistory userLoginHistory) {
        UserLoginHistoryJpaEntity savedUserHistory = repository.save(UserHistoryMapper.mapToJpaEntity(userLoginHistory));

        return UserHistoryMapper.mapToDomainEntity(savedUserHistory);
    }
}
