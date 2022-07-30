/**
 * Programa cliente usado para probar la implentacion de la interfaz
 * Secuencia y sus susclases.
 */

fun main() {
	try {
		val miColaDeEnteros = Cola<Int>()
		val miPilaDeCadenas = Pila<String>()
		
		println("Agregar elementos a la cola de enteros:")
		println(miColaDeEnteros.agregar(33))
		println(miColaDeEnteros.agregar(45))
		println(miColaDeEnteros.agregar(64))
		println(miColaDeEnteros.agregar(71))
		println(miColaDeEnteros.agregar(86))
		
		println("\nremover elementos a la cola de enteros:")
		println(miColaDeEnteros.remover())
		println(miColaDeEnteros.remover())
		println(miColaDeEnteros.remover())
		println(miColaDeEnteros.remover())
		println(miColaDeEnteros.remover())
		// println(miColaDeEnteros.remover()) // error, la cola está vacia
		
		println("\nagregar elementos a una pila de strings")
		println(miPilaDeCadenas.agregar("hola"))
		println(miPilaDeCadenas.agregar("gente"))
		println(miPilaDeCadenas.agregar("todo"))
		println(miPilaDeCadenas.agregar("chevere"))
		println(miPilaDeCadenas.agregar("en"))
		println(miPilaDeCadenas.agregar("lenguajes"))
		println(miPilaDeCadenas.agregar("de"))
		println(miPilaDeCadenas.agregar("programacion"))
		
		println("\nremover elementos a la pila de strings:")
		println(miPilaDeCadenas.remover())
		println(miPilaDeCadenas.remover())
		println(miPilaDeCadenas.remover())
		println(miPilaDeCadenas.remover())
		println(miPilaDeCadenas.remover())
		println(miPilaDeCadenas.remover())
		println(miPilaDeCadenas.remover())
		println(miPilaDeCadenas.remover())
		println(miPilaDeCadenas.remover()) // Error, la pila está vacia
	} catch (e: NoSuchElementException) {
		println(e)
	}
}
