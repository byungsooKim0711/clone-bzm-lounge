package clone.bzm.lounge.board.category.adapter.out.jpa;

import clone.bzm.lounge.board.domain.Category;
import clone.bzm.lounge.board.entity.CategoryJpaEntity;

import java.util.stream.Collectors;

class CategoryMapper {

    public static Category mapToDomainEntity(CategoryJpaEntity entity) {
        return Category.of(
                entity.getId(),
                entity.getName(),
                entity.getChildren()
                        .stream()
                        .map(CategoryMapper::mapToDomainEntity)
                        .collect(Collectors.toList())
        );
    }
}
