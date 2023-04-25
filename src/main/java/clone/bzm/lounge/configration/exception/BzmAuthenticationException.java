package clone.bzm.lounge.configration.exception;

public class BzmAuthenticationException extends RuntimeException {

    public BzmAuthenticationException(String message) {
        super(message);
    }

    public BzmAuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }
}
