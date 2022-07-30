/** Clase que extiende la clase abstracta Busqueda */
class BFS(val g: GrafoDirigido) : Busqueda() {
  
  val numeroDeVertices = g.obtenerNumeroDeVertices()
  val ListaDeVertices: Array<Vertice> = Array(numeroDeVertices, {i -> Vertice(i)})

    override fun buscar(D: Int, H: Int) : Int {
      ListaDeVertices[D].d = 0; ListaDeVertices[D].color = Color.GRIS;
      var explorados = 1
      var Q: MutableList<Vertice> = mutableListOf()
      Q.add(ListaDeVertices[D])
  
      while (!Q.isEmpty()) {
        var u: Vertice = Q[0] // almacena el vertice
        Q.removeAt(0) //desencola el vertice
  
        for (v in g.adyacentes(u.valor)) {
          if (ListaDeVertices[v.fin].color == Color.BLANCO) {
            explorados++
            if (v.fin == H) {
              return explorados
            }
            ListaDeVertices[v.fin].d = u.d + 1
            ListaDeVertices[v.fin].color = Color.GRIS
            Q.add(ListaDeVertices[v.fin])
          }
        }
        ListaDeVertices[u.valor].color = Color.NEGRO
      }
      return -1
    }
}
