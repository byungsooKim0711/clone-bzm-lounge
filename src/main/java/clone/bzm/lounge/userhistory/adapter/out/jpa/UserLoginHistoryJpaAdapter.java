package clone.bzm.lounge.userhistory.adapter.out.jpa;

import clone.bzm.lounge.userhistory.application.port.out.jpa.UserHistorySavePort;
import clone.bzm.lounge.userhistory.domain.UserHistoryInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserLoginHistoryJpaAdapter implements UserHistorySavePort {

    private final UserLoginHistoryJpaRepository repository;

    @Override
    public UserHistoryInfo save(UserHistoryInfo userHistory) {
        UserLoginHistoryJpaEntity savedUserHistory = repository.save(UserHistoryMapper.mapToJpaEntity(userHistory));

        return UserHistoryMapper.mapToDomainEntity(savedUserHistory);
    }
}
