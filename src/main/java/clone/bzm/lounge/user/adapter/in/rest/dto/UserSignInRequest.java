package clone.bzm.lounge.user.adapter.in.rest.dto;

import jakarta.validation.constraints.NotEmpty;

public record UserSignInRequest(@NotEmpty String email,
                                @NotEmpty String password) {
}
