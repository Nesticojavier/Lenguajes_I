/**
 * Clase usada para crear objetos de tipo Clase
 */
class Clase(val clase: String) {
    var padre: Clase? = null
    val metodos: MutableList<Pair<String, String>> = mutableListOf()
 
    /**
     * metodo para poder comparar los elementos de tipo Clase
     */
    override fun equals(other: Any?): Boolean {
        if (other == null) return false
        if (other !is Clase) return false
        if (this.clase == other.clase) return true
        return false
    }

    /**
     * Representacion en string de una clase
     */
    override fun toString() : String {

        if (this.metodos.size == 0) {
            return "No hay metodos para la clase ${this.clase}"
        }
        var str: String = ""
        for (index in this.metodos) {
            str += "${index.first} -> ${index.second} :: ${index.first} \n"
        }
        return str
    }
}