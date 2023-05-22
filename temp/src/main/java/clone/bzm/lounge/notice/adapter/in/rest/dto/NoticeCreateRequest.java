package clone.bzm.lounge.notice.adapter.in.rest.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record NoticeCreateRequest(
        @NotBlank String title,
        @NotBlank String content,
        boolean fix,
        boolean popup,
        @JsonFormat(pattern = "yyyyMMdd") LocalDate openDate,
        @JsonFormat(pattern = "yyyyMMdd") LocalDate closeDate
) {
}
