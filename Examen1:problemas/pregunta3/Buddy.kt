public class Buddy {

    // varible global dentro de la clase para almacenar el tamanyo de la memoria
    private var size: Int;

    // lista de listas de bloques libres
    private var free: MutableList<MutableList<Pair<Int, Int>>>;

    // diccionario para almacenar los espacios de memoria asignados a los nombres de usuario
    private var bloquesOcupados: HashMap<String,Pair<Int, Int>> = HashMap<String,Pair<Int, Int>>()

    /**
     * Constructor de la clase.
     * Al instanciar la clase, se crea la lista de bloques libres
     */
    constructor(s: Int) {
        size = s;

        // cantidad de potencias posibles de 2
        val x = Math.ceil(Math.log(size.toDouble()) / Math.log(2.0)).toInt();
    
        // inicializar la listas libres
        free = MutableList(x+1, {mutableListOf()});
        free[x].add(Pair(0, size - 1)); 
    }    

    /**
     * Metodo usado para reservar memoria
     */
    fun reservar(nombre: String, cantidad: Int): Boolean {

        // verificar que el nombre no tenga un espacio de memoria asignado
        if (bloquesOcupados.containsKey(nombre)) {
            println("error, el nombre ${nombre}, ya está en uso")
            return false
        }

        /* calcular en que lista libre buscar para obtener el bloque mas pequeño
           lo suficientemente grade para adaptarse a la longitud <caatidad> */
        val x = Math.ceil(Math.log(cantidad.toDouble()) / Math.log(2.0)).toInt();

        var i: Int;

        var temp: Pair<Int, Int>;

        // si conseguimos un bloque lo suficientemente grande
        if (free[x].size > 0) {

            temp = free[x].removeAt(0);
            bloquesOcupados.put(nombre, temp);
            println("Se ha reservado el bloque ${temp} para ${nombre}");
            return true;
        }
        
        
        // buscar a lo largo de la lista de bloques libres
        i = x + 1
        while (i < free.size) {
            
            if (free[i].size == 0) {
                i++
                continue;
            }
            
            // encontró un bloque lo 
            break; 
        }
        
        
        // si llegó al final de la lista, no pudo conseguir un bloque
        if (i == free.size) {
            println("no se pudo reservar memoria")
            return false
        }
        
        // remover el primer bloque
        temp = free[i].removeAt(0);
        i--;
        
        while (i >= x) {

            var newPair: Pair<Int, Int> = Pair(temp.first, temp.first + (temp.second - temp.first) / 2); 
            var newPair2: Pair<Int, Int> = Pair(temp.first + (temp.second - temp.first + 1) / 2, temp.second); 
            
            free[i].add(newPair);
            free[i].add(newPair2);

            temp = free[i].removeAt(0);
            
            i--
        }
        
        println("Se ha reservado el bloque ${temp} para ${nombre}");

        bloquesOcupados.put(nombre, temp);
        return true;

    }

    /**
     * Metodo usado para liberar memoria de un determinado usuario.
     * Retorna true si se pudo liberar espacio
     */
    fun liberar(nombre: String) : Boolean {

        // verificar que el nombre tenga un espacio de memoria asignado
        if (!bloquesOcupados.containsKey(nombre)) {
            println("error, el nombre ${nombre}, no tiene ningun espacio asignado")
            return false
        }

        var bloqueALiberar = bloquesOcupados.get(nombre)

        // direccion inicial del bloque
        var s = bloqueALiberar!!.first

        // //direccion final del bloque
        // var f = bloqueALiberar.second

        // capacidad del bloque
        var capacidad = capacidad(bloqueALiberar)

        // agregar el bloque a su respectiva lista
        var x = Math.ceil(Math.log(capacidad.toDouble()) / Math.log(2.0)).toInt()

        var i: Int;
        var buddyNumber: Int;
        var buddyAddress: Int;

        free[x].add(bloqueALiberar)
        println("Se ha liberado el bloque ${nombre} ${bloqueALiberar}")
        
        // calcular su buddyNumber buddy address
        buddyNumber = s / capacidad

        if (buddyNumber % 2 != 0) {
            buddyAddress = s - (Math.pow(2.0, x.toDouble())).toInt();
        } else {
            buddyAddress = s + (Math.pow(2.0, x.toDouble())).toInt();
        }


        //buscar in la lista lista libre para el buddy
        i = 0
        while (i < free[x].size) {
            
            // indica que el bloque vecino tambien esta libre
            if (free[x][i].first == buddyAddress) {
                    
                if (buddyNumber % 2 == 0) {
                    // agregar a la lista libre apropiada
                    free[x + 1].add(Pair(s, s + 2 * (Math.pow(2.0, x.toDouble())).toInt() - 1));

                } else {
                    // agregar a la lista libre apropiada
                    free[x + 1].add(Pair(buddyAddress,
                                    buddyAddress + 2 * (Math.pow(2.0, x.toDouble())).toInt() - 1));
                }

                // elimina los segmentos individuales
                free[x].removeAt(i);
                free[x].removeAt(free[x].size - 1);
                break;
            }
            i++
        }

        bloquesOcupados.remove(nombre)
        return true
    }

    /**
     * Metodo usado para mostrar el estado de la memoria,
     * asi como el espacio asignado a cada usuario
     */
    fun mostrar() {
        println("Listas de bloques libres:")
        println("${free} \n")
        for(key in bloquesOcupados.keys){  
            println("${key} tiene asociado el bloque de memoria ${bloquesOcupados[key]}")  
        }
    }

}

/**
 * Funcon usada para calcular la cantidad de bytes dentro de un bloque de memoria,
 * del cual tengo su direccion final e inicial
 */
fun capacidad(bloque: Pair<Int, Int>) : Int {
    return bloque.second - bloque.first + 1
}