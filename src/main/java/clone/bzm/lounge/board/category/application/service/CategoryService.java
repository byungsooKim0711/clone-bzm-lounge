package clone.bzm.lounge.board.category.application.service;

import clone.bzm.lounge.board.category.application.port.in.CategoryLoadUseCase;
import clone.bzm.lounge.board.category.application.port.out.CategoryLoadPort;
import clone.bzm.lounge.board.domain.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
class CategoryService implements CategoryLoadUseCase {

    private final CategoryLoadPort loadPort;

    @Transactional(readOnly = true)
    @Override
    public List<Category> getCategories() {
        return loadPort.getCategories();
    }
}
