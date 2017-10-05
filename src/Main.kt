import ParallelMergesort.ParallelMergesort
import Utilities.ListGenerator

fun main(args: Array<String>) {
    val gen = ListGenerator()
    val array = gen.generateIntArray()

    println("This is the generated Array:")
    println(Math.log(1.0/3.0))

    //val sorter = ParallelMergesort()
    // sorter.calculate(array)

    println("This is the ordenated Array:")
    println(array)
}