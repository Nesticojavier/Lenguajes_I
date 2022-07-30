/**
 * Clase que representa un grafo como lista de adyacencias y cada
 * nodo se representa por un número entero entre 0 y numero de nodos
 */
class GrafoDirigido {
    
    /* Representacion de un grafo como lista de adyacencias */
    var listaDeAdyacencia: Array<MutableList<Arco>> = Array(0,{mutableListOf()}) 

    /* Variables creadas dentro de la clase para facilitar el uso de algunas funciones */
    private var numeroDeVertices: Int = 0
    private var numeroDeLados: Int = 0

    /* Se construye un grafo a partir del numero de vertice */
    constructor(numDeVertices: Int) {
        numeroDeVertices = numDeVertices
        listaDeAdyacencia = Array(numDeVertices,{mutableListOf()})
    }

    /**
     * Agrega un lado al digrafo
     * Parametros: 
     * a: representa el lado a agregar y pertenece a la clase Arco
     * PRECONDICIONES: que los vertices del lado no se desborden de
     * la lista de adyacencia y que el lado no pertenezca al grafo
     * POSTCONDICIONES: Retorna true si se cumple la precondicion y
     * el lado se ha agregado con exito; de lo contrario, retorna false
     */
    fun agregarArco(a: Arco) : Boolean {

        // checkear precondicines
        if ( a.inicio < 0 || a.fin >= listaDeAdyacencia.size || a.fin < 0 || a.inicio >= listaDeAdyacencia.size) {
            return false
        } else if (listaDeAdyacencia[a.inicio].find{it.fin == a.fin} != null) {
            return false
        }

        numeroDeLados += 1
        return listaDeAdyacencia[a.inicio].add(a)
    }

    /** Retorna el número de vértices del grafo */
    fun obtenerNumeroDeVertices() : Int {
        return numeroDeVertices
    }

    /**
     * Retorna los adyacentes de v, en este caso los lados que tienen como vértice inicial a v. 
     * PARAMETROS:
     * v: vertice al cual se le obtendrán los vertices adyacentes
     * PRECONDICION: el vertice debe pertenecer al grafo
     * POSCONDICION: retorna una lista de lados de tamanio >=0
     */
    fun adyacentes(v: Int) : MutableList<Arco> {

        // checkeo de precondiciones
        if (v < 0 || v >= listaDeAdyacencia.size) {
            throw RuntimeException("No se ha encontrado el vertice ${v}")
        }
        return listaDeAdyacencia[v]
    }

    /**
     * String que muestra el contenido del grafo 
     */
    override fun toString() : String {
        var str: String = ""
        for ((index, lista) in this.listaDeAdyacencia.withIndex()) {
            str += "${index} --> ${lista} \n"
        }
        return str
    }
}

/**
 * Clase usada para representar los lados de un digrafo
 */
public open class Arco(val inicio: Int, val fin: Int) {

    /* Retorna el vértice inicial un arco arco */
    fun fuente() : Int {
        return inicio
    }

    /* Retorna el vértice final del arco */
    fun sumidero() : Int {
        return fin
    }

    /* Retorna la representacion en string de un arco */
    override fun toString() : String {
        return "(${inicio}, ${fin})"
    }
}
