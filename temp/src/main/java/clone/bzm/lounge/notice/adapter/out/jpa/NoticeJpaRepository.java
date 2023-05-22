package clone.bzm.lounge.notice.adapter.out.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

interface NoticeJpaRepository extends JpaRepository<NoticeJpaEntity, Long>, NoticeJpaCustomRepository {

}
