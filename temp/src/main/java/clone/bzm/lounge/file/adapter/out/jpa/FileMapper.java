package clone.bzm.lounge.file.adapter.out.jpa;

import clone.bzm.lounge.file.domain.File;

class FileMapper {

    static File mapToDomainEntity(FileJpaEntity entity) {
        return File.builder()
                .id(entity.getId())
                .type(entity.getType())
                .path(entity.getPath())
                .url(entity.getUrl())
                .name(entity.getName())
                .createdAt(entity.getCreatedAt())
                .createdBy(entity.getCreatedBy())
                .build();
    }

    static FileJpaEntity mapToJpaEntity(File domain) {
        return FileJpaEntity.from(
                domain.getName(),
                domain.getType(),
                domain.getPath(),
                domain.getUrl()
        );
    }
}
