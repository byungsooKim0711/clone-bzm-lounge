package clone.bzm.lounge.userhistory.adapter.out.jpa;

import clone.bzm.lounge.userhistory.domain.UserLoginHistory;

class UserHistoryMapper {

    static UserLoginHistoryJpaEntity mapToJpaEntity(UserLoginHistory domain) {
        return UserLoginHistoryJpaEntity.from(
                domain.getSignInUserId(),
                domain.getDevice(),
                domain.getIp(),
                domain.getService(),
                domain.getType()
        );
    }

    static UserLoginHistory mapToDomainEntity(UserLoginHistoryJpaEntity entity) {
        return UserLoginHistory.builder()
                .signInUserId(entity.getSignInUserId())
                .ip(entity.getIp())
                .device(entity.getDevice())
                .service(entity.getService())
                .type(entity.getType())
                .build();
    }
}
