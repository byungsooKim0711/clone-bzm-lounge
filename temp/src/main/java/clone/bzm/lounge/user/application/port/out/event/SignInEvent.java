package clone.bzm.lounge.user.application.port.out.event;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class SignInEvent extends ApplicationEvent {

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
    public SignInEvent(Object source, Long signInUserId, String device, String ip, String service, SignInType type) {
        super(source);
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
