package clone.bzm.lounge.board.post.adapter.out.jpa;

import clone.bzm.lounge.board.entity.PostJpaEntity;
import clone.bzm.lounge.board.post.application.port.in.command.PostSearchCommand;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import io.micrometer.common.util.StringUtils;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import static clone.bzm.lounge.board.entity.QAttachmentJpaEntity.attachmentJpaEntity;
import static clone.bzm.lounge.board.entity.QCategoryJpaEntity.categoryJpaEntity;
import static clone.bzm.lounge.board.entity.QCommentJpaEntity.commentJpaEntity;
import static clone.bzm.lounge.board.entity.QPostAttachmentJpaEntity.postAttachmentJpaEntity;
import static clone.bzm.lounge.board.entity.QPostJpaEntity.postJpaEntity;

class PostJpaCustomRepositoryImpl extends QuerydslRepositorySupport implements PostJpaCustomRepository {

    private final JPAQueryFactory query;

    public PostJpaCustomRepositoryImpl(JPAQueryFactory query) {
        super(PostJpaEntity.class);
        this.query = query;
    }

    @Override
    public List<PostJpaEntity> searchPostList(PostSearchCommand command) {
        List<Long> postIds = query.select(postJpaEntity.id)
                .from(postJpaEntity)
                .offset(command.currentPage())
                .limit(command.pageSize())
                .fetch();

        return query.selectFrom(postJpaEntity)
                .join(postJpaEntity.comments, commentJpaEntity).fetchJoin()
                .where(
                        postJpaEntity.id.in(postIds),
                        keywordBuilder(command.keywordMatchOption(), command.keywordOption(), command.keyword()),
                        dateBuilder(command.dateOption(), command.startDate(), command.endDate())
                )
                .fetch();
    }

    @Override
    public Optional<PostJpaEntity> searchPostById(Long id) {
        return Optional.ofNullable(
                query.selectFrom(postJpaEntity)
                        .where(postJpaEntity.id.eq(id))
                        .leftJoin(postJpaEntity.attachments, postAttachmentJpaEntity).fetchJoin()
                        .leftJoin(postAttachmentJpaEntity.attachment, attachmentJpaEntity).fetchJoin()
                        .join(postJpaEntity.category, categoryJpaEntity).fetchJoin()
                        .fetchOne()
        );
    }

    private BooleanBuilder keywordBuilder(String keywordMatchOption, String keywordOption, String keyword) {
        BooleanBuilder builder = new BooleanBuilder();
        if (!StringUtils.isBlank(keyword)) {
            if ("ALL".equals(keywordOption)) {
                builder.and(postJpaEntity.title.containsIgnoreCase(keyword)
                        .or(postJpaEntity.content.containsIgnoreCase(keyword)));
            }
            if ("TITLE".equals(keywordOption)) {
                builder.and(postJpaEntity.title.containsIgnoreCase(keyword));
            }
            if ("CONTENT".equals(keywordOption)) {
                builder.and(postJpaEntity.content.containsIgnoreCase(keyword));
            }
        }

        return builder;
    }

    private BooleanBuilder dateBuilder(String dateOption, LocalDate startDate, LocalDate endDate) {
        BooleanBuilder builder = new BooleanBuilder();

        switch (dateOption) {
            case "CREATED_AT" -> {
                builder.and(postJpaEntity.createdAt.goe(startDate.atStartOfDay())
                        .and(postJpaEntity.createdAt.loe(endDate.atTime(LocalTime.MAX))));
            }
            case "COMPLETED_AT" -> {
                builder.and(postJpaEntity.completedAt.goe(startDate.atStartOfDay())
                        .and(postJpaEntity.completedAt.loe(endDate.atTime(LocalTime.MAX))));
            }
        }

        return builder;
    }
}
