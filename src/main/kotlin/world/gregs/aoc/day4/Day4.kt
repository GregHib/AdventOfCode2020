package world.gregs.aoc.day4

import world.gregs.aoc.Challenge

object Day4 : Challenge {

    @JvmStatic
    fun main(args: Array<String>) {
        val input = readInput()
        val passports = getPassports(input)
            .map { details -> details.split(" ").map { it.split(":") }.map { it[0] to it[1] }.toMap() }
        println(part1(passports))
        println(part2(passports))
    }

    private fun getPassports(input: List<String>): List<String> {
        val passports = mutableListOf<String>()
        var sublist = mutableListOf<String>()
        for (line in input) {
            if (line.isBlank()) {
                passports.add(sublist.joinToString(separator = " "))
                sublist = mutableListOf()
            } else {
                sublist.add(line)
            }
        }
        if (sublist.isNotEmpty()) {
            passports.add(sublist.joinToString(separator = " "))
        }
        return passports
    }

    private val expected = setOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid", "cid")
    private val hexRegex = "#[a-fA-F0-9]{6}".toRegex()
    private val eyeColours = setOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth")

    fun part1(passports: List<Map<String, String>>): Int {
        return passports.count { details -> validFieldName(details) }
    }

    private fun validFieldName(details: Map<String, String>): Boolean {
        return expected.all { key -> details.containsKey(key) || key == "cid" }
    }

    fun part2(passports: List<Map<String, String>>): Int {
        return passports.count { details -> validFieldName(details) && validFieldValues(details) }
    }

    private fun validFieldValues(details: Map<String, String>): Boolean {
        return details.all { (key, value) ->
            when (key) {
                "byr" -> value.toIntOrNull() in 1920..2002
                "iyr" -> value.toIntOrNull() in 2010..2020
                "eyr" -> value.toIntOrNull() in 2020..2030
                "hgt" -> {
                    when {
                        value.endsWith("cm") -> value.removeSuffix("cm").toIntOrNull() in 150..193
                        value.endsWith("in") -> value.removeSuffix("in").toIntOrNull() in 59..76
                        else -> false
                    }
                }
                "hcl" -> value.matches(hexRegex)
                "ecl" -> eyeColours.contains(value)
                "pid" -> value.length == 9 && value.toIntOrNull() != null
                "cid" -> true
                else -> false
            }
        }
    }
}