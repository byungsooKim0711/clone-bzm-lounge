package clone.bzm.lounge.file.adapter.out.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

interface FileJpaRepository extends JpaRepository<FileJpaEntity, Long> {
}
