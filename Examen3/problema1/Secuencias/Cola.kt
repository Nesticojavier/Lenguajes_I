/**
 * Clase que implementa la interfaz Secuencia como un TAD cola
 */
class Cola<T> : Secuencia<T> {

    // variable privada para representar la coleccion
    private val cola: MutableList<T> = mutableListOf()
    
    /**
     * Metodo usado para agregar un elemento a la cola
     * Entrada: elemento a agregar
     * Salida: la cola con el elemento agregado
     */
    override fun agregar(valor: T) : Cola<T> {
        cola.add(valor)
        return this
    }

    /**
     * Metodo usado para eleminar un elemento de la cola
     * Salida: elemento removido
     */
    override fun remover() : T {
        if (this.vacio()) {
            throw NoSuchElementException("Error, la cola esta vacia")
        }
        return cola.removeFirst()
    }

    /**
     * Metodo para determinar si la cola esta vacia
     * Salida: true si lo esta, false en caso contrario
     */
    override fun vacio() : Boolean {
        return cola.size == 0
    }

    /**
     * Retorna la representacion en string de una cola
     */
    override fun toString() : String {
        return cola.toString()
    }
}