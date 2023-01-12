package clone.bzm.lounge.example.adapter.`in`.web

import clone.bzm.lounge.example.adapter.`in`.web.dto.ExampleCreateRequest
import clone.bzm.lounge.example.application.port.`in`.CreateExampleUseCase
import clone.bzm.lounge.example.application.port.`in`.LoadExampleUseCase
import clone.bzm.lounge.example.domain.Example
import org.springframework.web.bind.annotation.*

@RestController
class ExampleController(
    private val exampleUseCase: LoadExampleUseCase,
    private val createExampleUseCase: CreateExampleUseCase) {

    @GetMapping("/api/example/{exampleId}")
    fun findExampleById(@PathVariable exampleId: String): Example {
        return exampleUseCase.findExampleById(exampleId);
    }

    @PostMapping("/api/example")
    fun createExample(@RequestBody exampleCreateRequest: ExampleCreateRequest): Example {
        return createExampleUseCase.createExample(exampleCreateRequest)
    }
}