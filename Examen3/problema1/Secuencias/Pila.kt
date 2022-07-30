/**
 * Clase que implementa la interfaz Secuencia como un TAD pila
 */
class Pila<T> : Secuencia<T> {

    // variable privada para representar la coleccion
    private val pila: MutableList<T> = mutableListOf()

    /**
     * Metodo usado para agregar un elemento a la pila
     * Entrada: elemento a agregar
     * Salida: la pila con el elemento agregado
     */
    override fun agregar(valor: T) : Pila<T> {
        pila.add(valor)
        return this
    }

    /**
     * Metodo usado para eleminar un elemento de la pila
     * Salida: elemento removido
     */
    override fun remover() : T {
        if (this.vacio()) {
            throw NoSuchElementException("Error, la pila esta vacia")
        }
        return pila.removeLast()
    }

    /**
     * Metodo para determinar si la pila esta vacia
     * Salida: true si lo esta, false en caso contrario
     */
    override fun vacio() : Boolean {
        return pila.size == 0
    }

    /**
     * Retorna la representacion en string de una pila
     */
    override fun toString() : String {
        return pila.toString()
    }
}