package clone.bzm.lounge.user.application.port.in.command;

import jakarta.validation.constraints.NotBlank;

public record ChangePasswordCommand(
        @NotBlank String email,
        @NotBlank String oldPassword,
        @NotBlank String newPassword,
        boolean sessionClear) {
}
