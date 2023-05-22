package clone.bzm.lounge.file.adapter.in.rest.dto;

import clone.bzm.lounge.file.domain.File;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class FileResponse {

    private final Long id;

    private final String fileName;
    private final String fileType;
    private final String filePath;
    private final String fileUrl;

    private final LocalDateTime createdAt;
    private final Long createdBy;

    protected FileResponse(Long id,
                           String fileName, String fileType, String filePath, String fileUrl,
                           LocalDateTime createdAt, Long createdBy) {
        this.id = id;
        this.fileName = fileName;
        this.fileType = fileType;
        this.filePath = filePath;
        this.fileUrl = fileUrl;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
    }

    public static FileResponse of(File file) {
        return new FileResponse(
                file.getId(),
                file.getName(),
                file.getType(),
                file.getPath(),
                file.getUrl(),
                file.getCreatedAt(),
                file.getCreatedBy()
        );
    }
}
