package clone.bzm.lounge.board.post.adapter.out.jpa;

import clone.bzm.lounge.board.entity.PostJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

interface PostJpaRepository extends JpaRepository<PostJpaEntity, Long>, PostJpaCustomRepository {
}
