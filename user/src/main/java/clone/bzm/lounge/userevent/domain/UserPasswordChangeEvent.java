package clone.bzm.lounge.userevent.domain;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserPasswordChangeEvent {

    private final Long userId;
    private final LocalDateTime modifiedAt;
    private final boolean sessionClear;

    @Builder
    public UserPasswordChangeEvent(Long userId, LocalDateTime modifiedAt, boolean sessionClear) {
        this.userId = userId;
        this.modifiedAt = modifiedAt;
        this.sessionClear = sessionClear;
    }
}
