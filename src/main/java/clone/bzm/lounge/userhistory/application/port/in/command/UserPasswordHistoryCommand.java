package clone.bzm.lounge.userhistory.application.port.in.command;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record UserPasswordHistoryCommand(
        @NotNull Long userId,
        @NotNull LocalDateTime modifiedAt) {
}
