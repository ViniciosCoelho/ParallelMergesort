package ParallelMergesort

import java.util.concurrent.Semaphore

var array : IntArray? = null

class ParallelMergesort {
    private fun parallelCalc(range: IntRange, level : Int) {
        val sem1Next = Semaphore(0)
        val sem2Next = Semaphore(0)

        val midPos : Int = range.average().toInt()
        // val array1 = array.sliceArray(0 until midPos)
        // val array2 = array.sliceArray(midPos until array.size)

        Thread { calculate(0..midPos, level + 1, sem1Next) }.run()
        Thread { calculate(midPos..range.last, level + 1, sem2Next) }.run()

        sem1Next.acquire()
        sem2Next.acquire()
    }

    private fun calculate(range: IntRange, level : Int, semParent : Semaphore) {
        val procNum = Runtime.getRuntime().availableProcessors().toDouble()

        if (level < Math.log(procNum) / Math.log(2.0)) {
            parallelCalc(range, level)
        }

        array!!.sort(range.first, range.last)

        semParent.release()
    }

    fun calculate(arrayCalc : IntArray) {
        val sem1Next = Semaphore(0)
        val sem2Next = Semaphore(0)

        array = arrayCalc

        val mid = array!!.size!! / 2

        Thread { calculate(0..mid!!, 0, sem1Next) }.run()
        Thread { calculate(mid!!..array!!.size, 0, sem2Next) }.run()

        sem1Next.acquire()
        sem2Next.acquire()

        array?.sort()
    }
}