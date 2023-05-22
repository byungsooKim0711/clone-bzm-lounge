package clone.bzm.lounge.notice.adapter.out.jpa;

import clone.bzm.lounge.common.exception.NotFoundNoticeException;
import clone.bzm.lounge.notice.application.port.out.NoticeLoadPort;
import clone.bzm.lounge.notice.application.port.out.NoticeSavePort;
import clone.bzm.lounge.notice.domain.Notice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Repository
class NoticeJpaAdapter implements NoticeSavePort, NoticeLoadPort {

    private final NoticeJpaRepository repository;

    @Override
    public Notice findNotice(Long noticeId) {
        return repository.findById(noticeId)
                .map(NoticeMapper::mapToDomainEntity)
                .orElseThrow(NotFoundNoticeException::new);
    }

    @Override
    public List<Notice> findNotices() {
        return repository.findAll()
                .stream()
                .map(NoticeMapper::mapToDomainEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<Notice> findPopupNotices(LocalDate now) {
        return repository.findByNoticeBetweenOpenDateAndCloseDateAndIsPopup(now)
                .stream()
                .map(NoticeMapper::mapToDomainEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Notice saveNotice(Notice notice) {
        NoticeJpaEntity entity = NoticeMapper.mapToJpaEntity(notice);

        return NoticeMapper.mapToDomainEntity(repository.save(entity));
    }
}
