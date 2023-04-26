package clone.bzm.lounge.configration.exception;

import static clone.bzm.lounge.common.ResultCode.NO_MATCHED_PASSWORD_ERROR;

public class NoMatchedPasswordException extends AbstractException {

    public static final String FORMAT_MESSAGE = "비밀번호가 일치하지 않습니다.";

    public NoMatchedPasswordException() {
        super(NO_MATCHED_PASSWORD_ERROR, FORMAT_MESSAGE);
    }

    public NoMatchedPasswordException(Throwable cause) {
        super(NO_MATCHED_PASSWORD_ERROR, FORMAT_MESSAGE, cause);
    }
}
