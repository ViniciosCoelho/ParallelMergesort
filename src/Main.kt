import ParallelMergesort.ParallelMergesort
import Utilities.ListGenerator

var array : IntArray? = null

fun main(args: Array<String>) {
    val gen = ListGenerator()

    array = gen.generateIntArray()

    println("This is the generated Array:")
    array!!.forEach { println(it) }
    // println(Math.log(8.0) / Math.log(2.0))

    val sorter = ParallelMergesort()
    // sorter.calculate(array!!)

    println("This is the ordenated Array:")
    sorter.calculate(array!!).forEach { println(it) }
    // array!!.forEach { println(it) }
}