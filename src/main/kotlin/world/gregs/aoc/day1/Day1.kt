package world.gregs.aoc.day1

import world.gregs.aoc.Challenge

object Day1 : Challenge {

    @JvmStatic
    fun main(args: Array<String>) {
        val input = readInput().map { it.toInt() }
        println(part1(input))
        println(part2(input))
    }

    private fun part1(input: List<Int>): Int {
        for (i1 in input) {
            for (i2 in input) {
                if (i1 + i2 == 2020) {
                    return i1 * i2
                }
            }
        }
        return -1
    }

    private fun part2(input: List<Int>): Int {
        for (i1 in input) {
            for (i2 in input) {
                for (i3 in input) {
                    if (i1 + i2 + i3 == 2020) {
                        return i1 * i2 * i3
                    }
                }
            }
        }
        return -1
    }
}