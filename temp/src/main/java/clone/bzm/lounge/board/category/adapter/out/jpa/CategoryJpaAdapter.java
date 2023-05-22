package clone.bzm.lounge.board.category.adapter.out.jpa;

import clone.bzm.lounge.board.category.application.port.out.CategoryLoadPort;
import clone.bzm.lounge.board.domain.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Repository
class CategoryJpaAdapter implements CategoryLoadPort {

    private final CategoryJpaRepository repository;

    @Override
    public List<Category> getCategories() {
        return repository.findByCategoriesParentIsNull()
                .stream()
                .map(CategoryMapper::mapToDomainEntity)
                .collect(Collectors.toList());
    }
}
