package clone.bzm.lounge

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LoungeApplication

fun main(args: Array<String>) {
    runApplication<LoungeApplication>(*args)

    println("asdf")
}
