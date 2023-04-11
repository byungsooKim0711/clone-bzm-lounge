package clone.bzm.lounge.user.adapter.in.rest.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UserSignInRequest {

    @NotEmpty
    private String email;

    @NotEmpty
    private String password;
}
