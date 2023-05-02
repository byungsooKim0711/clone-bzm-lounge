package clone.bzm.lounge.notice.application.port.out;

import clone.bzm.lounge.notice.domain.Notice;

import java.time.LocalDate;
import java.util.List;

public interface NoticeLoadPort {

    Notice findNotice(Long noticeId);

    List<Notice> findNotices();

    List<Notice> findPopupNotices(LocalDate now);
}
