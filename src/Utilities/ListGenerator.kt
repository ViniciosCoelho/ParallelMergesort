package Utilities

import java.util.Random

class ListGenerator {
    private fun generateSize() : Int {
        var size : Int
        var rnd = Random()

        do {
            size = rnd.nextInt(3000)
        } while (size % 2 != 0)

        return size
    }

    fun generateIntArray(): IntArray = IntArray(generateSize())
}