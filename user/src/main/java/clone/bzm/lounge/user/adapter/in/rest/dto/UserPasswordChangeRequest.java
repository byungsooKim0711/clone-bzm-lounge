package clone.bzm.lounge.user.adapter.in.rest.dto;

import jakarta.validation.constraints.NotBlank;

public record UserPasswordChangeRequest(
        @NotBlank String oldPassword,
        @NotBlank String newPassword,
        boolean sessionClear) {

}
