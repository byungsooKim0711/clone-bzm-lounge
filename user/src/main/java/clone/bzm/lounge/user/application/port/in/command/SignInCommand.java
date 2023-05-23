package clone.bzm.lounge.user.application.port.in.command;

import jakarta.validation.constraints.NotEmpty;

public record SignInCommand(
        @NotEmpty String email,
        @NotEmpty String plainPassword,
        @NotEmpty String ip,
        @NotEmpty String device) {
}