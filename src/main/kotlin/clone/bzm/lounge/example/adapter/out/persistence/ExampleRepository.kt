package clone.bzm.lounge.example.adapter.out.persistence

import org.springframework.stereotype.Repository
import java.util.*

@Repository
class ExampleRepository {

    val exampleMap = mutableMapOf("example" to ExampleEntity("example", "Hexagonal entity example."))

    fun findExample(id: String): Optional<ExampleEntity> {
        return Optional.ofNullable(exampleMap[id]);
    }

    fun save(entity: ExampleEntity): ExampleEntity {
        exampleMap[entity.id] = entity;
        return exampleMap.getValue(entity.id)
    }
}