package clone.bzm.lounge.notice.application.port.in.command;

import clone.bzm.lounge.notice.domain.Notice;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record NoticeCreateCommand(
        @NotBlank String title,
        @NotBlank String content,
        boolean fix,
        boolean popup,
        LocalDate openDate,
        LocalDate closeDate
) {

    public Notice createNotice() {
        Notice createdNotice = null;
        if (popup) {
            createdNotice = Notice.createPopupNotice(
                    title(),
                    content(),
                    null,
                    null,
                    fix(),
                    openDate(),
                    closeDate()
            );
        } else {
            createdNotice = Notice.createNotice(
                    title(),
                    content(),
                    null,
                    null,
                    fix()
            );
        }

        return createdNotice;
    }
}
