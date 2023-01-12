package clone.bzm.lounge.example.adapter.`in`.web

import clone.bzm.lounge.example.application.port.`in`.ExampleUseCase
import clone.bzm.lounge.example.domain.Example
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class ExampleController(private val exampleUseCase: ExampleUseCase) {

    @GetMapping("/api/example/{exampleId}")
    fun example(@PathVariable exampleId: String): Example {
        return exampleUseCase.example(exampleId);
    }
}