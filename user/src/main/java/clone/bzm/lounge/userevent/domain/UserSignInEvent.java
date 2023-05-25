package clone.bzm.lounge.userevent.domain;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UserSignInEvent {

    @NotNull
    private final Long signInUserId;

    @NotEmpty
    private final String device;

    @NotEmpty
    private final String ip;

    @NotEmpty
    private final String service;

    @NotEmpty
    private final SignInType type;

    @Builder
    public UserSignInEvent(Long signInUserId, String device, String ip, String service, SignInType type) {
        this.signInUserId = signInUserId;
        this.device = device;
        this.ip = ip;
        this.service = service;
        this.type = type;
    }

    public enum SignInType {

        WEB,
        QR,
        ;
    }
}
