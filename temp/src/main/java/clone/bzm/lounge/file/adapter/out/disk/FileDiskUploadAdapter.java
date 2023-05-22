package clone.bzm.lounge.file.adapter.out.disk;

import clone.bzm.lounge.common.ResultCode;
import clone.bzm.lounge.common.exception.FileUploadException;
import clone.bzm.lounge.file.application.port.out.FileDiskUploadPort;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
class FileDiskUploadAdapter implements FileDiskUploadPort {

    private final static String DEFAULT_PATH = "/upload/file";

    @Override
    public String upload(MultipartFile file) {
        if (file == null || file.isEmpty()) {
            throw new FileUploadException(ResultCode.FILE_EMPTY_ERROR, "");
        }

        try {
            return createAndSaveFile(DEFAULT_PATH, "", file)
                    .toString();
        } catch (IOException e) {
            throw new FileUploadException(ResultCode.FILE_UPLOAD_ERROR, file.getOriginalFilename());
        }
    }

    public static Path createAndSaveFile(String path, String prefix, MultipartFile file) throws IOException {
        return saveFile(path, prefix, file, true);
    }

    public static Path saveFile(String path, String prefix, MultipartFile file, boolean checkDirectory) throws IOException {
        Path directory = Paths.get(path);

        if (checkDirectory && Files.notExists(directory)) {
            Files.createDirectories(directory);
        }

        Path tempPath = Files.createTempFile(directory, prefix, getExtensionWithDot(file.getOriginalFilename()));
        Files.write(tempPath, file.getBytes());

        return tempPath;
    }

    public static String getExtensionWithDot(String filename) {
        return "." + StringUtils.getFilenameExtension(filename);
    }
}
