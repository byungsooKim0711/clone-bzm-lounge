package clone.bzm.lounge.userhistory.adapter.out.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

interface UserPasswordHistoryRepository extends JpaRepository<UserPasswordHistoryJpaEntity, Long> {
}
