package clone.bzm.lounge.common;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResult<T> {

    private String code;
    private String message;

    private T data;

    protected ApiResult() {

    }

    @Builder
    protected ApiResult(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> ApiResult<T> succeed() {
        return succeed(ResultCode.SUCCESS.getResultCode(), ResultCode.SUCCESS.name(), null);
    }

    public static <T> ApiResult<T> succeed(T data) {
        return succeed(ResultCode.SUCCESS.getResultCode(), ResultCode.SUCCESS.name(), data);
    }

    private static <T> ApiResult<T> succeed(String code, String message, T data) {
        return ApiResult.<T>builder()
                .code(code)
                .message(message)
                .data(data)
                .build();
    }

    public static <T> ApiResult<T> failed(ResultCode resultCode) {
        return failed(resultCode.getResultCode(), resultCode.name());
    }

    public static <T> ApiResult<T> failed(ResultCode resultCode, String message) {
        return failed(resultCode.getResultCode(), message);
    }

    public static <T> ApiResult<T> failed(String code, String message) {
        return ApiResult.<T>builder()
                .code(code)
                .message(message)
                .data(null)
                .build();
    }
}