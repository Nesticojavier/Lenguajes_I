// Primer Examen/tarea. Ejercicio 1.(b)
// ii.

/**
 * Programa que dadas dos matrices A y B de tamanyo NxM y MxP, respectivamente,
 * las multiplica y guarda su resultado en un matriz C detamanyo NxP. 
 */

// Definimos los valores de N,M,P para realizar los calculos
const N = 3;
const M = 2;
const P = 4;

// realizamos la construnccion de las matrices a partir del tamanyo indicado con enteros generados aleatroiamente.
let A = Array.from({length: N}, () => Array.from({length: M}, () => Math.floor(Math.random()*10)));
let B = Array.from({length: M}, () => Array.from({length: P}, () => Math.floor(Math.random()*10)));
let C = Array.from({length: N}, () => Array.from({length: P}, () => 0));

// algoritmo que realiza la multiplicacion
for (i = 0; i < N; i++) {
    for (j = 0; j < P; j++) {
        var suma = 0;
        for (k = 0; k < M; k++) {
            suma = suma + A[i][k]*B[k][j]
        }
        C[i][j] = suma
    }
}

// una vez terminada la ejecucion, el resultado de la multiplicacion queda guardada en la matriz C.
console.log(C)