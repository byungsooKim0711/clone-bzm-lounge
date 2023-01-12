package clone.bzm.lounge.example.application.port.`in`

import clone.bzm.lounge.example.domain.Example

interface ExampleUseCase {

    fun example(id: String): Example
}