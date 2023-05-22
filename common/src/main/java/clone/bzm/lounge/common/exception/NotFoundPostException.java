package clone.bzm.lounge.common.exception;

import static clone.bzm.lounge.common.ResultCode.BAD_REQUEST;

public class NotFoundPostException extends AbstractException {

    public static final String FORMAT_MESSAGE = "id: %s 게시글을 찾을 수 없습니다.";

    public NotFoundPostException(Long postId) {
        super(BAD_REQUEST, String.format(FORMAT_MESSAGE, postId));
    }
}
