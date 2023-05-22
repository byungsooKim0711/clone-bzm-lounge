package clone.bzm.lounge.example.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;


interface ExampleJpaRepository extends JpaRepository<ExampleJpaEntity, Long> {
}
