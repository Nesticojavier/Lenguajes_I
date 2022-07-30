/**
 * Clase para asignarle atributos a los vertices
 */
public open class Vertice(val valor: Int) {
    var d: Int = Int.MAX_VALUE
    var f: Int = 0
    var color: Color = Color.BLANCO
    var pred: Vertice? = null
  } 
  
  enum class Color { NEGRO, GRIS, BLANCO }