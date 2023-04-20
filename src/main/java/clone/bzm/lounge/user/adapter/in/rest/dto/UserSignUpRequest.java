package clone.bzm.lounge.user.adapter.in.rest.dto;

import jakarta.validation.constraints.NotEmpty;

public record UserSignUpRequest(@NotEmpty String email,
                                @NotEmpty String password,
                                @NotEmpty String name,
                                @NotEmpty String phoneNumber) {
}
