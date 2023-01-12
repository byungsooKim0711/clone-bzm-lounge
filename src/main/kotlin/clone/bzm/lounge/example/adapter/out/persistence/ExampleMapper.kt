package clone.bzm.lounge.example.adapter.out.persistence

import clone.bzm.lounge.example.domain.Example
import org.springframework.stereotype.Component

@Component
class ExampleMapper {

    fun toDomain(entity: ExampleEntity) : Example {
        return Example(entity.id, entity.name)
    }

    fun toEntity(domain: Example): ExampleEntity {
        return ExampleEntity(domain.id, domain.name)
    }
}