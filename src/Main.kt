import Mergesort.mergesort
import Mergesort.parallelMergesort
import Utilities.ListGenerator
import kotlin.system.measureTimeMillis

fun main(args: Array<String>) {
    val gen = ListGenerator()

    val arraySeq = gen.generateIntArray(67108864)
    val arrayPar = arraySeq.copyOf()

    println("This is the generated Array:")
    // arraySeq.forEach({ print("$it ") })

    println("\n\nThis is the ordenated Array (Sequential):")
    val sequentialTime = measureTimeMillis({ arraySeq.mergesort() })
    // arraySeq.forEach({ print("$it ") })

    println("\n\nThis is the ordenated Array(Parallel):")
    val parallelTime = measureTimeMillis({ arrayPar.parallelMergesort() })
    // arrayPar.forEach({ print("$it ") })

    println("\n\nFinal times:")
    println("Sequential time = " + sequentialTime + " ms")
    println("Parallel time   = " + parallelTime + " ms")
}