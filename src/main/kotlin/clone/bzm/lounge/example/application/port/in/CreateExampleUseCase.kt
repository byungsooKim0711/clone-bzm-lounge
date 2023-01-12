package clone.bzm.lounge.example.application.port.`in`

import clone.bzm.lounge.example.adapter.`in`.web.dto.ExampleCreateRequest
import clone.bzm.lounge.example.domain.Example

interface CreateExampleUseCase {

    fun createExample(exampleCreateRequest: ExampleCreateRequest): Example
}