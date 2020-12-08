package world.gregs.aoc.day6

import world.gregs.aoc.Challenge

object Day6 : Challenge {

    @JvmStatic
    fun main(args: Array<String>) {
        val input = readInput()
        val groupAnswers = groupByLine(input)
        println(part1(groupAnswers))
        println(part2(groupAnswers))
    }

    // TODO duplicate of getPassports
    private fun groupByLine(lines: List<String>): List<List<String>> {
        val groups = mutableListOf<List<String>>()
        var group = mutableListOf<String>()
        lines.forEach { line ->
            if (line.isBlank()) {
                groups.add(group)
                group = mutableListOf()
            } else {
                group.add(line)
            }
        }
        if (group.isNotEmpty()) {
            groups.add(group)
        }
        return groups
    }

    fun part1(groups: List<List<String>>): Int {
        return groups.sumBy { answers -> answers(answers).distinct().size }
    }

    fun part2(groups: List<List<String>>): Int {
        return groups.sumBy { answers -> answers(answers).groupBy { it }.count { (_, list) -> list.size == answers.size } }
    }

    private fun answers(answers: List<String>) = answers.joinToString("").toCharArray()

}