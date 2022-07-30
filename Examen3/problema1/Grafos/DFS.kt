/** Clase que extiende la clase abstracta Busqueda con DFS*/
public class DFS(val g: GrafoDirigido) : Busqueda() {

    val numeroDeVertices = g.obtenerNumeroDeVertices()
    var listaDeVertices: Array<Vertice> = Array(numeroDeVertices, {i -> Vertice(i)})
    var nodosExplorados: Int = 0 
    var objetivoEncontrado: Boolean = false
    
    /**
     * Metodo sobrecargado que ejecuta el algoritmo de DFS para y retorna
     * la cantidad de vertices explorados.
     * No necesaramente el camino de menor costo
     */
    override fun buscar(D: Int, H: Int) : Int {
      listaDeVertices = Array(numeroDeVertices, {i -> Vertice(i)})
      nodosExplorados = 0
      objetivoEncontrado = false

      dfsVisit(g, D, H)
      
      if (!objetivoEncontrado) {
        return -1
      }
      
      return this.nodosExplorados
    }
    
    /**
     * Algoritmo recursivo de DFS
     */
    private fun dfsVisit(g: GrafoDirigido, v: Int, H: Int) {

      if (v == H) {
        objetivoEncontrado = true
      }
      listaDeVertices[v].color = Color.GRIS       // asignar color que indica que ya fue descubierto
      nodosExplorados++                           // aumentar el contador de vertices explorados
      for (u in g.adyacentes(v)) {
        if (listaDeVertices[u.fin].color == Color.BLANCO && !objetivoEncontrado) {
            listaDeVertices[u.fin].pred = listaDeVertices[v]  // asignar el vertice v como predecesor de u
            dfsVisit(g, u.fin, H)
        } 
      }

      listaDeVertices[v].color = Color.NEGRO  // el vertice ya fue explorado
    }
  
}
