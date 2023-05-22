package clone.bzm.lounge.common.exception;

import clone.bzm.lounge.common.ResultCode;
import lombok.Getter;

@Getter
public abstract class AbstractException extends RuntimeException {

    private final ResultCode resultCode;

    public AbstractException(ResultCode resultCode, String message) {
        super(message);
        this.resultCode = resultCode;
    }

    public AbstractException(ResultCode resultCode, String message, Throwable cause) {
        super(message, cause);
        this.resultCode = resultCode;
    }
}