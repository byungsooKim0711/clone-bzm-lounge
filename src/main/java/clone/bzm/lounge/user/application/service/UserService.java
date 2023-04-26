package clone.bzm.lounge.user.application.service;

import clone.bzm.lounge.configration.exception.DuplicateUserException;
import clone.bzm.lounge.configration.security.JwtProvider;
import clone.bzm.lounge.user.application.port.in.UserUseCase;
import clone.bzm.lounge.user.application.port.in.command.ChangePasswordCommand;
import clone.bzm.lounge.user.application.port.in.command.SignInCommand;
import clone.bzm.lounge.user.application.port.in.command.SignUpCommand;
import clone.bzm.lounge.user.application.port.out.event.PasswordChangeEvent;
import clone.bzm.lounge.user.application.port.out.event.SignInEvent;
import clone.bzm.lounge.user.application.port.out.event.SignInEvent.SignInType;
import clone.bzm.lounge.user.application.port.out.event.UserEventPort;
import clone.bzm.lounge.user.application.port.out.jpa.UserLoadPort;
import clone.bzm.lounge.user.application.port.out.jpa.UserSavePort;
import clone.bzm.lounge.user.domain.User;
import clone.bzm.lounge.user.domain.UserToken;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class UserService implements UserUseCase {

    private final UserLoadPort userLoadPort;
    private final UserSavePort userSavePort;
    private final UserEventPort userEventPort;

    @Transactional
    @Override
    public User signUp(SignUpCommand command) {
        boolean exists = userLoadPort.existsByEmail(command.email());
        if (exists) {
            throw new DuplicateUserException(command.email());
        }

        return userSavePort.signUp(command);
    }

    @Transactional
    @Override
    public User signIn(SignInCommand command) {
        // 유저 조회
        User user = userLoadPort.findUser(command.email(), command.plainPassword());

        // 로그인 이벤트 발행
        userEventPort.publishSignInEvent(SignInEvent.builder()
                .source(this)
                .signInUserId(user.getId())
                .ip(command.ip())
                .device(command.device())
                .service("clone-bzm-lounge.kakao.com")
                .type(SignInType.WEB)
                .build()
        );

        String token = JwtProvider.generateToken(user);

        user.addToken(new UserToken(token));

        // 리턴
        return user;
    }

    @Override
    public void signOut() {

    }

    @Transactional
    @Override
    public void changePassword(ChangePasswordCommand command) {
        User user = userSavePort.changePassword(command);

        userEventPort.publishPasswordEvent(PasswordChangeEvent.builder()
                        .source(this)
                        .userId(user.getId())
                        .sessionClear(command.sessionClear())
                        .modifiedAt(LocalDateTime.now())
                .build()
        );
    }
}
