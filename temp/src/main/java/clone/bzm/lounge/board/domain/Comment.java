package clone.bzm.lounge.board.domain;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class Comment {

    private Long id;

    private String serviceType;

    private String content;

    private boolean privacy;

    private List<Attachment> attachments;

    private List<Object> mentions;

    private List<Empathy> empathy;

    private Long createdBy;
    private LocalDateTime createdAt;
    private Long modifiedBy;
    private LocalDateTime modifiedAt;
}
