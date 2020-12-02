package world.gregs.aoc

import java.io.File

interface Challenge {
    fun readInput(file: String = "input"): List<String> {
        return File("./src/main/resources/${this::class.java.packageName.replace(".", "\\")}/$file").readLines()
    }
}