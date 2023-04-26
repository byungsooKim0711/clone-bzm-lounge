package clone.bzm.lounge.user.application.port.out.event;

import lombok.Builder;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import java.time.LocalDateTime;

@Getter
public class PasswordChangeEvent extends ApplicationEvent {

    private final Long userId;
    private final LocalDateTime modifiedAt;
    private final boolean sessionClear;

    @Builder
    public PasswordChangeEvent(Object source, Long userId, LocalDateTime modifiedAt, boolean sessionClear) {
        super(source);
        this.userId = userId;
        this.modifiedAt = modifiedAt;
        this.sessionClear = sessionClear;
    }
}
