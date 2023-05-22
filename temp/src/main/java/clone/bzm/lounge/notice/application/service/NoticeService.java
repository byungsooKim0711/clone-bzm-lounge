package clone.bzm.lounge.notice.application.service;

import clone.bzm.lounge.notice.application.port.in.NoticeUseCase;
import clone.bzm.lounge.notice.application.port.in.command.NoticeCreateCommand;
import clone.bzm.lounge.notice.application.port.out.NoticeLoadPort;
import clone.bzm.lounge.notice.application.port.out.NoticeSavePort;
import clone.bzm.lounge.notice.domain.Notice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
class NoticeService implements NoticeUseCase {

    private final NoticeLoadPort noticeLoadPort;
    private final NoticeSavePort noticeSavePort;

    @Transactional(readOnly = true)
    @Override
    public List<Notice> getNotice() {
        return noticeLoadPort.findNotices();
    }

    @Transactional(readOnly = true)
    @Override
    public Notice getNotice(long noticeId) {
        return noticeLoadPort.findNotice(noticeId);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Notice> getPopupNotice(LocalDate now) {
        return noticeLoadPort.findPopupNotices(now);
    }

    @Transactional
    @Override
    public Notice createNotice(NoticeCreateCommand command) {
        Notice notice = command.createNotice();

        return noticeSavePort.saveNotice(notice);
    }
}
