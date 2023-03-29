package clone.bzm.lounge.user.adapter.out.jpa;

import clone.bzm.lounge.user.application.port.out.jpa.UserLoadPort;
import clone.bzm.lounge.user.domain.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserJpaAdapter implements UserLoadPort {

    private final UserJpaRepository userJpaRepository;

    @Override
    public UserInfo findByEmail(String address) {
        return userJpaRepository.findByEmail(UserEmail.of(address))
                .map(user -> {
                    return new UserInfo();
                })
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public UserInfo findById(Long id) {
        return new UserInfo();
    }
}
