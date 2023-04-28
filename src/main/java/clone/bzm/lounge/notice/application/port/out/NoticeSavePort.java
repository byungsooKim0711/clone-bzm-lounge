package clone.bzm.lounge.notice.application.port.out;

import clone.bzm.lounge.notice.domain.Notice;

public interface NoticeSavePort {

    Notice saveNotice(Notice notice);
}
