package Utilities

import java.util.Random

class ListGenerator {
    private val numMaxRange = 3000
    private val sizeMaxRange = 1000000

    private fun generateRandomSize() : Int {
        var size : Int
        var rnd = Random()

        do size = rnd.nextInt(sizeMaxRange) while (size % 2 != 0 && size == 0)

        return size
    }

    fun generateRndIntArray(size : Int): IntArray {
        return IntArray(if (size > 0) size else generateRandomSize()) { Random().nextInt(numMaxRange) }
    }
}