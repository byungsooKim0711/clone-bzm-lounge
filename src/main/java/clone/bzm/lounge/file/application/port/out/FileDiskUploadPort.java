package clone.bzm.lounge.file.application.port.out;

import org.springframework.web.multipart.MultipartFile;

public interface FileDiskUploadPort {

    String upload(MultipartFile file);
}
