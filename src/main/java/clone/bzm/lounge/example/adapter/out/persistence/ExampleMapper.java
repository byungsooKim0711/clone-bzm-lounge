package clone.bzm.lounge.example.adapter.out.persistence;

import clone.bzm.lounge.example.domain.Example;
import jakarta.validation.constraints.NotNull;

class ExampleMapper {

    static Example mapToDomainEntity(@NotNull ExampleJpaEntity entity) {
        return Example.withId(
                Example.ExampleId.of(entity.getId()),
                entity.getName()
        );
    }

    static ExampleJpaEntity mapToJpaEntity(@NotNull Example domain) {
        return ExampleJpaEntity.from(
                domain.getId().getValue(),
                domain.getName()
        );
    }
}
