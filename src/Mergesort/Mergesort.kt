package Mergesort

internal fun IntArray.mergesort(init : Int, end : Int) {
    val numElem = end - init + 1
    if (numElem > 2) {
        val mid = (init + end) / 2
        mergesort(init, mid)
        mergesort(mid + 1, end)
        merge(numElem, init, mid, end)
    } else if (numElem == 2 && this[init] > this[end]) {
        val temp = this[init]
        this[init] = this[end]
        this[end] = temp
    }
}

private fun IntArray.merge(numElem : Int, init : Int, mid : Int, end : Int) {
    val merged = IntArray(numElem)
    var i = init
    var j = mid + 1
    var k = 0
    while (i <= mid && j <= end) {
        if (this[i] < this[j]) {
            merged[k] = this[i]
            i++
        } else {
            merged[k] = this[j]
            j++
        }
        k++
    }
    while (i <= mid) {
        merged[k] = this[i]
        i++
        k++
    }
    while (j <= end) {
        merged[k] = this[j]
        j++
        k++
    }
    var s = init
    for (r in 0 until numElem) {
        this[s] = merged[r]
        s++
    }

}

fun IntArray.mergesort() = mergesort(0, this.size - 1)