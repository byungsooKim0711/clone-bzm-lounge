package clone.bzm.lounge.user.adapter.out.jpa;

import clone.bzm.lounge.user.domain.User;

class UserMapper {

    static UserJpaEntity mapToJpaEntity(User user) {
        return UserJpaEntity.from(
                UserEmail.of(user.getEmail()),
                user.getSecurePassword(),
                user.getName(),
                user.getPhoneNumber()
        );
    }

    static User mapToDomainEntity(UserJpaEntity entity) {
        return User.withId(
                entity.getId(),
                entity.getEmail().getAddress(),
                entity.getPassword(),
                entity.getName(),
                entity.getPhoneNumber(),
                entity.getStatus().name(),
                entity.getCreatedAt(),
                entity.getModifiedAt()
        );
    }
}
