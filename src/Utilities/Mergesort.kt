package Utilities

private fun IntArray.merge(numElementos : Int, begin : Int, mid : Int, end : Int) {
    val merged = IntArray(numElementos)
    var i = begin
    var j = mid
    var k = 0

    while (i < mid && j < end) {
        if (this[i] < this[j]) {
            merged[k] = this[i]
            i++
        } else {
            merged[k] = this[j]
            j++
        }
        k++
    }

    while (i < mid) {
        merged[k] = this[i]
        i++
        k++
    }

    while (j < end) {
        merged[k] = this[j]
        j++
        k++
    }

    var s = begin

    for (r in 0 until numElementos) {
        this[s] = merged[r]
        s++
    }
}

private fun IntArray.mergesort(begin : Int, end : Int) {
    val numElementos = end - begin + 1

    if (numElementos > 2) {
        val mid = (begin + end) / 2

        this.mergesort(begin, mid)
        this.mergesort(mid, end)
        this.merge(numElementos, begin, mid, end)
    } else if (numElementos == 2 && this[begin] > this[end]) {
        val temp = this[begin]

        this[begin] = this[end]
        this[end] = temp
    }
}

fun IntArray.mergesort() = mergesort(0, this.size)