package clone.bzm.lounge.notice.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class Notice {

    private Long id;

    private Long categoryId;

    private String title;

    private String content;

    private String fileName;

    private String filePath;

//    private int pinLevel;

    private boolean fix;

    private boolean popup;

    private LocalDate popupOpenDate;
    private LocalDate popupCloseDate;

    private Long createdBy;
    private Long modifiedBy;

    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    @Builder(access = AccessLevel.PUBLIC)
    protected Notice(Long id, Long categoryId, String title, String content, String fileName, String filePath,
                     boolean fix, boolean popup, LocalDate popupOpenDate, LocalDate popupCloseDate,
                     Long createdBy, Long modifiedBy, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.categoryId = categoryId;
        this.title = title;
        this.content = content;
        this.fileName = fileName;
        this.filePath = filePath;
        this.fix = fix;
        this.popup = popup;
        this.popupOpenDate = popupOpenDate;
        this.popupCloseDate = popupCloseDate;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public static Notice createPopupNotice(String title, String content, String fileName, String filePath, boolean fix,
                                           LocalDate openDate, LocalDate closeDate) {
        return Notice.builder()
                .title(title)
                .content(content)
                .fileName(fileName)
                .filePath(filePath)
                .fix(fix)
                .popup(true)
                .popupOpenDate(openDate)
                .popupCloseDate(closeDate)
                .build();
    }

    public static Notice createNotice(String title, String content, String fileName, String filePath, boolean fix) {
        return Notice.builder()
                .title(title)
                .content(content)
                .fileName(fileName)
                .filePath(filePath)
                .fix(fix)
                .build();
    }
}
