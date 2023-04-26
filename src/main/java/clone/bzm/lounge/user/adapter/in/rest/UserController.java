package clone.bzm.lounge.user.adapter.in.rest;

import clone.bzm.lounge.common.ApiResult;
import clone.bzm.lounge.configration.security.BzmMember;
import clone.bzm.lounge.configration.security.BzmUserAuthentication;
import clone.bzm.lounge.user.adapter.in.rest.dto.UserPasswordChangeRequest;
import clone.bzm.lounge.user.adapter.in.rest.dto.UserResponse;
import clone.bzm.lounge.user.adapter.in.rest.dto.UserSignInRequest;
import clone.bzm.lounge.user.adapter.in.rest.dto.UserSignUpRequest;
import clone.bzm.lounge.user.adapter.in.rest.util.ServletRequestHelper;
import clone.bzm.lounge.user.application.port.in.UserUseCase;
import clone.bzm.lounge.user.application.port.in.command.ChangePasswordCommand;
import clone.bzm.lounge.user.application.port.in.command.SignInCommand;
import clone.bzm.lounge.user.application.port.in.command.SignUpCommand;
import clone.bzm.lounge.user.domain.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
class UserController {

    private final UserUseCase useCase;

    /**
     * 회원가입
     */
    @PostMapping("/api/v1/user/sign-up")
    ResponseEntity<UserResponse> signUp(@RequestBody @Valid UserSignUpRequest request) {

        SignUpCommand command = new SignUpCommand(
                request.email(),
                request.password(),
                request.name(),
                request.phoneNumber()
        );

        User registeredUser = useCase.signUp(command);

        return ResponseEntity.ok(
                UserResponse.of(registeredUser)
        );
    }

    /**
     * 로그인
     */
    @PostMapping("/api/v1/user/sign-in")
    ResponseEntity<UserResponse> signIn(@RequestBody @Valid UserSignInRequest request,
                                        HttpServletRequest servletRequest) {

        SignInCommand command = new SignInCommand(
                request.email(),
                request.password(),
                ServletRequestHelper.getRemoteIp(servletRequest),
                ServletRequestHelper.getUserAgent(servletRequest)
        );

        User signInUser = useCase.signIn(command);

        return ResponseEntity.ok(
                UserResponse.of(signInUser)
        );
    }

    /**
     * QR 로그인
     */
    @PostMapping("/api/v1/user/sign-in-qr")
    ResponseEntity<UserResponse> signInQr() {
        throw new UnsupportedOperationException("//todo:");
    }

    /**
     * 비밀번호 변경
     */
    @PostMapping("/api/v1/user/change-password")
    ResponseEntity<ApiResult<Void>> changePassword(@BzmMember BzmUserAuthentication authentication,
                                                   @RequestBody @Valid UserPasswordChangeRequest request) {

        ChangePasswordCommand command = new ChangePasswordCommand(
                authentication.email(),
                request.oldPassword(),
                request.newPassword(),
                request.sessionClear()
        );

        useCase.changePassword(command);

        return ResponseEntity.ok(ApiResult.succeed());
    }

    /**
     * 본인 정보 조회
     */
    @GetMapping("/api/v1/user/me")
    ResponseEntity<UserResponse> me(@BzmMember BzmUserAuthentication authentication) {
        throw new UnsupportedOperationException("//todo:");
    }
}
