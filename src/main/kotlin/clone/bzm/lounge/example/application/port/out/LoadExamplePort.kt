package clone.bzm.lounge.example.application.port.out

import clone.bzm.lounge.example.domain.Example

interface LoadExamplePort {

    fun load(id: String): Example
}