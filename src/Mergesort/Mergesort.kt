package Mergesort

private fun IntArray.mergesort(inicio: Int, fim: Int) {
    val numElementos = fim - inicio + 1
    if (numElementos > 2) {
        val meio = (inicio + fim) / 2
        mergesort(inicio, meio)
        mergesort(meio + 1, fim)
        merge(numElementos, inicio, meio, fim)
    } else if (numElementos == 2 && this[inicio] > this[fim]) { // entÃ£o, Ã© preciso inverter os dois elementos de v
        val temp = this[inicio]
        this[inicio] = this[fim]
        this[fim] = temp
    }
}

fun IntArray.merge(numElementos: Int, inicio: Int, meio: Int, fim: Int) {
    val merged = IntArray(numElementos)
    var i = inicio
    var j = meio + 1
    var k = 0
    while (i <= meio && j <= fim) {
        if (this[i] < this[j]) {
            merged[k] = this[i]
            i++
        } else {
            merged[k] = this[j]
            j++
        }
        k++
    }
    while (i <= meio) {
        merged[k] = this[i]
        i++
        k++
    }
    while (j <= fim) {
        merged[k] = this[j]
        j++
        k++
    }
    var s = inicio
    for (r in 0 until numElementos) {
        this[s] = merged[r]
        s++
    }

}

fun IntArray.mergesort() = mergesort(0, this.size - 1)