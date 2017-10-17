import Utilities.TestController

fun main(args: Array<String>) {
    val test = TestController

    do {
        println("Insert Y\\N for manual test (\"Q\" to exit):")
        val opt = readLine()!!

        if (opt.equals("Y", true)) {
            println("Insert size (0 >= size will be randomized):")
            val size = readLine()!!.toInt()

            test.startManualTest(size)
        } else if (opt.equals("N", true)) {
            test.startGeneralTest()
        }
    } while (!opt.equals("Q", true))
}