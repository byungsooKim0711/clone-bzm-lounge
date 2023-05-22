package clone.bzm.lounge.board.category.adapter.in.rest;

import clone.bzm.lounge.board.category.application.port.in.CategoryLoadUseCase;
import clone.bzm.lounge.common.ApiResult;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static clone.bzm.lounge.common.ApiResult.succeed;

@RequiredArgsConstructor
@RestController
class CategoryController {

    private final CategoryLoadUseCase loadUseCase;

    @GetMapping("/api/v1/category")
    public ResponseEntity<ApiResult<?>> getCategories() {
        return ResponseEntity.ok(
                succeed(loadUseCase.getCategories())
        );
    }

    // TODO: 카테고리 생성, 수정, ...
}
