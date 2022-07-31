import Manejador
fun main() {
    val manager = Manejador()

    println("***************************************\n" +
            "Bienvenido al manejador de tablas de metodos virtuales" +
            "\nPor favor ingrese las instrucciones como se indica: \n" +
            "CLASS <tipo> [<nombre>] : para crear una nueva clase \n" +
            "DESCRIBIR <nombre> : para obtener infomacion de los metodos de la clase <nombre>\n" +
            "SALIR : para salir del manejador\n" +
            "***************************************")
    while (true) {
        print("> ")
        var entrada = readLine()!!.split(" ")
        if (entrada.size < 1) {
            println("Error de entrada de datos. \n Debe ingrezar los datos como se indica")
        } else if (entrada[0] != "SALIR" && entrada[0] != "CLASS" && entrada[0] != "DESCRIBIR") {
            println("Error de entrada de datos. \n Debe ingrezar los datos como se indica")
        } else {
            when (entrada[0]){
    
                "SALIR" -> {break}
    
                "CLASS" -> {
                    if (entrada.size == 1) {
                        println("Error, CLASS debe definir un nuevo tipo")
                    } else if (entrada.size == 3 && entrada[2] == ":") {
                        println("Error, la clase ${entrada[1]} debe heredar de alguna clase")
                    } else {
                        manager.agregarNuevaClase(entrada)
                    }
                }
    
                "DESCRIBIR" -> {
                    if (entrada.size != 2) {
                        println("Error, DESCRIBIR recibe exacamente un parametro")
                    } else {
                        manager.describir(entrada[1])
                    }
                }
            }
        }
    }
}