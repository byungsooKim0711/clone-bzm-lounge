package clone.bzm.lounge.board.domain;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class Post {

    private Long id;

    private String serviceType;

    private String title;
    private String content;

    private boolean privacy;

    private List<Attachment> attachments;

    private List<Comment> comments;

    private Category category;

    private String progressStatus;

    private LocalDateTime completedAt;

    private LocalDateTime createdAt;
    private Long createdBy;
    private LocalDateTime modifiedAt;
    private Long modifiedBy;

    @Builder
    private Post(Long id, String serviceType, String title, String content,
                 boolean privacy, List<Attachment> attachments, List<Comment> comments, Category category,
                 String progressStatus, LocalDateTime completedAt, LocalDateTime createdAt, Long createdBy,
                 LocalDateTime modifiedAt, Long modifiedBy) {
        this.id = id;
        this.serviceType = serviceType;
        this.title = title;
        this.content = content;
        this.privacy = privacy;
        this.attachments = attachments;
        this.comments = comments;
        this.category = category;
        this.progressStatus = progressStatus;
        this.completedAt = completedAt;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.modifiedAt = modifiedAt;
        this.modifiedBy = modifiedBy;
    }
}
