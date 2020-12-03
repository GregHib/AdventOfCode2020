package world.gregs.aoc.day3

import world.gregs.aoc.Challenge

object Day3 : Challenge {

    @JvmStatic
    fun main(args: Array<String>) {
        val input = readInput()
        val grid = input.map { it.toCharArray().map { char -> char == '#' }.toBooleanArray() }
        println(getTreesEvery(grid, 3, 1))
        val part2 = arrayOf(
            getTreesEvery(grid, 1, 1),
            getTreesEvery(grid, 3, 1),
            getTreesEvery(grid, 5, 1),
            getTreesEvery(grid, 7, 1),
            getTreesEvery(grid, 1, 2)
        )
        println(part2.fold(1L) { total, trees -> total * trees })
    }

    private fun getTreesEvery(blocked: List<BooleanArray>, offsetX: Int, offsetY: Int): Int {
        var x = 0
        var y = 0
        var count = 0

        val width = blocked[0].size
        while (y < blocked.size) {
            if (blocked[y][x.rem(width)]) {
                count++
            }
            x += offsetX
            y += offsetY
        }
        return count
    }
}