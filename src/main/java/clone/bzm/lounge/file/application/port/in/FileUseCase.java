package clone.bzm.lounge.file.application.port.in;

import clone.bzm.lounge.file.application.port.in.command.FileUploadCommand;
import clone.bzm.lounge.file.domain.File;

public interface FileUseCase {

    File save(FileUploadCommand command);
}
