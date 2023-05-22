package clone.bzm.lounge.file.application.port.out;

import clone.bzm.lounge.file.domain.File;

public interface FileSavePort {

    File save(File file);
}
