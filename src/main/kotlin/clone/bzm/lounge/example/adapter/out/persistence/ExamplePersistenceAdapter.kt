package clone.bzm.lounge.example.adapter.out.persistence

import clone.bzm.lounge.example.application.port.out.LoadExamplePort
import clone.bzm.lounge.example.application.port.out.SaveExamplePort
import clone.bzm.lounge.example.domain.Example
import org.springframework.stereotype.Repository

@Repository
class ExamplePersistenceAdapter(
    private val exampleMapper: ExampleMapper,
    private val exampleRepository: ExampleRepository
) : LoadExamplePort, SaveExamplePort {

    override fun load(id: String): Example {
        val exampleEntity = exampleRepository.findExample(id).orElseThrow();
        return exampleMapper.toDomain(exampleEntity)
    }

    override fun save(example: Example): Example {
        var entity = exampleMapper.toEntity(example)
        entity = exampleRepository.save(entity);

        return exampleMapper.toDomain(entity);
    }
}