class Manejador {

    // variable global usada para almacenar las clases creadas
    val clases: HashMap<String, Clase> = HashMap<String, Clase>()

    fun agregarNuevaClase(lista: List<String>) : Boolean {

        if (clases.containsKey(lista[1])){
            println("Error, la clase ${lista[1]} ya existe")
            return false
        }

        val nuevaClase: Clase = Clase(lista[1])

        // agregar una clase que no hereda de nadie y no posee metodos
        if (lista.size == 2) {
            clases.put(lista[1],nuevaClase)
            return true
        }

        // agregar una clase que hereda de list[3]
        // siendo lista[3] la superclasC
        if(lista[2] ==  ":") {
            if(!clases.containsKey(lista[3])) {
                println("Error, la super clase ${lista[3]} no existe")
                return false
            } else if (findDuplicates(lista.subList(4, lista.size)).size != 0) {
                println("Error, hay nombres de metodos repetidos")
                return false
            }
            val superClase = clases.get(lista[3])

            //asignar padre a la nueva clase
            nuevaClase.padre = superClase

            //agregar nuevos metodos
            for (i in 4 until lista.size) {
                nuevaClase.metodos.add(Pair(lista[i], lista[1]))
            }

            // agregar metodos heredados
            for (metodo in superClase!!.metodos) {
                if (nuevaClase.metodos.find{ it.first == metodo.first} == null) {
                    nuevaClase.metodos.add(metodo)
                }
            }
            
            //agregar al diccionario clases
            clases.put(lista[1],nuevaClase)
            
            return true
        } 

        // verificar que no hayan nombres repetidos en la lista de metodos
        if (findDuplicates(lista.subList(2, lista.size)).size != 0) {
            println("Error, hay nombres de metodos repetidos")
            return false
        }

        // agregar una clase que no hereda de nadie
        for (i in 2 until lista.size) {
            nuevaClase.metodos.add(Pair(lista[i], lista[1]))
        }
        clases.put(lista[1],nuevaClase)
        
        
        return true
    }

    fun describir(clase: String) : Boolean {
        if (clases.get(clase) == null) {
            println("Error, la clase ${clase} no existe")
            return false
        }
        println(clases.get(clase))
        return true 
    }

    /**
     * Funcion para encontrar elementos duplicados en una lista
     * copyrigth: https://www.techiedelight.com/es/find-repeated-values-in-a-kotlin-list/
     */
    private fun <T> findDuplicates(values: List<T>): Set<T> {
        return values.groupingBy { it }.eachCount().filterValues { it > 1 }.keys
    }

}