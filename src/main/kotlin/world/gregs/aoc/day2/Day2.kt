package world.gregs.aoc.day2

import world.gregs.aoc.Challenge

object Day2 : Challenge {

    @JvmStatic
    fun main(args: Array<String>) {
        val regex = "(.*)-(.*)\\s([a-z]):\\s(.*)".toRegex()
        val input = readInput()
            .map { regex.matchEntire(it)!!.groupValues }
            .map { Triple(it[1].toInt()..it[2].toInt(), it[3][0], it[4]) }
        println(part1(input))
        println(part2(input))
    }

    private fun part1(input: List<Triple<IntRange, Char, String>>): Int {
        return input.count { (range, char, string) -> string.count { it == char } in range }
    }

    private fun part2(input: List<Triple<IntRange, Char, String>>): Int {
        return input.count { (range, char, string) ->
            val first = string[range.first - 1]
            val second = string[range.last - 1]
            (first == char || second == char) && first != second
        }
    }

}