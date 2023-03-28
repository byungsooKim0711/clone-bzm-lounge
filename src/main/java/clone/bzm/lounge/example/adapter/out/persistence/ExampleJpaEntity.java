package clone.bzm.lounge.example.adapter.out.persistence;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Getter
@Entity(name = "tb_example")
@Table
class ExampleJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 255, nullable = false)
    private String name;

    protected ExampleJpaEntity() {

    }

    @Builder
    protected ExampleJpaEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static ExampleJpaEntity from(String name) {
        return ExampleJpaEntity.builder()
                .name(name)
                .build();
    }

    static ExampleJpaEntity from(Long id, String name) {
        return ExampleJpaEntity.builder()
                .id(id)
                .name(name)
                .build();
    }

    ExampleJpaEntity updateName(String name) {
        this.name = name;
        return this;
    }
}
