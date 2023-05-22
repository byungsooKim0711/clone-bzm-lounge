package clone.bzm.lounge.board.category.adapter.out.jpa;

import clone.bzm.lounge.board.entity.CategoryJpaEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

import static clone.bzm.lounge.board.entity.QCategoryJpaEntity.categoryJpaEntity;

public class CategoryJpaCustomRepositoryImpl extends QuerydslRepositorySupport implements CategoryJpaCustomRepository {

    private final JPAQueryFactory query;

    public CategoryJpaCustomRepositoryImpl(JPAQueryFactory query) {
        super(CategoryJpaEntity.class);
        this.query = query;
    }

    @Override
    public List<CategoryJpaEntity> findByCategoriesParentIsNull() {
        return query.selectFrom(categoryJpaEntity)
                .where(categoryJpaEntity.parent.isNull())
                .fetch();
    }
}
