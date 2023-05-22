package clone.bzm.lounge.board.post.adapter.in.rest.dto;

import clone.bzm.lounge.board.domain.Post;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class PostSearchListResponse {

    private Long id;

    private String title;

    private String content;

    private boolean privacy;

    private Long createdBy;
    private LocalDateTime createdAt;
    private Long modifiedBy;
    private LocalDateTime modifiedAt;

    private LocalDateTime completedAt;

    private long commentCount;

    @Builder
    private PostSearchListResponse(Long id, String title, String content, boolean privacy,
                                  Long createdBy, LocalDateTime createdAt, Long modifiedBy, LocalDateTime modifiedAt,
                                  LocalDateTime completedAt,
                                  long commentCount) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.privacy = privacy;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.modifiedBy = modifiedBy;
        this.modifiedAt = modifiedAt;
        this.completedAt = completedAt;
        this.commentCount = commentCount;
    }

    public static List<PostSearchListResponse> of(@NotNull List<Post> posts) {
        return posts.stream()
                .map(post -> PostSearchListResponse.builder()
                        .id(post.getId())
                        .title(post.getTitle())
                        .content(post.getContent())
                        .privacy(post.isPrivacy())
                        .createdAt(post.getCreatedAt())
                        .createdBy(post.getCreatedBy())
                        .modifiedAt(post.getModifiedAt())
                        .modifiedBy(post.getModifiedBy())
                        .completedAt(post.getCompletedAt())
                        .commentCount(post.getComments() == null ? 0 : post.getComments().size())
                        .build()
                )
                .collect(Collectors.toList());
    }
}
