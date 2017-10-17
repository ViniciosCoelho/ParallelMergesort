package Mergesort

import java.util.concurrent.Semaphore
import kotlin.concurrent.thread

private var array : IntArray? = null

private val IntArray.maxProc: Int
get() = Runtime.getRuntime().availableProcessors()

private val IntArray.maxLevel : Int
get() = (Math.log(maxProc.toDouble()) / Math.log(2.0)).toInt()

private fun IntArray.parallelCalc(init: Int, end: Int, level: Int) {
    val sem1Next = Semaphore(0)
    val sem2Next = Semaphore(0)

    val mid: Int = (init + end) / 2

    thread (true) { parallelSplit(init, mid, level + 1, sem1Next) }
    thread(true) { parallelSplit(mid + 1, end, level + 1, sem2Next) }

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

    if (size >= maxProc * 2) {
        array = this
        parallelCalc(0, end, 1)
    }

    this.mergesort(0, end)
}