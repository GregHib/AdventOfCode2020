package world.gregs.aoc.day5

import world.gregs.aoc.Challenge

object Day5 : Challenge {

    @JvmStatic
    fun main(args: Array<String>) {
        val input = readInput()
        println(part1(input))
        println(part2(input))
    }

    fun part1(boardingPasses: List<String>): Int {
        return boardingPasses.maxOf { pass -> getSeatId(pass) }
    }

    fun getSeatId(boardingPass: String): Int {
        var rows = (0..127).toList()
        var seats = (0..7).toList()
        for (char in boardingPass) {
            when (char) {
                'F' -> rows = takeLower(rows)
                'B' -> rows = takeUpper(rows)
                'L' -> seats = takeLower(seats)
                'R' -> seats = takeUpper(seats)
            }
        }
        val row = rows.first()
        val seat = seats.first()
        return getId(row, seat)
    }

    private fun takeLower(list: List<Int>): List<Int> {
        return list.subList(0, list.size / 2)
    }

    private fun takeUpper(list: List<Int>): List<Int> {
        return list.subList(list.size / 2, list.size)
    }

    fun part2(boardingPasses: List<String>): Int {
        val array = Array(128) { IntArray(8) { -1 } }
        boardingPasses.forEach { pass ->
            val id = getSeatId(pass)
            val row = id / 8
            val seat = id.rem(8)
            array[row][seat] = id
        }
        array.forEachIndexed { row, seats ->
            val seat = seats.indexOfFirst { it == -1 }
            if (seat > 1) {
                return getId(row, seat)
            }
        }
        return -1
    }

    private fun getId(row: Int, seat: Int) = row * 8 + seat

}