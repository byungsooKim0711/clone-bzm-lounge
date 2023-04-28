package clone.bzm.lounge.notice.adapter.out.jpa;

import clone.bzm.lounge.notice.domain.Notice;

class NoticeMapper {

    static Notice mapToDomainEntity(NoticeJpaEntity entity) {
        return Notice.builder()
                .id(entity.getId())
                .categoryId(entity.getCategoryId())
                .title(entity.getTitle())
                .content(entity.getContent())
//                .fileName(entity.getFileName())
//                .filePath(entity.getFilePath())
                .fix(entity.isFix())
                .popup(entity.getNoticePopup().isPopup())
                .popupOpenDate(entity.getNoticePopup().getOpenDate())
                .popupCloseDate(entity.getNoticePopup().getCloseDate())
                .createdBy(entity.getCreatedBy())
                .createdAt(entity.getCreatedAt())
                .modifiedBy(entity.getModifiedBy())
                .modifiedAt(entity.getModifiedAt())
                .build();
    }

    static NoticeJpaEntity mapToJpaEntity(Notice domain) {
        return NoticeJpaEntity.of(
                domain.getCategoryId(),
                domain.getTitle(),
                domain.getContent(),
                domain.isFix(),
                !domain.isPopup()
                        ? NoticePopup.nonPopupOf()
                        : NoticePopup.of(domain.getPopupOpenDate(), domain.getPopupCloseDate())
        );
    }
}
