import ParallelMergesort.ParallelMergesort
import Utilities.ListGenerator
import kotlin.system.measureNanoTime

fun main(args: Array<String>) {
    val gen = ListGenerator()
    val array = gen.generateIntArray()

    println("This is the generated Array:")
    array.forEach { println(it) }

    val sorter = ParallelMergesort()

    println("This is the ordenated Array(Parallel):")
    val parallelTime = measureNanoTime {
        sorter.calculate(array).forEach { println(it) }
    }

    println("This is the ordenated Array (Sequential):")
    val sequentialTime = measureNanoTime {
        array.sort()
        array.forEach { println(it) }
    }

    println("Sequential time = " + sequentialTime + " nanoseconds")
    println("Parallel time = " + parallelTime + " nanoseconds")
}