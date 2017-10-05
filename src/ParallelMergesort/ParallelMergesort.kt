package ParallelMergesort

import java.util.concurrent.Semaphore

class ParallelMergesort {
    private fun parallelCalc(array : IntArray, level : Int) {
        val sem1Next = Semaphore(0)
        val sem2Next = Semaphore(0)

        val range1 = IntRange(0, array.size / 2)
        val range2 = IntRange(array.size / 2, array.size)

        val array1 = array.sliceArray(range1)
        val array2 = array.sliceArray(range2)

        Thread {calculate(array1, level + 1, sem1Next)}
        Thread {calculate(array2, level + 1, sem2Next)}

        sem1Next.acquire()
        sem2Next.acquire()
    }

    private fun calculate(array: IntArray, level : Int, semParent : Semaphore) {

        if (level < Math.log(2.0)) {
            parallelCalc(array, level)
        }

        array.sort()

        semParent.release()
    }

    fun calculate(array : IntArray) : IntArray {
        val sem1Next = Semaphore(0)
        val sem2Next = Semaphore(0)

        val range1 = IntRange(0, array.size / 2)
        val range2 = IntRange(array.size / 2, array.size)

        val array1 = array.sliceArray(range1)
        val array2 = array.sliceArray(range2)

        Thread {calculate(array1, 0, sem1Next)}
        Thread {calculate(array2, 0, sem2Next)}

        sem1Next.acquire()
        sem2Next.acquire()

        return array
    }
}