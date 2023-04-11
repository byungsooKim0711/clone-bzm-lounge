package clone.bzm.lounge.user.application.port.in;

import clone.bzm.lounge.user.application.port.in.command.SignInCommand;
import clone.bzm.lounge.user.application.port.in.command.SignUpCommand;
import clone.bzm.lounge.user.domain.User;

public interface UserUseCase {

    /**
     * 가입
     */
    User signUp(SignUpCommand command);

    /**
     * 로그인
     */
    User signIn(SignInCommand command);

    /**
     * 로그아웃
     */
    void signOut();

    /**
     * 비밀번호 변경
     */
    void changePassword();
}
