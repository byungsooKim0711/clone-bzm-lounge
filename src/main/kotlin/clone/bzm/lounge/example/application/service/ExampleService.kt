package clone.bzm.lounge.example.application.service

import clone.bzm.lounge.example.application.port.`in`.ExampleUseCase
import clone.bzm.lounge.example.application.port.out.LoadExamplePort
import clone.bzm.lounge.example.domain.Example
import org.springframework.stereotype.Service

@Service
class ExampleService(private val loadExamplePort: LoadExamplePort) : ExampleUseCase {

    override fun example(id: String): Example {
        return loadExamplePort.load(id);
    }
}