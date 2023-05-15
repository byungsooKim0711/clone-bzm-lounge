package clone.bzm.lounge.board.category.application.port.out;

import clone.bzm.lounge.board.domain.Category;

import java.util.List;

public interface CategoryLoadPort {

    List<Category> getCategories();
}
