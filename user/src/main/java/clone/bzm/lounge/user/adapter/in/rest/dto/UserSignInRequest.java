package clone.bzm.lounge.user.adapter.in.rest.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record UserSignInRequest(@NotEmpty @Email String email,
                                @NotEmpty String password) {
}
