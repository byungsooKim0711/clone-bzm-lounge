package clone.bzm.lounge.file.application.port.out;

import org.springframework.web.multipart.MultipartFile;

public interface FileStorageUploadPort {

    String upload(MultipartFile file);
}
