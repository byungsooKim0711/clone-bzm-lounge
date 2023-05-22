package clone.bzm.lounge.notice.application.port.in;

import clone.bzm.lounge.notice.application.port.in.command.NoticeCreateCommand;
import clone.bzm.lounge.notice.domain.Notice;

import java.time.LocalDate;
import java.util.List;

public interface NoticeUseCase {

    List<Notice> getNotice();

    Notice getNotice(long noticeId);

    List<Notice> getPopupNotice(LocalDate now);

    Notice createNotice(NoticeCreateCommand command);
}
