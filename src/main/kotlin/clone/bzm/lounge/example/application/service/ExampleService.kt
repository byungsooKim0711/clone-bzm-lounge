package clone.bzm.lounge.example.application.service

import clone.bzm.lounge.example.adapter.`in`.web.dto.ExampleCreateRequest
import clone.bzm.lounge.example.application.port.`in`.CreateExampleUseCase
import clone.bzm.lounge.example.application.port.`in`.LoadExampleUseCase
import clone.bzm.lounge.example.application.port.out.LoadExamplePort
import clone.bzm.lounge.example.application.port.out.SaveExamplePort
import clone.bzm.lounge.example.domain.Example
import org.springframework.stereotype.Service

@Service
class ExampleService(
    private val loadExamplePort: LoadExamplePort,
    private val saveExamplePort: SaveExamplePort
) : LoadExampleUseCase, CreateExampleUseCase {

    override fun findExampleById(id: String): Example {
        return loadExamplePort.load(id);
    }

    override fun createExample(exampleCreateRequest: ExampleCreateRequest): Example {
        return saveExamplePort.save(Example(exampleCreateRequest.id, exampleCreateRequest.name));
    }
}