package clone.bzm.lounge.user.application.port.in;

public interface UserUseCase {

    /** 가입 */
    void signIn();

    /** 로그인 */
    void signUp();

    /** 로그아웃 */
    void signOut();

    /** 비밀번호 변경 */
    void changePassword();
}
