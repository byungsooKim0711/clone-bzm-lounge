package clone.bzm.lounge.board.category.application.port.in;

import clone.bzm.lounge.board.domain.Category;

import java.util.List;

public interface CategoryLoadUseCase {

    List<Category> getCategories();
}
