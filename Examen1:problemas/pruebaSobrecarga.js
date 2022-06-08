/**
 * Ejemplo de definicion de dos funciones con el mismo nombre
 * para representar la sobrecarga.
 */

function sobrecarga(a, b) {
    console.log(a + b)
}

function sobrecarga(a) {
    console.log(a)
}


sobrecarga(5, 6) // print 5