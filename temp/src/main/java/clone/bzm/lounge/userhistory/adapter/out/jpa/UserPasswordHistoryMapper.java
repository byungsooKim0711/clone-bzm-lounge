package clone.bzm.lounge.userhistory.adapter.out.jpa;

import clone.bzm.lounge.userhistory.domain.UserPasswordHistory;

class UserPasswordHistoryMapper {

    static UserPasswordHistoryJpaEntity mapToJpaEntity(UserPasswordHistory domain) {
        return UserPasswordHistoryJpaEntity.from(
                domain.getUserId(),
                domain.getModifiedAt()
        );
    }

    static UserPasswordHistory mapToDomainEntity(UserPasswordHistoryJpaEntity entity) {
        return UserPasswordHistory.builder()
                .userId(entity.getUserId())
                .modifiedAt(entity.getPasswordModifiedAt())
                .build();
    }
}
