package clone.bzm.lounge.notice.adapter.out.jpa;

import java.time.LocalDate;
import java.util.List;

public interface NoticeJpaCustomRepository {

    List<NoticeJpaEntity> findByNoticeBetweenOpenDateAndCloseDateAndIsPopup(LocalDate now);
}
