/**
 * ejemplo usado para comprobar el alcance estatio de NodeJs
 */

let x = 3

function prueba2() {
    x = 2
}

function prueba() {
    var x = 5;
    prueba2()
}

prueba()
console.log(x)