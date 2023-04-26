package clone.bzm.lounge.configration.exception;

import static clone.bzm.lounge.common.ResultCode.AUTHENTICATION_ERROR;

public class AuthenticationException extends AbstractException {

    public AuthenticationException(String message) {
        super(AUTHENTICATION_ERROR, message);
    }

    public AuthenticationException(String message, Throwable cause) {
        super(AUTHENTICATION_ERROR, message, cause);
    }
}
