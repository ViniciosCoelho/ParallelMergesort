package Utilities

import java.io.File

class CSVBuilder {
    fun createCSV(times : Map<Long, Long>) {
        File("Test.csv").bufferedWriter().use { out ->
            times.forEach { out.write("${it.key}, ${it.value}\n") }
        }
    }
}