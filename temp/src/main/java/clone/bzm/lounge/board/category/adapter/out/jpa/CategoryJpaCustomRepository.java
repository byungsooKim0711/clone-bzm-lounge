package clone.bzm.lounge.board.category.adapter.out.jpa;

import clone.bzm.lounge.board.entity.CategoryJpaEntity;

import java.util.List;

interface CategoryJpaCustomRepository {

    List<CategoryJpaEntity> findByCategoriesParentIsNull();
}
