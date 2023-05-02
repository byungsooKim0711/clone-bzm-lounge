package clone.bzm.lounge.notice.adapter.out.jpa;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.time.LocalDate;
import java.util.List;

import static clone.bzm.lounge.notice.adapter.out.jpa.QNoticeJpaEntity.noticeJpaEntity;


public class NoticeJpaCustomRepositoryImpl extends QuerydslRepositorySupport implements NoticeJpaCustomRepository {

    private final JPAQueryFactory query;

    public NoticeJpaCustomRepositoryImpl(JPAQueryFactory query) {
        super(NoticeJpaEntity.class);
        this.query = query;
    }

    @Override
    public List<NoticeJpaEntity> findByNoticeBetweenOpenDateAndCloseDateAndIsPopup(LocalDate now) {
        return query.selectFrom(noticeJpaEntity)
                .where(
                        noticeJpaEntity.noticePopup.popup.isTrue(),
                        noticeJpaEntity.noticePopup.openDate.loe(now),
                        noticeJpaEntity.noticePopup.closeDate.goe(now)
                )
                .fetch();
    }
}
