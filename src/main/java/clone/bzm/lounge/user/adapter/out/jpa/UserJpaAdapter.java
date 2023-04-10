package clone.bzm.lounge.user.adapter.out.jpa;

import clone.bzm.lounge.user.application.port.out.jpa.UserLoadPort;
import clone.bzm.lounge.user.application.port.out.jpa.UserSavePort;
import clone.bzm.lounge.user.domain.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserJpaAdapter implements UserLoadPort, UserSavePort {

    private final UserJpaRepository userJpaRepository;

    @Override
    public UserInfo findByEmail(String address) {
        return userJpaRepository.findByEmail(UserEmail.of(address))
                .map(UserMapper::mapToDomainEntity)
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public UserInfo findById(Long id) {
        return userJpaRepository.findById(id)
                .map(UserMapper::mapToDomainEntity)
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public UserInfo signUp(UserInfo userInfo) {
        UserJpaEntity registeredUser = userJpaRepository.save(
                UserMapper.mapToJpaEntity(userInfo)
        );

        return UserMapper.mapToDomainEntity(registeredUser);
    }
}
