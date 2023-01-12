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

    // todo: 외부로 나가는건 domain이 나가는게 아니고 별도 ExampleResponse로 변경 필요한듯

    @GetMapping("/api/example/{exampleId}")
    fun findExampleById(@PathVariable exampleId: String): Example {
        return exampleUseCase.findExampleById(exampleId);
    }

    @PostMapping("/api/example")
    fun createExample(@RequestBody exampleCreateRequest: ExampleCreateRequest): Example {
        return createExampleUseCase.createExample(exampleCreateRequest)
    }
}