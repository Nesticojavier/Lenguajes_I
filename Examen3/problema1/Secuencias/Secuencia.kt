/**
 * Contrato de Secuencias para representar una coleccion
 * ordenada de elementos. La implementacion de sus metodos
 * se vera a detalle en las subclases que la extiendan.
 */
interface Secuencia<T> {
    /**
     * Metodo usado para agregar un elemento a la coleccion
     */
    fun agregar(valor: T) : Secuencia<T>

    /**
     * Metodo usado para eliminar un elemento de la coleccion
     */
    fun remover() : T

    /**
     * Metodo usado para determinar si la coleccion está vacia
     */
    fun vacio() : Boolean

}
