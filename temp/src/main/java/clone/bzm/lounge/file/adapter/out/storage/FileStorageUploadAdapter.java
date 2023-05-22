package clone.bzm.lounge.file.adapter.out.storage;

import clone.bzm.lounge.file.application.port.out.FileStorageUploadPort;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
class FileStorageUploadAdapter implements FileStorageUploadPort {

    @Override
    public String upload(MultipartFile file) {
        // todo:
        return "https://localhost:8080/dn/0OL6v/1xtqLK2KHufGYon20vqOk/img_l.jpg";
    }
}
