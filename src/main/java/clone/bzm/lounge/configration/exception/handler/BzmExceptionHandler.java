package clone.bzm.lounge.configration.exception.handler;

import clone.bzm.lounge.common.ApiResult;
import clone.bzm.lounge.configration.exception.AbstractException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class BzmExceptionHandler {

    @ExceptionHandler
    public ApiResult<?> handle(AbstractException e) {
        return ApiResult.failed(e.getResultCode(), e.getMessage());
    }
}
