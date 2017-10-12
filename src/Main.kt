import Mergesort.mergesort
import Mergesort.parallelMergesort
import Utilities.ListGenerator
import kotlin.system.measureTimeMillis

fun main(args: Array<String>) {
    val gen = ListGenerator()

    println("Insert size (0 >= size will be randomized):")
    val size = readLine()!!.toInt()

    val arraySeq = gen.generateIntArray(size)
    val arrayPar = arraySeq.copyOf()

    val sequentialTime = measureTimeMillis({ arraySeq.mergesort() })
    val parallelTime = measureTimeMillis({ arrayPar.parallelMergesort() })

    /*
    println("This is the generated Array:")
    arraySeq.forEach({ print("$it ") })

    println("\n\nThis is the ordenated Array (Sequential):")
    arraySeq.forEach({ print("$it ") })

    println("\n\nThis is the ordenated Array(Parallel):")
    arrayPar.forEach({ print("$it ") })
    */

    println("\n\nFinal times:")
    println("Sequential time = " + sequentialTime + " ms")
    println("Parallel time   = " + parallelTime + " ms")
}