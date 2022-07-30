/** Clase que extiende la clase abstracta Busqueda con BFS*/
class BFS(val g: GrafoDirigido) : Busqueda() {
  
  val numeroDeVertices = g.obtenerNumeroDeVertices()
  var listaDeVertices: Array<Vertice> = Array(numeroDeVertices, {i -> Vertice(i)})

    /**
     * Metodo sobrecargado que ejecuta el algoritmo de DFS para y retorna
     * la cantidad de vertices explorados.
     * No necesaramente el camino de menor costo
     */
    override fun buscar(D: Int, H: Int) : Int {
      listaDeVertices = Array(numeroDeVertices, {i -> Vertice(i)})
      listaDeVertices[D].d = 0; listaDeVertices[D].color = Color.GRIS;
      var nodosExplorados = 1
      var Q: MutableList<Vertice> = mutableListOf()
      Q.add(listaDeVertices[D])
  
      while (!Q.isEmpty()) {
        var u: Vertice = Q[0] // almacena el vertice
        Q.removeAt(0) //desencola el vertice
  
        for (v in g.adyacentes(u.valor)) {
          if (listaDeVertices[v.fin].color == Color.BLANCO) {
            nodosExplorados++
            if (v.fin == H) {
              return nodosExplorados
            }
            listaDeVertices[v.fin].d = u.d + 1
            listaDeVertices[v.fin].color = Color.GRIS
            Q.add(listaDeVertices[v.fin])
          }
        }
        listaDeVertices[u.valor].color = Color.NEGRO
      }
      return -1
    }
}
