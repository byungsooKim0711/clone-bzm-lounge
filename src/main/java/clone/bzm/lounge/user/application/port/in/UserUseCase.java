package clone.bzm.lounge.user.application.port.in;

import clone.bzm.lounge.user.domain.UserInfo;
import jakarta.validation.constraints.NotEmpty;

public interface UserUseCase {


    /**
     * 가입
     */
    UserInfo signUp(SignUpUserCommand command);

    /**
     * 로그인
     */
    void signIn();

    /**
     * 로그아웃
     */
    void signOut();

    /**
     * 비밀번호 변경
     */
    void changePassword();

    record SignUpUserCommand(
            @NotEmpty String email,
            @NotEmpty String plainPassword,
            @NotEmpty String name,
            @NotEmpty String phoneNumber) {
    }
}
