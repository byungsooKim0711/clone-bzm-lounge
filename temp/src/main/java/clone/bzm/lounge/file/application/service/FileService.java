package clone.bzm.lounge.file.application.service;

import clone.bzm.lounge.file.application.port.in.FileUseCase;
import clone.bzm.lounge.file.application.port.in.command.FileUploadCommand;
import clone.bzm.lounge.file.application.port.out.FileSavePort;
import clone.bzm.lounge.file.application.port.out.FileDiskUploadPort;
import clone.bzm.lounge.file.application.port.out.FileStorageUploadPort;
import clone.bzm.lounge.file.domain.File;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Service
public class FileService implements FileUseCase {

    private final FileSavePort savePort;
    private final FileDiskUploadPort diskUploadPort;
    private final FileStorageUploadPort storageUploadPort;

    @Transactional
    @Override
    public File save(FileUploadCommand command) {
        MultipartFile requestFile = command.file();

        String filePath = diskUploadPort.upload(requestFile);
        String fileUrl = storageUploadPort.upload(requestFile);
        String fileName = requestFile.getOriginalFilename();
        String fileType = requestFile.getContentType();

        return savePort.save(
                File.create(fileName, fileType, filePath, fileUrl)
        );
    }
}
