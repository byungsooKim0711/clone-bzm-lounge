package clone.bzm.lounge.notice.application.port.in.command;

import jakarta.validation.constraints.NotBlank;

public record NoticeCreateCommand(
        @NotBlank String title,
        @NotBlank String content,
        boolean fix
) {
}
