package clone.bzm.lounge.file.adapter.out.jpa;

import clone.bzm.lounge.file.application.port.out.FileSavePort;
import clone.bzm.lounge.file.domain.File;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
class FileJpaAdapter implements FileSavePort {

    private final FileJpaRepository repository;

    @Override
    public File save(File file) {
        FileJpaEntity entity = FileMapper.mapToJpaEntity(file);

        return FileMapper.mapToDomainEntity(repository.save(entity));
    }
}
