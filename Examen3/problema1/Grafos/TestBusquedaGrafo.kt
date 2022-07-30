/**
 * Programa cliente que prueba la implementacion de los algoritmos de busqueda
 */

fun main() {

    //se crea un grafo de 10 vertices
    val miGrafo = GrafoDirigido(10)

    // se agregan arcos
    miGrafo.agregarArco(Arco(0,1))
    miGrafo.agregarArco(Arco(0,2))
    miGrafo.agregarArco(Arco(2,4))
    miGrafo.agregarArco(Arco(1,3))
    miGrafo.agregarArco(Arco(3,5))
    miGrafo.agregarArco(Arco(5,6))
    miGrafo.agregarArco(Arco(4,7))
    miGrafo.agregarArco(Arco(2,8))
    miGrafo.agregarArco(Arco(8,9))
    miGrafo.agregarArco(Arco(6,9))

    // se instancian las clases DFS y BFS, respectivamente
    val dfs = DFS(miGrafo)
    val bfs = BFS(miGrafo)
    
    // se realizan algunas pruebas
    println(dfs.buscar(0,4))
    println(dfs.buscar(0,7))
    println(dfs.buscar(0,8))
    println(dfs.buscar(4,6)) // -1
    println(dfs.buscar(2,5)) // -1
    println(dfs.buscar(6,7)) // -1
    
    
    println(bfs.buscar(0,4)) 
    println(bfs.buscar(0,7)) 
    println(bfs.buscar(0,8)) 
    println(bfs.buscar(2,5)) // -1
    println(bfs.buscar(6,7)) // -1
    println(bfs.buscar(4,6)) // -1
}

