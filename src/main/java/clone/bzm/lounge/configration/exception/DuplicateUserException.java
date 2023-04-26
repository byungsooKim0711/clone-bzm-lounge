package clone.bzm.lounge.configration.exception;

import static clone.bzm.lounge.common.ResultCode.DUPLICATE_USERNAME_ERROR;

public class DuplicateUserException extends AbstractException {

    public static final String FORMAT_MESSAGE = "%s는 이미 존재하는 아이디입니다.";

    public DuplicateUserException(String username) {
        super(DUPLICATE_USERNAME_ERROR, String.format(FORMAT_MESSAGE, username));
    }

    public DuplicateUserException(String username, Throwable cause) {
        super(DUPLICATE_USERNAME_ERROR, String.format(FORMAT_MESSAGE, username), cause);
    }
}
