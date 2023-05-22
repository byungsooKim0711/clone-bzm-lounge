package clone.bzm.lounge.file.application.port.in.command;

import jakarta.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;

public record FileUploadCommand(
        @NotNull MultipartFile file
) {
}
