package clone.bzm.lounge.board.domain;

import java.time.LocalDateTime;

public class Attachment {

    private Long id;

    private Long postId;

    private String fileType;

    private String fileUrl;

    private String fileName;

    private String thumbnailUrl;

    private String status;

    private Long createdBy;

    private LocalDateTime createdAt;
}