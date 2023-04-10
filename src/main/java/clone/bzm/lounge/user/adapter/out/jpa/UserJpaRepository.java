package clone.bzm.lounge.user.adapter.out.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface UserJpaRepository extends JpaRepository<UserJpaEntity, Long> {

    Optional<UserJpaEntity> findByEmail(UserEmail email);

    boolean existsByEmail(UserEmail email);
}
