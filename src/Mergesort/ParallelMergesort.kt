package Mergesort

import java.util.concurrent.Semaphore

private var array : IntArray? = null

private val IntArray.maxProc: Int
get() = Runtime.getRuntime().availableProcessors()

private val IntArray.maxLevel : Int
get() = (Math.log(maxProc.toDouble()) / Math.log(2.0)).toInt()

private fun IntArray.parallelCalc(init: Int, end: Int, level: Int) {
    val sem1Next = Semaphore(0)
    val sem2Next = Semaphore(0)

    val mid: Int = (init + end) / 2

    Thread { parallelSplit(init, mid, level + 1, sem1Next) }.start()
    Thread { parallelSplit(mid + 1, end, level + 1, sem2Next) }.start()

    sem1Next.acquire()
    sem2Next.acquire()
}

private fun IntArray.parallelSplit(init: Int, end: Int, level: Int, semParent: Semaphore) {
    if (level < maxLevel) {
        parallelCalc(init, end, level)
    } else {
        array!!.mergesort(init, end)
    }

    semParent.release()
}

fun IntArray.parallelMergesort() {
    val size = this.size
    val end = size - 1

    if (size >= maxProc * 2 ) {
        val sem1Next = Semaphore(0)
        val sem2Next = Semaphore(0)

        val mid = (end) / 2

        array = this


        Thread { parallelSplit(0, mid, 1, sem1Next) }.start()
        Thread { parallelSplit(mid + 1, end, 1, sem2Next) }.start()

        sem1Next.acquire()
        sem2Next.acquire()
    }

    this.mergesort(0, end)
}