package Utilities

import Mergesort.mergesort
import Mergesort.parallelMergesort
import kotlin.system.measureTimeMillis

object TestController {
    private val gen = ListGenerator()
    private val fileHandler = CSVBuilder()

    fun startManualTest(size : Int) {
        val arraySeq = gen.generateRndIntArray(size)
        val arrayPar = arraySeq.copyOf()

        /*
        println("This is the generated Array:")
        arraySeq.forEach({ print("$it ") })
        */

        val sequentialTime = measureTimeMillis({ arraySeq.mergesort() })
        val parallelTime = measureTimeMillis({ arrayPar.parallelMergesort() })

        /*
        println("\n\nThis is the ordenated Array (Sequential):")
        arraySeq.forEach({ print("$it ") })

        println("\n\nThis is the ordenated Array(Parallel):")
        arrayPar.forEach({ print("$it ") })
        */

        println("\n\nFinal times:")
        println("Sequential time = " + sequentialTime + " ms")
        println("Parallel time   = " + parallelTime + " ms")
    }

    fun startGeneralTest() {
        val times = HashMap<Long, Long>()

        println("Starting process...")

        for (n in 15..26) {
            val size= Math.pow(2.0, n.toDouble()).toInt()

            val arraySeq = gen.generateRndIntArray(size)
            val arrayPar = arraySeq.copyOf()

            val sequentialTime = measureTimeMillis({ arraySeq.mergesort() })
            val parallelTime = measureTimeMillis({ arrayPar.parallelMergesort() })

            times.put(sequentialTime, parallelTime)
        }

        println("Creating CSV...")
        fileHandler.createCSV(times)
        println("Process finished!")
    }
}