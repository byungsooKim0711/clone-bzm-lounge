package clone.bzm.lounge.board.category.adapter.out.jpa;

import clone.bzm.lounge.board.entity.CategoryJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryJpaRepository extends JpaRepository<CategoryJpaEntity, Long>, CategoryJpaCustomRepository {
}
