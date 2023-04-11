package clone.bzm.lounge.userhistory.application.port.in.command;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record UserHistoryCommand(
        @NotNull Long signInUserId,
        @NotEmpty String device,
        @NotEmpty String ip,
        @NotEmpty String service,
        @NotEmpty String type) {
}
