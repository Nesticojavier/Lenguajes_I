import Buddy
fun main(args: Array<String>) {

    if (args.size != 1) {
        println("Error, debe introducir un unico parametro")
    }

    // instanciar in buddySystem con una cantidad indicada de memoria
    val buddySystem = Buddy(args[0].toInt())

    // pedir instrucciones al usuario hasta que ejecute Salir
    while (true) {
        println("***************************************\n" +
                "Bienvenido al simulador de Buddy System" +
                "\nPor favor ingrese las instrucciones como se indica: \n" +
                "RESERVAR <nombre> <cantidad> : para reservar memoria\n" +
                "LIBERAR <nombre> : para liberar la memoria de un usuario en especifico\n" +
                "MOSTRAR : para mostrar el estado de la meemoria y espacio asiganado a cada usuario\n" +
                "SALIR : para salir del simulador\n" +
                "***************************************")
        print("> ")
        var entrada = readLine()!!.split(" ")
        if (entrada.size > 3 || entrada.size < 1) {
            println("Error de entrada  de datos. \nDebe ingresar los datos como se indica")
        } else if (entrada[0] != "SALIR" && entrada[0] != "RESERVAR" && entrada[0] != "LIBERAR" && entrada[0] != "MOSTRAR") {
            println("Error de entrada  de datos. \nDebe ingresar los datos como se indica")
        } else {
            when (entrada[0]){

                "SALIR" -> {break}

                "RESERVAR" -> try {
                    if (entrada.size != 3) {
                        println("reservar debe tener dos parametros")
                    } else if (entrada[2].toInt() < 0) {
                        println("Error, <cantidad> deber ser un entero positivo")
                    } else if (entrada[2].toInt() > args[0].toInt()) {
                        println("no puede reservar un espacio mayor al disponible")
                    } else {
                        buddySystem.reservar(entrada[1], entrada[2].toInt())
                    }
                } catch(e: NumberFormatException) { println("Error, <cantidad> deber ser un entero positivo")}

                "LIBERAR" -> {
                    if (entrada.size != 2) {
                        println("LIBERAR debe tener un parametro")
                    } else {
                        buddySystem.liberar(entrada[1])
                    }
                }

                "MOSTRAR" -> {buddySystem.mostrar()}
            }

        }
    }


}
