package clone.bzm.lounge.notice.adapter.in.rest.dto;

import jakarta.validation.constraints.NotBlank;

public record NoticeCreateRequest(
        @NotBlank String title,
        @NotBlank String content,
        boolean fix
) {
}
