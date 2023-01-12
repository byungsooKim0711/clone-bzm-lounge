package clone.bzm.lounge.example.adapter.out.persistence

import org.springframework.stereotype.Repository
import java.util.*

@Repository
class ExampleJpaRepository {

    val exampleMap: Map<String, ExampleEntity> =
        mapOf("example" to ExampleEntity("example", "Hexagonal entity example."))

    fun findExample(id: String): Optional<ExampleEntity> {
        return Optional.ofNullable(exampleMap[id]);
    }
}