package clone.bzm.lounge.user.application.service;

import clone.bzm.lounge.user.application.port.in.UserUseCase;
import clone.bzm.lounge.user.application.port.out.jpa.UserLoadPort;
import clone.bzm.lounge.user.application.port.out.jpa.UserSavePort;
import clone.bzm.lounge.user.domain.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService implements UserUseCase {

    private final UserLoadPort userLoadPort;
    private final UserSavePort userSavePort;

    @Transactional
    @Override
    public UserInfo signUp(SignUpUserCommand command) {
        UserInfo userInfo = UserInfo.signIn(
                command.email(),
                encryptPassword(command.plainPassword()),
                command.name(),
                command.phoneNumber()
        );

        return userSavePort.signUp(userInfo);
    }

    @Override
    public void signIn() {

    }

    @Override
    public void signOut() {

    }

    @Override
    public void changePassword() {

    }

    private String encryptPassword(String plainPassword) {
        String securePassword = plainPassword;

        return securePassword;
    }
}
