import Utilities.mergesort
import Utilities.ListGenerator
import kotlin.system.measureNanoTime

fun main(args: Array<String>) {
    val gen = ListGenerator()

    val arraySeq = gen.generateIntArray(0)
    val arrayPar = arraySeq.copyOf()

    println("This is the generated Array:")
    // arraySeq.forEach { println(it) }

    println("\nThis is the ordenated Array (Sequential):")
    val sequentialTime = measureNanoTime { arraySeq.mergesort() }
    // arraySeq.forEach { println(it) }


    /* println("\nThis is the ordenated Array(Parallel):")
    val sorter = ParallelMergesort()
    val parallelTime = measureNanoTime { sorter.calculate(arrayPar) }
    // arrayPar.forEach { println(it) }
    */

    println("\nFinal times:")
    println("Sequential time = " + sequentialTime + " nanoseconds")
    // println("Parallel time   = " + parallelTime + " nanoseconds")
}