import time
from threading import Thread

# subrutina que representa un hilo de multiplicacion
def thread_function(n, m, hilo) -> int:
    print("Se inicia la multiplicación del hilo", hilo)
    time.sleep(2)

    print("Finaliza la multiplicación del hilo", hilo)
    return n * m 

# clase usada para poder obtener el valor de retorno de los hilos
# copyRight: https://stackoverflow.com/questions/6893968/how-to-get-the-return-value-from-a-thread-in-python
class ThreadWithReturnValue(Thread):
    def __init__(self, group=None, target=None, name=None,
                 args=(), kwargs={}, Verbose=None):
        Thread.__init__(self, group, target, name, args, kwargs)
        self._return = None
    def run(self):
        if self._target is not None:
            self._return = self._target(*self._args,
                                                **self._kwargs)
    def join(self, *args):
        Thread.join(self, *args)
        return self._return

def productoPunto(vector1, vector2) -> int:

    n = len(vector1)
    if(n != len(vector2)):
        print("Error, los vectores deben tener el mismo tamano")
        return

    print("Este programa creará", n, "hilos para realizar", n, 
                "las multiplicacioes" +
                " correspondientes al producto interno\n")
    
    vectorSum = []
    hilos = []
    for i in range(0,n):
        hilo = ThreadWithReturnValue(target=thread_function, 
                                    args=(vector1[i],vector2[i], i))
        hilo.start()
        hilos.append(hilo)

    for hiloo in hilos:
        vectorSum.append(hiloo.join())
    print("Se la suma del resultado que retornan todos los hilos")

    return sum(vectorSum)


def main():

    # se usa los siguientes vectores de prueba
    vector1 = [0,1,2,3,4]
    vector2 = [5,5,5,5,5]

    print(productoPunto(vector1, vector2))



main()