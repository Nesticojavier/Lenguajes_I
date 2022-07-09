"""
Autor: Nestor Gonzalez
Carnet: 1610455

Constantes usadas para las funciones:
X = 4
Y = 5
Z = 5
alpha = ((4+5) mod 5) + 3 = 7
beta = ((5+5) mod 5) + 3 = 3
"""

def fRecursiva(n: int) -> int :
    """  Version recursiva de la funcion F"""
    if ( 0 <= n < 21) :
        return n

    return sum(fRecursiva(n-3*i) for i in range(1,8))



def fRecursivaDeCola(n:int) -> int:
    """Version recursiva de cola de la funcion F"""
    
    def f_aux(acc: list, i: int) -> int:
        """
        Funcion recursiva auxiliar para calcular los valores de f.
        En vez de empezar en el valor 'n' y disminurlo hasta alcanzar
        los valores bases, iniciamos en los valores bases y aumentamos el
        contador desde un caso base.
        """

        # Caso base de la recursion
        if 0 <= n < 21:
            return acc[n]

        # Si se ha alcanzado el valor n buscado, entonces se calcula f(n) y se retorna
        elif n == i+1:
            return sumList(acc)
        
        # Se aplica el caso recursivo

        # Se obtiene la suma de los valores ya calculados y se asigna como el ultimo valor de la lista
        acc[21] = sumList(acc)

        # Se desplazan los valores calculados
        for j in range(1, 22):
            acc[j-1] = acc[j]
        
        # Se calcula el siguiente valor, llamando recursivamente a f_aux. la cual es recursiva
        # de cola, pues no se tiene que hacer ningun calculo adicional despues de evaluar la funcion.
        return f_aux(acc, i+1)

    # Retorna el valor de la funcion auxiliar con acc con los valores bases donde 
    # acc[i] es el valor f(n) con 0 <= n < 21. y el valor del contador i se inicializa en 20
    return f_aux([j for j in range(0, 22)], 20)



def fIterativa(n:int) -> int:
    """ Version iterativa de la funcion F"""
    
    # Se inicializan los valores de i y de la lista acc.
    # Esto corresponde a la llamada inicial de la funcion f_aux usada
    # en la version recursiva de cola
    i = 20
    acc = [i for i in range(0, 22)]

    # Componente del caso base cuando  0 <= n < 21
    if 0 <= n < 21:
        return n

    # Componente del caso recursivo:
    # Mientras n no sea i + 1
    while n != i+1:    
        # Se obtiene el valor de la funcion evaluada en i y se guarda en
        # la ultima posicion de la lista acc
        acc[21] = sumList(acc)
        for j in range(1, 22):
            acc[j-1] = acc[j]

        i += 1

    return sumList(acc)


def sumList(list):
    """Funcion usada para calcular la suma de la lista"""
    return sum([list[21 - i*3] for i in range(1, 8)])