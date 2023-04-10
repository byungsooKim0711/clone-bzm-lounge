package clone.bzm.lounge.user.adapter.out.jpa;

import clone.bzm.lounge.user.domain.UserInfo;

class UserMapper {

    static UserJpaEntity mapToJpaEntity(UserInfo userInfo) {
        return UserJpaEntity.from(
                UserEmail.of(userInfo.getEmail()),
                userInfo.getSecurePassword(),
                userInfo.getName(),
                userInfo.getPhoneNumber());
    }

    static UserInfo mapToDomainEntity(UserJpaEntity entity) {
        return UserInfo.withId(
                entity.getId(),
                entity.getEmail().getAddress(),
                entity.getName(),
                entity.getPhoneNumber(),
                entity.getStatus().name());
    }
}
