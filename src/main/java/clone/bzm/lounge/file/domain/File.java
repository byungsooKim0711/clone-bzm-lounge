package clone.bzm.lounge.file.domain;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class File {

    private Long id;

    private String name;
    private String type;
    private String path;
    private String url;

    private LocalDateTime createdAt;
    private Long createdBy;

    protected File() {

    }

    @Builder
    protected File(Long id,
                   String name, String type, String path, String url, String status,
                   LocalDateTime createdAt, Long createdBy) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.path = path;
        this.url = url;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
    }

    public static File create(String name, String type, String path, String url) {
        return File.builder()
                .name(name)
                .type(type)
                .path(path)
                .url(url)
                .build();
    }
}
