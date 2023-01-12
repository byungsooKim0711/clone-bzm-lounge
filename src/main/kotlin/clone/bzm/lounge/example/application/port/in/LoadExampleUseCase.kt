package clone.bzm.lounge.example.application.port.`in`

import clone.bzm.lounge.example.domain.Example

interface LoadExampleUseCase {

    fun findExampleById(id: String): Example
}