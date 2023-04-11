package clone.bzm.lounge.user.adapter.out.jpa;

import clone.bzm.lounge.user.application.port.out.jpa.UserLoadPort;
import clone.bzm.lounge.user.application.port.out.jpa.UserSavePort;
import clone.bzm.lounge.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserJpaAdapter implements UserLoadPort, UserSavePort {

    private final UserJpaRepository userJpaRepository;

    @Override
    public User findByEmail(String address) {
        return userJpaRepository.findByEmail(UserEmail.of(address))
                .map(UserMapper::mapToDomainEntity)
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public User findById(Long id) {
        return userJpaRepository.findById(id)
                .map(UserMapper::mapToDomainEntity)
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public User signUp(User user) {
        UserJpaEntity registeredUser = userJpaRepository.save(
                UserMapper.mapToJpaEntity(user)
        );

        return UserMapper.mapToDomainEntity(registeredUser);
    }
}
