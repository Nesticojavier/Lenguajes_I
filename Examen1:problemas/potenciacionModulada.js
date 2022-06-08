// Primer Examen/tarea. Ejercicio 1.(b)

// i.

/**
 * Funcion que calcula recursivamente la potenciacion modulada
 * @param {Entero} a Numero entero que representa la base de la potencia
 * @param {Entero} b Entero que representa la el exponente de la potencia
 * @param {Entero} c Modulo a calcular. Precondicion: c >= 2
 * @returns retorna el resultado de la potenciacion modular (a^b) mod c
 */
function potenciacionModulada(a, b, c) {

    // checkeo de precondiciones
    if (c < 2) {
        console.log("c tiene que ser mayor o igual que 2")
    }

    // caso base
    if (b === 0) {
        return 1
    }

    // caso recursivo
    return ((a%c)*(potenciacionModulada(a,b-1,c)))%c
}

//ejemplo
console.log(potenciacionModulada(4,5,6)); // (4^5) mod 6 = 4