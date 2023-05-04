package clone.bzm.lounge.common;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum ResultCode {

    SUCCESS("0000"),

    AUTHENTICATION_ERROR("2000"),
    DUPLICATE_USERNAME_ERROR("2001"),
    NO_MATCHED_PASSWORD_ERROR("2002"),

    BAD_REQUEST("4000"),
    NOT_FOUND("4040"),

    FILE_EMPTY_ERROR("5000"),
    FILE_UPLOAD_ERROR("5001"),

    INTERNAL_SERVER_ERROR("9999"),
    ;

    private final String resultCode;

    ResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    @JsonValue
    public String getResultCode() {
        return this.resultCode;
    }

    private static final Map<String, ResultCode> resultCodeMap =
            Arrays.stream(values())
                    .collect(Collectors.toMap(ResultCode::getResultCode, Function.identity()));

    public static ResultCode fromValue(String resultCode) {
        return resultCodeMap.get(resultCode);
    }
}