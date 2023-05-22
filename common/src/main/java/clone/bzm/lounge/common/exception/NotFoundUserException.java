package clone.bzm.lounge.common.exception;

import static clone.bzm.lounge.common.ResultCode.NOT_FOUND;

public class NotFoundUserException extends AbstractException {

    public static final String FORMAT_MESSAGE = "%s 유저를 찾을 수 없습니다.";

    public NotFoundUserException(String username) {
        super(NOT_FOUND, String.format(FORMAT_MESSAGE, username));
    }

    public NotFoundUserException(String username, Throwable cause) {
        super(NOT_FOUND, String.format(FORMAT_MESSAGE, username), cause);
    }
}
