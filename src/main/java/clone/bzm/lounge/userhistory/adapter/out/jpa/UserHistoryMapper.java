package clone.bzm.lounge.userhistory.adapter.out.jpa;

import clone.bzm.lounge.userhistory.domain.UserHistoryInfo;

class UserHistoryMapper {

    static UserLoginHistoryJpaEntity mapToJpaEntity(UserHistoryInfo domain) {
        return UserLoginHistoryJpaEntity.from(
                domain.getSignInUserId(),
                domain.getDevice(),
                domain.getIp(),
                domain.getService(),
                domain.getType()
        );
    }

    static UserHistoryInfo mapToDomainEntity(UserLoginHistoryJpaEntity entity) {
        return UserHistoryInfo.builder()
                .signInUserId(entity.getSignInUserId())
                .ip(entity.getIp())
                .device(entity.getDevice())
                .service(entity.getService())
                .type(entity.getType())
                .build();
    }
}
