package clone.bzm.lounge.configration.exception;

import static clone.bzm.lounge.common.ResultCode.NOT_FOUND;

public class NotFoundNoticeException extends AbstractException {

    public static final String FORMAT_MESSAGE = "공지를 찾을 수 없습니다.";

    public NotFoundNoticeException() {
        super(NOT_FOUND, FORMAT_MESSAGE);
    }

    public NotFoundNoticeException(Throwable cause) {
        super(NOT_FOUND, FORMAT_MESSAGE, cause);
    }
}
