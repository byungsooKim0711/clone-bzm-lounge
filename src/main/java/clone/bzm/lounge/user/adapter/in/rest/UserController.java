package clone.bzm.lounge.user.adapter.in.rest;

import clone.bzm.lounge.user.adapter.in.rest.dto.UserResponse;
import clone.bzm.lounge.user.adapter.in.rest.dto.UserSignUpRequest;
import clone.bzm.lounge.user.application.port.in.UserUseCase;
import clone.bzm.lounge.user.application.port.in.UserUseCase.SignUpUserCommand;
import clone.bzm.lounge.user.domain.UserInfo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
class UserController {

    private final UserUseCase useCase;

    @PostMapping("/api/v1/user/sign-up")
    ResponseEntity<UserResponse> signUp(@RequestBody @Valid UserSignUpRequest request) {

        SignUpUserCommand command = new SignUpUserCommand(
                request.getEmail(),
                request.getPassword(),
                request.getName(),
                request.getPhoneNumber()
        );

        UserInfo registeredUser = useCase.signUp(command);

        return ResponseEntity.ok(
                UserResponse.of(registeredUser)
        );
    }
}
