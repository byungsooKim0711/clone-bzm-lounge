package clone.bzm.lounge.example.adapter.out.persistence

import clone.bzm.lounge.example.application.port.out.LoadExamplePort
import clone.bzm.lounge.example.domain.Example
import org.springframework.stereotype.Repository

@Repository
class ExamplePersistenceAdapter(private val exampleMapper: ExampleMapper,
                                private val exampleJpaRepository: ExampleJpaRepository) : LoadExamplePort {

    override fun load(id: String): Example {
        val exampleEntity = exampleJpaRepository.findExample(id).orElseThrow();
        return exampleMapper.toDomain(exampleEntity);
    }
}