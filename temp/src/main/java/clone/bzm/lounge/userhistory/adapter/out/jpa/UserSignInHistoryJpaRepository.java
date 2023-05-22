package clone.bzm.lounge.userhistory.adapter.out.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

interface UserSignInHistoryJpaRepository extends JpaRepository<UserSignInHistoryJpaEntity, Long> {
}
