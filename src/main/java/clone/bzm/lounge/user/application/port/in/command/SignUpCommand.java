package clone.bzm.lounge.user.application.port.in.command;

import jakarta.validation.constraints.NotEmpty;

public record SignUpCommand(
        @NotEmpty String email,
        @NotEmpty String plainPassword,
        @NotEmpty String name,
        @NotEmpty String phoneNumber) {
}