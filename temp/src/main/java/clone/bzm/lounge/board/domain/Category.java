package clone.bzm.lounge.board.domain;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class Category {
    private Long id;
    private String name;

    private List<Category> subCategories;

    @Builder
    protected Category(Long id, String name, List<Category> subCategories) {
        this.id = id;
        this.name = name;
        this.subCategories = subCategories;
    }

    public static Category of(Long id, String name, List<Category> subCategories) {
        return new Category(id, name, subCategories);
    }
}
