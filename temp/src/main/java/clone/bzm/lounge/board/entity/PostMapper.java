package clone.bzm.lounge.board.entity;

import clone.bzm.lounge.board.domain.Post;

public class PostMapper {

    public static Post mapToDomainEntity(PostJpaEntity entity) {
        Post.PostBuilder builder = Post.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .content(entity.getContent())
                .privacy(entity.isPrivacy())
                .progressStatus(entity.getProgressStatus())
                .completedAt(entity.getCompletedAt())
                .createdAt(entity.getCreatedAt())
                .modifiedAt(entity.getModifiedAt())
                .createdBy(entity.getCreatedBy())
                .modifiedBy(entity.getModifiedBy())
//                .category(CategoryMapper.mapToDomainEntity(entity.getCategory()))
                // attachment
                ;

        return builder.build();
    }

//    static PostJpaEntity mapToJpaEntity(Post post) {
//
//    }
}
