package clone.bzm.lounge.example.application.port.out

import clone.bzm.lounge.example.domain.Example

interface SaveExamplePort {

    fun save(example: Example): Example
}