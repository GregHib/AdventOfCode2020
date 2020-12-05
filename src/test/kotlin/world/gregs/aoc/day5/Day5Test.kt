package world.gregs.aoc.day5

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import world.gregs.aoc.day5.Day5.getSeatId

internal class Day5Test {

    @Test
    fun `example passes`() {
        assertEquals(357, getSeatId("FBFBBFFRLR"))
        assertEquals(567, getSeatId("BFFFBBFRRR"))
        assertEquals(119, getSeatId("FFFBBBFRRR"))
        assertEquals(820, getSeatId("BBFFBBFRLL"))
    }
}
