package clone.bzm.lounge.user.application.service;

import clone.bzm.lounge.user.application.port.in.UserUseCase;
import clone.bzm.lounge.user.application.port.in.command.SignInCommand;
import clone.bzm.lounge.user.application.port.in.command.SignUpCommand;
import clone.bzm.lounge.user.application.port.out.event.SignInEvent;
import clone.bzm.lounge.user.application.port.out.event.SignInEvent.SignInType;
import clone.bzm.lounge.user.application.port.out.event.UserEventPort;
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
    private final UserEventPort userEventPort;

    @Transactional
    @Override
    public UserInfo signUp(SignUpCommand command) {
        UserInfo userInfo = UserInfo.signUp(
                command.email(),
                encryptPassword(command.plainPassword()),
                command.name(),
                command.phoneNumber()
        );

        return userSavePort.signUp(userInfo);
    }

    @Transactional
    @Override
    public UserInfo signIn(SignInCommand command) {
        // 유저 조회
        UserInfo userInfo = userLoadPort.findByEmail(command.email());

        // 패스워드 비교
        boolean isMatchedPassword = isMatchedPassword(userInfo.getSecurePassword(), command.plainPassword());
        if (!isMatchedPassword) {
            throw new RuntimeException("//todo: ");
        }

        // 로그인 이벤트 발행
        userEventPort.publishSignInEvent(SignInEvent.builder()
                        .source(this)
                        .signInUserId(userInfo.getId())
                        .ip(command.ip())
                        .device(command.device())
                        .service("clone-bzm-lounge.kakao.com")
                        .type(SignInType.WEB)
                .build()
        );

        // 리턴
        return userInfo;
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

    private boolean isMatchedPassword(String securePassword, String plainPassword) {
        return securePassword.equals(plainPassword);
    }
}
