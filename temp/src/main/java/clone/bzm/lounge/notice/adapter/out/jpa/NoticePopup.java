package clone.bzm.lounge.notice.adapter.out.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Embeddable
class NoticePopup {

    @Column(name = "popup")
    private boolean popup;

    @Column(name = "open_date")
    private LocalDate openDate;

    @Column(name = "close_date")
    private LocalDate closeDate;

    protected NoticePopup() {

    }

    protected NoticePopup(LocalDate openDate, LocalDate closeDate) {
        this.popup = true;
        this.openDate = openDate;
        this.closeDate = closeDate;
    }

    public static NoticePopup of(LocalDate open, LocalDate close) {
        return new NoticePopup(open, close);
    }

    public static NoticePopup nonPopupOf() {
        return new NoticePopup();
    }
}
