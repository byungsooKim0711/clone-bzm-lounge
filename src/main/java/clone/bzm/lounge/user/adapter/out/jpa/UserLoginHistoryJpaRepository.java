package clone.bzm.lounge.user.adapter.out.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

interface UserLoginHistoryJpaRepository extends JpaRepository<UserLoginHistoryJpaEntity, Long> {
}
