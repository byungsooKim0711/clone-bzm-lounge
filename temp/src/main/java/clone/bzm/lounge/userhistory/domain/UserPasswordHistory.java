package clone.bzm.lounge.userhistory.domain;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserPasswordHistory {

    private Long userId;

    private LocalDateTime modifiedAt;

    @Builder
    public UserPasswordHistory(Long userId, LocalDateTime modifiedAt) {
        this.userId = userId;
        this.modifiedAt = modifiedAt;
    }
}
