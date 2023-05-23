package clone.bzm.lounge.userhistory.adapter.out.jpa;

import clone.bzm.lounge.userhistory.domain.UserSignInHistory;

class UserSignInHistoryMapper {

    static UserSignInHistoryJpaEntity mapToJpaEntity(UserSignInHistory domain) {
        return UserSignInHistoryJpaEntity.from(
                domain.getSignInUserId(),
                domain.getDevice(),
                domain.getIp(),
                domain.getService(),
                domain.getType()
        );
    }

    static UserSignInHistory mapToDomainEntity(UserSignInHistoryJpaEntity entity) {
        return UserSignInHistory.builder()
                .signInUserId(entity.getSignInUserId())
                .ip(entity.getIp())
                .device(entity.getDevice())
                .service(entity.getService())
                .type(entity.getType())
                .build();
    }
}
