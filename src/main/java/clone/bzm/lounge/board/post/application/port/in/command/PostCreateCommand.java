package clone.bzm.lounge.board.post.application.port.in.command;

import com.fasterxml.jackson.databind.JsonNode;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record PostCreateCommand(
        @NotBlank String title,
        @NotBlank String content,
        boolean privacy,
        List<Long> attachmentsIds,
        List<Long> mentionedUserIds
) {
}
