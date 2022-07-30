abstract class SerVivo() {
    abstract fun respirar()
}

class persona(val existir: Boolean) : SerVivo() {
    
    val grafo = existir
    override fun respirar() {
        println("Hola, estoy respirando..")
    }
    
    fun hablar() {
        if (grafo) {
            println("Hola, estoy hablando...")
        }
    }
}

fun main() {
    val miGrafo = GrafoDirigido(7)
    miGrafo.agregarArco(Arco(0,1))
    miGrafo.agregarArco(Arco(0,2))
    miGrafo.agregarArco(Arco(2,4))
    miGrafo.agregarArco(Arco(1,3))
    miGrafo.agregarArco(Arco(3,5))
    miGrafo.agregarArco(Arco(5,6))

    val bfs = BFS(miGrafo)
    println(bfs.buscar(4,6))
}

