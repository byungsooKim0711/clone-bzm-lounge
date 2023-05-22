package clone.bzm.lounge.common.exception;

import clone.bzm.lounge.common.ResultCode;

public class FileUploadException extends AbstractException {

    public static final String FORMAT_MESSAGE = "%s 파일 업로드에 실패하였습니다.";

    public FileUploadException(ResultCode resultCode, String filename) {
        super(resultCode, String.format(FORMAT_MESSAGE, filename));
    }
}
